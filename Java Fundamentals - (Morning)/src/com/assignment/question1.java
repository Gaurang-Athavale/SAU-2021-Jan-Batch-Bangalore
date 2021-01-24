package com.assignment;

import java.util.ArrayList;
import java.util.Collections;

public class question1 {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int i=0; i<15; i++) {
            arrayList.add((int) (Math.random()*100));
        }

        System.out.println("Unsorted List: "+arrayList);
        Collections.sort(arrayList);
        System.out.println("Sorted List: "+arrayList);
    }
}
