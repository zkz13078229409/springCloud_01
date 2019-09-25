package zkz.example.servlet;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

@WebServlet("/student/changeStudentServlet")
public class changeStudentServlet extends HttpServlet {
    private stuService stuService=new stuServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String json=req.getParameter("json1");
        System.out.println(json.toString()+">>>>");
        req.setCharacterEncoding("utf-8");

        Gson gson=new Gson();
        gson.toJson(json);
        student json1 = gson.fromJson(json,student.class);
       Integer i= stuService.updateById(json1);
        resp.setHeader("Content-type", "text/html;charset=UTF-8");

        resp.setCharacterEncoding("UTF-8");

        if(i!=0) {
            resp.getWriter().write("修改成功");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }
}
