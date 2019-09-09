package com.atgadmin.qa.testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atgadmin.qa.base.TestBase;
import com.atgadmin.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();

	}

	@Test(enabled = false) // (priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "ATG Admin");
	}

	@Test(enabled = false) // (priority=2)
	public void loginTest() throws Exception {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000L);
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/mat-toolbar/nav/div/a[2]")).click();
		String hname = driver.findElement(By.xpath("/html/body/app-root/app-default-layout/mat-toolbar/nav/div/a[2]"))
				.getText();

		Assert.assertEquals(hname, "Security");
	}

	@Test(enabled = false) // (priority=3)
	public void CreateNewAffiliatesTest() throws Exception {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(4000L);
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-master-account-list/app-list-layout/article/div/div/mat-nav-list/mat-list-item[1]/div/div[2]/h3"))
				.click();
		Thread.sleep(4000L);
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-affiliate-list/app-list-layout/article/mat-toolbar/mat-toolbar-row[2]/span[2]/div/button/span"))
				.click();
		// Enter Affiliate Name
		driver.findElement(By.id("mat-input-2")).sendKeys("Affiliate36 Test BMC");

		Random rad = new Random();
		int val = rad.nextInt(10000);
		rad.nextInt((24 * 22) + 1);

		driver.findElement(By.id("mat-input-13")).sendKeys("" + val);
		Thread.sleep(4000L);
		driver.findElement(By.id("mat-input-3")).sendKeys("TBC");
		Thread.sleep(4000L);
		driver.findElement(By.id("mat-input-4")).sendKeys("13468 77th Ave");
		driver.findElement(By.id("mat-input-6")).sendKeys("Surrey");
		driver.findElement(By.id("mat-input-7")).sendKeys("BC");
		Thread.sleep(4000L);
		driver.findElement(By.className("mat-select-arrow")).click();
		Thread.sleep(4000L);
		driver.findElement(By.xpath("//*[@id='mat-option-1']/span")).click();
		driver.findElement(By.id("mat-input-8")).sendKeys("60173");
		driver.findElement(By.id("mat-input-9")).sendKeys("9421034858");
		driver.findElement(By.id("mat-input-10")).sendKeys("yarvikar@gmail.com");
		driver.findElement(By.id("mat-input-11")).sendKeys("yarvikar@associaonline.com");
		driver.findElement(By.id("mat-input-12")).sendKeys("ATGPay");
		driver.findElement(By.className("mat-checkbox-label")).click();
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-edit-affiliate/app-item-layout/div/mat-card/mat-card-content/form/button[1]/span"))
				.click();
		Thread.sleep(4000L);
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-affiliate-details/app-item-layout/mat-toolbar/mat-toolbar-row/app-breadcrumb/a[2]/span"))
				.click();
		Thread.sleep(4000L);
		// Enter Affiliate Name
		driver.findElement(By.xpath("//*[@id='mat-input-14']")).sendKeys("Affiliate36");
		Thread.sleep(4000L);

		String affnum = driver.findElement(By.className("mat-line")).getText();

		// Verify Affiliate Creation
		Thread.sleep(5000L);
		Assert.assertEquals(affnum, "Affiliate36 Test BMC");
		Thread.sleep(5000L);

	}

	@Test(enabled = false)
	public void manageProfileTest() throws Exception {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/mat-toolbar/button/span/mat-icon")).click();
		driver.findElement(By.xpath("//*[@id='cdk-overlay-0']/div/div/a[1]")).click();
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-profile/app-item-layout/div/mat-card[1]/mat-card-title/button/span/mat-icon"))
				.click();
		driver.findElement(By.xpath("//*[@id='mat-input-3']")).clear();
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//*[@id='mat-input-3']")).sendKeys("9421034858");
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-edit-profile/app-item-layout/div/mat-card[1]/mat-card-actions/button/span"))
				.click();
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/mat-toolbar/nav/div/a[2]")).click();
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-default/app-list-layout/article/div/div/mat-nav-list/mat-list-item[1]/div/div[2]/h3"))
				.click();
		String phno = driver
				.findElement(By
						.xpath("/html/body/app-root/app-default-layout/app-profile/app-item-layout/div/mat-card[1]/mat-card-content/mat-list/mat-list-item/div/div[2]/p[4]"))
				.getText();
		System.out.println(phno);

		Assert.assertTrue(phno.contains("9421034858"));
	}

	@Test(enabled = false)
	public void addNewAdminUserTest() throws Exception {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/mat-toolbar/nav/div/a[2]")).click();
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-default/app-list-layout/article/mat-toolbar/mat-toolbar-row[2]/span[2]/div/button/span/mat-icon"))
				.click();
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-checkbox-1']/label/div")));
		Thread.sleep(4000L);
		WebElement email = driver.findElement(By.className("mat-form-field-infix"));
		Thread.sleep(4000L);
//Change Email ID
		Actions actions = new Actions(driver);
		actions.moveToElement(email);
		actions.click();
		actions.sendKeys("associa.ava+admin9@gmail.com");
		actions.build().perform();
//Change Enter Name
		driver.findElement(By.xpath("//*[@id='mat-input-3']")).sendKeys("Admin User Nine");
		// Check the Global Admin checkbox
		driver.findElement(By.xpath("//*[@id='mat-checkbox-1']/label/div")).click();
		// Click on Role Dropdown
		driver.findElement(By.xpath("//*[@id='mat-select-0']/div/div[2]/div")).click();
		// Select Admin Role
		driver.findElement(By.xpath("//*[@id='mat-option-1']/span")).click();
		// Click on Next button on User Details page
		driver.findElement(By.xpath("//*[@id='cdk-step-content-0-0']/div[2]/button/span")).click();
		Thread.sleep(4000L);
		// Click on Next button on Assignment page
		driver.findElement(By.xpath("//*[@id='cdk-step-content-0-1']/div/button/span")).click();
		Thread.sleep(4000L);
		// Click on Save button		
		driver.findElement(By.xpath("//*[@id='cdk-step-content-0-2']/div/button/span")).click();
		Thread.sleep(4000L);
String uname = driver.findElement(By.xpath("//*[@id='cdk-step-content-0-2']/mat-list/mat-list-item/div/div[2]/h3")).getText();
		Thread.sleep(4000L);
		// Click on Security Tab
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/mat-toolbar/nav/div/a[2]")).click();
// Change User Name	
		driver.findElement(By.xpath("//*[@id='mat-input-7']")).sendKeys("Admin User Nine");
		


String sname = driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-default/app-list-layout/article/div/div/mat-nav-list/mat-list-item/div/div[2]/h3")).getText();

					Assert.assertEquals(uname, sname);
		
		
	}

	@Test(enabled = false)
	public void addNewCustomerServiceUserTest() throws Exception
	{
//Enter Username and Passowrd		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//Click on Sign In button		
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/mat-toolbar/nav/div/a[2]")).click();
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-default/app-list-layout/article/mat-toolbar/mat-toolbar-row[2]/span[2]/div/button/span/mat-icon"))
				.click();
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-checkbox-1']/label/div")));
		Thread.sleep(4000L);
		WebElement email = driver.findElement(By.className("mat-form-field-infix"));
		Thread.sleep(4000L);
//Change Email ID
		Actions actions = new Actions(driver);
		actions.moveToElement(email);
		actions.click();
		actions.sendKeys("associa.ava+csuser3@gmail.com");
		actions.build().perform();
//Change Enter Name
		driver.findElement(By.xpath("//*[@id='mat-input-3']")).sendKeys("CS User Three");
// Click on Role Dropdown
		driver.findElement(By.xpath("//*[@id='mat-select-0']/div/div[2]/div")).click();
//Select Customer Service Role
		driver.findElement(By.xpath("//*[@id='mat-option-0']/span")).click();
//Click on Next Button
		driver.findElement(By.xpath("//*[@id='cdk-step-content-0-0']/div[2]/button/span")).click();
		Thread.sleep(4000L);
//Click on Select Affiliate drop down
		driver.findElement(By.xpath("//*[@id='mat-input-5']")).sendKeys("Associa British");
//Select Affiliate from drop down
		driver.findElement(By.xpath("//*[@id='mat-option-25']/span")).click();
//Click on Next button
		driver.findElement(By.xpath("//*[@id='cdk-step-content-0-1']/div/button/span")).click();
//Click on Save button
		driver.findElement(By.xpath("//*[@id='cdk-step-content-0-2']/div/button")).click();
		
		
		String csname = driver.findElement(By.xpath("//*[@id='cdk-step-content-0-2']/mat-list/mat-list-item/div/div[2]/h3")).getText();
		Thread.sleep(4000L);
		// Click on Security Tab
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/mat-toolbar/nav/div/a[2]")).click();
// Change User Name	
		driver.findElement(By.xpath("//*[@id='mat-input-7']")).sendKeys("CS User Three");
		


String csuname = driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-default/app-list-layout/article/div/div/mat-nav-list/mat-list-item/div/div[2]/h3")).getText();

					Assert.assertEquals(csname, csuname);		
	}
	
	@Test//(enabled = false)
	public void updateAdminUserTest() throws Exception
	{
//Enter Username and Passowrd		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//Click on Security Tab		
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/mat-toolbar/nav/div/a[2]")).click();
		Thread.sleep(5000L);
		WebElement searchBox = driver.findElement(By.className("mat-form-field-infix"));
//Click on Search Textbox using Action class		
		Actions actions = new Actions(driver);
		actions.moveToElement(searchBox);
		actions.click();
		actions.sendKeys("yarvikar@associaonline.com");
		actions.build().perform();
		Thread.sleep(4000L);
//Click on User Name
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-default/app-list-layout/article/div/div/mat-nav-list/mat-list-item/div/div[2]/p[1]")).click();
//click on Profile Edit	
		Thread.sleep(5000L);
//Edit profile		
		driver.findElement(By.xpath("/html/body/app-root/app-default-layout/app-profile/app-item-layout/div/mat-card[1]/mat-card-title/button/span/mat-icon")).click();
		Thread.sleep(4000L);
//clear name field		
		driver.findElement(By.xpath("//*[@id='mat-input-3']")).clear();
		Thread.sleep(5000L);
//Change name details		
		driver.findElement(By.xpath("//*[@id='mat-input-3']")).sendKeys("GU Arvikar Yogesh");
//click on save button		
		driver.findElement(By
				.xpath("/html/body/app-root/app-default-layout/app-edit-profile/app-item-layout/div/mat-card[1]/mat-card-actions/button/span"))
				.click();
		Thread.sleep(5000L);
//click on profile image icon
		driver.findElement(By.xpath("//*[@class='mat-icon material-icons']")).click();
		
	}
	
	
	@AfterMethod(enabled = false)
	public void tearDown() throws Exception {

		Thread.sleep(7000L);
		driver.quit();
	}

}
