package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.activity.Activity;
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
}
