package zkz.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zkz.example.exception.UserNotExistExc;

import java.util.Arrays;
import java.util.Map;

@Controller
public class helloController {

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("msg","你好");
        map.put("h","<h1>哈哈</h1>");
        map.put("list",Arrays.asList("123","3435","45353"));
        return "success";
    }
//    @RequestMapping("/hello")
//    public String hello(){
//        return "success";
//    }
/*@RequestMapping({"/","index.html"})
    public String index(){
        return "index";
    }*/

@ResponseBody
@RequestMapping("/hello")
public String hello(@RequestParam("user") String user){
    if(user.equals("aaa")){
        throw  new UserNotExistExc();
    }
    return "hello world";
}

}
