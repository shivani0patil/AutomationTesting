package asser;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.listerner.BaseClass;


public class InvoviceTest  extends BaseClass{
	 @Test
	 public void createInvoice()
	 {
		System.out.println("excute invoice ");
		String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle, "logo");
		System.out.println("step 1 ");
		System.out.println("step 2 ");
		System.out.println("step 3 ");
		
	 }
	 
	 @Test
	 public void createInvoiceContact()
	 {
		System.out.println("excute invoice ");
		
		System.out.println("step 1 ");
		System.out.println("step 2 ");
		System.out.println("step 3 ");
		
	 }
	

}
