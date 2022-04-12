package com.projectname.api.client.calls;

import java.util.List;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.activity.Activity;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class ActivityAPI {
    public static List<Activity> activityResponse() {
        return GsonFunctions.parseSuccessResponseAsListToModel(RestAssuredFunctions.get(ApiEndpoints.GET_POST_ACTIVITY), Activity[].class);
    }

    public static Activity createActivityResponse (Activity activityRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.GET_POST_ACTIVITY, activityRequest), Activity.class);
    }
}