package logics.entranceRelated;

import entities.decks.Deck;
import log.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Register {
    private UsersFileReader usersFileReader=new UsersFileReader();
    private String user,pass;
    public boolean register(String user,String password)
    {
        this.user=user;
        this.pass=password;
    boolean permission=false;
    if(!usersFileReader.isThere(user))
    {
        makeUser(user, password);
        permission=true;
    }
    return permission;
    }
    private void makeUser(String username,String password)
    {

    }
    private void makeUserFile()
    {
        JSONObject userDetails = new JSONObject();
        JSONArray array1 = new JSONArray();
        JSONArray array2=new JSONArray();
        JSONArray array3=new JSONArray();
        JSONArray array4=new JSONArray();
        JSONArray array5=new JSONArray();
        array1.add("The Dark Portal");array1.add("Warpath");array1.add("Inner Rage");array1.add("Silence");array1.add("Fungal Fortunes");array1.add("Wisp");array1.add("Vicious Scalehide");array1.add("Novice Engineer");array1.add("Test Subject");array1.add("Polymorph");
        array4.add("Classic Mage");
        array3.add("MAGE");
        userDetails.put("UserName", user);
        userDetails.put("Password", pass);
        userDetails.put("Coins", 50);
        userDetails.put("WholeCards", array1);
        userDetails.put("NowCards", array2);
        userDetails.put("OpenedHeros",array3);
        userDetails.put("ID",getUserNum());
        userDetails.put("Decks",array4);

        JSONObject userObject = new JSONObject();
        userObject.put("user", userDetails);
        //Add users to list
        JSONArray userList = new JSONArray();
        userList.add(userObject);
        //Write JSON file

        try {
            int u= getUserNum()+ 1;
            FileWriter fw = new FileWriter("usersFile\\numberusers.txt");

            fw.write(u + "");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
            Log.LOGGER.finest("error "+e.getStackTrace());

        }
//        System.out.println("Success...");


        try (FileWriter file1 = new FileWriter("usersFile\\" + user + ".json")) {
            file1.write(userDetails.toJSONString());
            file1.flush();
            file1.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            Log.LOGGER.finest("error "+e.getStackTrace());

        }

    }
    private void makeUserDeckFile()
    {
        JSONObject userDetails = new JSONObject();
        JSONArray array2=new JSONArray();
        array2.add("Classic Mage");
        userDetails.put("Decks",array2);

        for(int i=0;i<array2.size();i++)
        {
            JSONArray array1 = new JSONArray();
            ArrayList<String> cards= Deck.getInstance(array2.get(i).toString()).getCards();
            for(int j=0;j<cards.size();j++)
            {
                array1.add(cards.get(j));
            }
            userDetails.put(array2.get(i).toString(),array1);
            userDetails.put(array2.get(i).toString()+"hero",Deck.getInstance(array2.get(i).toString()).getHeroClass().toString());
            userDetails.put(array2.get(i).toString()+"whole","1");
            userDetails.put(array2.get(i).toString()+"wins","0");
            ArrayList <String> list=new ArrayList<>();
            for(int i1=0;i1<10;i1++)
            {
                list.add("0");
            }
            userDetails.put(array2.get(i).toString()+"nums",list);

        }
        //  array1.add("The Dark Portal");array1.add("Warpath");array1.add("Inner Rage");array1.add("Silence");array1.add("Fungal Fortunes");array1.add("Wisp");array1.add("Vicious Scalehide");array1.add("Novice Engineer");array1.add("Test Subject");array1.add("Polymorph");
        // userDetails.put();
        try (FileWriter file1 = new FileWriter("usersdeck\\" + user + ".json")) {
            file1.write(userDetails.toJSONString());
            file1.flush();
            file1.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            Log.LOGGER.finest("error "+e.getStackTrace());
        }
    }
private void makeUserLogFile(){
    try (FileWriter file1 = new FileWriter("logs\\" + user+"-" +( getUserNum())+ ".log")) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        file1.write("USER:"+user+"\n"+"CREATED_AT:"+dtf.format(now)+"\n"+"PASSWORD:"+pass+"\n");

        file1.close();

    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
        Log.LOGGER.finest("error "+e.getStackTrace());
    }
}
private int getUserNum()
{
    try {
        String filePath = "usersFile\\numberusers.txt";
        String st = readAllBytesJava7(filePath);
        if (st.equals("")) {
            return 0;
        } else {
            int ans = 0;
            ans = Integer.valueOf(st);
            return ans;
        }
    }
    catch(Exception e)
    {
        Log.LOGGER.finest("error "+e.getStackTrace());

    }
    return 0;
}
    private String readAllBytesJava7(String filePath)
    {
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            Log.LOGGER.finest("error "+e.getStackTrace());

        }
        return content;
    }
    }

