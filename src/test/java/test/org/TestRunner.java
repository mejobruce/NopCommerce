package test.org;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.snippets.Snippet;
import report.org.Reporting;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Regeister.feature",glue= {"sdef.org"},dryRun=false,monochrome=true,plugin= {"pretty","json:src/test/resources/Reports/output.json"},strict=false,snippets=SnippetType.CAMELCASE)
public class TestRunner {
	//\src\test\resources\Features\Login.feature
	@AfterClass
	public static void afterClass() {
		Reporting.jvnReports(System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\Reports\\\\output.json");
		


	}
	

}
