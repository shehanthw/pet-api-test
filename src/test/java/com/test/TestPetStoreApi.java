package com.test;

import com.utils.JsonUtils;
import com.utils.PropertyUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;

public class TestPetStoreApi {

    public TestPetStoreApi() {
        RestAssured.baseURI =  PropertyUtils.getValue("BASE_URL");
    }

    @Test(priority = 1)
    public void testCreateNewPet() {
        HashMap<String, Object> newPetData = JsonUtils.readFile("src/test/resources/data/pets.json");

        Response response = RestAssured
                .given()
                .header("api_key", "special-key")
                .contentType("application/json")
                .body(newPetData)
                .when()
                .post("/")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
    }

    @Test(priority = 2)
    public void testGetPetTypeById() {
        int petId = 16678957;
        Response response = RestAssured
                .given()
                .header("api_key", "special-key")
                .contentType("application/json")
                .pathParams("petId", petId)
                .when()
                .get("/{petId}")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
        String petName = response.jsonPath().getString("name");
        Assert.assertEquals(petName, "Dave");
    }


}
