package test;

import java.io.*;
import java.net.Socket;

public class socket_test {
    public static void main(String [] args) throws Exception {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
      //  System.out.println(( client.getLocalSocketAddress().toString().getBytes()));
          out.write(( client.getLocalSocketAddress().toString().getBytes()));
           //out.writeUTF("hello world"+ client.getLocalSocketAddress().toString());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
           System.out.println("服务器响应： " + in.read());
    //    System.out.println("服务器响应2"+in.readUTF());
            client.close();

    }
}
