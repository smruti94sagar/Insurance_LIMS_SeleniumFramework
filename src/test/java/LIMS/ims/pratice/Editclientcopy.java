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
import com.LIMS.genericUtility.VerificationUtility;
import com.LIMS.genericUtility.WaitUtility;
import com.LIMS.genericUtility.enums.Editclientdetails;
import com.LIMS.genericUtility.enums.FreameworkConstant;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.objectRepository.elements.EditClientPage;
import com.LIMS.objectRepository.elements.EditClientPage1;
import com.LIMS.objectRepository.elements.LoginPage;

public class Editclientcopy {
	
		public static void main(String[] args) throws IOException {
			String testCaseName = "EditClientTest";
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
			// System.out.println(password);
			String sheetname = Editclientdetails.UPDATECLIENT.getSheetName();
			String expTEstCase = "editclient";
			WebDriver driver = sel.launchWebBrowser("chrome");
			LoginPage lgp = new LoginPage(driver);
			sel.maximiseWindow(driver);
			System.out.println(url);
			Map<String, String> map = tabl.getData(sheetname, expTEstCase);
			System.out.println(map);
			sel.getApplication(driver, url);
			VerificationUtility vfu = new VerificationUtility();

			Map<String, String> verifyData = tabl.getData("verificationData", testCaseName);
			vfu.partialverification(driver.getTitle(), verifyData.get("loginTtle"), "page", "login");
			wait.waitForPageLoad(driver);
			lgp.LoginAction(username, password);
			EditClientPage ep = new EditClientPage(driver);
			ep.Clickeditclient();
			EditClientPage1 ep1 = new EditClientPage1(driver);
			ep1.editclientPage(map);

			// ep1.editclientPage(map);
			// vfu.partialverification(driver.getTitle(), map.get("key"), "page" ,"login" );

		}
	}


