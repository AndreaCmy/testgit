package com.cmy.controller.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mengyingc on 2017/4/5.
 */
public class SocketClient {
    public static void main(String[] args) {

        try{
            Socket socket = new Socket("127.0.0.1", 5200);
            System.out.println("客户端启动成功,发送数据到端口5200");

            //向本机的5200发送请求
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
            //socket输出流
            PrintWriter writerToServer = new PrintWriter(socket.getOutputStream());
            //读取服务器端的响应信息
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 从系统标准输入读入一字符串
            String line = inFromClient.readLine();
            while(line != null && !line.equals("")){
                writerToServer.println("send to Server:" + line);
                writerToServer.flush();
                System.out.println("Server reply:" + inFromServer.readLine());
                line = inFromClient.readLine();
            }//end while





            //关闭资源
            writerToServer.close();
            inFromServer.close();
            inFromClient.close();;
            socket.close();
        }catch (Exception e){

        }

    }
}
