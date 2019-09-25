package zkz.example.exception;
/**
 * create by: zkz
 * description: 自定义用户不存在吟异常
 * create time: 11:14 2019/9/21
 * param :
 */
public class UserNotExistExc extends RuntimeException {
    public UserNotExistExc(){
        super("用户不存在");
    }

}
