package com.feng.example.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SocketServer {
    public static String _pattern = "yyyy-MM-dd HH:mm:ss SSS";
    public static SimpleDateFormat format = new SimpleDateFormat(_pattern);
    // 设置超时间
    public static int _sec = 0;
    // Scanner
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("----------Server----------");
        System.out.println(format.format(new Date()));

        ServerSocket server;
        try {
            server = new ServerSocket(8001);
            System.out.println("监听建立 等你上线\n");

            //1、建立连接
            Socket socket = server.accept();

            System.out.println(format.format(new Date()));
            System.out.println("建立了链接\n");

            while(true){

                //2、读消息
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(format.format(new Date()) + "\n" + reader.readLine() + "\n");

                //3、写消息
                Writer writer = new OutputStreamWriter(socket.getOutputStream());
                System.out.println(format.format(new Date()));
                String reply = input.nextLine();
                writer.write(reply + "\n");
                writer.flush();
            }


        } catch (SocketTimeoutException e) {
            System.out.println(format.format(new Date()) + "\n" + _sec + "秒没给我数据 我下啦\n\n\n\n\n");
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}