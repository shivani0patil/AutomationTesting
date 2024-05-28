package first;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Pro_file {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      FileInputStream fs=new FileInputStream("./src/test/resources/comm.properties");
      Properties p=new Properties();
      p.load(fs);
     String b= p.getProperty("browser");
     System.out.println(b);
	}

}
