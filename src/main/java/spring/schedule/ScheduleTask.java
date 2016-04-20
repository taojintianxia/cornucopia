/**
 * ScheduleTask.java
 * @author kane
 * @created 2016年4月20日
 */
package spring.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kane
 *
 */
public class ScheduleTask {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void doSomething() {
		logger.info("正在执行定时任务");
	}

}
