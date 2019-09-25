package zkz.example.dao;

import sun.security.pkcs11.Secmod;
import zkz.example.po.student;
import zkz.example.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class stuDao {
    public student selectById(String stuId) {
        Connection con= DBUtils.openConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        student student=new student();
        try {
            pst=con.prepareStatement("select * from student where stuId=?");
            pst.setInt(1,Integer.parseInt(stuId));
            rs=pst.executeQuery();
            if(rs.next()){
                student.setStuId(rs.getInt("stuId"));
                student.setPhone(rs.getInt("phone"));
                    if(  rs.getInt("sex")==1){
                        student.setSex("男");
                    }
                    else{
                        student.setSex("女");
                    }

                student.setStuName(rs.getString("studentName"));
                student.setStuNum(rs.getInt("studentNum"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(con,pst,rs);
        return student;


    }

    public Integer updateById(student json1) {
        Connection con= DBUtils.openConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        int update=0;
        try {
            pst=con.prepareStatement("update student stu set  stu.studentNum=?, stu.studentName=?, stu.sex=?, stu.phone=? where stu.stuId=?");
            pst.setInt(1,json1.getStuNum());
            pst.setString(2,json1.getStuName());
            pst.setInt(3,"男".equals(json1.getSex())?1:2);
            pst.setInt(4,json1.getPhone());
            pst.setInt(5,json1.getStuId());
            update = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(con,pst,rs);
        return update;

    }

    public int del(String id) {
        Connection con= DBUtils.openConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        int update=0;

        try {
            pst=con.prepareStatement("DELETE  from student where stuId=?");
            pst.setInt(1,Integer.parseInt(id));
            update = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(con,pst,rs);
            return update;

    }

    public Integer addStudent(student json1) {
        Connection con= DBUtils.openConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        int update=0;
        try {
            pst=con.prepareStatement("insert into student (studentName,studentNum,sex,phone) values(?,?,?,?);");
            pst.setString(1,json1.getStuName());
            pst.setInt(2,json1.getStuNum());
            pst.setInt(3,"男".equals(json1.getSex())?1:2);
            pst.setInt(4,json1.getPhone());
            update = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(con,pst,rs);
        return update;


    }
}
