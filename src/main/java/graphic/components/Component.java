package graphic.components;

import graphic.mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
