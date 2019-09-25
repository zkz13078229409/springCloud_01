package zkz.example.config;

import com.sun.org.apache.xalan.internal.xsltc.dom.FilterIterator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zkz.example.listen.myListen;
import zkz.example.servlet.Myservlet;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;

/**
 * create by: zkz
 * description: 注册三大组件
 * create time: 15:14 2019/9/21
 * param :
 */
@Configuration
public class myServerConfig {
    //注册servlet容器
    @Bean
        public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<Myservlet> bean = new ServletRegistrationBean<>(new Myservlet(), "/myServlet");
           bean.setLoadOnStartup(1);
                return bean;
    }
    //注册过滤器
  @Bean
    public FilterRegistrationBean myFilter(){
      FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
      //设置过滤器类
      filterRegistrationBean.setFilter(new myFilter());
      //设置过滤的请求
      filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
      return filterRegistrationBean;
  }
  /*注册listen*/
  @Bean
    public ServletListenerRegistrationBean myListen(){
      ServletListenerRegistrationBean servletRegistrationBean = new ServletListenerRegistrationBean(new myListen());
      return servletRegistrationBean;
  }

}
