package tests;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import com.shaft.tools.io.ReportManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ApiTests {
    @Test
    public void getOneRandomCatFact(){


        //Identify request query params
        List<List<Object>> queryParams = Arrays.asList(
                Arrays.asList("animal_type", "cat"),
                Arrays.asList("amount", "1"));
        //build the request
        RestActions apiObject = new RestActions("https://cat-fact.herokuapp.com/");
        Response res = apiObject
                .buildNewRequest("facts/random", RestActions.RequestType.GET)
                .setParameters(queryParams,RestActions.ParametersType.QUERY)
                .performRequest();
        //log the response to the report
        ReportManager.log(res.asPrettyString());
        //read cat fact text
        String catFactMessage= RestActions.getResponseJSONValue(res,"text");
        //verify it's not empty
        Assert.assertTrue(!catFactMessage.isEmpty());



    }
}
