package zkz.example.Service;

import zkz.example.po.User;
import zkz.example.po.student;

import java.util.List;

public interface UserService {
    User check(String username, String password);

    int selectCount();

    List<student> selectListLimmit(int id,int totalPagesNum, int pagesCounts);

    User selectById(String id);

    Integer updateUserById(User json1);
}
