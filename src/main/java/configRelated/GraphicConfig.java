package configRelated;

import java.awt.*;

public abstract class GraphicConfig {
    protected Configs properties;
    protected String name;

    private int width, height;

    public GraphicConfig(String name) {
        this.name = name;
        setProperties();
    }

    protected void initialize() {
        width = Math.toIntExact((long)Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        height = Math.toIntExact((long) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    protected abstract void setProperties();
}
