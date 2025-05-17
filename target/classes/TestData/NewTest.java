package utils;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  
	  ConfigReader reader = new ConfigReader();

      String url = reader.getProperty("baseUrl");
      String username = reader.getProperty("username");
      String password = reader.getProperty("password");

      System.out.println("URL: " + url);
      System.out.println("Username: " + username);
      System.out.println("Password: " + password);

      // Use this data in your test (e.g., open browser and login)
  }
}

	  
	  
	  
	  
  }
}
