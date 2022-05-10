package com.projectname.api.client.calls;

import java.util.List;

import com.google.protobuf.Api;
import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.activity.common.Activity;
import com.projectname.api.client.data.model.activity.delete.EmptyResponse;
import com.projectname.api.client.utils.GsonFunctions;
import com.projectname.api.client.utils.RestAssuredFunctions;

public class ActivityAPI {
    public static List<Activity> activityResponse() {
        return GsonFunctions.parseSuccessResponseAsListToModel(RestAssuredFunctions.get(ApiEndpoints.GET_POST_ACTIVITY), Activity[].class);
    }

    public static Activity createActivityResponse (Activity activityRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.GET_POST_ACTIVITY, activityRequest), Activity.class);
    }

    public static Activity getActivityById (int id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.GET_PUT_DELETE_ACTIVITY(id)),Activity.class);
    }

    public static Activity putActivityById (int id, Activity activityRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(activityRequest, ApiEndpoints.GET_PUT_DELETE_ACTIVITY(id)), Activity.class);
    }

    public static EmptyResponse deleteActivityById (int id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.GET_PUT_DELETE_ACTIVITY(id)), EmptyResponse.class);
    }
}