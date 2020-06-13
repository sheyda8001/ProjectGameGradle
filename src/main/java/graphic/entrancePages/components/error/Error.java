package graphic.entrancePages.components.error;

import java.util.HashMap;

public enum Error{
    REGISTER,
    SIGNIN;
    HashMap<Error,String> errors=new HashMap<>();
    public void setErrors()
    {
        errors. put(REGISTER, "this username has been made");
        errors. put(SIGNIN, "invalid password or username");
    }
    public String toString()
    {
        return super.toString();
    }
    public String getError(Error error)
    {
        return errors.get(error);
    }

}