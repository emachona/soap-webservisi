package com.example.soapwebservisi;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet>
            messageDispatcherServletServletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "oglasi")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema oglasiSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("OglasiPort");
        wsdl11Definition.setLocationUri("/ws");

        wsdl11Definition.setTargetNamespace("http://localhost.com/oglas");
        wsdl11Definition.setSchema(oglasiSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema oglasiSchema(){
        return new SimpleXsdSchema(new ClassPathResource("schema.xsd"));
    }
}
