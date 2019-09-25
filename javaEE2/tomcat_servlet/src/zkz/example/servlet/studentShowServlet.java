package zkz.example.servlet;


import com.google.gson.Gson;
import zkz.example.Service.impl.stuServiceImpl;
import zkz.example.Service.stuService;
import zkz.example.po.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/studentShowServlet")
public class studentShowServlet extends HttpServlet {
   private stuService stuService=new stuServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("stuId"));
        //学生信息查询
        resp.setHeader("Content-type", "text/html;charset=UTF-8");

        resp.setCharacterEncoding("UTF-8");
      student student= stuService.selectById(req.getParameter("stuId"));
      //转化为json格式
        Gson gson = new Gson();
        String result = gson.toJson(student);

        resp.getWriter().print(result);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
