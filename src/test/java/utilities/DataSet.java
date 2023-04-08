package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
	
	@DataProvider(name = "invalidCredentials")
	public static Object dataset() {
		Object[][] objects = {
				{"0111111111","password", "Please enter a valid phone number."}, 
				{"01757921769", " ......7", "Incorrect username or password."}, 
				{"1866733730", "123456789", "Incorrect username or password."}, 
				{"abc@c.com"," abc@c.com", "Incorrect username or password."}};
		
		return objects;
	}

}
