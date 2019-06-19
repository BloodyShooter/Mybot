package org.gvozdetscky;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ideone {

    public static void main(String[] args) throws Exception {
        System.out.println(33 + 33 + "33" + 22);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HH:mm:ss");
        System.out.println(format.format(new Date()));

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        File file = new File("./screenshot.png");

        System.out.println("путь к файлу " + file.getAbsolutePath());

        System.out.println(ImageIO.write(image, "png", file));
    }

}
