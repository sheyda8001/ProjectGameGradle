package graphic;

import configRelated.ConfigLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageMaker {
    private static ImageMaker imageMaker ;
    private BufferedImage bufferedImage =null;
    private String path;
    private ImageMaker(String path)
    {
        this.path=path;
    }
    public static ImageMaker getInstance(String path)
    {
        if(imageMaker==null)
        {
            imageMaker=new ImageMaker(path);
        }
        return imageMaker;
    }
    public BufferedImage getImage()
    {

        try {
            this.bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.bufferedImage;
    }
    public BufferedImage resizeImage(int width,int height)
    {
        Image tmp = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
