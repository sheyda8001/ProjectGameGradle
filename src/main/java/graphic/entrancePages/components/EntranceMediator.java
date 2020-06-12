package graphic.entrancePages.components;

import graphic.mediator.Mediator;

public interface EntranceMediator extends Mediator {
    void addName(String name);
    void addPass(String pass);
    void setEnter();
    void setRegister();
}
