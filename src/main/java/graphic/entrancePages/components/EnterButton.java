package graphic.entrancePages.components;

import graphic.Components;
import graphic.mediator.Mediator;
import logics.entranceRelated.Entrance;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class EnterButton extends JButton implements Components {
    private EntranceMediator mediator;
    public EnterButton() {
        super("Enter");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = (EntranceMediator)mediator;
    }
    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
//        if (!Entrance.loginPermission(tname.getText().toString(), tpass.getText().toString(), "register")) {
//
//            game.Main.getWindow().setWindowPanel(entrancePage());
//            ErrorFrame errorFrame = new ErrorFrame(Error.REGISTER);
//        } else {
//            Log.makelog();
//            game.Main.getWindow().setWindowPanel(mainMenu());
//        }
    }
    public String getName(){
        return "enter";
    }
}
