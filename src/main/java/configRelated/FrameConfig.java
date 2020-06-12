package configRelated;

import configRelated.ConfigLoader;
import configRelated.GraphicConfig;

import javax.swing.*;

public class FrameConfig extends GraphicConfig {
    private int closeOperation;
    private boolean resizaable , undecorated;
private ImageIcon imageIcon;
    public FrameConfig(String name){
        super(name);
        initialize();
    }
    protected void initialize() {
        super.initialize();
        closeOperation = properties.readInteger("CloseOperation");
        resizaable = properties.readBoolean("Resizable");
        undecorated = properties.readBoolean("undecorated");
        imageIcon=new ImageIcon(properties.getProperty("ImageIcon"));
    }

    public boolean isResizaable() {
        return resizaable;
    }

    public boolean isUndecorated() {
        return undecorated;
    }

    public int getCloseOperation() {
        return closeOperation;
    }

    public ImageIcon getImageIcon(){ return imageIcon; }
    @Override
    protected void setProperties() {
        this.properties = ConfigLoader.getInstance().getFrameProperties(name);
    }
}
