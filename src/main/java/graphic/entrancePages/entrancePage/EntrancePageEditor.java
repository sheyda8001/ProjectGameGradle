package graphic.entrancePages.entrancePage;

import graphic.Components;
import graphic.FramePanelInterface;
import graphic.entrancePages.components.*;
import graphic.entrancePages.components.error.Error;
import graphic.entrancePages.components.error.ErrorFrame;
import graphic.entrancePages.registerPage.RegisterPage;
import graphic.mainPanel.MainPanel;
import log.Log;
import logics.entranceRelated.Login;

import javax.swing.*;
import java.awt.*;

public class EntrancePageEditor implements EntranceMediator {
   private NameBox tname;
   private PassBox tpass;
   private JLabel name;
   private JLabel pass;
   private EnterButton signin;
   private RegisterButton register;
   private FramePanelInterface framePanelInterface=FramePanelInterface.getInstance();
    @Override
    public void registerComponent(Components component) {
        component.setMediator(this);
        switch (component.getName())
        {
            case("register"):
                register=(RegisterButton)component;
                break;
            case("enter"):
                signin=(EnterButton)component;
                break;
            case("passBox") :
                tpass=(PassBox)component;
                break;
            case("nameBox") :
                tname=(NameBox)component;
                break;
            case("register1") :

        }
    }
@Override
public void setRegister()
{
    framePanelInterface.setPanel( new RegisterPage());
}

    private void refreshSignInPage() {
        framePanelInterface.setPanel( new EntrancePage());
    }



    @Override
    public void createGUI(MainPanel panel) {
        name = new JLabel("Name :");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(panel.getWidth()/8,100);
        pass = new JLabel("Password :");
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(100, 20);
        pass.setLocation(panel.getWidth()/8,150);
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(200, 40);
        tname.setLocation(panel.getWidth()/8+name.getWidth(),100);
        tpass.setFont(new Font("Arial", Font.PLAIN, 15));
        tpass.setSize(200, 40);
        tpass.setLocation(panel.getWidth()/8+name.getWidth(),150);
        signin.setFont(new Font("Arial", Font.PLAIN, 15));
        signin.setSize(100, 20);
        signin.setLocation((panel.getWidth()-100)/2,200);
        register.setFont(new Font("Arial", Font.PLAIN, 15));
        register.setSize(100, 20);
        register.setLocation((panel.getWidth()-100)/2, 250);
        panel.add(name);
        panel.add(pass);
        panel.add(tname);
        panel.add(tpass);
        panel.add(register);
        panel.add(signin);
    }

    @Override
    public void register() {

    }

    @Override
    public void login() {
        if(Login.loginPermission(tname.getText(),tpass.getText(),"enter"))
        {
            Log.makelog();
        }
        else{
            ErrorFrame errorFrame = new ErrorFrame(Error.SIGNIN);
            refreshSignInPage();

        }
    }

}
