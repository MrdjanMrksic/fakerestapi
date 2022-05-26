package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;

public class PricingPage extends PageBase {
    public PricingPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()){
            NavigationBarPage navigationBarPage = new NavigationBarPage(driver, url, email, password);
            if (navigationBarPage.isDisplayed()){
                navigationBarPage.openPricingPage();
            }
        }
        return this;
    }

    @Override
    public boolean isDisplayed(){
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"Main\"]/div[6]/div/div[1]/section/div[1]/div[1]/div[1]"),driver);
    }
}
