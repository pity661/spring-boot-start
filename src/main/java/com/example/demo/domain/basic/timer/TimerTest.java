package com.example.demo.domain.basic.timer;

import java.awt.*;
import java.util.Date;
import javax.swing.*;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-11-13 14:28
 */
public class TimerTest {
  public static void main(String[] args) {
    //

    Timer t =
        new Timer(
            3000,
            event -> {
              System.out.println("At the tone, the time is " + new Date());
              Toolkit.getDefaultToolkit().beep();
            });
    t.start();
    JOptionPane.showMessageDialog(null, "Quit program?");
    System.exit(0);
  }
}
