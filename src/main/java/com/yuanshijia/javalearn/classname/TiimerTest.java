package com.yuanshijia.javalearn.classname;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author yuan
 * @date 2019/10/2
 * @description
 */
public class TiimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(1000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("now time = " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}