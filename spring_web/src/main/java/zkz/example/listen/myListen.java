package zkz.example.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class myListen implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web项目启动....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Web项目销毁....");
    }
}
