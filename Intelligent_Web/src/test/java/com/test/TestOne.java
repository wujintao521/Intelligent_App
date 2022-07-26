package com.test;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class TestOne {

    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");

        List<List<String>> partition = ListUtils.partition(list, 3);
        partition.stream().forEach(sublist -> {
            System.out.println(sublist);
        });

    }

}
