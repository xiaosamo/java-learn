package com.yuanshijia.javalearn.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yuan
 * @date 2019/8/31
 * @description
 * https://juejin.im/book/5b4bc28bf265da0f60130116/section/5b4bc28b5188251b1f224ee5
 */
public class IOServer {

    public static final int port = 8000;
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务端启动，端口:"+port);
        // (1) 接收新连接线程
        new Thread(() -> {
            // 死循环的目的就是不断监测这条连接上是否有数据可以读
            while (true) {
                // (1) 阻塞方法获取新的连接
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("新连接接入...");
                    // (2) 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            byte[] data = new byte[1024];
                            int len;
                            InputStream inputStream = socket.getInputStream();
                            while ((len = inputStream.read(data)) != -1) {
                                String msg = new String(data, 0, len);
                                System.out.println("服务端收到消息：" + msg);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
