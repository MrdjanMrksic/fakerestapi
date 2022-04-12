package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.ActivityAPI;
import com.projectname.api.client.data.model.activity.Activity;
import com.projectname.api.tests.functional.asserts.ActivityAssert;
import com.projectname.api.tests.init.TestBase;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import java.util.List;

public class ActivityTest extends TestBase {
    ActivityAssert activityAssert = new ActivityAssert();

    @Test(groups = "priority")
    @Description("Test getting of the list of activities and assert that all objects are not empty")
    public void getListOfActivitiesTest() {
        List<Activity> getActivitiesResponse = ActivityAPI.activityResponse();

        activityAssert.assertListOfActivities(getActivitiesResponse);
    }
}
