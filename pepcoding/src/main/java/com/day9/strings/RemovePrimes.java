package com.day9.strings;

import java.io.*;
import java.util.*;

public class RemovePrimes {

    public static boolean isPrime(int val)
    {
        for(int div = 2; div*div <= val ;div++)
        {
            if(val % div == 0)
            {
                return false;
            }

        }

        return true;
    }
    public static void solution(ArrayList<Integer> al){
        // write your code here
        int n = al.size();
        /**
         * Important Tip::
         * As we are doing in place element deletion :  we should start from back else the array index
         */
        for(int i = n-1;i>=0;i--)
        {
            int val = al.get(i);
            if(isPrime(val))
            {
                al.remove(i);
            }
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }

}

