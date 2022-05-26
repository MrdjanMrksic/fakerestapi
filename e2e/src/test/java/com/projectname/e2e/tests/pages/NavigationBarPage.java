package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBarPage extends PageBase {

    public NavigationBarPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.id("PHPTRAVELS"), driver);
    }

    private WebElement getDemoBtn(){
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/a[1]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find Demo button on Navigation bar page", e);
        }
    }

    private WebElement getFeaturesBtn(){
        try {
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/span"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find Features button on Navigation bar page", e);
        }
    }

    private WebElement getMainFeaturesBtn(){
        getFeaturesBtn().click();
        try{
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/div/a[1]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find Main button on Features dropdown menu");
        }
    }

    public MainFeaturesPage openMainFeaturesPage(){
        getMainFeaturesBtn().click();
        return new MainFeaturesPage(driver, url, email, password);
    }

    public DemoPage openDemoPage(){
        getDemoBtn().click();
        return new DemoPage(driver, url, email, password);
    }


}
