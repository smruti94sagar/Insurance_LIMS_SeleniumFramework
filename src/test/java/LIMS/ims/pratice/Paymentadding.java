package LIMS.ims.pratice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.LIMS.genericUtility.ActionUtility;
import com.LIMS.genericUtility.CharacteristicUtility;
import com.LIMS.genericUtility.FrameUtility;
import com.LIMS.genericUtility.SelectUtility;
import com.LIMS.genericUtility.SeleniumUtility;
import com.LIMS.genericUtility.TabulationUtility;
import com.LIMS.genericUtility.VerificationUtility;
import com.LIMS.genericUtility.WaitUtility;
import com.LIMS.genericUtility.enums.FreameworkConstant;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.genericUtility.enums.pyamentdeatils;
import com.LIMS.objectRepository.elements.AddPaymentPage;
import com.LIMS.objectRepository.elements.ClickAddClientPage;
import com.LIMS.objectRepository.elements.LoginPage;

public class Paymentadding {
	static WebDriver driver;
    public static void main(String[]args) throws IOException
	{
		SeleniumUtility sel=new SeleniumUtility();	
		ActionUtility action=new ActionUtility();
		FrameUtility fram=new FrameUtility();
	
		SelectUtility select=new SelectUtility();
		WaitUtility wait=new WaitUtility();
		
		//data
		CharacteristicUtility chart=new CharacteristicUtility(FreameworkConstant.TEST_PROPERTY_FILE_PATH);
		TabulationUtility tabl=new TabulationUtility(FreameworkConstant.TEST_EXCEL_FILE_PATH);
		//commondata
		String browser=chart.getPropertyData(PropertiesFile.BROWSER);
		String url=chart.getPropertyData(PropertiesFile.URL);
		String img=chart.getPropertyData(PropertiesFile.IMAGEPATH);
		String time=chart.getPropertyData(PropertiesFile.TIMEOUT);
		String username=chart.getPropertyData(PropertiesFile.USERNAME);
		String password=chart.getPropertyData(PropertiesFile.PASSWORD);
		System.out.println(url);
		String sheetname=pyamentdeatils.CLIENT.getSheetName();
		String expTEstCase="addpayment";
	    System.out.println(tabl.getData(sheetname, expTEstCase, "Recipt_No"));
	    
	    //System.out.println(tabl.getData(sheetname, "Addclient","name"));
		WebDriver driver=sel.launchWebBrowser("chrome");
		sel.maximiseWindow(driver);	
		System.out.println(url);
		sel.getApplication(driver, url);
		wait.waitForPageLoad(driver);
		LoginPage lgp=new LoginPage (driver);
		lgp.LoginAction(username, password);
		driver.findElement(By.xpath("//a[contains(text(),'CLIENTS')]")).click();
		driver.findElement(By.xpath("//a[@href='clientStatus.php?client_id=1511986754']")).click();
		driver.findElement(By.xpath("//a[text()='Add Payment']")).click();
		driver.findElement(By.name("recipt_no")).click();
		driver.findElement(By.name("client_id")).click();
		String month=tabl.getData(sheetname, "addpayment", "Month");
		driver.findElement(By.xpath("//input[@name='month']")).sendKeys(month);
		String amount=tabl.getData(sheetname, "addpayment", "Amount");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(amount);
		String due=tabl.getData(sheetname, "addpayment", "Due");
		driver.findElement(By.xpath("//input[@name='due']")).sendKeys(due);
		String fine=tabl.getData(sheetname, "addpayment", "Fine");
		driver.findElement(By.xpath("//input[@name='fine']")).sendKeys(fine);
		driver.findElement(By.name("agent_id")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='PAYMENTS']")).click();
		List<WebElement>list=driver.findElements(By.xpath("//tbody/tr/td/following-sibling::td"));
		for(WebElement alllist:list)
		{
			String id=alllist.getText();
			if(id.equals("1511987920"))
			{
				System.out.println("payment added sucessfully");
				break;
			}
		}
		driver.findElement(By.className("btn-danger")).click();
		driver.close();
	}
}
		
		
		
		
		
		/*driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'CLIENTS')]")).click();
		driver.findElement(By.xpath("//a[@href='clientStatus.php?client_id=1511986754']")).click();
		driver.findElement(By.xpath("//a[text()='Add Payment']")).click();
		driver.findElement(By.name("recipt_no")).sendKeys("1675329554_657334077");
		driver.findElement(By.name("client_id")).sendKeys("1675320052");
		driver.findElement(By.xpath("//input[@name='month']")).sendKeys("july");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("50000");
		driver.findElement(By.xpath("//input[@name='due']")).sendKeys("4000");
		driver.findElement(By.xpath("//input[@name='fine']")).sendKeys("8000");
		driver.findElement(By.name("agent_id")).sendKeys("555");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='PAYMENTS']")).click();
		List<WebElement>list=driver.findElements(By.xpath("//tbody/tr/td/following-sibling::td"));
		for(WebElement alllist:list)
		{
			String id=alllist.getText();
			if(id.equals("1511987920"))
			{
				System.out.println("payment added sucessfully");
				break;
			}
		}
		driver.findElement(By.className("btn-danger")).click();
		driver.close();
*/
		/*String testCaseName = "AddPaymentTest";
		SeleniumUtility sel = new SeleniumUtility();
		ActionUtility action = new ActionUtility();
		FrameUtility fram = new FrameUtility();

		SelectUtility select = new SelectUtility();
		WaitUtility wait = new WaitUtility();

		// data
		CharacteristicUtility chart = new CharacteristicUtility(FreameworkConstant.TEST_PROPERTY_FILE_PATH);
		TabulationUtility tabl = new TabulationUtility(FreameworkConstant.TEST_EXCEL_FILE_PATH);
		// commondata
		String browser = chart.getPropertyData(PropertiesFile.BROWSER);
		String url = chart.getPropertyData(PropertiesFile.URL);
		String img = chart.getPropertyData(PropertiesFile.IMAGEPATH);
		String time = chart.getPropertyData(PropertiesFile.TIMEOUT);
		String username = chart.getPropertyData(PropertiesFile.USERNAME);
		String password = chart.getPropertyData(PropertiesFile.PASSWORD);
		System.out.println(url);
		String sheetname = pyamentdeatils.CLIENT.getSheetName();
		String expTEstCase = "addpayment";
		WebDriver driver = sel.launchWebBrowser("chrome");
		LoginPage lgp = new LoginPage(driver);
		sel.maximiseWindow(driver);
		System.out.println(url);
		Map<String, String> map = tabl.getData(sheetname, expTEstCase);
		sel.getApplication(driver, url);
		Map<String, String> verifyData = tabl.getData("verificationData", testCaseName);
		VerificationUtility verificationUtility = new VerificationUtility();
		verificationUtility.partialverification(driver.getTitle(), verifyData.get("loginTtle"), "page", "login page");
		wait.waitForPageLoad(driver);
		lgp.LoginAction(username, password);
		ClickAddClientPage adp = new ClickAddClientPage(driver);
		adp.Clickclientsts();
		AddPaymentPage ap = new AddPaymentPage(driver);
		ap.addNewPayment(map);
		sel.closeAllWindow(driver);

}
}
*/

