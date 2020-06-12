package graphic;

import graphic.entrancePages.entrancePage.EntrancePage;
import graphic.mainFrame.MainFrame;
import graphic.mainPanel.MainPanel;

public class FramePanelInterface {
    private static FramePanelInterface framePanelInterface;
    private MainFrame frame;
    private FramePanelInterface()
    {
        frame=new MainFrame();
    }
    public static FramePanelInterface getInstance()
    {
        if(framePanelInterface ==null)
        {
            framePanelInterface =new FramePanelInterface();
        }
        return framePanelInterface;
    }
    public void setPanel(MainPanel panel)
    {
       frame.setPanel(panel);
    }
}
