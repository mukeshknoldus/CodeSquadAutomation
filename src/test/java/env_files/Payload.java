package env_files;

public class Payload {
    public static String get_already_registered_user_data() {
        String payload = "{\n" +
                " \"userName\": \"knoldustestuser\",\n" +
                " \"emailId\": \"knoldustestuser@gmail.com\" ,\n" +
                " \"password\": \"knoldus@123\"\n" +
                "}";
        return payload;
    }

    public static String get_new_user_data() {
        String payload = "{\n" +
                " \"userName\": \"knoldustestuser\",\n" +
                " \"emailId\": \"knoldustestuser@gmail.com\" ,\n" +
                " \"password\": \"knoldus@123\"\n" +
                "}";
        return payload;
    }
}
