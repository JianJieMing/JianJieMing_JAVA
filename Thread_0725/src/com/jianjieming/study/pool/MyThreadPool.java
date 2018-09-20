package com.jianjieming.study.pool;

/**
 * 我的线程池
 *
 * @author 铭
 */
public class MyThreadPool {

    private SubThread[] threads;

    public MyThreadPool(int poolSize) {
        threads = new SubThread[poolSize];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new SubThread();
        }
    }

//    开启线程池
    public void start(){
        for (SubThread thread : threads) {
//            遍历并开始所有线程
            thread.start();
        }
    }

    public void execute(Runnable r){
        SubThread.add(r);
    }

}
