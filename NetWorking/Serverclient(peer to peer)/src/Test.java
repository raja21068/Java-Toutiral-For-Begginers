import java.net.ServerSocket;
import java.net.Socket;


class Test {
	  public static void main(String args[])throws Exception {
		  ServerSocket server= new ServerSocket(9000);
	    	System.out.println("Server is Waiting...");
	    	Socket socket = server.accept();
			System.out.println("Connected with : "+socket.getInetAddress());
	  }
}
