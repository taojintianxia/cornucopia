package pattern.dynamicrules;

public enum RulesMsgEnum {
	
	SUCCESS("success"),
	
	NOT_24_HOUR_NEW_USER("用户不是24小时内注册的"),
	
	NOT_REGISTER_FROM_YOUKU("用户不是通过优酷注册的"),
	
	NOT_INVEST_USER("该用户不是投资用户"),
	;
	
	private String msg;
	
	private RulesMsgEnum(String msg){
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
