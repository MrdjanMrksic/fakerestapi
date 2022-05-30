package com.projectname.e2e.tests.asserts;

import com.projectname.e2e.tests.data.model.UserPageDetails;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PhpTravelAssert {
    private SoftAssert softAssert;

    public PhpTravelAssert(){
        softAssert = new SoftAssert();
    }

    public void asserUserDataOnUserPage(UserPageDetails actualDetails, UserPageDetails expectedDetails){
        if (actualDetails == null){
            Assert.fail("Actual details are null");
        }

//        this.softAssert.assertEquals(actualDetails.getFirstAndLastName(), expectedDetails.getFirstAndLastName(), "Name did not match");
//        this.softAssert.assertEquals(actualDetails.getAddress1(), expectedDetails.getAddress1(), "Address 1 did not match");
//        this.softAssert.assertEquals(actualDetails.getAddress2(), expectedDetails.getAddress2(), "Address 2 did not match");
//        this.softAssert.assertEquals(actualDetails.getCityStatePostalCode(), expectedDetails.getCityStatePostalCode(), "City, State and Postal code did not match");
//        this.softAssert.assertEquals(actualDetails.getCountry(), expectedDetails.getCountry(), "Country did not match");

        this.softAssert.assertEquals(actualDetails.getAddress1(),  expectedDetails.getCompanyName() + "\n" + expectedDetails.getFirstAndLastName() + "\n" + expectedDetails.getAddress1() + "\n"
                + expectedDetails.getAddress2() + "\n" + expectedDetails.getCityStatePostalCode() + "\n" + expectedDetails.getCountry(), "User details didnt match");
        this.softAssert.assertAll();
    }
}
