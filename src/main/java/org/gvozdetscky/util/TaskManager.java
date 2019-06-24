package org.gvozdetscky.util;

import java.util.stream.Stream;

public class TaskManager {

    public static String getRunProgramm() {

        Stream<ProcessHandle> allProcesses = ProcessHandle.allProcesses();

        StringBuffer str = new StringBuffer();

        allProcesses.forEach(p -> {
            if (p.info().command().isPresent()) {
                str.append(p.info().command().get()).append('\n');
            }

        });

        return str.toString();

    }

    public static String killProcess(String nameProcess) {
        Stream<ProcessHandle> allProcesses = ProcessHandle.allProcesses();

        StringBuffer str = new StringBuffer();

        allProcesses.forEach(p -> {
            if (p.info().command().isPresent()) {
                if (p.info().command().get().contains(nameProcess)) {
                    p.destroy();
                    str.append(p.info().command().get()).append("\n");
                }
            }

        });

        return str.toString();
    }
}
