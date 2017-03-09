package acherie.java.util.concurrent;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>User: wangjie
 * <p>Date: 3/2/2017
 */
public class FutureTaskTest {

    @Test
    public void testFutureTaskAsyn() {
        FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("FutureTask thread:" + Thread.currentThread().getName());
                return Thread.currentThread().getName();
            }
        });

        stringFutureTask.run();

        System.out.println("Main thread:" + Thread.currentThread().getName());
        System.out.println("Main thread toString:" + Thread.currentThread());

        try {
            Assert.assertEquals(Thread.currentThread().getName(), stringFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
