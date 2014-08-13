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
		// �ٴ���һ��JobDetailʵ����ָ��SimpleJob

		JobDetail jobDetail = new JobDetail("job1_1", "jGroup1", SimpleJob.class);

		// ��ͨ��SimpleTrigger������ȹ�������������ÿ2������һ�Σ�������2��

		SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1", "tgroup1");

		simpleTrigger.setStartTime(new Date());

		simpleTrigger.setRepeatInterval(1000);

//		simpleTrigger.setRepeatCount(0);
		simpleTrigger.setDescription(username);

		// ��ͨ��SchedulerFactory��ȡһ��������ʵ��

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {

			Scheduler scheduler = schedulerFactory.getScheduler();

			scheduler.scheduleJob(jobDetail, simpleTrigger);// �� ע�Ტ���е���

			scheduler.start();// �ݵ�������
		} catch (QuartzMessageException qme) {
			message = qme.getMessage();
			qme.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}
}
