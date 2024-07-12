package org.pom_Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.gherkin.model.Scenario;

public class Automation_practice {

	public static WebDriver driver;

	public static WebDriver base(String b_name, String url) {
		if (b_name.equalsIgnoreCase("ch") || b_name.equalsIgnoreCase("crome")) {

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().window().maximize();

		}

		if (b_name.equalsIgnoreCase("ff") || b_name.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().window().maximize();

		}

		if (b_name.equalsIgnoreCase("ed") || b_name.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().window().maximize();

		}

		driver.get(url);

		return driver;

	}

	public static void Openbrowser() {
		base("ch", "https://qa-practice.netlify.app/contact-us");

	}

	public static void Scrolling_Demo() {

		base("ch", "https://qa-practice.netlify.app/scroll");

		Actions ac = new Actions(driver);

		WebElement txt = driver.findElement(By.xpath("//h3[text()='THE END']"));

		txt.click();
		ac.scrollToElement(txt).perform();

	}

	public static void tabHandle() {

		base("ch", "https://qa-practice.netlify.app/tab");

		WebElement ele = driver.findElement(By.xpath("//a[text()='Press me - New Tab']"));
		ele.click();

		String beforewin = driver.getWindowHandle();

		for (String currentwin : driver.getWindowHandles()) {

			if (!currentwin.equalsIgnoreCase(beforewin)) {
				driver.switchTo().window(currentwin);

			}

		}

		WebElement eletxt = driver.findElement(By.xpath("//h2[text()='Table Example']"));

		String name = eletxt.getText();

		System.out.println(name);

	}

	public static void datepikker() {

		List<WebElement> eles;

		base("ch", "https://qa-practice.netlify.app/calendar");

		WebElement ele = driver.findElement(By.xpath("//input[@placeholder='Pick a date']"));

		ele.click();

		for (int i = 0; i <= 10; i++) {
			WebElement n = driver.findElement(By.xpath("//th[text()='»']"));
			n.click();

			WebElement date = driver.findElement(By.xpath("//th[@class='datepicker-switch'][1]"));

			String name = date.getText();

			String month = name.split(" ")[0];
			String Year = name.split(" ")[1];

			if (month.equalsIgnoreCase("September")) {

				List<WebElement> sun = driver.findElements(By.xpath(
						"//th[text()='Sa' or text()='Su']/following::tbody/tr/td[1] | //th[text()='Sa' or text()='Su']/following::tbody/tr/td[7]"));

				for (WebElement e : sun) {
					String date7 = e.getText();
					System.out.println(date7);

				}

				break;

			}

		}

	}

	public static void framhandle() {

		base("ch", "https://qa-practice.netlify.app/iframe");

		List<WebElement> frams = driver.findElements(By.tagName("iframe"));

		driver.switchTo().defaultContent();
		for (WebElement ele : frams) {

			if (ele.isDisplayed() && ele.isEnabled()) {

				driver.switchTo().frame(ele);

			}

		}

		WebElement ele = driver.findElement(By.xpath("//h1[text()='Hello, this is an Iframe!']"));

		String text = ele.getText();

		System.out.println(text);

	}

	public static void tabhandle() {
		base("ch", "https://qa-practice.netlify.app/tab");

		WebElement ele = driver.findElement(By.xpath("//a[text()='Press me - New Tab']"));
		ele.click();

		String beforewindo = driver.getWindowHandle();

		for (String windowhand : driver.getWindowHandles()) {

			if (!beforewindo.equalsIgnoreCase(windowhand)) {

				driver.switchTo().window(windowhand);

			}

		}

		WebElement txt = driver.findElement(By.xpath("//h2[text()='Table Example']"));

		String name = txt.getText();

		System.out.println(name);

	}

	public static void alerthandle() {

		base("ch", "https://qa-practice.netlify.app/alerts");

		WebElement ele = driver.findElement(By.xpath("//button[@id='alert-btn']"));
		ele.click();

		Alert al = driver.switchTo().alert();

		String name = al.getText();
		al.dismiss();

		System.out.println(name);

	}
	
	
	public void dis()
	{
		
		
		
		
	}

	

	public static void main(String[] args) {

		alerthandle();
	}

}
