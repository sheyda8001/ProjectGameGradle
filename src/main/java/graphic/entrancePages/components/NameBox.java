package graphic.entrancePages.components;

import graphic.Components;
import graphic.mediator.Mediator;

import javax.swing.*;

public class NameBox extends JTextField implements Components {
    private Mediator mediator;
    public String getName(){return "nameBox";}
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator=mediator;
    }
}
