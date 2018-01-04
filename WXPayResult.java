package tangjie.qipai.majiang.logic.weixin;

/**
 * 微信支付结果返回的参数
 * @author iYjrg_xiebin
 * @date 2015年11月24日下午5:33:20
 */
public class WXPayResult {

	private String appid;//公众账号ID
	private String mch_id;//微信支付分配的商户号
	private String device_info;//微信支付分配的终端设备号，
	private String nonce_str;//随机字符串，32位：数字+大写字母组合
	private String sign;//签名：回调的时候需要反校验
	private String result_code;//SUCCESS/FAIL
	private String err_code;//错误返回的信息描述
	private String err_code_des;//错误返回的信息描述
	private String openid;//用户在商户appid下的唯一标识
	private String is_subscribe;//用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	private String trade_type;//交易类型:JSAPI、NATIVE、APP
	private String bank_type;//银行类型:ICBC_DEBIT:工商银行（借记卡）;ICBC_CREDIT:工商银行（信用卡）;
	private int total_fee;//订单总金额，单位为分;1元=100分；
	private String fee_type;//货币种类，符合ISO4217标准的三位字母代码，默认人民币：CNY
	private int cash_fee;//实际支付：现金支付金额订单现金支付金额
	private String cash_fee_type;//货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
	private int coupon_fee;//优惠券总金额：代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额
	private int coupon_count;//优惠券的数量：1张
	private String coupon_id_0;//代金券或立减优惠ID,$n为下标，从0开始编号;目前一个订单只能用一张优惠券，(后面需要延伸的话，加参数)
	private int coupon_fee_0;//单个代金券或立减优惠支付金额,$n为下标，从0开始编号
	private String transaction_id;//微信支付订单号:1217752501201407033233368018
	private String out_trade_no;//商户系统的订单号，与请求一致。交易单号：1212321211201407033568112322
	private String attach;//商家数据包，原样返回:比如阿迪达斯的篮球鞋，白色，35
	private String time_end;//支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
	private String return_code;//SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	private String return_msg;//返回信息，如非空，为错误原因
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
	public String getResult_code() {
		return result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public String getOpenid() {
		return openid;
	}
	public String getIs_subscribe() {
		return is_subscribe;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public String getBank_type() {
		return bank_type;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public int getCash_fee() {
		return cash_fee;
	}
	public String getCash_fee_type() {
		return cash_fee_type;
	}
	public int getCoupon_fee() {
		return coupon_fee;
	}
	public int getCoupon_count() {
		return coupon_count;
	}
	public String getCoupon_id_0() {
		return coupon_id_0;
	}
	public int getCoupon_fee_0() {
		return coupon_fee_0;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public String getAttach() {
		return attach;
	}
	public String getTime_end() {
		return time_end;
	}
	public String getReturn_code() {
		return return_code;
	}
	public String getReturn_msg() {
		return return_msg;
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
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public void setCash_fee(int cash_fee) {
		this.cash_fee = cash_fee;
	}
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}
	public void setCoupon_fee(int coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	public void setCoupon_count(int coupon_count) {
		this.coupon_count = coupon_count;
	}
	public void setCoupon_id_0(String coupon_id_0) {
		this.coupon_id_0 = coupon_id_0;
	}
	public void setCoupon_fee_0(int coupon_fee_0) {
		this.coupon_fee_0 = coupon_fee_0;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	

}
