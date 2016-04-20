package pattern.dynamicrules;

import org.joda.time.DateTime;

public class Rules {
	
	public RulesMsgEnum validate24HourActiveUser(User user){
		DateTime targetTime = new DateTime(user.getActiveDate());
		targetTime.plusDays(1);
		if(targetTime.isBeforeNow()){
			return RulesMsgEnum.NOT_24_HOUR_NEW_USER;
		}else {
			return RulesMsgEnum.SUCCESS;
		}
	}
	
	public RulesMsgEnum validateUserSID(User user){
		if(user.getSid() > 10){
			return RulesMsgEnum.NOT_REGISTER_FROM_YOUKU;
		}else {
			return RulesMsgEnum.SUCCESS;
		}
	}
	
	public RulesMsgEnum validateIsInvestUser(User user){
		if(user.getInvestAmount() > 0){
			return RulesMsgEnum.NOT_INVEST_USER;
		}else {
			return RulesMsgEnum.SUCCESS;
		}
	}
}
