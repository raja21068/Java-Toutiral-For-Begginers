import java.io.File;
import java.io.FilenameFilter;
class Filtering implements FilenameFilter{
	
	String extension;
	Filtering(String ext){
		extension = ext; 
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		File ff = new File(dir,name);
		if(ff.isFile()){ return name.startsWith(extension);}
		return false;
	}
} 

public class FilenameFilterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("E:/javaProgramms/students.txt");
		Filtering filter = new Filtering(".java");
		
	}
}
