package amigo.sshmemo.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import amigo.sshmemo.dao.BaseDao;
import amigo.sshmemo.dao.BaseDaoImpl;
import amigo.sshmemo.dao.Memo;
import amigo.sshmemo.dao.User;
import amigo.sshmemo.exception.QuartzMessageException;

public class SimpleJob implements Job {
	BaseDao dao = new BaseDaoImpl();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
		String username = jobCtx.getTrigger().getDescription();
		
		System.out.println(" triggered. time is:"
				+ username + (new Date()));
		
		User user = (User)dao.getObject(User.class, username);
		
		Set memosSet = user.getMemos();
		
		for(Iterator it = memosSet.iterator();it.hasNext();){
			Memo memo = (Memo)it.next();
			Date date = memo.getRemindTime();
			Date now = new Date();
			if(now.equals(date)){
				String message = sdf.format(now);
				throw new QuartzMessageException(message);
			}
		}
		
		
		
		

	}
}
