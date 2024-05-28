package first;

import org.testng.annotations.Test;

public class TestNgSample {

	@Test(priority=1)
	public void createOrdertest()
	{
		
		System.out.println("excute sample test");
		String s=null;
		System.out.println(s.equals("56454"));
	}
	@Test(priority=2)
	public void modifyorder()
	{
		System.out.println("excute create ");
	}
	
	@Test(priority=3)
	public void deleteOrder()
	{
		System.out.println("delete order");
	}
}
