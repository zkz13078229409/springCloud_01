package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class socekt_test2 extends Thread {
    private ServerSocket serverSocket;

    public socekt_test2(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run()
    {
        System.out.println("海贼王");

            try
            {
               // System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
             //   System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
               // System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
                in.close();
                out.close();
                server.close();
            }catch(SocketTimeoutException s)
            {
              //  System.out.println("Socket timed out!");
            }catch(IOException e)
            {
                e.printStackTrace();
            }

    }
    public static void main(String [] args)
    {
        int port = Integer.parseInt(args[0]);
        System.out.println(port);
        try
        {
            Thread t = new socekt_test2(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }


}
