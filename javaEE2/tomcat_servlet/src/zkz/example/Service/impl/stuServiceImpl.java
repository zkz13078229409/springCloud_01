package zkz.example.Service.impl;

import zkz.example.Service.stuService;
import zkz.example.dao.stuDao;
import zkz.example.po.student;

public class stuServiceImpl implements stuService {
       private stuDao stuDao=new stuDao();
    @Override
    public student selectById(String stuId) {
           return  stuDao.selectById(stuId);

    }

    @Override
    public Integer updateById(student json1) {
       return stuDao.updateById(json1);

    }

    @Override
    public int del(String id) {
       return stuDao.del(id);
    }

    @Override
    public Integer addStudent(student json1) {
        return stuDao.addStudent(json1);
    }
}
