package com.yang.datastructer.array;

import com.yang.datastructure.array.DynamicArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.Consumer;

public class TestDynamicArray {

    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
//        dynamicArray.addLast(5);
        dynamicArray.add(2, 5);

        for (int i = 0; i < 5; i++) {
            System.out.println(dynamicArray.get(i));
        }
    }

    @Test
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

//        dynamicArray.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

//        dynamicArray.forEach((element) -> {
//            System.out.println(element);
//        });

        dynamicArray.foreach(System.out::println);
    }

    @Test
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        // 增强for的底层就是 hasNext() 和 next()
        for(Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    public void test4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("测试删除")
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        int removed = dynamicArray.remove(2);
        assertEquals(3, removed);
        dynamicArray.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("测试扩容")
    public void test6() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 9; i++) {
            dynamicArray.addLast(i + 1);
        }
        dynamicArray.foreach(System.out::println);
    }

}
