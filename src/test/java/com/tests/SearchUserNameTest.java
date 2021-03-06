package com.tests;

import annotations.AzureTestCaseId;
import annotations.AzureTestPlanSuitId;
import com.apiServices.SearchUserService;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

/**
 * navigate to https://jsonplaceholder.typicode.com/users
 * then verify that Samantha contains in response body.
 */


public class SearchUserNameTest {

    SearchUserService callUser = new SearchUserService();
    Response response;

    @DisplayName("Call Samantha")
    @Test
    @Tag("smoke")

    public void searchForUserTest() {
        response=callUser.SearchUserName("Samantha");
        Assertions.assertTrue(response.statusCode() == 200);
        String responseString = response.body().asString();
        Assert.assertTrue(responseString.contains("Samantha"));
    }
}