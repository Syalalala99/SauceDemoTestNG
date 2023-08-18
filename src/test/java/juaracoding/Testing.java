package juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.SauceDemoPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing {
    WebDriver driver;
    SauceDemoPage sauceDemoPage;


    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        sauceDemoPage = new SauceDemoPage();

    }

    @AfterClass
    public void finish() {
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    //Login Test
    @Test(priority = 1)
    public void invalidLoginOne() {
        sauceDemoPage.blankLogin();
        Assert.assertEquals(sauceDemoPage.getTxtBlankAllert(), "Epic sadface: Username is required");
    }

    @Test(priority = 2)
    public void invalidLoginTwo() {
        sauceDemoPage.wrongLogin();
        Assert.assertEquals(sauceDemoPage.getTxtWrongAllert(), "Epic sadface: Username and password do not match any user in this service");
        System.out.println("Negative Login Test Case Success");
    }

    @Test(priority = 3)
    public void validLogin() {
        sauceDemoPage.validLogin();
        Assert.assertEquals(sauceDemoPage.getTxtLoginAllert(), "Products");
        System.out.println("Valid Login Test Case Success");
    }

    //Add Product Test
    @Test(priority = 4)
    public void addProduct() {
        sauceDemoPage.addProduct();
        System.out.println("Add Product Test Case Success");
    }

    //Checkout Product Test
    @Test(priority = 5)
    public void invalidCheckoutOne() {
        sauceDemoPage.blankCheckout();
        Assert.assertEquals(sauceDemoPage.getTxtBlankCheckout(), "Error: First Name is required");
    }

    @Test(priority = 6)
    public void invalidCheckoutTwo() {
        sauceDemoPage.wrongCheckout();
        Assert.assertEquals(sauceDemoPage.getTxtWrongCheckout(), "Error: Last Name is required");
        System.out.println("Negative Checkout Test Case Success");
    }

    @Test(priority = 7)
    public void validCheckout() {
        sauceDemoPage.validCheckout();
        Assert.assertEquals(sauceDemoPage.getTxtCheckoutAllert(), "THANK YOU FOR YOUR ORDER");
        System.out.println("Valid Checkout Test Case Success");
    }

    @Test(priority = 8)
    public void logout() {
        sauceDemoPage.logout();
    }
}
