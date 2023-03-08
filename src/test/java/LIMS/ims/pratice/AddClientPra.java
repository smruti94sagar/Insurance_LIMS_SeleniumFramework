package LIMS.ims.pratice;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.LIMS.genericUtility.ActionUtility;
import com.LIMS.genericUtility.CharacteristicUtility;
import com.LIMS.genericUtility.FrameUtility;
import com.LIMS.genericUtility.JavaScriptUtility;
import com.LIMS.genericUtility.SelectUtility;
import com.LIMS.genericUtility.SeleniumUtility;
import com.LIMS.genericUtility.TabulationUtility;
import com.LIMS.genericUtility.WaitUtility;
import com.LIMS.genericUtility.enums.ExcellSheet;
import com.LIMS.genericUtility.enums.FreameworkConstant;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.objectRepository.elements.AddClientPage;
import com.LIMS.objectRepository.elements.ClickAddClientPage;
import com.LIMS.objectRepository.elements.CommonPage;
import com.LIMS.objectRepository.elements.LoginPage;

public class AddClientPra {
	 static WebDriver driver;
		public static void main(String[]args) throws IOException {
			
			SeleniumUtility sel=new SeleniumUtility();	
			ActionUtility action=new ActionUtility();
			FrameUtility fram=new FrameUtility();
			JavaScriptUtility jsu=new JavaScriptUtility(driver);
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
			String expTEstCase="Addclient";
		    WebDriver driver=sel.launchWebBrowser("chrome");
			LoginPage lgp=new LoginPage (driver);
			sel.maximiseWindow(driver);	
			System.out.println(url);
			Map<String, String> map = tabl.getData(sheetname, expTEstCase);
			System.out.println(map.get("Client_id"));
		    sel.getApplication(driver, url);
			wait.waitForPageLoad(driver);
			lgp.LoginAction(username, password);
			ClickAddClientPage adp=new ClickAddClientPage(driver);
			adp.AddClient();
			CommonPage cp=new CommonPage(driver);
			Map<String, String> key = tabl.getData(sheetname, "Addclient");
			cp.setDataIntoclient(key);

//			//driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
//			//driver.findElement(By.xpath("//a[text()='Add Client']")).click();
//			tabl.getData("client", "Addclient");
//			String clientid=tabl.getData(sheetname, "Addclient","Client_id");
//			String clientpassword=tabl.getData(sheetname, "Addclient", "Client_password");
//			String cl_name=tabl.getData(sheetname, "Addclient", "Name");
//			String cl_gen=tabl.getData(sheetname, "Addclient", "Gender");
//			String cl_dob=tabl.getData(sheetname, "Addclient", "Birth_Date");
//			String cl_sta=tabl.getData(sheetname, "Addclient", "Marital_Status");
//			String cl_nd=tabl.getData(sheetname, "Addclient", "National_ID");
//			String phone=tabl.getData(sheetname, "Addclient", "Phone");
//			String addres=tabl.getData(sheetname, "Addclient", "Address");
//			String p_id=tabl.getData(sheetname, "Addclient", "Policy_ID");
//			String nominee_id=tabl.getData(sheetname, "Addclient", "Nominess_ID");
//			String nominee_name=tabl.getData(sheetname, "Addclient", "No_Name");
//			String nominee_gen=tabl.getData(sheetname, "Addclient", "GENDER");
//			String nominee_dob=tabl.getData(sheetname, "Addclient", "Birth_Date");
//			String nominee_ND=tabl.getData(sheetname, "Addclient", "Nartinal_ID");
//			String relation=tabl.getData(sheetname, "Addclient", "RelationShip");
//			String priority=tabl.getData(sheetname, "Addclient", "Priority");
//			String nominee_phn=tabl.getData(sheetname, "Addclient", "Phone");
//			driver.findElement(By.name("client_id")).sendKeys(clientid);
//			driver.findElement(By.name("client_password")).sendKeys(clientpassword);
//			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(cl_name);
//			driver.findElement(By.name("fileToUpload")).sendKeys("F:\\wp5747176.jpg");
//			driver.findElement(By.xpath("//input[@name='sex']")).sendKeys(cl_gen);
//			driver.findElement(By.xpath("//input[@name='birth_date']")).sendKeys(cl_dob);
//			driver.findElement(By.name("maritial_status")).sendKeys(cl_sta);
//			driver.findElement(By.xpath("//input[@name='nid']")).sendKeys(cl_nd);
//			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
//			driver.findElement(By.xpath("//input[@name='address']")).sendKeys(addres);
//			driver.findElement(By.name("policy_id")).sendKeys(p_id);
//			driver.findElement(By.name("agent_id")).click();
//			driver.findElement(By.name("nominee_id")).sendKeys(nominee_id);
//			driver.findElement(By.name("nominee_id")).sendKeys(nominee_name);
//			driver.findElement(By.name("nominee_sex")).sendKeys(nominee_gen);
//			driver.findElement(By.name("nominee_birth_date")).sendKeys(nominee_dob);
//			driver.findElement(By.name("nominee_nid")).sendKeys(nominee_ND);
//			driver.findElement(By.name("nominee_relationship")).sendKeys(relation);
//			driver.findElement(By.xpath("//input[@name='priority']")).sendKeys(priority);
//			driver.findElement(By.name("nominee_phone")).sendKeys(nominee_phn);
//			driver.findElement(By.xpath("//input[@type='submit']")).click();
//			driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
//		    List<WebElement> list=driver.findElements(By.xpath("//tbody/tr/td/following-sibling::td"));
//			System.out.println(list.size());
//		    
//			for(WebElement alllist:list)
//			{
//				String name=alllist.getText();
//				if(name.equals("smruti"))
//			{
//				System.out.println("add client successfully");
//				break;
//			}
//				
//		}
//			driver.findElement(By.className("btn-danger")).click();
//			driver.close();
//			
//		}
	//
	//
	//
	//	
////		 /*
//		    WebDriverManager.chromedriver().setup();
//			WebDriver driver=new ChromeDriver();
	//	
//			driver.get(pob.getProperty(url));
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//			driver.findElement(By.name("username")).sendKeys(pob.getProperty("username"));
//			driver.findElement(By.name("password")).sendKeys(pob.getProperty("password"));
//			driver.findElement(By.xpath("//button[text()='login']")).click();
//			driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
//			driver.findElement(By.xpath("//a[text()='Add Client']")).click();
//			
//			driver.findElement(By.name("client_password")).sendKeys(map.get("Client_password"));
//			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(map.get("Name"));
//			driver.findElement(By.name("fileToUpload")).sendKeys("F:\\wp5747176.jpg");
//			driver.findElement(By.xpath("//input[@name='sex']")).sendKeys(map.get("Gender"));
//			driver.findElement(By.xpath("//input[@name='birth_date']")).sendKeys(map.get("Birth_Date"));
//			driver.findElement(By.name("maritial_status")).sendKeys(map.get("Marital_Status"));
//			driver.findElement(By.xpath("//input[@name='nid']")).sendKeys(map.get("National_ID"));
//			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(map.get("Phone"));
//			driver.findElement(By.xpath("//input[@name='address']")).sendKeys(map.get("Address"));
//			driver.findElement(By.name("policy_id")).sendKeys(map.get("Policy_ID"));
//			driver.findElement(By.name("agent_id")).click();
//			driver.findElement(By.name("nominee_id")).sendKeys(map.get("Nominess_ID"));
//			driver.findElement(By.name("nominee_name")).sendKeys(map.get("Name"));
//			driver.findElement(By.name("nominee_sex")).sendKeys(map.get("GENDER"));
//			driver.findElement(By.name("nominee_birth_date")).sendKeys(map.get("Birth_Date"));
//			driver.findElement(By.name("nominee_nid")).sendKeys(map.get("Nartinal_ID"));
//			driver.findElement(By.name("nominee_relationship")).sendKeys(map.get("RelationShip"));
//			driver.findElement(By.xpath("//input[@name='priority']")).sendKeys(map.get("Priority"));
//			driver.findElement(By.name("nominee_phone")).sendKeys(map.get("Phone"));
//			driver.findElement(By.xpath("//input[@type='submit']")).click();
//			driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
//			List<WebElement> list=driver.findElements(By.xpath("//tbody/tr/td/following-sibling::td"));
//			System.out.println(list.size());
//		    
//			for(WebElement alllist:list)
//			{
//				String text=alllist.getText();
//				if(text.equals("Rajesh"))
//			{
//				System.out.println("add client successfully");
//				break;
//			}
//				
//		}
//			driver.findElement(By.className("btn-danger")).click();
//			fis.close();
//			driver.close();
//			*/
			
		}
	}
		
/*static WebDriver driver;
	public static void main(String[]args) throws IOException {
		
		SeleniumUtility sel=new SeleniumUtility();	
		ActionUtility action=new ActionUtility();
		FrameUtility fram=new FrameUtility();
		JavaScriptUtility jsu=new JavaScriptUtility(driver);
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
		String expTEstCase="Addclient";
	    WebDriver driver=sel.launchWebBrowser("chrome");
		LoginPage lgp=new LoginPage (driver);
		sel.maximiseWindow(driver);	
		System.out.println(url);
		Map<String, String> map = tabl.getData(sheetname, expTEstCase);
		System.out.println(map.get("Client_id"));
		System.out.println(map.get("phone"));
	    sel.getApplication(driver, url);
		wait.waitForPageLoad(driver);
		lgp.LoginAction(username, password);
		ClickAddClientPage adp=new ClickAddClientPage(driver);
		adp.AddClient();
		AddClientPage addClientPage = new AddClientPage(driver);
		System.out.println(map);
		addClientPage.addNewClient(map);
		
		*/

			
		







