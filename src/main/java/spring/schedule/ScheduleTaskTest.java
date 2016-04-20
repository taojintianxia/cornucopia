/**
 * ScheduleTaskTest.java
 * @author kane
 * @created 2016年4月20日
 */
package spring.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author kane
 *
 */
@ContextConfiguration(locations = { "classpath:/applicationContext-schedule.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ScheduleTaskTest {

	@Test
	public void testScheduleTask() {

	}

}
