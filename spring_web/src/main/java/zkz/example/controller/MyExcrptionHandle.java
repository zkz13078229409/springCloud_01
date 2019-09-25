package zkz.example.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import zkz.example.exception.UserNotExistExc;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/**
 * create by: zkz
 * description:
 * @ControllerAdvice注解 是该类成为异常处理器类
 * @ExceptionHandler  标注处理的异常类
 * create time: 11:26 2019/9/21
 * param :
 */
@ControllerAdvice
public class MyExcrptionHandle {

   /* @ResponseBody
    @ExceptionHandler(UserNotExistExc.class)
    public   Map<String,Object> handleException(Exception e){
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.not exist");
        map.put("message",e.getMessage());
        return map;
    }*/



    @ExceptionHandler(UserNotExistExc.class)
    public   String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        //一定要传入我们自己的错误状态码，否则默认是200
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("code","user.not exist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
