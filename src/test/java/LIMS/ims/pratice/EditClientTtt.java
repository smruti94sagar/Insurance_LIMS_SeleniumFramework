package LIMS.ims.pratice;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.LIMS.genericUtility.ActionUtility;
import com.LIMS.genericUtility.CharacteristicUtility;
import com.LIMS.genericUtility.FrameUtility;
import com.LIMS.genericUtility.SelectUtility;
import com.LIMS.genericUtility.SeleniumUtility;
import com.LIMS.genericUtility.TabulationUtility;
import com.LIMS.genericUtility.WaitUtility;
import com.LIMS.genericUtility.enums.ExcellSheet;
import com.LIMS.genericUtility.enums.FreameworkConstant;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.objectRepository.elements.ClickAddClientPage;
import com.LIMS.objectRepository.elements.LoginPage;

public class EditClientTtt {
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
		//System.out.println(password);
		String sheetname=ExcellSheet.CLIENT.getSheetName();
		String expTEstCase="editclient";
		WebDriver driver=sel.launchWebBrowser("chrome");
		LoginPage lgp=new LoginPage (driver);
		sel.maximiseWindow(driver);	
		System.out.println(url);
		Map<String, String> map = tabl.getData(sheetname, expTEstCase);
		System.out.println(map);
		sel.getApplication(driver, url);
		wait.waitForPageLoad(driver);
		lgp.LoginAction(username, password);
	
		
		/*driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
	    driver.findElement(By.xpath("//a[text()='Client Status']")).click();
	    driver.findElement(By.xpath("//a[text()='Edit Client']")).click();
	    driver.findElement(By.name("fileToUpload")).sendKeys("F:\\\\wp5747176.jpg");
	    driver.findElement(By.xpath("//input[@name='client_id']")).sendKeys("89745612");
	    driver.findElement(By.name("client_password")).sendKeys("7894");
	    driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Hari");
	    driver.findElement(By.xpath("//input[@name='sex']")).sendKeys("male");
	    driver.findElement(By.name("marital_status")).sendKeys("unmarried");
	    driver.findElement(By.xpath("//input[@name='nid']")).sendKeys("852");
	    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("2301698741");
	    driver.findElement(By.xpath("//input[@name='address']")).sendKeys("pune");
	    driver.findElement(By.xpath("//input[@name='policy_id']")).sendKeys("0069");
	    driver.findElement(By.name("agent_id")).sendKeys("896472");
	    driver.findElement(By.xpath("//input[@name='submit']")).click();
	    driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
	    List<WebElement>list=driver.findElements(By.xpath("//tbody/tr/td/following-sibling::td"));
	    for(WebElement alllist:list)
	    {
		 String name=alllist.getText();
		  if(name.equals("smruti"))
		   {
			System.out.println("client update successfully");
		    }
	   }
	     driver.findElement(By.className("btn-danger")).click();
*/
}
}


