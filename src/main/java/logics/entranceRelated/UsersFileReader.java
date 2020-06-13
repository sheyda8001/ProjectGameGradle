package logics.entranceRelated;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsersFileReader {
    public boolean isMatch(String user, String password) {
        boolean isMatch = false;
        String[] usepass = new String[2];
        try (FileReader reader = new FileReader("usersFile\\" + user + ".json")) {
            // parsing file "JSONExample.json"
            FileReader reade = new FileReader("usersFile\\" + user + ".json");
            Object obj = new JSONParser().parse(reade);
            reade.close();
            reader.close();
            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            // getting firstName and lastName
            String firstName = (String) jo.get("UserName");
            String lastName = (String) jo.get("Password");
            usepass[0] = firstName;
            usepass[1] = lastName;
            if (user.equals(firstName) && password.equals(lastName)) {
                isMatch = true;
            }


        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        } catch (ParseException e) {
        }
        return isMatch;
    }
    public boolean isThere(String user)
    {
        boolean isThere=false;
        try (FileReader reader = new FileReader("usersFile\\" + user + ".json")) {
            // parsing file "JSONExample.json"
            FileReader reade = new FileReader("usersFile\\" + user + ".json");

            reade.close();
            reader.close();
            isThere=true;
        } catch (FileNotFoundException e) {
        isThere=false;
        } catch (IOException e) {
        }
        return isThere;
    }

}
