package main.multiProcess;

import java.io.*;
import java.net.URLDecoder;

public class Main {
    public static void main(String[] args) {
        // Example 1
//        for (int i = 0; i < 10; i++) {
//            Calculator calculator = new Calculator(i);
//            Thread thread = new Thread(calculator);
//            thread.run();
//        }

        // example 2
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximum Priority: %s\n", Thread.MAX_PRIORITY);

        Thread[] threads;
        Thread.State states[];

        // 运行10个线程，5个使用最高优先级，5个使用最低优先级
        threads = new Thread[10];
        states = new Thread.State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if (i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread_" + i);
        }

        //等待线程完成，同时将线程状态信息写入到文件
        PrintWriter pw = null;
        try {
            // 获取项目根路径
            String configFile = Main.class.getClassLoader().getResource("").getPath();
            configFile = URLDecoder.decode(configFile, "utf-8");

            System.out.println(configFile);

            File logFile = new File(configFile + "/data/log.txt");

            if (!logFile.getParentFile().exists()) {
                logFile.getParentFile().mkdirs();
            }
            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            FileWriter file = new FileWriter(logFile);
            pw = new PrintWriter(file);

            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
                states[i] = threads[i].getState();
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != states[i]) { // 如果线程状态发生了变化
                        writeThreadInfo(pw, threads[i], states[i]); // 将线程变化之前的状态写入文件
                        states[i] = threads[i].getState(); // 记录新的状态
                    }
                }

                finish = true;
                for (int i = 0; i < 10; i++) {
                    // 如果所有线程都终止了finish就为true
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    /**
     * 将线程状态信息写入到一个文件中
     *
     * @param pw     写数据的流
     * @param thread 信息要被写入文件的线程
     * @param state  线程的前一个状态
     */
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d ---- %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority:  %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");

    }
}
