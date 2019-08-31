package com.yuanshijia.javalearn.socket2;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author yuan
 * @date 2019/8/31
 * @description
 * 连接上服务端 8000 端口之后，每隔 2 秒，我们向服务端写一个带有时间戳的 "hello world"。
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", IOServer.port);
                while (true) {
                    try {
                        String msg = new Date() + ": hello world";
                        // 发送到服务端
                        System.out.println("客户端发送数据：" + msg);
                        socket.getOutputStream().write(msg.getBytes());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
