package com.training.arrayapp;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int myarray[];
        myarray=new int[5];
        myarray[0]=101;
        myarray[1]=102;
        myarray[2]=303;
        myarray[3]=504;
        myarray[4]=105;
        
        System.out.println(myarray);
        System.out.println(Arrays.toString(myarray));
        
        for(int i=0;i<myarray.length;i++) {
        	System.out.println(myarray[i]);
            
        }
        for(int num:myarray) {
        	System.out.println(num);
            
        }
        
       Arrays.sort(myarray);
       System.out.println(Arrays.toString(myarray));
       }
    }
