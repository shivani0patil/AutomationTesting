package asser;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryDemoTest

{
	 @Test(retryAnalyzer = com.crm.generic.listerner.RetryListclass.class)
	 public void activatesim()
	 {
		System.out.println("excute invoice ");
	
		Assert.assertEquals(" ", "logo");
		System.out.println("step 1 ");
		System.out.println("step 2 ");
		System.out.println("step 3 ");
		
	 }

}
