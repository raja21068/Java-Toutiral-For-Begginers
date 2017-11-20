import java.io.PrintWriter;
import java.io.IOException;
class PrintWriterDemo{
	public static void main(String arg[]){
		PrintWriter f= new PrintWriter(System.out);
		f.println("Hello");
		f.println("student");
		System.out.println("Press any key & enter");
		//try{System.in.read();}catch(IOException e){}
		f.flush();
		f.println("Thanks");
		try{System.in.read();}catch(IOException e){}
		f.println("Student");
		f.flush();
		
	}
}