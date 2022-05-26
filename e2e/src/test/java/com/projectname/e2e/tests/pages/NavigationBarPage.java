package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.pages.features.*;
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

    private WebElement getPricingBtn(){
        try{
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/a[2]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find Pricing button on Navigation bar page", e);
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
            throw new AssertionError("Could not find Main Fetures button on Features dropdown menu");
        }
    }

    private WebElement getHotelsModuleBtn(){
        getFeaturesBtn().click();
        try{
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/div/a[2]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find Hotels Module button on Features dropdown menu", e);
        }
    }

    private WebElement getFlightsModuleBtn(){
        getFeaturesBtn().click();
        try{
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/div/a[3]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find Flights Module button on Features dropdown menu", e);
        }
    }

    private WebElement getToursModuleBtn(){
        getFeaturesBtn().click();
        try{
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/div/a[4]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find Tours Module button on Features dropdown menu", e);
        }
    }

    private WebElement getCarsModuleBtn(){
        getFeaturesBtn().click();
        try{
            return driver.findElement(CustomBy.xpath("/html/body/header/div/nav/div[1]/div/a[5]"));
        } catch (Exception e){
            e.printStackTrace();
            throw new AssertionError("Could not find Cars Module button on Features dropdown menu", e);
        }
    }

    public DemoPage openDemoPage(){
        getDemoBtn().click();
        return new DemoPage(driver, url, email, password);
    }

    public PricingPage openPricingPage(){
        getPricingBtn().click();
        return new PricingPage(driver, url, email, password);
    }

    public MainFeaturesPage openMainFeaturesPage(){
        getMainFeaturesBtn().click();
        return new MainFeaturesPage(driver, url, email, password);
    }


    public HotelsModulePage openHotelsModulePage(){
        getHotelsModuleBtn().click();
        return new HotelsModulePage(driver, url, email, password);
    }

    public FlightsModulePage openFlightsModulePage(){
        getFlightsModuleBtn().click();
        return new FlightsModulePage(driver, url, email, password);
    }

    public ToursModulePage openToursModulePage(){
        getToursModuleBtn().click();
        return new ToursModulePage(driver, url, email, password);
    }

    public CarsModulePage openCarsModulePage(){
        getCarsModuleBtn().click();
        return new CarsModulePage(driver, url, email, password);
    }

}
