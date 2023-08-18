package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoPage {
    //locator Login
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;
    @FindBy(xpath = "//h3[normalize-space()='Epic sadface: Username is required']")
    WebElement blankLoginAllert;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement wrongLoginAllert;
    @FindBy(xpath = "//div[@class='product_label']")
    WebElement LoginAllert;

    //locator Add Product
    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Backpack']")
    WebElement backpackItem;
    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Fleece Jacket']")
    WebElement jacketItem;
    @FindBy(xpath = "//button[normalize-space()='ADD TO CART']")
    WebElement btnAddToCart;
    @FindBy(xpath = "//button[normalize-space()='<- Back']")
    WebElement btnBack;
    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']")
    WebElement btnShoppingCart;

    //locator Checkout
    @FindBy(xpath = "//a[normalize-space()='CHECKOUT']")
    WebElement btnCheckout;
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCode;
    @FindBy(xpath = "//input[@value='CONTINUE']")
    WebElement btnContinue;
    @FindBy(xpath = "//h3[normalize-space()='Error: First Name is required']")
    WebElement blankCheckoutAllert;
    @FindBy(xpath = "//h3[normalize-space()='Error: Last Name is required']")
    WebElement wrongCheckOutAllert;
    @FindBy(xpath = "//a[normalize-space()='FINISH']")
    WebElement btnFinish;
    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    WebElement checkoutAllert;

    //locator Logout
    @FindBy(xpath = "//button[normalize-space()='Open Menu']")
    WebElement btnMenu;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logoutMenu;
    private WebDriver driver;

    public SauceDemoPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void blankLogin() {
        btnLogin.click();
    }

    public void wrongLogin() {
        username.sendKeys("standard");//memasukan username
        password.sendKeys("secret");//memasukan password
        btnLogin.click();//mengklik tombol login
    }

    public void validLogin() {
        username.clear();
        username.sendKeys("standard_user");//memasukan username
        password.clear();
        password.sendKeys("secret_sauce");//memasukan password
        btnLogin.click();//mengklik tombol login
    }

    public void addProduct() {
        backpackItem.click();
        btnAddToCart.click();
        btnBack.click();
        jacketItem.click();
        btnAddToCart.click();
        btnShoppingCart.click();
        btnCheckout.click();
    }

    public void blankCheckout() {
        btnContinue.click();
    }

    public void wrongCheckout() {
        firstName.sendKeys("kristoporus");
        btnContinue.click();
    }

    public void validCheckout() {
        firstName.clear();
        firstName.sendKeys("kristoporus");
        lastName.sendKeys("Tino");
        postalCode.sendKeys("123");
        btnContinue.click();
        btnFinish.click();
    }

    public void logout() {
        btnMenu.click();
        logoutMenu.click();
    }

    public String getTxtBlankAllert() {
        return blankLoginAllert.getText();
    }

    public String getTxtWrongAllert() {
        return wrongLoginAllert.getText();
    }

    public String getTxtLoginAllert() {
        return LoginAllert.getText();
    }

    public String getTxtBlankCheckout() {
        return blankCheckoutAllert.getText();
    }

    public String getTxtWrongCheckout() {
        return wrongCheckOutAllert.getText();
    }

    public String getTxtCheckoutAllert() {
        return checkoutAllert.getText();
    }
}

