package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.activity.Activity;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ActivityAssert {
    public SoftAssert softAssert = new SoftAssert();

    public void assertListOfActivities(List<Activity> activityResponse) {
        for (int i = 0; i < activityResponse.size(); i++) {
            softAssert.assertFalse(activityResponse.get(i).getId() < 0, "ID is less than 0"); //how to check if int is empty, notNull does not work
            softAssert.assertFalse(activityResponse.get(i).getTitle().isEmpty(), "Title is empty");
            softAssert.assertFalse(activityResponse.get(i).getDueDate().isEmpty(), "Due date is  empty");
            //how to check if boolean is missing
        }
        softAssert.assertAll();
    }

    public void assertCreateActivityResponse(Activity actualResponse, Activity expectedRequest) {
        if (actualResponse == null){
            Assert.fail("Activity is not created");
        }

        softAssert.assertEquals(actualResponse.getId(), expectedRequest.getId(), "ID did not match");
        softAssert.assertEquals(actualResponse.getTitle(), expectedRequest.getTitle(), "Title did not match");
        softAssert.assertEquals(actualResponse.getDueDate(), expectedRequest.getDueDate(), "Due date did not match");
        softAssert.assertEquals(actualResponse.isCompleted(), expectedRequest.isCompleted(), "Completion status did not match");

        softAssert.assertAll();
    }
}
