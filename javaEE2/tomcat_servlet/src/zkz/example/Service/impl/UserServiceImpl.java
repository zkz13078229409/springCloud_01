package zkz.example.Service.impl;

import zkz.example.Service.UserService;
import zkz.example.dao.UserDao;
import zkz.example.po.User;
import zkz.example.po.student;

import java.util.List;

public class UserServiceImpl implements UserService {

private UserDao userDao=new UserDao();
    @Override
    public User check(String username, String password) {
       User user= userDao.login(username,password);
        System.out.println(user.toString());
       return user;
    }

    @Override
    public int selectCount() {
        return userDao.selectCount();
    }

    @Override
    public List<student> selectListLimmit(int id,int totalPagesNum, int pagesCounts) {
        return userDao.selectListLimit(id,totalPagesNum,pagesCounts);
    }

    @Override
    public User selectById(String id) {
        return userDao.selectById(id);

    }

    @Override
    public Integer updateUserById(User json1) {
        return userDao.updateUserById(json1);
    }
}
