package com.course.selenium.example;

import com.course.selenium.helpers.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddAddressSteps {

    private WebDriver driver = BrowserFactory.getDriver();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        driver.get("https://mystore-testlab.coderslab.pl");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.name("email")).sendKeys("wzkkgazkhcoakoevnt@hthlm.com");
        driver.findElement(By.name("password")).sendKeys("SweetChilli");
        driver.findElement(By.id("submit-login")).click();
        
    }

    @When("the user navigates to the addresses page")
    public void theUserNavigatesToTheAddressesPage() {
        driver.findElement(By.cssSelector(".account .addresses")).click();
    }

    @And("the user clicks on Create new address")
    public void theUserClicksOnCreateNewAddress() {
        driver.findElement(By.cssSelector(".addresses-footer .btn")).click();
    }

    @And("the user fills the address form with {alias}, {address}, {city}, {postal code}, {country}, {phone}")
    public void theUserFillsTheAddressFormWith(String alias, String address, String city, String zip, String country, String phone) {
        driver.findElement(By.name("alias")).sendKeys(alias);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("postal code")).sendKeys(zip);
        driver.findElement(By.name("id_country")).sendKeys(country);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.cssSelector(".form-footer .btn-primary")).click();
        
    }

    @Then("the new address is added with {alias}, {address}, {city}, {postal code}, {country}, {phone}")
    public void theNewAddressIsAddedWith(String alias, String address, String city, String zip, String country, String phone) {
        String actualAlias = driver.findElement(By.cssSelector(".address .alias")).getText();
        String actualAddress = driver.findElement(By.cssSelector(".address .address1")).getText();
        String actualCity = driver.findElement(By.cssSelector(".address .city")).getText();
        String actualZip = driver.findElement(By.cssSelector(".address .postal code")).getText();
        String actualCountry = driver.findElement(By.cssSelector(".address .country")).getText();
        String actualPhone = driver.findElement(By.cssSelector(".address .phone")).getText();

        assert alias.equals(actualAlias);
        assert address.equals(actualAddress);
        assert city.equals(actualCity);
        assert zip.equals(actualZip);
        assert country.equals(actualCountry);
        assert phone.equals(actualPhone);
    }
}
