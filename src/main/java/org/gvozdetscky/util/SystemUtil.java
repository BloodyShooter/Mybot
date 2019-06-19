package org.gvozdetscky.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SystemUtil {

    public BufferedImage getScreenShot() {
        try {
            return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (AWTException e) {
            e.printStackTrace();
        }

        return null;
    }

    public InputStream getInputStreamScreenShot() {

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try {
            ImageIO.write(getScreenShot(), "png", os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(os.toByteArray());
    }
}
