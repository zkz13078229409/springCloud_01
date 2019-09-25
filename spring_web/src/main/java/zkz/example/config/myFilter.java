package zkz.example.config;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.servlet.*;
import java.io.IOException;

public class myFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter执行.....");
            filterChain.doFilter(servletRequest,servletResponse);
    }


}
