package zkz.example.servlet;

import zkz.example.Service.UserService;
import zkz.example.Service.impl.stuServiceImpl;
import zkz.example.Service.stuService;
import zkz.example.po.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/delStudentServlet")
public class delStudentServlet extends HttpServlet {
    private stuService stuService=new stuServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("id");
        int num=stuService.del(id);
        System.out.println(num+">");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        if(num!=0) {
            resp.getWriter().write("删除成功");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
