package zkz.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zkz.example.dao.DepartmentDao;
import zkz.example.dao.EmployeeDao;
import zkz.example.entities.Department;
import zkz.example.entities.Employee;

import java.util.Collection;
import java.util.Map;

@Controller
public class empsController {
        @Autowired
    EmployeeDao employeeDao;
        @Autowired
    DepartmentDao departmentDao;
    //查询所有员工
    @GetMapping("/emps")
    public String list( Model model){
        Collection<Employee> employeeDaoAll = employeeDao.getAll();
        model.addAttribute("emps",employeeDaoAll);
        return "emps/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //执行操作后需要重定向或者转发到当前项目下的List界面
        //redirect:/表示当前项目下
        //forward
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //处理修改页面的请求,查处当前员工然后回显
//    PathVariable 获取请求的路径中变量的值
    //获取到的e对象使用model保存
    @GetMapping("/emp/{id}")
    public String EditPage(@PathVariable("id") Integer id,Model model){
        System.out.println(id);
        //页面选举要显示所欲部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        Employee e=     employeeDao.get(id);
        model.addAttribute("emp",e);
        //回到修改页面
        return "emps/add";

    }
    //员工修改
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println(employee+"修改的员工数据");
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //员工删除
    @DeleteMapping("/emp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
