import java.net.Socket;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import javax.imageio.ImageIO;

public class SenderImage {
    public static void main(String arg[])throws Exception{
        System.out.println("Waiting for connection....");
        
        Socket socket = new Socket("127.0.0.1",9090);
        System.out.println("Connected..");  
        
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        
        Robot robot = new Robot();
        
        BufferedImage image;
//        do{
        image = robot.createScreenCapture(rec);
        ImageIO.write(image, "png", out);
        System.out.println("sended...");
        
//        }while(true);
//        out.close();
    }
}
