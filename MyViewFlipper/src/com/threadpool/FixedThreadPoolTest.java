
package com.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.os.Bundle;

public class FixedThreadPoolTest extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		 MyTask myTask = new MyTask();
	        ExecutorService exec = Executors.newFixedThreadPool(10);
	        for (int i = 0; i < 10; i++) {
	            exec.submit(myTask);
	        }
	}
	
	 static class MyTask implements Runnable {
	        @Override
	        public void run() {
	            System.out.println(System.currentTimeMillis() + ":thread id" + Thread.currentThread().getId());
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}