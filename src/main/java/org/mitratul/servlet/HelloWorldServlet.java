package org.mitratul.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mitratul.service.ITalkService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloWorldServlet extends HttpServlet implements ApplicationContextAware {

    private static final long serialVersionUID = 3963827365159036525L;

    private long initTime;
    private ApplicationContext context;

    public HelloWorldServlet() {
        initTime = System.currentTimeMillis();
        System.out.println("Instantiating HelloWorldServlet @ " + initTime);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doProcess(req, resp, "doGet()");
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doProcess(req, resp, "doPost()");
    }


    private void doProcess(HttpServletRequest req, HttpServletResponse resp, String str)
            throws ServletException, IOException {
        resp.getOutputStream().println(
                "\"Hello World\" - says " + str + " of HelloWorldServlet (initialized @ " + initTime + ")");

        resp.getOutputStream().println(((ITalkService)context.getBean("talkServiceProxy")).sayHello());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
