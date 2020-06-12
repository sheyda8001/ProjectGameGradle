package graphic;

import graphic.mainPanel.MainPanel;

public interface Panel {
    void registerComponents();
    MainPanel getPanel();
    void creatGUI();
}
