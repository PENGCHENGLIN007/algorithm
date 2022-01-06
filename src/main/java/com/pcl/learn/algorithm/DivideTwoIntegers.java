package com.pcl.learn.algorithm;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int rs = DivideTwoIntegers.divide(10,3);
        System.out.println(rs);
    }
    public static  int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if(divisor==dividend){
            return 1;
        }
        if(0==divisor+dividend){
            return -1;
        }
        boolean sign;
        if(dividend>0 && divisor>0){
            sign = true;
        }else if(dividend>0 && divisor<0){
            sign = false;
            divisor = 0-divisor;
        }else if(dividend<0 && divisor>0){
            sign = false;
            dividend = 0-dividend;
        }else{
            sign = true;
            divisor = 0-divisor;
            dividend = 0-dividend;
        }

        int i = 0;
        int sum = divisor;
        while(sum<dividend){
            sum+=divisor;
            i++;
        }
        if(sign==false){
            return -i;
        }else{
            return i;
        }

    }
}
