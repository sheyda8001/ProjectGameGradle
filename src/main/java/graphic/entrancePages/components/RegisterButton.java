package graphic.entrancePages.components;

import game.Main;
import graphic.Components;
import graphic.entrancePages.components.error.Error;
import graphic.entrancePages.components.error.ErrorFrame;
import graphic.mediator.Mediator;
import log.Log;
import logics.entranceRelated.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegisterButton extends JButton implements Components {
    private EntranceMediator mediator;
    public RegisterButton() {
        super("Register");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = (EntranceMediator)mediator;
    }
    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.setRegister();
    }
    public String getName(){
        return "register";
    }
}

