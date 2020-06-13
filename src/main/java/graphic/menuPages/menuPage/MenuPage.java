package graphic.menuPages.menuPage;

import graphic.mainPanel.MainPanel;
import graphic.mediator.Mediator;

public class MenuPage extends MainPanel {
    private Mediator mediator ;
    public MenuPage() {
        super("menuPage");

    }
    private void makeGUI()
    {
        registerComponents();
        mediator.createGUI(this);
    }
    @Override
    protected void registerComponents() {

    }
}
