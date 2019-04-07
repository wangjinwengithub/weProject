package www.com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerTest implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("=========监听器初始化中，你可以在这里做一些事情===========");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("==============监听器销毁==================================");
	}

	
}
