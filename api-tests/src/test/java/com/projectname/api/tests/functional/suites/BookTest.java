package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.ActivityAPI;
import com.projectname.api.client.calls.BookAPI;
import com.projectname.api.client.data.model.activity.common.Activity;
import com.projectname.api.client.data.model.book.common.Book;
import com.projectname.api.client.data.model.delete.EmptyResponse;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.ActivityProvider;
import com.projectname.api.tests.data.provider.BookProvider;
import com.projectname.api.tests.functional.asserts.ActivityAssert;
import com.projectname.api.tests.functional.asserts.BookAssert;
import com.projectname.api.tests.init.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.projectname.api.client.utils.Allure.logStep;

public class BookTest extends TestBase {
    BookAssert bookAssert = new BookAssert();

    @Test
    @Description("Test getting the list of books adn assert that all objects are not empty")
    public void getListOfBooksTest(){
        List<Book> getBooksResponse = BookAPI.bookResponse();

        bookAssert.assertListOfBooks(getBooksResponse);
    }

    @Test
    @Description("Test creation of book and assert that it was successfully created")
    public void verifyCreateBook (){
        Book createBookRequest = new Book(31, "Test title", "Test description", 12,"Test excerpt","2022-04-13T08:48:02.0849715+00:00");

        logStep("INFO: Create book");
        Book createBookActual = BookAPI.createBookResponse(createBookRequest);
        logStep("PASS: Book is created");

        Book createBookExpected = Book.parseExpectedBookResponse(createBookRequest);

        BookAssert bookAssert = new BookAssert();

        logStep("INFO: Verify book is created");
        bookAssert.assertBookResponses(createBookActual, createBookExpected);
        logStep("PASS: Response is verified");
    }

    @Test(groups = {"regression", "smoke"}, dataProvider = DataProviderNames.VERIFY_CREATE_BOOK, dataProviderClass = BookProvider.class)
    @Description("Test creation of book and assert that is was successfully created")
    public void verifyCreateBookWithDataProvider(String methodNameSuffix, Book createBookRequest){
        logStep("INFO: Create Book");
        Book createBookActual = BookAPI.createBookResponse(createBookRequest);
        logStep("Pass: Book is created");

        Book createBookExpected = Book.parseExpectedBookResponse(createBookRequest);

        logStep("INFO: Verify Book is created");
        bookAssert.assertBookResponses(createBookActual, createBookExpected);
        logStep("PASS: Response is verified");

    }

    @Test
    @Description("Test getting book by id and assert that all fields are not empty")
    public void getBookById() {
        Book getBookById = BookAPI.getBookById(1);

        bookAssert.assertBookById(getBookById);
    }

    @Test(groups = {"regression", "smoke"}, dataProvider = DataProviderNames.VERIFY_UPDATE_BOOK, dataProviderClass = BookProvider.class)
    @Description("Test put book by id and assert that the update was successful")
    public static void verifyUpdateActivityById(String suffix, Book updateBookRequest){
        Book actualResponse = BookAPI.putBookById(2, updateBookRequest);

        Book expectedResponse = Book.parseExpectedBookResponse(updateBookRequest);

        BookAssert bookAssert = new BookAssert();
        bookAssert.assertBookResponses(actualResponse, expectedResponse);
    }

    @Test
    @Description("Test delete book by id and assert that deletion was successful")
    public static void verifyDeleteActivityById(){
        EmptyResponse actualResponse = BookAPI.deleteBookById(3);

        Assert.assertNull(actualResponse);

        //Proper test would be to try and get activity with the same id that we just deleted
        //But because of the API under test, this test would fail

    }

}
