package logics.entranceRelated;

import entities.player.Player;
import game.Main;

public class SignIn {
private UsersFileReader usersFileReader=new UsersFileReader();
public boolean signIn(String username,String password)
{
    boolean permission =false;
    if(usersFileReader.isThere(username))
    {
        if(usersFileReader.isMatch(username,password))
        {
            Main.player=new Player(username,password);
            permission=true;
        }
    }
    return permission;
}
}
