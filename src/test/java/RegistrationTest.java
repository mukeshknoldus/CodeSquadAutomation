import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

import env_files.Resources;
import env_files.Payload;


public class RegistrationTest {
    Properties env_properties = new Properties();

    @BeforeTest
    public void getData() throws IOException {

        FileInputStream inputStream = new FileInputStream("..//CodeSquadTest//src//test//java//env_files//env.properties");
        env_properties.load(inputStream);
    }

    @Test
    public void post_registration_valid_credentials() {
        Response response =  null;
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            response = given().contentType(ContentType.JSON).body(Payload.get_already_registered_user_data()).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(409,response.getStatusCode());
        System.out.println("After assertion");
        response.then().assertThat().and().body("status",equalTo("failed")).and().
                body("errors.message",equalTo("Username or Email address already in use."))
                .and().header("Server",equalTo(env_properties.getProperty("SERVER")));
    }
}
