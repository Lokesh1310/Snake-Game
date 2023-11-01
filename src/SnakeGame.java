import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class FDemo extends JFrame {
	JPDemo jp;
	FDemo(){
		jp=new JPDemo();
	 add(jp);
	 }
	
}

class JPDemo extends JPanel implements ActionListener,KeyListener{
     ImageIcon img1,img2,img3;
	 Image dot,head,food;
	 int x[]=new int[100];
	 int y[]=new int[100];
	 int dots=5;
	 boolean st=false;
	 boolean left=false,up=false,down=false,right=true;
	 int r1=0,r2=0;
	JPDemo(){
		x[0]=120;
		x[1]=100;
		x[2]=80;
		x[3]=60;
		x[4]=40;
		y[0]=100;
		y[1]=100;
		y[2]=100;
		y[3]=100;
		y[4]=100;
		setBackground(Color.white);
		img1=new ImageIcon("dot.png");
		dot=img1.getImage();
        img2=new ImageIcon("head.png");
		head=img2.getImage();		
		    img3=new ImageIcon("food.png");
		food=img3.getImage();		
	
		
		Timer T=new Timer(200,this);
		T.start();
         addKeyListener(this);	
          setFocusable(true);	 
	randomDemo();
	}
	
	void randomDemo(){
		
		r1=(int)Math.round(Math.random()*30+1);
        r1=r1*20;
		r2=(int)Math.round(Math.random()*30+1);
        r2=r2*20;
	
	}
	public void paintComponent(Graphics g){
	   super.paintComponent(g);
	   for(int i=0;i<dots;i++){
		   if(i==0)
		   {g.drawImage(head,x[i],y[i],this);
		   }
		   else{
		   g.drawImage(dot,x[i],y[i],this);
	}}
	g.drawImage(food,r1,r2,this);
	
	
	
	}
	
public void actionPerformed(ActionEvent e){
	
	if(x[0]==r1 && y[0]==r2){
		dots++;
		randomDemo();
		
	}
	
	
	
	
	
	if(st){for(int i=dots;i>0;i--){
		x[i]=x[i-1];
		y[i]=y[i-1];
		
	}
	
	if(right){
		x[0]=x[0]+20;
	}
	if(left){
		x[0]=x[0]-20;
	}
	if(up){
		y[0]=y[0]-20;
	}
	if(down){
		y[0]=y[0]+20;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}
	repaint();
}

public void keyReleased(KeyEvent e){
	
}
public void keyPressed(KeyEvent e){
	st=true;
	if(e.getKeyCode()==KeyEvent.VK_LEFT){
		left=true;
		right=false;
		down=false;
		up=false;
	}
	
	if(e.getKeyCode()==KeyEvent.VK_RIGHT){
		left=false;
		right=true;
		down=false;
		up=false;
	}
	
	if(e.getKeyCode()==KeyEvent.VK_UP){
		left=false;
		right=false;
		down=false;
		up=true;
	}
	
	if(e.getKeyCode()==KeyEvent.VK_DOWN){
		left=false;
		right=false;
		down=true;
		up=false;
	}
	
	
	
	
	
}
public void keyTyped(KeyEvent e){}




}

class SnakeGame
{
	public static void main(String ar[]){
		FDemo f=new FDemo();
		f.setVisible(true);
		f.setSize(1000,1000);
		f.setLocation(100,100);
	}
}
