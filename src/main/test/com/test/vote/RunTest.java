package com.test.vote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunTest {
	public static ExecutorService pool=Executors.newCachedThreadPool();
	public static void main(String[] args) {
		for(int i=1;i<20;i++){
			System.out.println("程序开始运行");
			pool.execute(new VoteCallable(4000, i));
			System.out.println("程序结束运行");
		}
		pool.shutdown();
	}
}
