package org.pom_TestCases;

import org.BaseUtility.startUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pom_Pages.LoginPage;
import org.propertiesUtility.PropertiesGeneric;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Group_practice {

	public static void main(String[] args) {

		startUp bu = new startUp();
		WebDriver driver = bu.startUp("ch", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		
		
		
	}
}
