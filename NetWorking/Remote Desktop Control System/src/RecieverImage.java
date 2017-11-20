import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RecieverImage {
    public static void main(String arg[])throws Exception{
        
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        
        JLabel picLabel = new JLabel("Hello");
        
        frame.getContentPane().add(picLabel);
        frame.setSize(600,600);
        frame.setVisible(true);
        
        ServerSocket server =new ServerSocket(9090);
        Socket socket = server.accept();
        System.out.println("connected with ...");
        DataInputStream in = new DataInputStream(socket.getInputStream());
       
        BufferedImage image;
//         do{
        
        image = ImageIO.read(in);
        System.out.println("recieved...");
//        picLabel.removeAll();
        picLabel.setIcon(new ImageIcon(image));
        picLabel.repaint();
        
//        }while(true);
        
    }
}
