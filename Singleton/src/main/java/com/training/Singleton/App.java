package com.training.Singleton;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Single s1 = Single.getInstance();
        Single s2 = Single.getInstance();
        
        if(s1==s2) {
         System.out.println("same instance -- singleton");
        }
        else {
         System.out.println("different instances ");
        }
    }
}
 
