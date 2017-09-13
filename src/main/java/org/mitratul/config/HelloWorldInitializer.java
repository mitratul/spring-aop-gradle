package org.mitratul.config;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.mitratul.servlet.HelloWorldServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class HelloWorldInitializer implements WebApplicationInitializer  {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
//        AnnotationConfigWebApplicationContext rootContext =
//                new AnnotationConfigWebApplicationContext();
//        rootContext.register(AppConfig.class);
        XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
        rootContext.setConfigLocation("WEB-INF/spring/app-config.xml");
        rootContext.setServletContext(servletContext);
        rootContext.refresh();

        // Manage the life-cycle of the root application context
        //TODO: why is refresh() not called implicitly here? it is called later, after appServlet is initialized.
        servletContext.addListener(new ContextLoaderListener(rootContext));

        //* this will work with class based cglib proxy
//        HelloWorldServlet helloWorldServlet = (HelloWorldServlet) rootContext.getBean("helloWorldServletProxy");
//        final ServletRegistration.Dynamic appServlet0 = servletContext.addServlet(
//                "helloWorldServlet", helloWorldServlet);
//        appServlet0.setLoadOnStartup(1);
//        appServlet0.addMapping("/helloworld.do");

        //* This is for interface based jdk dynamic proxy
        Servlet hwServlet = (Servlet) rootContext.getBean("helloWorldServletProxy");
        final ServletRegistration.Dynamic appServlet1 = servletContext.addServlet(
                "hwServlet", hwServlet);
        appServlet1.setLoadOnStartup(1);
        appServlet1.addMapping("/helloworld.do");

        final ServletRegistration.Dynamic appServlet = servletContext.addServlet(
                "HelloServlet", new HelloWorldServlet());
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/hello.do");
    }

}
