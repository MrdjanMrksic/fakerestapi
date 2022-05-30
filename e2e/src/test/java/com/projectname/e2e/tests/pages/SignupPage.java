package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.data.model.RegisterUserRequest;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SignupPage extends PageBase {
    public SignupPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()) {
            NavigationBarPage navigationBarPage = new NavigationBarPage(driver, url, email, password);
            navigationBarPage.openSignupPage();
        }
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                return this;

    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.id("containerNewUserSignup"), driver);
    }

    //GET ELEMENTS
    private WebElement getFirstNameInputField(){
        try{
            return driver.findElement(CustomBy.id("inputFirstName"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find first name input field on Signup page", e);
        }
    }

    private WebElement getLastNameInputField(){
        try{
            return driver.findElement(CustomBy.id("inputLastName"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find last name input field on Signup page", e);
        }
    }

    private WebElement getEmailInputField(){
        try{
            return driver.findElement(CustomBy.id("inputEmail"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find email input field on Signup page", e);
        }
    }

    private WebElement getCountryDialCodeButton(){
        try{
            return driver.findElement(CustomBy.xpath("//*[@id=\"containerNewUserSignup\"]/div[1]/div/div/div[4]/div/div/div/div/div[2]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find country dial code button on Signup page", e);
        }
    }

    private List<WebElement> getCountryDialCodeListButton(){
        try{
            return driver.findElements(CustomBy.className("country-name"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find dial code countries list on Signup page", e);
        }
    }

    private WebElement getCountryFromDialCodeList(String country){
        getCountryDialCodeButton().click();
        List<WebElement> countries = getCountryDialCodeListButton();
        for(WebElement countryElement: countries) {
            if (countryElement.getText().equals(country)) {
                return countryElement;
            }
        }
            throw new AssertionError("Could not find country in the list of country dial codes on the Signup page");
        }

    private WebElement getPhoneInputField(){
        try{
            return driver.findElement(CustomBy.id("inputPhone"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find phone input field on Signup page", e);
        }
    }




    private WebElement getCompanyNameInputField(){
        try{
            return driver.findElement(CustomBy.id("inputCompanyName"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find company name input field on Signup page", e);
        }
    }

    private WebElement getStreetAddress1InputField(){
        try{
            return driver.findElement(CustomBy.id("inputAddress1"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find street address 1 input field on Signup page", e);
        }
    }

    private WebElement getStreetAddress2InputField(){
        try{
            return driver.findElement(CustomBy.id("inputAddress2"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find street address 2 input field on Signup page", e);
        }
    }

    private WebElement getCityInputField(){
        try{
            return driver.findElement(CustomBy.id("inputCity"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find city input field on Signup page", e);
        }
    }

    private WebElement getStateInputField(){
        try{
            return driver.findElement(CustomBy.id("stateinput"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find state input field on Signup page", e);
        }
    }

    private WebElement getPostcodeInputField(){
        try{
            return driver.findElement(CustomBy.id("inputPostcode"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find postcode input field on Signup page", e);
        }
    }

    private WebElement getCountrySelectField(){
        try{
            return driver.findElement(CustomBy.id("inputCountry"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find country select field on Signup page", e);
        }
    }

    private void selectCountry(String country){
        Select countries = new Select(getCountrySelectField());
        countries.selectByValue(country);
    }

    private WebElement getMobileInputField(){
        try{
            return driver.findElement(CustomBy.id("customfield2"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find mobile input field on Signup page", e);
        }
    }

    private WebElement getEnterPasswordInputField(){
        try{
            return driver.findElement(CustomBy.id("inputNewPassword1"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find enter password input field on Signup page", e);
        }
    }

    private WebElement getConfirmPasswordInputField(){
        try{
            return driver.findElement(CustomBy.id("inputNewPassword2"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find confirm password input field on Signup page", e);
        }
    }

    private WebElement getMailingListSwitch(){
        try{
            return driver.findElement(CustomBy.xpath("//*[@id=\"frmCheckout\"]/div[3]/div/div/div/span[1]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find mailing list switch on Signup page", e);
        }
    }

    private WebElement getRegisterButton(){
        try{
            return driver.findElement(CustomBy.xpath("//*[@id=\"frmCheckout\"]/p/input"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not register button on Signup page", e);
        }
    }

    public UserPage registerNewUser(RegisterUserRequest userRequest){
        getFirstNameInputField().click();
        getFirstNameInputField().clear();
        getFirstNameInputField().sendKeys(userRequest.getFirstName());

        getLastNameInputField().click();
        getLastNameInputField().clear();
        getLastNameInputField().sendKeys(userRequest.getLastName());

        getEmailInputField().click();
        getEmailInputField().clear();
        getEmailInputField().sendKeys(userRequest.getEmail());

        getCountryFromDialCodeList(userRequest.getCountry().getCountryDialCode()).click();

        getPhoneInputField().click();
        getPhoneInputField().clear();
        getPhoneInputField().sendKeys(userRequest.getPhoneNumber());

        getCompanyNameInputField().click();
        getCompanyNameInputField().clear();
        getCompanyNameInputField().sendKeys(userRequest.getCompanyName());

        getStreetAddress1InputField().click();
        getStreetAddress1InputField().clear();
        getStreetAddress1InputField().sendKeys(userRequest.getAddress1());

        getStreetAddress2InputField().click();
        getStreetAddress2InputField().clear();
        getStreetAddress2InputField().sendKeys(userRequest.getAddress2());

        getCityInputField().click();
        getCityInputField().clear();
        getCityInputField().sendKeys(userRequest.getCity());

        getStateInputField().click();
        getStateInputField().clear();
        getStateInputField().sendKeys(userRequest.getState());

        getPostcodeInputField().click();
        getPostcodeInputField().clear();
        getPostcodeInputField().sendKeys(userRequest.getPostalCode());

        selectCountry(userRequest.getCountry().getCountryAbbreviation());

        getMobileInputField().click();
        getMobileInputField().clear();
        getMobileInputField().sendKeys(userRequest.getMobile());

        getEnterPasswordInputField().click();
        getEnterPasswordInputField().clear();
        getEnterPasswordInputField().sendKeys(userRequest.getPassword());

        getConfirmPasswordInputField().click();
        getConfirmPasswordInputField().clear();
        getConfirmPasswordInputField().sendKeys(userRequest.getPassword());

        getMailingListSwitch().click();

        getRegisterButton().click();

        return new UserPage(driver, url, email, password);
    }
}
