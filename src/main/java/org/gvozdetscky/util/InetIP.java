package org.gvozdetscky.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class InetIP {

    private static final String CHECKIP_AMAZONAWS_ADRRESS = "http://checkip.amazonaws.com";

    /**
     * Метод возврашает внешний p полученый с сайта amazonaws рессурс <a href="http://checkip.amazonaws.com">http://checkip.amazonaws.com</a>
     * @return Возврашает ip  строковом формате
     * Или null  случае возникновения Exception
     */
    public String getInetIP() {

        String ip = null;

        try {
            URL whatismyip = new URL(CHECKIP_AMAZONAWS_ADRRESS);

            try(BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()))) {

                ip = in.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ip;
    }

}
