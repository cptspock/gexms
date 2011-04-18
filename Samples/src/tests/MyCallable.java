package tests;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<Integer> {

	public Integer call() throws java.io.IOException {
		return 1;
	}

	public static void main(String args[]) {
		FutureTask<Integer> task = new FutureTask<Integer>(new MyCallable());
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.submit(task);
		try {
			Integer result = (Integer) task.get();
			System.out.println("Result from task.get () = " + result);
		} catch (Exception e) {
			System.err.println(e);
		}
		es.shutdown();
	}
}
