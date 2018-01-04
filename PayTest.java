package tangjie.qipai.majiang.logic.paymax;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import tangjie.qipai.majiang.logic.paymax.PaymaxConfig;
import tangjie.qipai.majiang.logic.weixin.HttpXmlUtils;
import tangjie.qipai.majiang.logic.weixin.RandCharsUtils;
import tangjie.qipai.majiang.logic.weixin.Unifiedorder;
import tangjie.qipai.majiang.logic.weixin.WXSignUtils;
import tangjie.qipai.majiang.logic.weixin.XMLUtil;

public class PayTest{
	
	private final static Logger log = Logger.getLogger(PayTest.class);
	

	@SuppressWarnings("unchecked")
	public String Pay(Map<String,Object> map){
		
		//参数组
		String appid = PaymaxConfig.WX_APPID;
		String mch_id = PaymaxConfig.WX_MCHID;
		String nonce_str = RandCharsUtils.getRandomString(16);
		String body = (String)map.get("body");
		String detail = (String) map.get("subject");
		String attach = JSON.toJSONString(map.get("metadata"));
		String out_trade_no = (String)map.get("order_no");
		int total_fee = Integer.valueOf((String)map.get("amount"));//单位是分，即是0.01元,前端转化为元
		String spbill_create_ip = (String)map.get("client_ip");
		String time_start = RandCharsUtils.timeStart();
		String time_expire = RandCharsUtils.timeExpire();
		String notify_url = PaymaxConfig.WX_NOTIFYURL;
		String trade_type = PaymaxConfig.WX_TRADETYPE; 
		
		
		//参数：开始生成签名
		SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
		parameters.put("appid", appid);
		parameters.put("mch_id", mch_id);
		parameters.put("nonce_str", nonce_str);
		parameters.put("body", body);
		parameters.put("detail", detail);
		parameters.put("attach", attach);
		parameters.put("out_trade_no", out_trade_no);
		parameters.put("total_fee",String.valueOf(total_fee));
		parameters.put("time_start", time_start);
		parameters.put("time_expire", time_expire);
		parameters.put("notify_url", notify_url);
		parameters.put("trade_type", trade_type);
		parameters.put("spbill_create_ip",spbill_create_ip);
		
		String sign = WXSignUtils.createSign("UTF-8", parameters);

		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(appid);
		unifiedorder.setMch_id(mch_id);
		unifiedorder.setNonce_str(nonce_str);
		unifiedorder.setBody(body);
		unifiedorder.setDetail(detail);
		unifiedorder.setAttach(attach);
		unifiedorder.setOut_trade_no(out_trade_no);
		unifiedorder.setTotal_fee(total_fee);
		unifiedorder.setSpbill_create_ip(spbill_create_ip);
		unifiedorder.setTime_start(time_start);
		unifiedorder.setTime_expire(time_expire);
		unifiedorder.setNotify_url(notify_url);
		unifiedorder.setTrade_type(trade_type);
		unifiedorder.setSign(sign);

		Map<String, String> restmap = null;
		String weixinPost = null;
		try{
			//第一次签名  请求prepay_id
			weixinPost = HttpXmlUtils.httpsRequest(PaymaxConfig.WX_URL, PaymaxConfig.POST, HttpXmlUtils.xmlInfo(unifiedorder)).toString();			
			restmap = XMLUtil.doXMLParse(weixinPost);
		}catch(Exception e){
			log.info("微信支付请求支付对象异常");
			return "ERROR";
		}
		SortedMap<Object, Object> payMap = new TreeMap<Object, Object>();
        if ("SUCCESS".equals(restmap.get("result_code"))) {
            payMap.put("appid", restmap.get("appid"));
            payMap.put("partnerid", restmap.get("mch_id"));
            payMap.put("prepayid", restmap.get("prepay_id"));
            payMap.put("package", "Sign=WXPay");
            payMap.put("noncestr", restmap.get("nonce_str"));
            payMap.put("timestamp", payTimestamp());
			//请求到prepay_id后，进行新参数二次签名；
            payMap.put("sign",WXSignUtils.createSign("UTF-8",payMap));
        }else{
        	log.info("二次签名出现异常");
        	return "ERROR";
        }
        JSONObject payjson = maptojson(payMap);
		log.info(payjson);
		return payjson.toJSONString();
	}
	
	
	
	/**获取时间戳**/
    public static String payTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
    
    /**将Map转成json方便前端解析**/
    public static JSONObject maptojson(Map map){
    	JSONObject json = new JSONObject();
    	for (Object key : map.keySet()) {
			json.put((String) key, map.get(key));
		}
    	return json;
    }
}
