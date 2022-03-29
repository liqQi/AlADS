package com.company.cha2;

import java.util.Arrays;
import java.util.Random;

public class Test2_8 {

    public static void main(String[] args) {
        int[] len1 = new int[]{250, 500, 1000, 2000};
        long[] time1 = new long[4];
        for (int i = 0; i < len1.length; i++) {
            long total1 = 0L;
            for (int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                algorithm1(len1[i]);
                long end = System.nanoTime();
                total1 += (end - start);
            }
            time1[i] = total1/10;
        }
        System.out.println("algorithm1 time:"+Arrays.toString(time1));

        int[] len2 = new int[]{25000, 50000, 100000, 200000,400000,800000};
        long[] time2 = new long[6];
        for (int i = 0; i < len2.length; i++) {
            long total1 = 0L;
            for (int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                algorithm2(len2[i]);
                long end = System.nanoTime();
                total1 += (end - start);
            }
            time2[i] = total1/10;
        }
        System.out.println("algorithm2 time:"+Arrays.toString(time2));

        int[] len3 = new int[]{100000, 200000, 400000, 800000,1600000,3200000,6400000};
        long[] time3 = new long[7];
        for (int i = 0; i < len3.length; i++) {
            long total1 = 0L;
            for (int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                algorithm2(len3[i]);
                long end = System.nanoTime();
                total1 += (end - start);
            }
            time3[i] = total1/10;
        }
        System.out.println("algorithm2 time:"+Arrays.toString(time3));
    }

    private static int[] algorithm1(int len) {
        int[] ret = new int[len];
        Random random = new Random();
        boolean flag;
        for (int i = 0; i < ret.length; i++) {
            while (true) {
                int r = random.nextInt(len) + 1;
                flag = false;
                for (int j = 0; j < i; j++) {
                    if (ret[j] == r) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    ret[i] = r;
                    break;
                }
            }
        }
        return ret;
    }

    private static int[] algorithm2(int len) {
        int[] ret = new int[len];
        boolean[] flags = new boolean[len];
        Random random = new Random();
        for (int i = 0; i < ret.length; i++) {
            while (true) {
                int r = random.nextInt(len);
                if (!flags[r]) {
                    flags[r] = true;
                    ret[i] = r;
                    break;
                }
            }
        }
        return ret;
    }

    private static int[] algorithm3(int len){
        int[] ret = new int[len];
        Random random = new Random();
        for (int i = 0; i < ret.length; i++) {
            ret[i]=i+1;
        }
        for(int i=1;i<len;i++){
            swap(ret,i,random.nextInt(i));
        }
        return ret;
    }

    public static void swap(int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

class GetRandom {

    static Random random = new Random();

    public static int getRandomNumber(int i, int j) {
        if (i >= j) {
            return j;
        }
        return random.nextInt(j - i) + i;
    }

}
