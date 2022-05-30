package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.data.model.UserPageDetails;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class UserPage extends PageBase {
    public UserPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"Secondary_Navbar-Account\"]/a"), driver);
    }

    private WebElement getFistAndLastName(){
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/strong"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find first and last name on User page", e);
        }
    }

    private WebElement getAddress1(){
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/br[1]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find address 1 on User page", e);
        }
    }

    private WebElement getAddress2(){
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/br[2]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find address 2 on User page", e);
        }
    }

    private WebElement getCityStateAndPostalCode(){
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/br[3]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find city, state and postal code on User page", e);
        }
    }

    private WebElement getCountry(){
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div/br[4]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find country on User page", e);
        }
    }

    private WebElement getUserCard(){
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"main-body\"]/div/div[1]/div[1]/div[1]/div/div[2]/div"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find user card on User page", e);
        }
    }

    public UserPageDetails getActualUserDetails(){
        UserPageDetails userPageDetails = new UserPageDetails();

        userPageDetails.setFirstAndLastName(getFistAndLastName().getText());
        userPageDetails.setAddress1(getUserCard().getText());
        userPageDetails.setAddress2(getAddress2().getText());
        userPageDetails.setCityStatePostalCode(getCityStateAndPostalCode().getText());
        userPageDetails.setCountry(getCountry().getText());

        return userPageDetails;
    }
}