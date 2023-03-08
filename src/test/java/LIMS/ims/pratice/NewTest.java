package LIMS.ims.pratice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest extends Commonclass {
  @AfterSuite
  public void Test1() {
	  
	   System.out.println("AfterSuite");
   }
  
  @AfterTest
  public void Test2()
  {
	  System.out.println("AfterTest");
  }
  @AfterClass
  public void Test3()
  {
	 System.out.println("AfterClass"); 
  }
  @AfterMethod
  public void Test4()
  {
	  System.out.println("AfterMethod");
  }
  @Test
  public void Test5()
  {
	  System.out.println("Test");
  }   
  @BeforeMethod
  public void Test6()
  {
	  System.out.println("BeforeMethod");
  }
  @BeforeClass
  public void Test7()
  {
	  System.out.println("BeforeClass");
  }
  @BeforeTest
  public void Test8()
  {
	  System.out.println("BeforeTest");
  }
  @BeforeSuite
  public void Test9()
  {
	  System.out.println("BeforeSuite");
  }
  
}

