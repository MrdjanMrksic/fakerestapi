package com.projectname.api.client.data.model.book.common;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.data.model.activity.common.Activity;

public class Book implements Serializable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pageCount")
    @Expose
    private int pageCount;
    @SerializedName("excerpt")
    @Expose
    private String excerpt;
    @SerializedName("publishDate")
    @Expose
    private String publishDate;
    private final static long serialVersionUID = -8520929711137330627L;

    public Book() {
    }

    public Book(int id, String title, String description, int pageCount, String excerpt, String publishDate) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    public static Book parseExpectedBookResponse (Book bookRequest){
        Book book = new Book();

        book.setId(bookRequest.getId());
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setPageCount(bookRequest.getPageCount());
        book.setExcerpt(bookRequest.getExcerpt());
        book.setPublishDate(bookRequest.getPublishDate());

        return book;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

}