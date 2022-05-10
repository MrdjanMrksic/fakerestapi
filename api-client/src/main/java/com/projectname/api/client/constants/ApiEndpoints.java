package com.projectname.api.client.constants;

//List of endpoint as constants
public class ApiEndpoints {

    public static final String USERS = "api/users";
    public static final String users(String userId) {
        return USERS + "/" + userId;
    }

    //Activity Endpoints
    //GET/POST Activity
    public static final String GET_POST_ACTIVITY = "/api/v1/Activities";

    //GET/PUT/DELETE Activities by id
    public static final String GET_PUT_DELETE_ACTIVITY = "/api/v1/Activities/";
    public static String GET_PUT_DELETE_ACTIVITY(int id) {return GET_PUT_DELETE_ACTIVITY + id;}

}
