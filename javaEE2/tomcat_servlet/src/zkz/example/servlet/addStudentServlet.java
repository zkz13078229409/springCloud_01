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

@WebServlet("/student/addStudentServlet")
public class addStudentServlet extends HttpServlet {
    private zkz.example.Service.stuService stuService=new stuServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String json=req.getParameter("json1");
        System.out.println(json.toString()+"数据添加");
        req.setCharacterEncoding("utf-8");

        Gson gson=new Gson();
        gson.toJson(json);
        student student = gson.fromJson(json, student.class);
        Integer i= stuService.addStudent(student);
        resp.setHeader("Content-type", "text/html;charset=UTF-8");

        resp.setCharacterEncoding("UTF-8");

        if(i!=0) {
            resp.getWriter().write("添加成功");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
