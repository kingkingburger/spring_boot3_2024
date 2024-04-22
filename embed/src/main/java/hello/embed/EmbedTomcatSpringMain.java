package hello.embed;

import hello.spring.HelloConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class EmbedTomcatSpringMain {
    public static void main(String[] args) throws LifecycleException {
    System.out.println("Embedded Tomcat");

        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(9080);
        tomcat.setConnector(connector);

        //스프링 컨테이너 생성
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(HelloConfig.class);

        // 디스패처 서블릿 생성, 스프링 연결
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);

        // 디스패처 서블릿 등록
        Context context = tomcat.addContext("", "/");

        //== 코드 추가 시작==
        File docBaseFile = new File(context.getDocBase());
        if (!docBaseFile.isAbsolute()) {
            docBaseFile = new File(((org.apache.catalina.Host)
                    context.getParent()).getAppBaseFile(), docBaseFile.getPath());
        }
        docBaseFile.mkdirs();
        //== 코드 추가 종료==


        tomcat.addServlet("", "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/", "dispatcher");

        tomcat.start();

    }
}
