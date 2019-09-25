package test;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

/*实现序列化的两个条件
* 1:实现Serializable接口
* 2：该类的所有属性必须是可序列化的
* 如果有一个属性不是可序列化的，则该属性必须注明是短暂的。
* 对于不想序列化的属性，有专门的关键字 transient：private  transient String SSN;
* 当对该类序列化时，会自动忽略被 transient 修饰的属性。
*
*
* */
public class Employee  implements Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    @Test
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }


    //测试Socket链接
    public static void main(String [] args)
    {
        String serverName = args[0];
       // System.out.println(args[0]);
        int port = Integer.parseInt(args[1]);
        try
        {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }


}
