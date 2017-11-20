import java.net.Socket;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class SenderImage {
    public static void main(String arg[])throws Exception{
        System.out.println("Waiting for connection....");
        String ip = JOptionPane.showInputDialog(null,"Enter ip address");
        Socket socket = new Socket(ip,9090);
        System.out.println("Connected..");  
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        
        Robot robot = new Robot();
        do{            
            BufferedImage image = robot.createScreenCapture(rec);
            ImageIO.write(image, "jpg", byteOut);
            byte[] data = byteOut.toByteArray();
            out.println(data.length);
            out.write(data,0,data.length);
            byteOut.reset();
            System.out.println("sended...");
        
        }while(true);
//        out.close();
    }
}
