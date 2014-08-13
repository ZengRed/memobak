package amigo.sshmemo.dwr;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.proxy.dwr.Util;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;
import amigo.sshmemo.quartz.SimpleTriggerRunner;


public class DWRHelper {   
    private static LinkedList<Message> messages = new LinkedList<Message>();   
    private static ReentrantLock lock = new ReentrantLock(); //JDK5��   
    String message;
    @SuppressWarnings("deprecation")
	public void addMessage(String username){   
        try{   
            lock.lock();   
               
            if(username!=null && username.trim().length()>0){   
                messages.addFirst(new Message(username));   
                if(messages.size()>10){   
                    messages.removeLast();   
                }   
            }   
         
            
        }catch(Exception ex){   
            ex.printStackTrace();   
        }finally{   
            lock.unlock();   
        }   
           
//        try{
//        	  SimpleTriggerRunner simpleTriggerRunner = new SimpleTriggerRunner();
//        	  message = simpleTriggerRunner.runJob(username);
//        }catch(Exception e){
//        	e.printStackTrace();
//        }
      
        //���DWR������   
        WebContext webContext = WebContextFactory.get();   
           
        //��ȡ��ǰҳ��URL������/ext3/test_tag.jsp   
        String currentPage = webContext.getCurrentPage();   
           
        //��ǰ�ű�sessin   
        ScriptSession scriptSession = webContext.getScriptSession();   
           
        //����ҳ��ؼ���ֵ   
        Util util = new Util(scriptSession);   
        util.setValue("text", ""); //���������ҳ��������ֵ   
           
        //���ýű�sessin������ֵ   
        scriptSession.setAttribute("uid", "cjm");   
           
        //��ȡ�ű�session������ֵ   
        for(Iterator it=scriptSession.getAttributeNames();it.hasNext();){   
            String attrName = (String)it.next();   
            System.out.println(attrName + "=" + scriptSession.getAttribute(attrName));   
        }   
           
        //��ȡ���������ǰҳ��Ľű�session   
        Collection<ScriptSession> sessions = webContext.getScriptSessionsByPage(currentPage);   
           
        Util utilAll = new Util(sessions);   
           
        //ִ�пͻ��˽ű�   
        ScriptBuffer script = new ScriptBuffer();   
        script.appendScript("clientFunction(")   
//          .appendData(scriptSession.getAttribute("uid"))  
          .appendData(message)  
          .appendScript(");");   
           
        for(ScriptSession session: sessions){   
            session.addScript(script);   
        }   
           
        //������Щ�ű�session��һЩԪ��   
        utilAll.removeAllOptions("messages");   
        utilAll.addOptions("messages", messages, "id", "text");   
    }   
    public void test(String username){
    	
    }
}  
