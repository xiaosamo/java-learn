package com.yuanshijia.javalearn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author yuan
 * @date 2019/8/24
 * @description
 */
public class ClientHandler {

    public static final int MAX_DATA_LEN = 1024;
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        System.out.println("新的客户端连接");
        new Thread(() -> {
            doStart();
        }).start();
    }

    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] data = new byte[MAX_DATA_LEN];
            int len;
            while ((len = inputStream.read(data)) != -1) {
                String msg = new String(data, 0, len);
                System.out.println("客户端传来消息:" + msg);
                socket.getOutputStream().write(data); // 获取客户端的输出流，把数据返回到客户端
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
