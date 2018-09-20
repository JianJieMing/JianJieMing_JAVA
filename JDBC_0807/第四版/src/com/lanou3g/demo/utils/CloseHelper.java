package com.lanou3g.demo.utils;

public class CloseHelper {

    public static void close(AutoCloseable... closeable){
        for (AutoCloseable closer : closeable) {
            if (closer != null) {
                try {
                    closer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
