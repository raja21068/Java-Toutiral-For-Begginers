
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUISender extends javax.swing.JFrame {

    DatagramSocket socket;
    Scanner scan = new Scanner(System.in);
    InetAddress address;
    String s ="";
    byte[] data;
    /** Creates new form GUISender */
    public GUISender() {
        initComponents();
        setVisible(true);
        try{
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
        }catch(Exception ex){ex.printStackTrace();}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        messageScrollPane = new javax.swing.JScrollPane();
        messageTextField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        recieveMessageScrollPane = new javax.swing.JScrollPane();
        recieveMessageTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sender");
        setMinimumSize(new java.awt.Dimension(200, 200));
        getContentPane().setLayout(null);

        messageScrollPane.setViewportView(messageTextField);

        getContentPane().add(messageScrollPane);
        messageScrollPane.setBounds(10, 100, 238, 50);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton);
        sendButton.setBounds(12, 154, 238, 30);

        recieveMessageScrollPane.setViewportView(recieveMessageTextField);

        getContentPane().add(recieveMessageScrollPane);
        recieveMessageScrollPane.setBounds(10, 10, 238, 80);

        pack();
    }// </editor-fold>

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
            s = messageTextField.getText();
            data = s.getBytes();
            DatagramPacket packet = new DatagramPacket(data,0,data.length,address,9090);
            try {
                socket.send(packet);
            } catch (IOException ex) {
                Logger.getLogger(GUISender.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            byte[] dataR = new byte[100];
            DatagramPacket packet2 = new DatagramPacket(dataR,0,dataR.length,address,9090);
            try {
                socket.receive(packet2);
            } catch (IOException ex) {
                Logger.getLogger(GUISender.class.getName()).log(Level.SEVERE, null, ex);
            }
            s = new String(dataR , 0,dataR.length);
            recieveMessageTextField.setText(s);
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUISender().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JScrollPane messageScrollPane;
    private javax.swing.JTextField messageTextField;
    private javax.swing.JScrollPane recieveMessageScrollPane;
    private javax.swing.JTextField recieveMessageTextField;
    private javax.swing.JButton sendButton;
    // End of variables declaration
}
