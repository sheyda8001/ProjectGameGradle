package graphic.entrancePages.components;

import graphic.mediator.Mediator;

public interface RegisterMediator extends Mediator  {
    void addName(String name);
    void addPass(String pass);
    void setEnter();
}
