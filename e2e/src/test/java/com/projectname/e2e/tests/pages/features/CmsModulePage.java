package com.projectname.e2e.tests.pages.features;

import com.projectname.e2e.tests.pages.NavigationBarPage;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;

public class CmsModulePage extends PageBase {
    public CmsModulePage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()){
            NavigationBarPage navigationBarPage = new NavigationBarPage(driver, url, email, password);
            if (navigationBarPage.isDisplayed()){
                navigationBarPage.openCmsModulePage();
            }
        }
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.id("header-title"), driver);
    }
}
