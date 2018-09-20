package com.jianjieming.study.pool;

/**
 * @author 铭
 */
public class PoolMain {
    public static void main(String[] args) throws InterruptedException {
        /*
            线程池
            阻塞队列
         */
//        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
//        实现一个简单的线程池.
//        SubThread t = new SubThread();
//        t.start();
//        SubThread t1 = new SubThread();
//        t1.start();
//        SubThread t2 = new SubThread();
//        t2.start();
//        for (int i = 0; i < 50; i++) {
//            final int index = i;
//            t.add(() -> {
//                Thread thread = Thread.currentThread();
//                System.out.println(thread.getName() + "任务" + index);
//                try {
//                    Thread.sleep(1500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }


//        queue.add(()->{});
//        queue.add(()->{});
//        queue.add(()->{});
////        先进先出
//        Runnable take1 = queue.take();
//        Runnable take2 = queue.take();
//        Runnable take3 = queue.take();
////        不给我菜我就不走,等菜来了就拿走
//        Runnable take4 = queue.take();


//        创建线程池对象,并设置线程数量
        MyThreadPool pool = new MyThreadPool(3);
        pool.start();
        for (int i = 0; i < 50; i++) {
            final int index = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务" + index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
}
