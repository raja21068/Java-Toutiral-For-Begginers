import javax.swing.*;

class BackgroundMove extends Thread{
	JFrame frame;
	ImageIcon Image1;
	ImageIcon Image2;
	ImageIcon helicopterIcon;
	static JLabel Image1Label;
	static JLabel Image2Label;
	JLabel helicopterLabel;
	
	BackgroundMove(){
		frame=new JFrame();
		frame.setLayout(null);
		frame.setBounds(200,200,700,500);
		frame.setDefaultCloseOperation(3);
		
		Image1=new ImageIcon("A1.jpg");
		Image1Label=new JLabel(Image1);
		Image2=new ImageIcon("A2.jpg");
		Image2Label=new JLabel(Image2);
		helicopterIcon=new ImageIcon("helicopter.png");
		helicopterLabel=new JLabel(helicopterIcon);
		
		Image1Label.setBounds(0,0,frame.getWidth(),frame.getHeight());
		Image1Label.setBounds(500,0,frame.getWidth(),frame.getHeight());
		helicopterLabel.setBounds(50,50,200,100);
		frame.getContentPane().add(helicopterLabel);
		frame.getContentPane().add(Image1Label);
		frame.getContentPane().add(Image2Label);
		
		//try {
			start();
			//} catch(Exception e){}
		
		frame.show();
	}
	
	public static void main(String arg[]){
		new BackgroundMove();
	}
	

	
	public void run(){
		for(int i=0,j=700;i>-700;i--,j--){
			Image1Label.setBounds(i,0,frame.getWidth(),frame.getHeight());
			Image2Label.setBounds(j,0,frame.getWidth(),frame.getHeight());
			try{Thread.sleep(20);}catch(Exception e){}
			//show();
			if(i==-699){  i=700; }
			if(j==-699){ j=700; }
	}//end of run
}}