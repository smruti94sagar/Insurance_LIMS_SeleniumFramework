package Org_InsuranceDomain_Clients;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.LIMS.genericUtility.ActionUtility;
import com.LIMS.genericUtility.CharacteristicUtility;
import com.LIMS.genericUtility.FrameUtility;
import com.LIMS.genericUtility.JavaUtility;
import com.LIMS.genericUtility.SelectUtility;
import com.LIMS.genericUtility.SeleniumUtility;
import com.LIMS.genericUtility.TabulationUtility;
import com.LIMS.genericUtility.WaitUtility;
import com.LIMS.genericUtility.enums.ExcellSheet;
import com.LIMS.genericUtility.enums.FreameworkConstant;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.objectRepository.elements.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheackClientStatusTest {
	public static void main(String[] args) throws IOException {
		SeleniumUtility sel = new SeleniumUtility();
		ActionUtility action = new ActionUtility();
		FrameUtility fram = new FrameUtility();
		
		SelectUtility select = new SelectUtility();
		JavaUtility ja = new JavaUtility();
		WaitUtility wait=new WaitUtility();

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
		ja.consolePrint(password);
		String sheetname = ExcellSheet.CLIENT.getSheetName();
		String expTEstCase = "Addclient";
		System.out.println(tabl.getData(sheetname, expTEstCase, "Client_id"));
		System.out.println(tabl.getData(sheetname, "Addclient", "name"));
		WebDriver driver = sel.launchWebBrowser("chrome");
		LoginPage lgp=new LoginPage (driver);
		sel.maximiseWindow(driver);
		System.out.println(url);
		sel.getApplication(driver, url);
		wait.waitForPageLoad(driver);
		lgp.LoginAction(username, password);
		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		driver.findElement(By.xpath("//a[text()='Client Status']")).click();
		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//tbody/tr/td/following-sibling::td"));
		for (WebElement alllist : list) 
		{
			String CLIENT_ID= alllist.getText();
			if (CLIENT_ID.equals("1675070241")) 
			{
				System.out.println("client update successfully");
				break;
			}
		}
		//driver.findElement(By.className("btn-danger")).click();
		driver.close();

	}
	
}
