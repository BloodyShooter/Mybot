package org.gvozdetscky.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class TaskManagerTest {

    @Test
    public void test() {

        HashMap<Integer, String> processMap = new HashMap<>();

        Stream<ProcessHandle> allProcesses = ProcessHandle.allProcesses();

        allProcesses.forEach(p -> {
            System.out.println(p.pid() + p.info().toString());
        });
    }

    private static String text(Optional<?> optional) {
        return optional.map(Object::toString).orElse("-");
    }

}