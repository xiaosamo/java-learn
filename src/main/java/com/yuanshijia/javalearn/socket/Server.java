package com.yuanshijia.javalearn.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yuan
 * @date 2019/8/24
 * @description
 */
public class Server {
    private ServerSocket serverSocket;

    public Server(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口:" + port);
        } catch (IOException e) {
            System.err.println("服务端启动失败");
            e.printStackTrace();
        }
    }

    public void start() {
        new Thread(() -> {
            doStart();
        }).start();
    }

    private void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept(); // accept会阻塞
                new ClientHandler(client).start();  // 每建立一个连接，创建一个线程去处理
            } catch (IOException e) {
                System.out.println("服务器异常");
                e.printStackTrace();
            }
        }
    }
}
