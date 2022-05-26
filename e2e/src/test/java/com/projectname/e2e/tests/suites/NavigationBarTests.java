package com.projectname.e2e.tests.suites;

import com.projectname.e2e.tests.pages.DemoPage;
import com.projectname.e2e.tests.pages.features.HotelsModulePage;
import com.projectname.e2e.tests.pages.features.MainFeaturesPage;
import com.projectname.e2e.tests.pages.NavigationBarPage;
import com.projectname.e2e.tests.pages.PricingPage;
import com.projectname.e2e.tests.suites.common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBarTests extends TestBase {

    @Test
    public void verifyDemoButtonIsWorking(){
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(),"","","");

        DemoPage demoPage = navigationBarPage.openDemoPage();

        Assert.assertTrue(demoPage.isDisplayed());
    }

    @Test
    public void verifyPricingButtonIsWorking(){
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(),"","","");

        PricingPage pricingPage = navigationBarPage.openPricingPage();

        Assert.assertTrue(pricingPage.isDisplayed());
    }

    @Test
    public void verifyMainFeaturesButtonIsWorking(){
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(),"","","");

        MainFeaturesPage mainFeaturesPage = navigationBarPage.openMainFeaturesPage();

        Assert.assertTrue(mainFeaturesPage.isDisplayed());
    }

    @Test
    public void VerifyHotesModulePageIsWorking(){
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "", "", "");

        HotelsModulePage hotelsModulePage = navigationBarPage.openHotelsModulePage();

        Assert.assertTrue(hotelsModulePage.isDisplayed());
    }
}
