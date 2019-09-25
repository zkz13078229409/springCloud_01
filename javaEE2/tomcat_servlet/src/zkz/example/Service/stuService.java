package zkz.example.Service;

import zkz.example.po.student;

public interface stuService {
    public student selectById(String stuId) ;

     public Integer updateById(student json1);

   public  int del(String id);

    Integer addStudent(student json1);
}
