package LIMS.ims.pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest1 {
  @Test(dataProvider="data")
  public void f(String test0,String test1,String test2,String test3) {
	  System.out.println(test0);
	  System.out.println(test1);
	  System.out.println(test2);
	  System.out.println(test3);
  }
  
  @DataProvider( name="data")
  public static String[][] data(){
 
	  String[][] arr=new String[1][4];
	  arr[0][0]="Banglore";
	  arr[0][1]="pune";
	  arr[0][2]="Chennai";
	  arr[0][3]="Delhi";
	  return arr;
  }
  
  
}

