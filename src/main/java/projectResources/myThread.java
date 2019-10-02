package projectResources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.swing.event.TreeWillExpandListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



public class myThread implements Runnable  {

	
	private String string;
	private String browser;
	private String name;
	private WebDriver driver;
	private int times;
	private String env;

	public myThread(String name,String string,int times, String browser, String env) {
		this.name=name;
		this.browser=browser;
		this.string = string;
		this.times = times;
		this.env = env;
		
		
	}
	
	

	@Override
	public void run() {
		int timess=times;	
		System.out.println("This is from Thread"+ env);
			
			for (int i = 0; i < timess; i++) {
				WebDriver driver1=null;
				
			
			if(browser.equals("chrome")) {
				ChromeOptions options = new ChromeOptions();
				System.setProperty("webdriver.chrome.driver", "/Users/user/Documents/Workspaces/chromedriver");
				driver1 = new ChromeDriver( options );
				//driver1.manage().window().fullscreen();
				
			}
			if(browser.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", "/Users/user/Documents/Workspaces/geckodriver");
				
				driver1 = new FirefoxDriver();
			}
			if(browser.equals("safari")) {
				System.setProperty("webdriver.safari.driver", "/Users/user/Downloads/SafariDriver.safariextz⁩");
				
				driver1 = new FirefoxDriver();
			}
		    
			
			System.out.println(name+" Thread is Running!");
			
			
			System.out.println("TEST CHOOSE"+ string);
			
			
			switch(string.toString()) {
			
			
				}
				}
			
			
			}
				}
			