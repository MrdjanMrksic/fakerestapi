package com.projectname.api.tests.data.provider;

import com.projectname.api.client.calls.ActivityAPI;
import com.projectname.api.client.data.model.activity.Activity;
import com.projectname.api.client.data.model.users.create.CreateUserRequest;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.DataProvider;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ActivityProvider {

    static Random rand = new Random();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @DataProvider(name = DataProviderNames.VERIFY_CREATE_ACTIVITY)
    public static Object[][] verifyCreateActivity() {

        int id = 0;
        List<Activity> activityResponse = ActivityAPI.activityResponse();

        for (int i = 0; i <= activityResponse.size(); i++) {
            if (id <= activityResponse.get(i).getId()) {
                id = activityResponse.get(i).getId()+1;
            }
        }

        return new Object[][]{
                {"WithRandomFields", new Activity(id, RandomStringGenerator.createRandomStringAlphanumericWithLen(12) , sdf.format(new Date()), rand.nextBoolean())},
                {"WithGivenFields", new Activity(32, "FakeRestApi Post Test", sdf.format(new Date()), true)},
        };
    }

    @DataProvider(name = DataProviderNames.VERIFY_UPDATE_ACTIVITY)
    public static Object[][] verifyUpdateActivity(){
        return new Object[][]{
                {"WithRandomFields", new Activity(rand.nextInt(30), RandomStringGenerator.createRandomStringAlphanumericWithLen(12) , sdf.format(new Date()), rand.nextBoolean())},
                {"WithGivenFields", new Activity(32, "FakeRestApi Put Test", sdf.format(new Date()), true)},
        };
    }
}
