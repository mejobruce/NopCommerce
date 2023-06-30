package report.org;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	
	
public static void jvnReports(String jsonFile) {
		
	
	
	File reportsDirectory = new  File(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports");
	Configuration con = new Configuration (reportsDirectory,"Non commerce  Automation");
	con.addClassifications("Browser", "Chrome");
	con.addClassifications("Vesion", "114");
	con.addClassifications("os", "Windowes");
	con.addClassifications("Sprint", "1");
	List<String> jsonFiles = new ArrayList<String>();
	   jsonFiles .add(jsonFile);
	   ReportBuilder buillder = new ReportBuilder(jsonFiles,con);
	   buillder.generateReports();
	}

}
