package org.gvozdetscky.util;

import java.util.stream.Stream;

public class TaskManager {

    public static String getRunProgramm() {

        Stream<ProcessHandle> allProcesses = ProcessHandle.allProcesses();

        StringBuffer str = new StringBuffer();

        allProcesses.forEach(p -> {
            if (p.info().command().isPresent()) {
                System.out.println(p.info().command().toString());
                str.append(p.info().command().toString()).append('\n');
            }

        });

        return str.toString();

    }
}
