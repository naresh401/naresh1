package utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class readconfig {
	Properties pro;
public readconfig(){
	FileInputStream file;
	try {
		file = new FileInputStream("E:\\frame\\naresh\\configaration\\config.properties");
	
		
		
		pro=new Properties();
		
		pro.load(file);
	}
		catch (Exception e) {
			System.out.println("expectin is "+e.getMessage());
			
	}
	
}
public String getbaseurl(){
	String baseurl=pro.getProperty("baseurl");
	return baseurl;
	
}
public String getusername(){
	String username=pro.getProperty("username");
	return username;
}
public String getpassword()
{
	String password=pro.getProperty("password");
	return password;
	
}
public String getchromepath()
{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	
}
public String getiepath()
{
	String iepath=pro.getProperty("iepath");
	return iepath;
	
}
public String getfirefoxpath()
{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	
}

}



