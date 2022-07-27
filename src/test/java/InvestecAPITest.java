import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class InvestecAPITest {

    String url = "https://swapi.dev/api/people/";

    @Test
    public void getRequest(){
        //Execute GET request and verify a success response
        int statusCode = given().when().get(url)
                .getStatusCode();
        System.out.println("Status Code is: " + statusCode);
        Assert.assertTrue(statusCode == 200);
    }

    @Test
    public void getResponseBody(){
        //Get the response body to view it
        given().when().get(url)
                .then().log().body();
    }

    @Test
    public void validateSkinColor(){
        //Get the skin color of R2-D2 and assert that it is White, Blue
        String skinColor = given().when().get(url)
                .then().extract().path("results[2].skin_color");
        System.out.println(skinColor);
        Assert.assertTrue(skinColor.equals("white, blue"));
    }

}
