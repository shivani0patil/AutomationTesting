package first;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.netty.handler.codec.json.JsonObjectDecoder;

public class ReadJson {

	private static final String JSONObject = null;

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub

		JSONParser per=new JSONParser();
		Object obj=per.parse(new FileReader("./src/test/resources/jscomman.json"));
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("timeout"));
	}

}
