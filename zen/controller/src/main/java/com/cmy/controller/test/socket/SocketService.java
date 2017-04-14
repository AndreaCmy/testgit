package com.cmy.controller.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mengyingc on 2017/4/5.
 */
public class SocketService {
    public static void main(String[] args) {
        SocketService socketService = new SocketService();
        socketService.oneServer();
    }

    public void oneServer(){
       try{
           ServerSocket serverSocket = new ServerSocket(5200);
           System.out.println("服务器启动成功,开始监听端口5200》》");
           while(true){
               Socket socket = null;
               socket = serverSocket.accept();
               System.out.println("阻塞，服务器开始接受请求 from"+ socket.getInetAddress() + ":" +socket.getPort());

               //socket输入流
               BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

               //socket输出流
               PrintWriter writerToClient = new PrintWriter(socket.getOutputStream());
               //服务器端控制台输入
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               String line = inFromClient.readLine();
               while(line != null && !line.equals("")) {
                   writerToClient.println("Client say:"+line);
                   writerToClient.flush();
                   System.out.println("Client say:" + line);
                   line = inFromClient.readLine();
               }//end while




               //关闭资源
               writerToClient.close();
               inFromClient.close();
               br.close();;
               socket.close();
               serverSocket.close();
           }

       }catch (Exception e){

       }

    }
}


