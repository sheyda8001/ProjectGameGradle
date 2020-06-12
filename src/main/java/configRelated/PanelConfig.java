package configRelated;

import configRelated.ConfigLoader;
import configRelated.GraphicConfig;
import graphic.ImageMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;

public class PanelConfig extends GraphicConfig {
    private String bgImage,panelName,bgType;
    private BufferedImage image;
    private Color bgColor;
    private ImageMaker imageMaker;
    public PanelConfig(String name,String panelName){
        super(name);
        this.panelName=panelName;
        initialize();
    }
    protected void initialize() {
        super.initialize();
        System.out.println(panelName);
        bgImage = properties.getProperty(panelName);
        setBG();
    }
    private void setBG()
    {
        if(bgImage.contains("img"))
        {
            imageMaker=ImageMaker.getInstance(bgImage);
            image=imageMaker.resizeImage(getWidth(),getHeight());
            bgType="image";
        }
        else{

            try {
                Field field = Class.forName("java.awt.Color").getField(bgImage);
                bgColor = (Color)field.get(null);
            } catch (Exception e) {
                bgColor = null; // Not defined
            }
            bgType="color";

        }
    }
    public String getTypeBG()
    {
        return bgType;
    }
    public BufferedImage getBGImage(){ return image;}
    public Color getBGColor(){ return bgColor;}
    @Override
    protected void setProperties() {
        this.properties = ConfigLoader.getInstance().getPanelProperties(name);
    }
}
