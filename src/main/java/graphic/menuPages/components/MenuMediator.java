package graphic.menuPages.components;

import graphic.mediator.Mediator;

public interface MenuMediator extends Mediator {
    void setStore();
    void setStatus();
    void setCollection();
    void setPlay();
    void setDeleteAccount();
}
