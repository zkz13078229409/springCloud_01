package zkz.example.servlet;

import zkz.example.service.UserService;
import zkz.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/changeStatus")
public class changeStatusServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("changeStatus...");
        System.out.println(req.getParameter("work"));
        System.out.println(req.getParameter("id"));
        String work=req.getParameter("work");
        String id=req.getParameter("id");
        //判断操作

           Integer status= userService.changeStatus(id,work);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
