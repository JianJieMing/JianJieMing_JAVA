package com.jianjieming.sping.study;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Unit test1 for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
        String str = "com.jianjieming.sping.study.Person";
        this.test(str);
    }

    public void test(String str) {
//        Person person = new Person();
        try {
            Class<?> aClass = Class.forName(str);
            System.out.println(aClass);
//            Class<? extends Person> aClass = person.getClass();
            Object o1 = aClass.newInstance();
//            Method eat = aClass.getDeclaredMethod("eat", String.class);
//            Object o = eat.invoke(instance, "张三");
            if (o1 instanceof Person) {
                ((Person) o1).eat("张三");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
