package graphic.mainPanel;

import configRelated.PanelConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MainPanel extends JPanel {
    private PanelConfig config;
    private String name;
    private BufferedImage bgImage;
    public MainPanel(String name)
    {
        super();
        this.name=name;
        init();
    }
    private void init()
    {
        config = new PanelConfig("PANEL_CONFIG_FILE",name);
        configurePanel();
    }
    private void configurePanel()
    {
        setBG();
        setLayout(null);
        this.setBounds(0,0,config.getWidth(), config.getHeight());
    }
    private void setBG()
    {
        if(config.getTypeBG().equals("image"))
        {
            this.bgImage=config.getBGImage();
        }
        else{
            this.setBackground(config.getBGColor());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.bgImage, 0, 0, null);
    }
    protected abstract void registerComponents();
}
