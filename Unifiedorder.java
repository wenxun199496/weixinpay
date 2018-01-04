package tangjie.qipai.majiang.logic.weixin;

/**
 * 统一下单提交为微信的参数
 * @author iYjrg_xiebin
 * @date 2015年11月26日上午10:17:06
 */
public class Unifiedorder {
	
	private String appid;//微信分配的公众账号ID（企业号corpid即为此appId）,例如：wxd678efh567hg6787
	private String mch_id;//商户id
	private String device_info;//终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
	private String nonce_str;//随机字符串:数字+大写字母的组合，32位
	private String sign;//签名
	private String body;//商品或支付单简要描述
	private String detail;//商品名称明细列表
	private String attach;//附加参数
	private String out_trade_no;//商户系统内部的订单号
	private String fee_type;//货币类型:符合ISO 4217标准的三位字母代码，默认人民币：CNY
	private int total_fee;//总金额
	private String spbill_create_ip;//APP和网页支付提交[用户端ip]，Native支付填调用微信支付API的机器IP。
	private String time_start;//订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
	private String time_expire;//订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010;最短失效时间间隔必须大于5分钟[支付宝是30分钟，同样30分钟]
	private String goods_tag;//商品标记，代金券或立减优惠功能的参数
	private String notify_url;//接收微信支付异步通知回调地址
	private String trade_type;//交易类型:JSAPI，NATIVE，APP
	private String product_id;//trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	private String limit_pay;//no_credit--指定不能使用信用卡支付
	private String openid;//trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识
	
	public String getAppid() {
		return appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public String getBody() {
		return body;
	}
	public String getDetail() {
		return detail;
	}
	public String getAttach() {
		return attach;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public String getFee_type() {
		return fee_type;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public String getTime_start() {
		return time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public String getProduct_id() {
		return product_id;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public String getOpenid() {
		return openid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	

}
