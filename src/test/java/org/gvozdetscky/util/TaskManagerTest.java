package org.gvozdetscky.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class TaskManagerTest {

    @Test
    public void test() {

        HashMap<Long, ProcessHandle> processMap = new HashMap<>();

        Stream<ProcessHandle> allProcesses = ProcessHandle.allProcesses();

        allProcesses.forEach(p -> {
            if (p.info().command().isPresent()) {
                System.out.println(p.info().command().toString());
                if (p.info().command().get().contains("chrome.exe")) {
                    processMap.put(p.pid(), p);
                }
            }

        });

        processMap.forEach((k, p) -> p.destroy());

    }

    private static String text(Optional<?> optional) {
        return optional.map(Object::toString).orElse("-");
    }

}