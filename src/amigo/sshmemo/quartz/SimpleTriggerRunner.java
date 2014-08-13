package amigo.sshmemo.quartz;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import amigo.sshmemo.exception.QuartzMessageException;

public class SimpleTriggerRunner {
	String message;

	public String runJob(String username) {
		// ①创建一个JobDetail实例，指定SimpleJob

		JobDetail jobDetail = new JobDetail("job1_1", "jGroup1", SimpleJob.class);

		// ②通过SimpleTrigger定义调度规则：马上启动，每2秒运行一次，共运行2次

		SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1", "tgroup1");

		simpleTrigger.setStartTime(new Date());

		simpleTrigger.setRepeatInterval(1000);

//		simpleTrigger.setRepeatCount(0);
		simpleTrigger.setDescription(username);

		// ③通过SchedulerFactory获取一个调度器实例

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {

			Scheduler scheduler = schedulerFactory.getScheduler();

			scheduler.scheduleJob(jobDetail, simpleTrigger);// ④ 注册并进行调度

			scheduler.start();// ⑤调度启动
		} catch (QuartzMessageException qme) {
			message = qme.getMessage();
			qme.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}
}
