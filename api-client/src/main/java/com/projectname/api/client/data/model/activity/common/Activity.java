package com.projectname.api.client.data.model.activity.common;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activity implements Serializable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("dueDate")
    @Expose
    private String dueDate;
    @SerializedName("completed")
    @Expose
    private boolean completed;
    private final static long serialVersionUID = -1648174630450269578L;

    public Activity() {
    }

    public Activity(int id, String title, String dueDate, boolean completed) {
        super();
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public static Activity parseExpectedActivityResponse (Activity activityRequest){
      Activity activity = new Activity();

      activity.setId(activityRequest.getId());
      activity.setTitle(activityRequest.getTitle());
      activity.setDueDate(activityRequest.getDueDate());
      activity.setCompleted(activityRequest.isCompleted());

      return activity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}