import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.request;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import env_files.Resources;
import env_files.Payload;



public class RegistrationTest {
    Properties env_properties = new Properties();


    @BeforeTest
    public void getData() throws IOException {
        System.out.println("Hi This is Before Method");

        FileInputStream inputStream = new FileInputStream("/home/knoldus/Documents/Automation/CodeSquadAutomation/src/test/java/env_files/env.properties");
        System.out.println("/n/n size ="+ inputStream.getFD().toString());
        env_properties.load(inputStream);

        System.out.println(env_properties.getProperty("HOST"));
        System.out.println(env_properties.getProperty("SERVER"));
        //RestAssured.basePath = "/user/registration";
    }

    @Test(groups = {"tst"})
    public void post_registration_valid_credentials() {
        Response response =  null;
        RegistrationPOJO obj = new RegistrationPOJO();
        obj.setEmail("testknoldus@knoldus.com");
        obj.setPassword("123456");
        obj.setUserName("testknoldus");

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
