package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.ActivityAPI;
import com.projectname.api.client.calls.UserAPI;
import com.projectname.api.client.data.model.activity.Activity;
import com.projectname.api.client.data.model.users.create.CreateUserRequest;
import com.projectname.api.client.data.model.users.create.CreateUserResponse;
import com.projectname.api.tests.functional.asserts.ActivityAssert;
import com.projectname.api.tests.functional.asserts.UserAssert;
import com.projectname.api.tests.init.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.projectname.api.client.utils.Allure.logStep;

public class ActivityTest extends TestBase {
    ActivityAssert activityAssert = new ActivityAssert();

    @Test
    @Description("Test getting of the list of activities and assert that all objects are not empty")
    public void getListOfActivitiesTest() {
        List<Activity> getActivitiesResponse = ActivityAPI.activityResponse();

        activityAssert.assertListOfActivities(getActivitiesResponse);
    }

    @Test
    @Description("Test create activity and assert that it was successfully created")
    public static void verifyCreateActivity() {
        //LocalDateTime date = LocalDateTime.now();

        Activity createActivityRequest = new Activity(31, "Test Title", "2022-04-13T08:48:02.0849715+00:00", false);

        logStep("INFO: Create activity");
        Activity createActivityActual = ActivityAPI.createActivityResponse(createActivityRequest);
        logStep("PASS: Activity is created");

        Activity createActivityExpected = Activity.parseExpectedActivityResponse(createActivityRequest);

        ActivityAssert activityAssert = new ActivityAssert();
        logStep("INFO: Verify user is created");
        activityAssert.assertCreateActivityResponse(createActivityActual, createActivityExpected);
        logStep("PASS: Response is verified");


    }
}
