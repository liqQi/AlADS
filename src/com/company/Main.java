package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println(mi(2,1));
        System.out.println(mi(2,2));
        System.out.println(mi(2,3));
        System.out.println(mi(2,4));
        System.out.println(mi(2,5));
        System.out.println(mi(2,6));
    }

    public static String mi(int base,int day){
        BigInteger ret = new BigInteger(String.valueOf(base));
        for(int i =1;i<day;i++){
            ret = ret.multiply(ret);
        }
        return ret.toString();
    }
}
