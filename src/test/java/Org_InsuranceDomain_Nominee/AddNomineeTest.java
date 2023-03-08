package Org_InsuranceDomain_Nominee;

import java.util.Map;

import org.testng.annotations.Test;

import com.LIMS.genericUtility.Mainclass;
import com.LIMS.genericUtility.annotations.Report;
import com.LIMS.genericUtility.enums.ExcellSheet;
import com.LIMS.objectRepository.elements.AddClientPage;
import com.LIMS.objectRepository.elements.AddNomineePage;
import com.LIMS.objectRepository.elements.ClickAddClientPage;
import com.LIMS.objectRepository.elements.ClickNomineePage;

public class AddNomineeTest extends Mainclass{
  @Report(author = "smruti")
  @Test(groups="sanity")
  public void addnomiee() {

		String sheetname = ExcellSheet.NOMINEEDETAILS.getSheetName();
		String expTEstCase = "addnominee";
		Map<String, String> map = tabl.getData(sheetname, expTEstCase);
		ClickNomineePage clicknomineepage= new ClickNomineePage(driver);
		clicknomineepage.clicknominee();
		System.out.println("click nomineebutton sucessfully");
		AddNomineePage addnomineepage=new AddNomineePage(driver);
		System.out.println(map);
		addnomineepage.addNominee(map);
		System.out.println("Addnominee sucessfully");

  
  
  
  }
}
