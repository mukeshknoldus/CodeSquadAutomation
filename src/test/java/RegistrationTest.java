import com.fasterxml.jackson.databind.ObjectMapper;
import env_files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.*;

import java.util.Properties;

import static env_files.Payload.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;


public class RegistrationTest {
    Properties env_properties = new Properties();
    RegistrationPOJO registrationPOJO = new RegistrationPOJO();
    String registeredUser = getUniqueUserName();
    String registeredEmail = getUniqueEmail();;
    @BeforeTest
    public void getData() throws IOException {
        FileInputStream inputStream = new FileInputStream("..//CodeSquadTest//src//test//java//env_files//env.properties");
        env_properties.load(inputStream);
    }

    @Test
    public void post_registration_valid_credentials() {
        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = registeredUser;
            registrationPOJO.emailId = registeredEmail;
            registrationPOJO.password = getPassword();
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                       post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(200,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("success")).and().
                body("data.userName",equalTo(registeredUser))
                .and().header("Server",equalTo(env_properties.getProperty("SERVER")));
    }

    @Test
    public void post_registration_invalid_userName() {

        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = "KRK";
            registrationPOJO.emailId = registeredEmail;
            registrationPOJO.password = getPassword();
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(422,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("failed")).
                header("Server",equalTo(env_properties.getProperty("SERVER")));

    }

    @Test
    public void post_registration_alreadyUsed_UserName() {
        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = "knoldustestuser";
            registrationPOJO.emailId = registeredEmail;
            registrationPOJO.password = getPassword();
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(409,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("failed")).
                body("errors.message",equalTo("Username or Email address already in use.")).
                header("Server",equalTo(env_properties.getProperty("SERVER")));
    }

    @Test
    public void post_registration_invalid_emailID() {

        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = registeredUser;
            registrationPOJO.emailId = "test@knolus";
            registrationPOJO.password = getPassword();
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(422,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("failed")).
                header("Server",equalTo(env_properties.getProperty("SERVER")));
    }


    @Test
    public void post_registration_alreadyUsed_EmailID() {
        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = registeredUser;
            registrationPOJO.emailId = "knoldustestuser@gmail.com ";
            registrationPOJO.password = getPassword();
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(409,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("failed")).
                body("errors.message",equalTo("Username or Email address already in use.")).
                header("Server",equalTo(env_properties.getProperty("SERVER")));
    }

    @Test
    public void post_registration_all_fields_empty() {

        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = "";
            registrationPOJO.emailId = "";
            registrationPOJO.password = "";
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(422,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("failed")).
                header("Server",equalTo(env_properties.getProperty("SERVER")));
    }

    @Test
    public void post_registration_empty_userName() {

        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = "";
            registrationPOJO.emailId = registeredEmail;
            registrationPOJO.password = getPassword();
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(422,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("failed")).
                header("Server",equalTo(env_properties.getProperty("SERVER")));
    }

    @Test
    public void post_registration_empty_Email() {

        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = registeredUser;
            registrationPOJO.emailId = "";
            registrationPOJO.password = getPassword();
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(422,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("failed")).
                header("Server",equalTo(env_properties.getProperty("SERVER")));
    }

    @Test
    public void post_registration_empty_password() {

        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = registeredUser;
            registrationPOJO.emailId = registeredEmail;
            registrationPOJO.password = "";
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(422,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("failed")).
                header("Server",equalTo(env_properties.getProperty("SERVER")));
    }

    @Test
    public void post_registration_invalid_password() {

        Response response =  null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            RestAssured.baseURI = env_properties.getProperty("HOST");
            registrationPOJO.userName = registeredUser;
            registrationPOJO.emailId = registeredEmail;
            registrationPOJO.password = "1234";
            String json_object = mapper.writeValueAsString(registrationPOJO);
            response = given().contentType(ContentType.JSON).body(json_object).when().
                    post(Resources.post_registration());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(422,response.getStatusCode());

        response.then().assertThat().and().body("status",equalTo("failed")).
                header("Server",equalTo(env_properties.getProperty("SERVER")));
    }


    @AfterTest
    public void deleteRegisteredUser() {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection(
                        System.getenv("DataBase"),System.getenv("UserName"),System.getenv("Password"));
                String query = "delete from users where email_id = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, registeredEmail);
                preparedStmt.execute();
                System.out.println("Deleted successfully");
            }catch(Exception e){
                System.out.println(e);
            }
    }

}
