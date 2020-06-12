package graphic.entrancePages.entrancePage;

import graphic.entrancePages.components.EnterButton;
import graphic.entrancePages.components.NameBox;
import graphic.entrancePages.components.PassBox;
import graphic.entrancePages.components.RegisterButton;
import graphic.mainPanel.MainPanel;
import graphic.mediator.Mediator;

public  class EntrancePage extends MainPanel {
    private Mediator mediator ;
    public EntrancePage() {
        super("entrancePage");
        mediator =new EntrancePageEditor();
        makeGUI();
    }
    private void makeGUI()
    {
        registerComponents();
        mediator.createGUI(this);
    }
    @Override
    protected void registerComponents() {
       mediator.registerComponent( new EnterButton());
       mediator.registerComponent( new RegisterButton());
       mediator.registerComponent(new NameBox());
       mediator.registerComponent(new PassBox());
    }

}
