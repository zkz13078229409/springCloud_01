package zkz.example.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * create by: zkz
 * description: 给容器中添加我们自定义的错误信息
 * create time: 12:07 2019/9/21
 * param :
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
        //返回值的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //获取父类的map
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        //在map中添加我自定义的错误信息
        errorAttributes.put("author","zkz");
        /*0表示从请求域中获取，1表示从session域中获取*/
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        errorAttributes.put("ext",ext);
        return errorAttributes;
    }
}
