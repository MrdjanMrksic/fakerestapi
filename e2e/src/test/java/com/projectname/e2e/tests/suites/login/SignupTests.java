package com.projectname.e2e.tests.suites.login;

import com.projectname.e2e.tests.asserts.PhpTravelAssert;
import com.projectname.e2e.tests.data.model.RegisterUserRequest;
import com.projectname.e2e.tests.data.model.UserPageDetails;
import com.projectname.e2e.tests.data.provider.phptravels.PhpTravelsProvider;
import com.projectname.e2e.tests.pages.NavigationBarPage;
import com.projectname.e2e.tests.pages.SignupPage;
import com.projectname.e2e.tests.pages.UserPage;
import com.projectname.e2e.tests.suites.common.TestBase;
import org.testng.annotations.Test;

public class SignupTests extends TestBase {

    @Test
    public void verifyUserIsRegistered(){
        NavigationBarPage navigationBarPage = new NavigationBarPage(getDriver(), "","","");
        navigationBarPage.show();

        SignupPage signupPage = new SignupPage(getDriver(), "","","");
        signupPage.show();

        RegisterUserRequest userRequest = PhpTravelsProvider.prepareRegisterUserRequest();

        UserPage userPage = signupPage.registerNewUser(userRequest);

        UserPageDetails actualUserDetails = userPage.getActualUserDetails();

        UserPageDetails expectedUserDetails = UserPageDetails.parseExpectedUserDetails(userRequest);

        PhpTravelAssert phpTravelAssert = new PhpTravelAssert();
        phpTravelAssert.asserUserDataOnUserPage(actualUserDetails, expectedUserDetails);

    }
}
