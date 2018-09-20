package com.jianjieming.Test;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomCallable implements Callable<Long> {

    private static final Random RANDOM = new Random();

    private Random r = new Random();

    //    作用: 可以保证在某个线程中都使用独立的某个对象
    private ThreadLocal<Random> local = new ThreadLocal<Random>() {
        @Override
        protected Random initialValue() {
            return new Random();
        }
    };

    private int mode;

    public RandomCallable(int mode) {
        this.mode = mode;
    }

    private Random getRandom() {
        switch (mode) {
            case 1:
                return RANDOM;
            case 2:
                return r;
            case 3:
                Random random = local.get();
                if (random == null) {
                    local.set(new Random());
                }
//                local.get()方法,只会取出与当前线程所绑定的对象.
                return local.get();
        }
        return null;
    }

    @Override
    public Long call() throws Exception {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            getRandom().nextInt();
        }
        return System.currentTimeMillis() - time;
    }
}
