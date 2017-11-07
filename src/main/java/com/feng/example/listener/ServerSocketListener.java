package com.feng.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by tianfengluyao on 2017/11/7.
 */
public class ServerSocketListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //启动socket服务的线程
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //关闭socket线程的服务，释放监听端口
    }
}
