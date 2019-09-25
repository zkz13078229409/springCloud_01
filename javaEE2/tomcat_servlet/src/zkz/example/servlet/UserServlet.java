package zkz.example.servlet;

import zkz.example.Service.UserService;
import zkz.example.Service.impl.UserServiceImpl;
import zkz.example.po.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet  extends HttpServlet {


    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    /**
                 * create by: zkz
                 * description: 登陆逻辑
                 * create time: 20:45 2019/9/6
                 * param :
                 */


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入到登录逻辑");

        //获取参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
            User user=userService.check(username,password);
        System.out.println(user.getName());
        try{
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(user!=null){
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }


    }


}
