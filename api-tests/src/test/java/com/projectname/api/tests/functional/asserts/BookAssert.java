package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.activity.common.Activity;
import com.projectname.api.client.data.model.book.common.Book;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class BookAssert {
    public SoftAssert softAssert = new SoftAssert();

    public void assertListOfBooks(List<Book> bookResponse) {
        for (int i = 0; i < bookResponse.size(); i++) {
            softAssert.assertFalse(bookResponse.get(i).getId() < 0, "ID is less than 0"); //how to check if int is empty, notNull does not work
            softAssert.assertFalse(bookResponse.get(i).getTitle().isEmpty(), "Title is empty");
            softAssert.assertFalse(bookResponse.get(i).getDescription().isEmpty(), "Descrition is empty");
            softAssert.assertFalse(bookResponse.get(i).getPageCount() < 0, "Page count is less than 0");
            softAssert.assertFalse(bookResponse.get(i).getExcerpt().isEmpty(), "Excerpt is empty");
            softAssert.assertFalse(bookResponse.get(i).getPublishDate().isEmpty(), "Due date is  empty");
            //how to check if boolean is missing
        }
        softAssert.assertAll();
    }

    public void assertBookById(Book bookResponse){
        softAssert.assertFalse(bookResponse.getId() < 0, "ID is less than 0");
        softAssert.assertFalse(bookResponse.getTitle().isEmpty(), "Title is empty");
        softAssert.assertFalse(bookResponse.getDescription().isEmpty(), "Descrition is empty");
        softAssert.assertFalse(bookResponse.getPageCount() < 0, "Page count is less than 0");
        softAssert.assertFalse(bookResponse.getExcerpt().isEmpty(), "Excerpt is empty");
        softAssert.assertFalse(bookResponse.getPublishDate().isEmpty(), "Due date is  empty");

        softAssert.assertAll();
    }

    public void assertBookResponses(Book actualResponse, Book expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Book is not updated");
        }
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId());
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle());
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription());
        softAssert.assertEquals(actualResponse.getPageCount(), expectedResponse.getPageCount());
        softAssert.assertEquals(actualResponse.getExcerpt(), expectedResponse.getExcerpt());
        softAssert.assertEquals(actualResponse.getPublishDate(), expectedResponse.getPublishDate());

        softAssert.assertAll();
    }
}
