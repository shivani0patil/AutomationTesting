package TestNg;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.ObjectRepository.CreateNewOrganization;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.generic.Fileutility.ExcelUtility;

import com.crm.generic.Webdriver.JavaUtility;
import com.crm.generic.Webdriver.UtilityClassObject;

public class CreateOrgTest extends BaseClass {

	@Test(groups="smokeTest")
	public void CreateOrgIndustryTest() throws IOException, Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from the excel");
		JavaUtility ju = new JavaUtility();
		int num = ju.random();
		ExcelUtility x = new ExcelUtility();
		String orgname = x.getDataExcel("Sheet1", 4, 2) + num;
		HomePage h = new HomePage(driver);

		CreateNewOrganization org2 = new CreateNewOrganization(driver);
		// click on organization
		OrganizationPage org1 = new OrganizationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization page");
		h.getOrganization().click();
		org1.getButton().click();
		org2.getOrgname().sendKeys(orgname);
		org2.getSavebtn();
	}

	@Test
	public void createOrgtestTest() throws IOException, Throwable {

		JavaUtility ju = new JavaUtility();
		int num = ju.random();
		ExcelUtility x = new ExcelUtility();
		String orgname = x.getDataExcel("Sheet1", 4, 2) + num;
		String dropdwon = x.getDataExcel("Sheet1", 4, 3);
		String type = x.getDataExcel("Sheet1", 4, 4);

		HomePage h = new HomePage(driver);
		// click on organization
		CreateNewOrganization org = new CreateNewOrganization(driver);
		h.getOrganization().click();
		OrganizationPage org2 = new OrganizationPage(driver);
		org2.getButton().click();
		org.createOrgindusrt(orgname, dropdwon, type);
		org.getSavebtn();
	}
}
