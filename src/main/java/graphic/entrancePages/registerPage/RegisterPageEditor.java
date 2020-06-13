package graphic.entrancePages.registerPage;

import graphic.Components;
import graphic.FramePanelInterface;
import graphic.entrancePages.components.*;
import graphic.entrancePages.components.error.Error;
import graphic.entrancePages.components.error.ErrorFrame;
import graphic.mainPanel.MainPanel;
import log.Log;
import logics.entranceRelated.Login;

import javax.swing.*;
import java.awt.*;

public class RegisterPageEditor implements EntranceMediator {
    private NameBox tname;
    private PassBox tpass;
    private JLabel name;
    private JLabel pass;
    //private EnterButton signin;
    private RegisterButton1 register;
    private MainPanel panel = null;
    private String name1, pass1;
    private FramePanelInterface framePanelInterface = FramePanelInterface.getInstance();

    @Override
    public void registerComponent(Components component) {
        component.setMediator(this);
        switch (component.getName()) {
//            case ("register"):
//                register = (RegisterButton) component;
//                break;
            case ("register1"):

                register = (RegisterButton1) component;
                break;
            case ("passBox"):
                tpass = (PassBox) component;
                break;
            case ("nameBox"):
                tname = (NameBox) component;
                break;
        }
    }



    @Override
    public void createGUI(MainPanel panel) {
        name = new JLabel("Name :");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(panel.getWidth() / 8, 100);
        pass = new JLabel("Password :");
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(100, 20);
        pass.setLocation(panel.getWidth() / 8, 150);
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(200, 40);
        tname.setLocation(panel.getWidth() / 8 + name.getWidth(), 100);
        tpass.setFont(new Font("Arial", Font.PLAIN, 15));
        tpass.setSize(200, 40);
        tpass.setLocation(panel.getWidth() / 8 + name.getWidth(), 150);
        register.setFont(new Font("Arial", Font.PLAIN, 15));
        register.setSize(100, 20);
        register.setLocation((panel.getWidth() - 100) / 2, 200);
//        register.setFont(new Font("Arial", Font.PLAIN, 15));
//        register.setSize(100, 20);
       // register.setLocation((panel.getWidth() - 100) / 2, 250);
        panel.add(name);
        panel.add(pass);
        panel.add(tname);
        panel.add(tpass);
       // panel.add(register);
        panel.add(register);
    }

    private void refreshRegisterPage() {
        framePanelInterface.setPanel( new RegisterPage());

    }

    @Override
    public void setRegister() {

    }

    @Override
    public void register() {
        if (Login.loginPermission(tname.getText(),tpass.getText(),"register")) {
            Log.makelog();
        } else {
            ErrorFrame errorFrame = new ErrorFrame(Error.REGISTER);
            refreshRegisterPage();
        }
    }

    @Override
    public void login() {

    }


}
