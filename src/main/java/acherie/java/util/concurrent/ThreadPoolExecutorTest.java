package acherie.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = new ThreadPoolExecutor(1, 1,
                0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        executorService.execute(() -> {
            System.out.println("------------111---------------");
        });

        TimeUnit.SECONDS.sleep(5);

        executorService.execute(new Run1());
    }

    static class Run1 implements Runnable {

        @Override
        public void run() {
            int count = 0;
            while (true) {
                count++;
                System.out.println("-----------222--------------" + count);

                if (count == 10) {
                    System.out.println(1 / 0);
                }

                if (count == 20) {
                    System.out.println("count=" + count);
                    break;
                }
            }
        }
    }
}
