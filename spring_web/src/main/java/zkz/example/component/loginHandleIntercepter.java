package zkz.example.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by: zkz
 * description: 登陆检查
 * create time: 17:31 2019/9/20
 * param :
 */
public class loginHandleIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     String username= (String) request.getSession().getAttribute("username");
     if(!StringUtils.isEmpty(username)){
         return true;
     }
     else{
         request.setAttribute("msg","没有权限，请先登陆!");
         request.getRequestDispatcher("/index.html").forward(request,response);
         return false;
     }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
