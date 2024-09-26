package com.yang.datastructer.array;

import com.yang.datastructure.array.DynamicArray;
import org.junit.jupiter.api.Test;

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

}
