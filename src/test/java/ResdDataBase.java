import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ResdDataBase 
{
	WebDriver dr;
	@BeforeMethod
	public void start()
	{
		 System.setProperty("webdriver.chrome.driver", "/Users/bittech/Downloads/chromedriver");
			dr=new ChromeDriver();
			dr.get("http://www.facebook.com");
	}
	@Test
	public void test12() throws SQLException
	{
		HashMap<String, String> h=test1();
		 
			
		dr.findElement(By.id("email")).sendKeys(h.get("123"));
		dr.findElement(By.id("email")).sendKeys(h.get("1234"));

		 
	}

	public HashMap<String, String> test1() throws SQLException
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		HashMap<String, String> map=new HashMap();
		try {
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BTC190121E", "root","");
			 st=con.createStatement();
			  rs=st.executeQuery("Select * from table1");
			  while(rs.next())
			  {
				  String k=rs.getString("id");
				  String v=rs.getString("name");
				  map.put(k,v);
				 // System.out.println();
				 // System.out.println(rs.getString(2));
			  }
			 Iterator i= map.entrySet().iterator();
			 while(i.hasNext())
			 {
				 Entry e=(Entry)i.next();
				 System.out.println(e.getKey()+   "   "+e.getValue());
			 }
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null)
			{
				con.close();
			}
			if(st!=null)
			{
				st.close();
			}
		}
		return map;
		
	}

}
