package com.yuanshijia.javalearn.socket;

/**
 * @author yuan
 * @date 2019/8/24
 * @description
 */
public class ServerBoot {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }
}
