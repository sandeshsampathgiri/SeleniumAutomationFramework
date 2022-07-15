package com.qa.capsulecrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.qa.capsulecrm.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eDriver;
	public static Logger log = Logger.getLogger(BaseClass.class);

	public BaseClass() {

		prop = new Properties();
		// String filePath = System.getProperty("user.dir")
		// + "\\src\\main\\java\\com\\qa\\capsulecrm\\config\\config.properties";

		String configPath = System.getProperty("user.dir");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configPath + "\\src\\main\\java\\com\\qa\\capsulecrm\\config\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initializeBrowser() {

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			log.info("Initializing chrome browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			log.info("opening the browser in maximized mode");
			options.addArguments("--incognito");
			log.info("opening the browser in incognito mode");
			options.setAcceptInsecureCerts(true);
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			log.info("Initializing chrome browser");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			log.info("opening the browser in maximized mode");
			options.addArguments("--incognito");
			log.info("opening the browser in incognito mode");
			options.setAcceptInsecureCerts(true);
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("appURL"));

	}

	

}
