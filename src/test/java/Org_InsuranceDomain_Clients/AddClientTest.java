package Org_InsuranceDomain_Clients;





import java.io.IOException;


import java.util.Map;


import org.testng.annotations.Test;

import com.LIMS.genericUtility.Mainclass;
import com.LIMS.genericUtility.annotations.Report;
import com.LIMS.genericUtility.enums.ExcellSheet;

import com.LIMS.objectRepository.elements.AddClientPage;
import com.LIMS.objectRepository.elements.ClickAddClientPage;
/**
 * 
 * @author smruti
 *
 */
public class AddClientTest extends Mainclass {
	@Report(author = "smruti")
	@Test(groups = "smoke")
	/**
	 * 
	 * @throws IOException
	 */
	public void addclient() throws IOException {
     
		String sheetname = ExcellSheet.CLIENT.getSheetName();
		String expTEstCase = "Addclient";
		Map<String, String> map = tabl.getData(sheetname, expTEstCase);
		ClickAddClientPage adp = new ClickAddClientPage(driver);
		adp.AddClient();
		AddClientPage addClientPage = new AddClientPage(driver);
		System.out.println(map);
		addClientPage.addNewClient(map);

	}
}
