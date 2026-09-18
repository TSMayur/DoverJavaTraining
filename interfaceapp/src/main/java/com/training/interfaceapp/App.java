package com.training.interfaceapp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Derived derived=new Derived();
        derived.show();
        Base base=new Derived();
        base.show();
       base=new Newderived();
       base.show();
        
    }
}
