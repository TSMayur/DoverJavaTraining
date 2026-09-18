package com.training.StaticApp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Employee e1=new Employee(1,"Mayur","DA");

    	Employee e2=new Employee(444,"Mayur","PM");
    	
    	System.out.println(e1);
    	System.out.println(e2);
    	System.out.println(Employee.getCount());
    	
    	
    }
}
