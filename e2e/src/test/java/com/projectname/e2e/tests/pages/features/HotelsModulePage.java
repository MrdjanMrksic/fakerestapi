package com.projectname.e2e.tests.pages.features;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;

public class HotelsModulePage extends PageBase {
    public HotelsModulePage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
