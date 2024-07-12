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

public class LoginPageTestCases {

	public  WebDriver driver;
	startUp bu;
	PropertiesGeneric pro;
	LoginPage lp;
	SoftAssert ac = new SoftAssert();
	
	@BeforeMethod()
	public void initBrowser() {
		bu = new startUp();
		driver = bu.startUp("ch", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@AfterMethod()
	public void closeBrowser() {
		driver.close();
	}

	@Test(groups = {"Smoke"})
	public void verifyLoginPage() {
		
		 lp = new LoginPage(driver);
		lp.placeholder_Username_inputField();
		lp.CurrentUrl();
		ac.assertEquals(lp.Title(), "OrangeHRM");
		ac.assertEquals(lp.Login_txt(), "Login");
		ac.assertEquals(lp.Username_Admin_txt(), "Username : Admin");
		ac.assertEquals(lp.Password_admin123_txt(), "Password : admin123");
		ac.assertEquals(lp.forgetpasswordTxt(), "Forgot your password?");
		ac.assertAll();

	}

	@Test(groups = {"Smoke"})
	public void verify_Loginpage_placeholders() {
		 lp = new LoginPage(driver);
		ac.assertEquals(lp.Username_txt(), "Username");
		ac.assertEquals(lp.Password_txt(), "Password");
		ac.assertAll();

	}

	@Test()
	public void verify_Login_with_correct_Cradancial(String username, String password) {
		 lp = new LoginPage(driver);
		lp.placeholder_Username_inputField();
		lp.placeholder_Password_inputField();
		lp.submitBtn();
		ac.assertEquals(lp.dashboadTxt(), "Dashboard");
		ac.assertAll();

	}

	@Test()
	public void verify_Login_with_Wrong_Cradancial() {
		 lp = new LoginPage(driver);
		lp.placeholder_Username_inputField();
		// lp.placeholder_Password_inputField();
		lp.submitBtn();
		ac.assertEquals(lp.Errormessage(), "Required");
		ac.assertAll();

	}

	@Test()
	public void verify_Login_with_Wrong_Cradancial1() {
		lp = new LoginPage(driver);
		SoftAssert ac = new SoftAssert();
		lp.placeholder_Password_inputField();
		lp.submitBtn();
		ac.assertEquals(lp.Errormessage(), "Required");
		ac.assertAll();

	}

	@Test(priority = 1)
	public void verify_Login_with_Wrong_Cradancial2() {
		lp = new LoginPage(driver);
		SoftAssert ac = new SoftAssert();
		lp.submitBtn();
		ac.assertEquals(lp.Errormessage(), "Required");
		ac.assertAll();

	}

	@Test()
	public void verify_Loginpage_in_forgotpasswordLink() {
		lp = new LoginPage(driver);
		SoftAssert ac = new SoftAssert();
		lp.forgetpasswordclick();
		ac.assertEquals(lp.CurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
		ac.assertAll();

	}

	@Test()
	public void verify_Loginpage_forget_password() {
		lp = new LoginPage(driver);
		SoftAssert ac = new SoftAssert();
		lp.forgetpasswordclick();
		ac.assertEquals(lp.CurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
		ac.assertEquals(lp.Reset_PasswordTxt(), "Reset Password");
		lp.Reset_usernameinputfiled();
		lp.Reset_Passwordbtn();
		ac.assertEquals(lp.CurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset");
		ac.assertEquals(lp.Reset_Password_link_sent_successfully(), "Reset Password link sent successfully");
		ac.assertAll();

	}

	@Test()
	public void verify_Loginpage_forget_password_cancal() {
		 lp = new LoginPage(driver);
		SoftAssert ac = new SoftAssert();
		lp.forgetpasswordclick();
		ac.assertEquals(lp.CurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
		ac.assertEquals(lp.Reset_PasswordTxt(), "Reset Password");
		lp.Reset_Cancalbtn();
		ac.assertEquals(lp.CurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		ac.assertAll();

	}

}
