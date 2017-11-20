
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUIReciever extends javax.swing.JFrame {

    Scanner scan = new Scanner(System.in);
    DatagramSocket socket;
    byte data[] = new byte[500];
    String s="";
    DatagramPacket packet;
    DatagramPacket packet2;
    /** Creates new form GUIReciever */
    public GUIReciever() {
        try {
            initComponents();
            setVisible(true);
            socket = new DatagramSocket(9090);
            
            packet = new DatagramPacket(data,0,data.length);
                socket.receive(packet);
                s = new String(data,0,data.length);
                this.recieveMessageTextField.setText(s);
        } catch (Exception ex) {
            Logger.getLogger(GUIReciever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageScrollPane = new javax.swing.JScrollPane();
        messageTextField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        recieveMessageScrollPane = new javax.swing.JScrollPane();
        recieveMessageTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reciever");
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
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        try {  
                s=messageTextField.getText();
                data = s.getBytes();
                packet2 = new DatagramPacket(data,0,data.length ,packet.getAddress(),packet.getPort());
                socket.send(packet2);
                
                DatagramPacket packet = new DatagramPacket(data,0,data.length);
                socket.receive(packet);
                s = new String(data,0,data.length);
                this.recieveMessageTextField.setText(s);
        } catch (IOException ex) {
            Logger.getLogger(GUIReciever.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_sendButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUIReciever().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane messageScrollPane;
    private javax.swing.JTextField messageTextField;
    private javax.swing.JScrollPane recieveMessageScrollPane;
    private javax.swing.JTextField recieveMessageTextField;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}
