package Org_InsuranceDomain_Clients;



import java.util.Map;



import org.testng.annotations.Test;

import com.LIMS.genericUtility.Mainclass;
import com.LIMS.genericUtility.VerificationUtility;
import com.LIMS.genericUtility.annotations.Report;
import com.LIMS.genericUtility.enums.pyamentdeatils;
import com.LIMS.objectRepository.elements.AddPaymentPage;
import com.LIMS.objectRepository.elements.ClickAddClientPage;
/**
 * 
 * @author smruti
 *
 */

public class AddPaymentTest extends Mainclass {
	@Report(author = "smruti")
    @Test(groups="Regression")
	/**
	 * This script is used to addpayment details.
	 */
	public void addpayment()
	{
        
		String testCaseName = "AddPaymentTest";
		String sheetname = pyamentdeatils.CLIENT.getSheetName();
		String expTEstCase = "addpayment";
		Map<String, String> map = tabl.getData(sheetname, expTEstCase);
		sel.getApplication(driver, url);
		Map<String, String> verifyData = tabl.getData("verificationData", testCaseName);
		VerificationUtility verificationUtility = new VerificationUtility();
		verificationUtility.partialverification(driver.getTitle(), verifyData.get("loginTtle"), "page", "login page");
		ClickAddClientPage adp = new ClickAddClientPage(driver);
		adp.Clickclientsts();
		AddPaymentPage ap = new AddPaymentPage(driver);
		ap.addNewPayment(map);
		

	}
}
