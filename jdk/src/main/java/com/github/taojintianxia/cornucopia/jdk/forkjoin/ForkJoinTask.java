package com.github.taojintianxia.cornucopia.jdk.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTask extends RecursiveTask<Integer> {
    
    private static final int MAX = 50;
    private int arr[];
    private int start;
    private int end;
    
    public ForkJoinTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Integer compute() {
        int sum = 0;
        // 当 end-start 的值小于 MAX 时候，开始打印
        if ((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            System.out.println("===== 任务分解 ======");
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            ForkJoinTask left = new ForkJoinTask(arr, start, middle);
            ForkJoinTask right = new ForkJoinTask(arr, middle, end);
            // 并行执行两个小任务
            left.fork();
            right.fork();
            // 把两个小任务累加的结果合并起来
            return left.join() + right.join();
        }
    }
}
