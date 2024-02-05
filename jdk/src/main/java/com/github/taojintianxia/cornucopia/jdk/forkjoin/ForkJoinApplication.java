package com.github.taojintianxia.cornucopia.jdk.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinApplication {
    
    public static void main(String... args) throws InterruptedException {
        List<Future<Integer>> futures = new ArrayList<>();
        
        int arr1[] = new int[10];
        int arr2[] = new int[100];
        int arr3[] = new int[1000];
        int arr4[] = new int[10000];
        int arr5[] = new int[100000];
        
        int total1 = 0;
        int total2 = 0;
        int total3 = 0;
        int total4 = 0;
        int total5 = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            total1 += (arr1[i] = i);
        }
        for (int i = 0; i < arr2.length; i++) {
            total2 += (arr2[i] = i);
        }
        for (int i = 0; i < arr3.length; i++) {
            total3 += (arr3[i] = i);
        }
        for (int i = 0; i < arr4.length; i++) {
            total4 += (arr4[i] = i);
        }
        for (int i = 0; i < arr5.length; i++) {
            total5 += (arr5[i] = i);
        }
        
        System.out.println("初始化 array1 时的总和 =" + total1);
        System.out.println("初始化 array2 时的总和 =" + total2);
        System.out.println("初始化 array3 时的总和 =" + total3);
        System.out.println("初始化 array4 时的总和 =" + total4);
        System.out.println("初始化 array5 时的总和 =" + total5);
        
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        futures.add(forkJoinPool.submit(new ForkJoinTask(arr1, 0, arr1.length)));
        futures.add(forkJoinPool.submit(new ForkJoinTask(arr2, 0, arr2.length)));
        futures.add(forkJoinPool.submit(new ForkJoinTask(arr3, 0, arr3.length)));
        futures.add(forkJoinPool.submit(new ForkJoinTask(arr4, 0, arr4.length)));
        futures.add(forkJoinPool.submit(new ForkJoinTask(arr5, 0, arr5.length)));
        
        // 提交可分解的 PrintTask 任务
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> futures.forEach(each -> {
            try {
                each.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }));
        
        
        completableFuture.whenComplete((v, e) -> {
            System.out.println("所有的任务都已经完成了");
        }).join();
        
        futures.forEach(each -> {
            try {
                System.out.println(" Feature 计算出来的总和  : " + each.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        //        System.out.println("计算出来的总和 =" + future.get());
        
        // Integer integer = forkJoinPool.invoke(new RecursiveTaskDemo(arr, 0, arr.length) );
        // System.out.println ("计算出来的总和 =" + integer);
        
        // 关闭线程池
        forkJoinPool.shutdown();
    }
}

