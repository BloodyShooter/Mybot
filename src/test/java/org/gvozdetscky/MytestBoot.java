package org.gvozdetscky;

import javafx.scene.input.KeyCode;
import sun.awt.SunHints;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MytestBoot {

    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        Thread.sleep(2000);
        Random r = new Random();
        int x = r.nextInt(800) + 200;
        int y = r.nextInt(400) + 300;
        robot.mousePress(InputEvent.BUTTON1_MASK);
        for(int i = 0; i < 300; i++) {
            x += (r.nextInt(10) - 20);
            y += (r.nextInt(10) - 20);
            x = x % 1000;
            y = y % 700;
            if (x < 200) {
                x += 200;
            }
            if (y < 300) {
                y += 300;
            }

            robot.mouseMove(x, y);
            Thread.sleep(100);
        }
    }

    static void exit(Robot robot) throws InterruptedException {
        Thread.sleep(1000);
        robot.mouseMove(1250, 10);
        Thread.sleep(200);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(200);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(200);
        for (int i = 0; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_A);
            Thread.sleep(200);
        }
        Thread.sleep(200);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}