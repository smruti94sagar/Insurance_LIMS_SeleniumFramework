package Org_InsuranceDomain_Clients;


import java.util.Map;


import org.testng.annotations.Test;



import com.LIMS.genericUtility.Mainclass;
import com.LIMS.genericUtility.annotations.Report;
import com.LIMS.genericUtility.enums.Editclientdetails;

import com.LIMS.objectRepository.elements.EditClientPage;
import com.LIMS.objectRepository.elements.EditClientPage1;

/**
 * 
 * @author smruti
 *
 */
public class EditClientTest extends Mainclass {
	/**
	 * This script is used to editclientdetails
	 */
	@Report(author = "smruti")
	@Test
	   public void editclient()
	   {
		
		String sheetname = Editclientdetails.UPDATECLIENT.getSheetName();
		String expTEstCase = "editclient";
	    Map<String, String> map = tabl.getData(sheetname, expTEstCase);
		System.out.println(map);
		EditClientPage ep = new EditClientPage(driver);
		ep.Clickeditclient();
		EditClientPage1 ep1 = new EditClientPage1(driver);
		ep1.editclientPage(map);

		

	}
}