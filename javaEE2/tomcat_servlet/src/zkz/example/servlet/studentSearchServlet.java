package zkz.example.servlet;

import zkz.example.Service.UserService;
import zkz.example.Service.impl.UserServiceImpl;
import zkz.example.po.User;
import zkz.example.po.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/studentSearchServlet/search")
//学生信息管理
public class studentSearchServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object id=req.getParameter("id");
        String page=req.getParameter("thisPage");
            int currentPage=1;
            if(!"".equals(page)&&page!=null) {
                currentPage = Integer.parseInt(page);
            }
        //设置每页显示的页数
        int num=3;
            //数据总数
        int totalPagesNum= userService.selectCount();
        //总页数
        int pagesCounts=(totalPagesNum%num==0)?(totalPagesNum/num):(totalPagesNum/num)+1;

        //获取当前页的数据
        List<student> stuList=userService.selectListLimmit(Integer.parseInt(id.toString()),currentPage,num);
        //设置数据
        req.setAttribute("totalPagesNum",totalPagesNum);
        req.setAttribute("pagesCount",pagesCounts);
        req.setAttribute("num",num);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("stuList",stuList);
        req.getRequestDispatcher("/resource/sys/role/list.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
