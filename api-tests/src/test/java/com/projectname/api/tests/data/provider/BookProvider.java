package com.projectname.api.tests.data.provider;

import com.projectname.api.client.calls.ActivityAPI;
import com.projectname.api.client.calls.BookAPI;
import com.projectname.api.client.data.model.activity.common.Activity;
import com.projectname.api.client.data.model.book.common.Book;
import com.projectname.api.client.utils.RandomStringGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BookProvider {
    static Random rand = new Random();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @DataProvider(name = DataProviderNames.VERIFY_CREATE_BOOK)
    public static Object[][] verifyCreateBook() {

        int id = 0;
        List<Book> bookResponse = BookAPI.bookResponse();

        for (int i = 0; i <bookResponse.size(); i++) {
            if (id <= bookResponse.get(i).getId()) {
                id = bookResponse.get(i).getId()+1;
            }
        }

        return new Object[][]{
                {"WithRandomFields", new Book(id, RandomStringGenerator.createRandomStringAlphanumericWithLen(12), RandomStringGenerator.createRandomStringAlphanumericWithLen(350),RandomStringGenerator.createRandomWholeNumber(50,250), RandomStringGenerator.createRandomStringAlphanumericWithLen(3200), sdf.format(new Date()))},
                {"WithGivenFields", new Book(32, "FakeRestApi Post Test", "Test description", 120, "Test excerpt",sdf.format(new Date()))},
        };
    }

    @DataProvider(name = DataProviderNames.VERIFY_UPDATE_BOOK)
    public static Object[][] verifyUpdateBook(){
        return new Object[][]{
                {"WithRandomFields", new Book(rand.nextInt(30), RandomStringGenerator.createRandomStringAlphanumericWithLen(12), RandomStringGenerator.createRandomStringAlphanumericWithLen(350),RandomStringGenerator.createRandomWholeNumber(50,250), RandomStringGenerator.createRandomStringAlphanumericWithLen(3200), sdf.format(new Date()))},
                {"WithGivenFields", new Book(32, "FakeRestApi Put Test", "Test put description", 124, "Test put excerpt",sdf.format(new Date()))},
        };
    }
}
