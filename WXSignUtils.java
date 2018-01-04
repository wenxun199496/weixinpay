package tangjie.qipai.majiang.logic.weixin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.apache.http.client.entity.UrlEncodedFormEntity;

/**
 * 微信支付签名
 * @author iYjrg_xiebin
 * @date 2015年11月25日下午4:47:07
 */
public class WXSignUtils {
	//http://mch.weixin.qq.com/wiki/doc/api/index.php?chapter=4_3
	//商户Key：改成公司申请的即可
	//32位密码设置地址：  jdex1hvufnm1sdcb0e81t36k0d0f15nc 2irwoj0xjlt6a4vqecvq02hy5enzsrd5
	private static String Key = "bangxuepaixinxikejiyouxiangongsi";

	/**
	 * 微信支付签名算法sign
	 * @param characterEncoding
	 * @param parameters
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("rawtypes")
	public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			Object v = entry.getValue();
			if(null != v && !"".equals(v) 
					&& !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + Key);
		System.out.println("字符串拼接后是："+sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
		return sign; 
	}
}
