package logics.entranceRelated;

public class Login {
    public static boolean loginPermission(String username,String password,String job) {

        if(job.equals("register")) {
            return register(username,password);
        }
        else{
            return signin(username, password);
        }
    }

    private static boolean signin(String username,String password)
    {
        SignIn SI = new SignIn();
        return SI.signIn(username, password);
    }
    private static boolean register(String user,String password)
    {
        Register register=new Register();
        return register.register(user,password);
    }
    
}
