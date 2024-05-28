package first;

import org.testng.annotations.Test;

public class TestNgDependsonmethods {

	@Test
	public void createOrdertest()
	{
		
		System.out.println("excute sample test");
		String s=null;
		System.out.println(s.equals("56454"));
	}
	
	
	@Test(dependsOnMethods="createOrdertest")
	public void modifyorder()
	{
		System.out.println("excute create ");
	}
	
	@Test(dependsOnMethods="modifyorder")
	public void deleteOrder()
	{
		System.out.println("delete order");
	}
}
