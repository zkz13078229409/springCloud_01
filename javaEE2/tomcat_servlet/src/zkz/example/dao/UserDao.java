package zkz.example.dao;

import zkz.example.po.User;
import zkz.example.po.student;
import zkz.example.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/***
 * 使用读写分离完成admin表的登陆增删改查操作
 */
public class UserDao {

    /***
     * 登陆 查询readHost
     * @param name
     * @param password
     */
    public User login(String name, String password) {
       //获取数据链接
        Connection con = DBUtils.openConnection();
        PreparedStatement pst=null;
        ResultSet rs =null;
        User user =null;
        try {
            pst=con.prepareStatement("select * from teacher where username=? and password=?");
            pst.setString(1,name);
            pst.setString(2,password);
            rs=pst.executeQuery();
            while(rs.next()){
                user =new User();
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getInt("sex")==1?"男":"女");
                user.setPhone(rs.getInt("phone"));
                user.setId(rs.getInt("Id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(rs!=null)
                    rs.close();
                if(pst!=null)
                    pst.close();
                 con.close();
            }catch (SQLException e) {

            }
            return user;
        }
    }

    public int addUser(String name, String password) {
        Connection con =null;
        PreparedStatement pst =null;
        int count=0;
        try {
            pst=con.prepareStatement("insert into admin(username,password) values(?,?)");
            pst.setString(1,name);
            pst.setString(2,password);
            count=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
               if(pst!=null)
                   pst.close();
               con.close();
            }catch(Exception e){
            }
        }
        return count;
    }

    /***
     * 查询所有的用户列表
     * @return
     */
    public List<User> getAllUsers() {
        List<User> users =new ArrayList<>();
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            pst=con.prepareStatement("select * from admin");
            rs=pst.executeQuery();
            while(rs.next()){
                User user =new User();
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        }catch(Exception e){

        }finally{
            try{
                if(rs!=null)
                    rs.close();
                if(pst!=null)
                    pst.close();
                con.close();
            }catch (Exception e){

            }
        }
        return users;
    }

    public int updateUser(int id, String name, String password) {
        Connection con =null;
        PreparedStatement pst=null;
        int count=0;
        try {
            pst=con.prepareStatement("update admin set username=?,password=? where id=?");
            pst.setString(1,name);
            pst.setString(2,password);
            pst.setInt(3,id);
            count=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(pst!=null)
                    pst.close();
                con.close();
            }catch(Exception e){
            }
        }
        return count;
    }

    /***
     * 删除用户根据
     * @param id
     * @return
     */
    public int deleteUser(int id) {
        int count =0;
        Connection con=null;
        PreparedStatement pst =null;
        try{
            pst=con.prepareStatement("delete from admin where id=?");
            pst.setInt(1,id);
            count =pst.executeUpdate();
        }catch (Exception e ){

        }finally {
            try{
                if(pst!=null)
                    pst.close();
                con.close();
            }catch(Exception e){
            }
        }
        return count;
    }
        //获取该教师的所有学生信息
    public int selectCount() {
        int totalCount=0;
        //获取连接对象
        Connection con =DBUtils.openConnection();
        PreparedStatement pst=null;
        ResultSet rs =null;
        try {
            pst=con.prepareStatement("select count(tsId) from ts");
            rs =pst.executeQuery();
            while(rs.next()){
                totalCount=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(con,pst,rs);
        return totalCount;
    }


        //查询几条数据
    public List<student> selectListLimit(int id ,int currentPage, int num) {
        Connection con= DBUtils.openConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        List<student> list=new ArrayList<>();
        String sql="select stu.studentNum,stu.studentName,stu.stuId,stu.sex,stu.phone from ts,student stu  where stu.stuId=ts.studentId and ts.teacherId=?  limit ?,? ";
        try {
            pst=con.prepareStatement(sql);
            System.out.println((currentPage-1)*num);
            pst.setInt(1,id);
            pst.setInt(2,(currentPage-1)*num);
            pst.setInt(3,num);
            rs=pst.executeQuery();
            while(rs.next()){
            student student=new student(rs.getInt("stuId"),
              rs.getInt("studentNum"),
              rs.getInt("sex")==1?"男":"女",
              rs.getInt("phone"),
              rs.getString("studentName"));
      list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(con,pst,rs);
        return list;

    }

    public User selectById(String id) {
        Connection con= DBUtils.openConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select * from teacher where Id=?";
        User user=null;
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1,(Integer.parseInt(id)));
            rs=pst.executeQuery();
            if(rs.next()){
               user=new User(rs.getString("username"), rs.getString("password"),
                        rs.getInt("sex")==1?"男":"女",rs.getInt("age"),
                        rs.getInt("phone"),rs.getInt("id")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(con,pst,rs);
        return user;

    }

    public Integer updateUserById(User json1) {
        Connection con= DBUtils.openConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        int update=0;
        System.out.println("男".equals(json1.getSex()));
        try {
            pst=con.prepareStatement("update teacher tea set  tea.username=?, tea.sex=?, tea.age=?, tea.password=? where tea.Id=?");
            pst.setString(1,json1.getName());
            pst.setInt(2,"男".equals(json1.getSex())?1:2);
            pst.setInt(3,json1.getAge());
            pst.setString(4,json1.getPassword());
            pst.setInt(5,json1.getId());
            update = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(con,pst,rs);
        return update;

    }
}
