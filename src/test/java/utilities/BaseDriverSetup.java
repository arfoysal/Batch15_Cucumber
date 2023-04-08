package utilities;

import java.time.Duration;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriverSetup {

	private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

	public static void setDriver(WebDriver driver) {
		BaseDriverSetup.LOCAL_DRIVER.set(driver);
	}

	public static WebDriver getDriver() {
		return LOCAL_DRIVER.get();
	}

	public static WebDriver getBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			return new ChromeDriver(chromeOptions);

		case "edge":
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();

		default:
			throw new RuntimeException("Browser not Found! using given name: " + browserName);
		}
	}

	public static synchronized void setBrowser(String browserName) {
		WebDriver webDriver = getBrowser(browserName);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		webDriver.manage().window().maximize();
		setDriver(webDriver);
	}

	public static synchronized void quitBrowser(Scenario scenario) {
		takeScreenShot(scenario);
		getDriver().quit();
	}

	public static void takeScreenShot(Scenario scenario){
		if (scenario.isFailed()){
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] s_source = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(s_source, "image/png", screenShotName);
		}
	}
}
