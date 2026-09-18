package com.training.Singleton;


public class Single {
 private int num;
 //private static int count;
 private static Single single;
 
 private Single() {
  count++;
 }
 
 public static Single getInstance() {
  if(count==0) {
   single = new Single();
  }
  return single;
 }
  public int getNum() {
   return num;
  }
  
  public void setNum(int num) {
   this.num=num;
  }
}
 