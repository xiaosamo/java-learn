package com.yuanshijia.javalearn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @author yuan
 * @date 2019/8/24
 * @description
 */
public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, PORT);
        new Thread(() -> {
            System.out.println("客户端启动成功");
            while (true) {
                String msg = "hello, now time : " + new Date();
                System.out.println("客户端发送数据：" + msg);
                try {
                    socket.getOutputStream().write(msg.getBytes());
                } catch (IOException e) {
                    System.err.println("客户端接收数据出错");
                    e.printStackTrace();
                }
                sleep();
            }
        }).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
