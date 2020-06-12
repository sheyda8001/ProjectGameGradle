package graphic.entrancePages.registerPage;

import graphic.entrancePages.components.EnterButton;
import graphic.entrancePages.components.NameBox;
import graphic.entrancePages.components.PassBox;
import graphic.entrancePages.components.RegisterButton;
import graphic.entrancePages.entrancePage.EntrancePageEditor;
import graphic.mainPanel.MainPanel;
import graphic.mediator.Mediator;

public  class RegisterPage extends MainPanel {
    private Mediator mediator =new RegisterPageEditor();
    public RegisterPage() {
        super("registerPage");
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
        mediator.registerComponent(new NameBox());
        mediator.registerComponent(new PassBox());
    }

}
