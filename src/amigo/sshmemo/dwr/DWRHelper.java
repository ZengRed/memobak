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
    private static ReentrantLock lock = new ReentrantLock(); //JDK5锁   
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
      
        //获得DWR上下文   
        WebContext webContext = WebContextFactory.get();   
           
        //获取当前页面URL，比如/ext3/test_tag.jsp   
        String currentPage = webContext.getCurrentPage();   
           
        //当前脚本sessin   
        ScriptSession scriptSession = webContext.getScriptSession();   
           
        //设置页面控件的值   
        Util util = new Util(scriptSession);   
        util.setValue("text", ""); //这里是清空页面输入框的值   
           
        //设置脚本sessin的属性值   
        scriptSession.setAttribute("uid", "cjm");   
           
        //获取脚本session的属性值   
        for(Iterator it=scriptSession.getAttributeNames();it.hasNext();){   
            String attrName = (String)it.next();   
            System.out.println(attrName + "=" + scriptSession.getAttribute(attrName));   
        }   
           
        //获取所有浏览当前页面的脚本session   
        Collection<ScriptSession> sessions = webContext.getScriptSessionsByPage(currentPage);   
           
        Util utilAll = new Util(sessions);   
           
        //执行客户端脚本   
        ScriptBuffer script = new ScriptBuffer();   
        script.appendScript("clientFunction(")   
//          .appendData(scriptSession.getAttribute("uid"))  
          .appendData(message)  
          .appendScript(");");   
           
        for(ScriptSession session: sessions){   
            session.addScript(script);   
        }   
           
        //更新这些脚本session的一些元素   
        utilAll.removeAllOptions("messages");   
        utilAll.addOptions("messages", messages, "id", "text");   
    }   
    public void test(String username){
    	
    }
}  
