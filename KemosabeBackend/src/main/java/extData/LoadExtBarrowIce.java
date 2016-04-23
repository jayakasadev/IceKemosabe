package extData;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Jaya Kasa
 * @version 1.0
 */
public class LoadExtBarrowIce{
    private String url = "http://feeder.gina.alaska.edu/radar-uaf-barrow-seaice-images/current/image.png";
    private static LoadExtBarrowIce loadExtBarrowIce = null;
    private URL urlObj= null;

    private LoadExtBarrowIce(){
        try {
            urlObj = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static LoadExtBarrowIce getInstance(){
        if(loadExtBarrowIce == null){
            loadExtBarrowIce = new LoadExtBarrowIce();
        }
        return loadExtBarrowIce;
    }


    public Object getData(){
        RenderedImage image = null;

        try {
            image = ImageIO.read(urlObj);
            System.out.println(this.getClass() + " --> class of image: " + image.getClass());

            //OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("/data/img"));
            File file = new File("/data/img");

            if(!file.exists()){
                System.out.println("creating /data/img");
                file.mkdirs();
            }

            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
