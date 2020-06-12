package graphic.mainFrame;

import configRelated.FrameConfig;
import graphic.mainPanel.MainPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private FrameConfig config;
    private MainPanel panel;
    public MainFrame ()
    {
        super("HearthStone");
        initFrame();
    }
    public MainFrame(MainPanel panel)
    {
        super("HearthStone");
        this.panel=panel;
        initFrame();
    }
    private void initFrame() {
        try {
            config = new FrameConfig("FRAME_CONFIG");
            configFrame();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void configFrame() {
        this.setSize(config.getWidth(), config.getHeight());
        this.setDefaultCloseOperation(config.getCloseOperation());
        this.addWindowCloseListener();
        this.setResizable(config.isResizaable());
        this.setLocationRelativeTo(null);
        this.setIconImage(config.getImageIcon().getImage());
        this.setUndecorated(config.isUndecorated());
        setPanel(this.panel);

    }

    private void addWindowCloseListener()
    {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we)
            {
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
                if(PromptResult==JOptionPane.YES_OPTION)
                { //Updater updater=new Updater(game.Main.getPlayer());
                   // updater.update();
                    System.exit(0);

                }
            }
        });
    }
    public void setPanel(MainPanel panel)
    {
        setContentPane(panel);
        invalidate();
        validate();
        setVisible(true);
    }
}
