package lib.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static TakesScreenshot tk;
	public static Select s;
	public static boolean b;
	public static Robot r;

	public WebDriver launchBrowser(String browserName) {

		try {
			if (browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browserName.equals("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else {
				System.out.println("Invlid Brwoser");
			}
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}

	public WebElement locator(String locatorName, String data) {

		WebElement findElement = null;

		try {
			if (locatorName.equals("xpath")) {
				findElement = driver.findElement(By.xpath(data));
			} else if (locatorName.equals("id")) {
				findElement = driver.findElement(By.id(data));

			} else if (locatorName.equals("className")) {
				findElement = driver.findElement(By.className(data));
			} else if (locatorName.equals("Name")) {
				findElement = driver.findElement(By.name(data));
			} else if (locatorName.equals("linkText")) {
				findElement = driver.findElement(By.linkText(data));
			} else if (locatorName.equals("partialLinkText")) {
				findElement = driver.findElement(By.partialLinkText(data));
			} else if (locatorName.equals("tagName")) {
				findElement = driver.findElement(By.tagName(data));
			} else if (locatorName.equals("cssSelector")) {
				findElement = driver.findElement(By.cssSelector(data));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return findElement;

	}

	public List<WebElement> locators(String locatorName, String data) {
		List<WebElement> listOfElements = null;
		try {
			if (locatorName.equals("xpath")) {
				listOfElements = driver.findElements(By.xpath(data));
			} else if (locatorName.equals("id")) {
				listOfElements = driver.findElements(By.id(data));

			} else if (locatorName.equals("className")) {
				listOfElements = driver.findElements(By.className(data));
			} else if (locatorName.equals("Name")) {
				listOfElements = driver.findElements(By.name(data));
			} else if (locatorName.equals("linkText")) {
				listOfElements = driver.findElements(By.linkText(data));
			} else if (locatorName.equals("partialLinkText")) {
				listOfElements = driver.findElements(By.partialLinkText(data));
			} else if (locatorName.equals("tagName")) {
				listOfElements = driver.findElements(By.tagName(data));
			} else if (locatorName.equals("cssSelector")) {
				listOfElements = driver.findElements(By.cssSelector(data));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listOfElements;

	}

	public static void screenDisplay(String data) {
		try {
			System.out.println(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void takeAttribute(WebElement e, String data) {
		try {
			e.getAttribute(data);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

	}

	public void loadUrl(String Url) {
		try {
			driver.get(Url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterText(WebElement e, String data) {
		try {
			if (enabled(e) && displayed(e)) {
				e.sendKeys(data);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public void btnClick(WebElement e) {
		try {
			if (enabled(e) == true) {
				e.click();
			} else
				System.out.println("Invalid Botton");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String pageTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return title;
	}

	public void dragAndDrob(WebElement src, WebElement target) {
		try {
			Actions ac;
			ac = new Actions(driver);
			ac.dragAndDrop(src, target).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void rightClick(WebElement target) {
		try {
			Actions ac;
			ac = new Actions(driver);
			ac.contextClick(target).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void doubleClick(WebElement target) {
		try {
			Actions ac;
			ac = new Actions(driver);
			ac.doubleClick(target).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void mouseOver(WebElement target) {
		try {
			Actions ac;
			ac = new Actions(driver);
			ac.moveToElement(target).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void chooseOption(String selectOption, WebElement e, String data ) {
		try {
			if (selectOption.equals("text")) {
				s = new Select(e);
				s.selectByVisibleText(data);
			} else if (selectOption.equals("value")) {
				s = new Select(e);
				s.selectByValue(data);
			} else {
				System.out.println("No select option");
			}

		} catch (Exception ex) {
			
		}

	}
	public void chooseOptionIndex(WebElement e,int index) {
		try {
			s = new Select(e);
			s.selectByIndex(index);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void dontChosseOption(String notSelectOption, String text, int index, String value, WebElement e) {
		try {
			if (notSelectOption.equals("text")) {
				s = new Select(e);
				s.deselectByVisibleText(text);
			} else if (notSelectOption.equals("value")) {
				s = new Select(e);
				s.deselectByValue(value);

			} else if (notSelectOption.equals("index")) {
				s = new Select(e);
				s.deselectByIndex(index);
			} else {
				System.out.println("No select option");
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public void deSelectOptionByAll(WebElement e) {
		try {
			s = new Select(e);
			s.deselectAll();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public List<WebElement> selectGetOption(WebElement e) {
		List<WebElement> li = null;
		try {
			s = new Select(e);
			li = s.getOptions();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return li;
	}

	public List<WebElement> selectGetAllOption(WebElement e) {
		List<WebElement> li = null;
		try {
			s = new Select(e);
			li = s.getAllSelectedOptions();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return li;

	}

	public WebElement firstGetSelectOption(WebElement e) {
		WebElement selectFirst = null;
		try {
			s = new Select(e);
			selectFirst = s.getFirstSelectedOption();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return selectFirst;
	}

	public boolean selectIsMultiple(WebElement e) {
		try {
			s = new Select(e);
			b = s.isMultiple();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return b;
	}

	public TargetLocator switchToTargetElement() {
		TargetLocator locator = null;
		try {
			locator = driver.switchTo();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return locator;
	}

	public Alert alertSwitchToAlert() {
		Alert al = null;
		try {
			al = switchToTargetElement().alert();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return al;
	}

	public void switchToFrameId(String data) {
		try {
			switchToTargetElement().frame(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void switchToFrameName(String data) {
		switchToTargetElement().frame(data);
	}

	public void switchToFrameWebElement(WebElement e) {
		switchToTargetElement().frame(e);
	}

	public void switchToFrameWebIndex(int index) {
		switchToTargetElement().frame(index);
	}

	public void switchToFrameParentFrame() {
		switchToTargetElement().parentFrame();
	}

	public void switchToFrameDefaultContent() {
		try {
			switchToTargetElement().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void acceptAlert() {
		try {
			alertSwitchToAlert().accept();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void dismissAlert() {
		try {
			alertSwitchToAlert().dismiss();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void senkeyAlert(String data) {
		try {
			alertSwitchToAlert().sendKeys(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getTextAlert(String data) {
		try {
			data = alertSwitchToAlert().getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	public String getText(WebElement e, String data) {
		try {
			data = e.getText();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return data;
	}

	public String getAttribute(WebElement e, String data) {
		try {
			data = e.getAttribute(data);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return data;
	}

	public boolean displayed(WebElement e) {
		try {
			b = e.isDisplayed();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return b;
	}

	public boolean enabled(WebElement e) {
		try {
			b = e.isEnabled();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return b;
	}

	public boolean isSlelected(WebElement e) {
		try {
			b = e.isSelected();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return b;
	}

	public String displayCurrentUrl(String data) {
		try {
			data = driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	public String parentWindowId(String data) {
		try {
			data = driver.getWindowHandle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	public Set<String> listOfWindowId() {
		Set<String> windowHandles = null;
		try {
			windowHandles = driver.getWindowHandles();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return windowHandles;
	}

	public WebDriver switchToWindowesUrl(String data, WebDriver window) {
		try {
			window = switchToTargetElement().window(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return window;
	}

	public Navigation NavigateTo() {
		Navigation navi = null;
		try {
			navi = driver.navigate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return navi;
	}

	public void naviForward() {
		try {
			NavigateTo().forward();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void naviBackwordTo() {
		try {
			NavigateTo().back();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void naviRefresh() {
		try {
			NavigateTo().refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void naviToStringUrl(String data) {
		try {
			NavigateTo().to(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void naviURL(String data) {
		try {
			NavigateTo().to(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void setTextByJavascriptExecutor(WebElement e, String data) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + data + "')", e);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void clickByJavascriptExecutor(WebElement e) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", e);

		} catch (Exception ex) {
			System.out.println(ex.getSuppressed());
		}
	}

	public void screenShot(String photo) throws IOException, Throwable {
		try {
			if (photo.equals("snapshot")) {
				tk = (TakesScreenshot) driver;
				File src = tk.getScreenshotAs(OutputType.FILE);
				System.out.println(src);
				File dest = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports");
				FileUtils.copyFile(src, dest);
			} else if (photo.equals("capture")) {
			    r = new Robot();
				r.keyPress(KeyEvent.VK_WINDOWS);
				r.keyPress(KeyEvent.VK_PRINTSCREEN);
				r.keyRelease(KeyEvent.VK_WINDOWS);
				r.keyRelease(KeyEvent.VK_PRINTSCREEN);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	
	
	
	public byte[] takeScreenShots() {
		
		try {
			

			Dimension d = new 	Dimension (700,800);
			driver.manage().window().setSize(d); 
			tk = (TakesScreenshot) driver;
			byte[] src = tk.getScreenshotAs(OutputType.BYTES);
			return src;
		} catch (Exception e) {
			// Handle the exception here
			e.printStackTrace(); // Print the stack trace (optional)
			return null; // or any other appropriate action
		}
	}

	public void recent() throws Throwable {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_ALT);
			r.keyRelease(KeyEvent.VK_TAB);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getDataFromExcel(String sheet, int row, int cell) throws IOException {
		String value = null;
		try {
			File sheetLocation = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Framework\\Excel\\adactin.xlsx");
			FileInputStream fInput = new FileInputStream(sheetLocation);
			Workbook w = new XSSFWorkbook(fInput);
			Sheet s = w.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.getCell(cell);
			int type = c.getCellType();
			if (type == 1) {
				value = c.getStringCellValue();

			}
			if (type == 0) {
				if (DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
					value = sim.format(d);

				} else {
					double d = c.getNumericCellValue();
					long l = (long) d;
					value = String.valueOf(l);
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

}
