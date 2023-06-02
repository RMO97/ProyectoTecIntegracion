package com.example.demo;

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
public class Configuracion extends WsConfigurerAdapter{

    //Definicion de los frijolitos

    //Definicion del esquema a utilizar
    @Bean
    public XsdSchema saludoSchema(){
        return new SimpleXsdSchema(new ClassPathResource("esquema.xsd"));
    }
    
    //Ruta base para las peticiones
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }


    //Ubicacion del wsdl para los endpoints
    @Bean(name = "lomitos")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema saludosSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("lomitosPort");        
        wsdl.setLocationUri("/ws");   
        wsdl.setTargetNamespace("https://perreria.uv.mx/lomitos");        
        wsdl.setSchema(saludosSchema);
        return wsdl;
    }
}