package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.ActivityAPI;
import com.projectname.api.client.data.model.activity.Activity;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.ActivityProvider;
import com.projectname.api.tests.functional.asserts.ActivityAssert;
import com.projectname.api.tests.init.TestBase;
import jdk.jfr.Description;
import org.testng.annotations.Test;

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

    @Test(groups = {"regression", "smoke"}, dataProvider = DataProviderNames.VERIFY_CREATE_ACTIVITY, dataProviderClass = ActivityProvider.class)
    @Description("Test create activity and assert that it was successfully created")
    public static void verifyCreateActivityWithDataProvider(String methodNameSuffix, Activity createActivityRequest) {

        logStep("INFO: Create Activity");
        Activity createActivityActual = ActivityAPI.createActivityResponse(createActivityRequest);
        logStep("PASS: Activity is created");

        Activity createActivityExpected = Activity.parseExpectedActivityResponse(createActivityRequest);

        ActivityAssert activityAssert = new ActivityAssert();
        logStep("INFO: Verify Activity is created");
        activityAssert.assertCreateActivityResponse(createActivityActual, createActivityExpected);
        logStep("PASS: Response is verified");

    }

    @Test(groups = {"regression", "smoke"}, dataProvider = DataProviderNames.VERIFY_UPDATE_ACTIVITY, dataProviderClass = ActivityProvider.class)
    @Description("Test put activity by ID and assert that the update was successful")
    public static void verifyUpdateActivityById(String suffix, Activity updateActivityRequest){
        Activity actualResponse = ActivityAPI.putActivityById(10, updateActivityRequest);

        Activity expectedResponse = Activity.parseExpectedActivityResponse(updateActivityRequest);

        ActivityAssert activityAssert = new ActivityAssert();
        activityAssert.assertUpdateActivity(actualResponse, expectedResponse);
    }
}
