package org.gvozdetscky.util;

import static org.junit.Assert.*;

public class InetIPTest {

    private InetIP inetIP = new InetIP();

    @org.junit.Test
    public void getInetIP() {
        String ip = this.inetIP.getInetIP();

        String msg = "Не получили ip";

        assertNotNull(msg, ip);

        System.out.println("Внешний ip " + ip);
    }
}