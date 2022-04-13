package com.projectname.api.tests.data.provider;

import com.projectname.api.client.calls.ActivityAPI;
import com.projectname.api.client.data.model.activity.Activity;
import com.projectname.api.client.data.model.users.create.CreateUserRequest;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ActivityProvider {

    @DataProvider(name = DataProviderNames.VERIFY_CREATE_ACTIVITY)
    public static Object[][] verifyCreateActivity() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Random rand = new Random();
        int id = 0;
        List<Activity> activityResponse = ActivityAPI.activityResponse();

        for (int i = 0; i < activityResponse.size(); i++) {
            if (id < activityResponse.get(i).getId()) {
                id = activityResponse.get(i).getId();
            }
        }

        return new Object[][]{
                {"WithRandomFields", new Activity(id, RandomStringGenerator.createRandomStringAlphanumericWithLen(12) , sdf.format(new Date()), rand.nextBoolean())},
                {"WithGivenFields", new Activity(32, "FakeRestApi test", sdf.format(new Date()), true)},
        };
    }
}
