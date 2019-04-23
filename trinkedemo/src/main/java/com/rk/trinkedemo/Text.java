package com.rk.trinkedemo;

import java.util.TreeMap;

/**
 * @author orange
 * @time 2019-04-14 10:51
 */
public class Text {
    public static void main(String[] args){

        int [] target={10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35};
        count(target);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(5,10);
        map.put(1,2);

    }

    private static void count(int[] target) {
        int temp=0;
        int index=-1;
        for (int i = 0; i < target.length; i++) {
            if (target[i] < 0) {
                temp=target[i];
                target[i]=target[index+1];
                target[index+1]=temp;
                index++;
            }
        }
        for (int i = 0; i < target.length; i++) {
            System.out.print(""+target[i]+"\r\n");
        }

    }
}
