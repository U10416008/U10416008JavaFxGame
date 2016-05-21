/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008javafxgame;

/**
 *
 * @author user
 */
/* Import api */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Fan extends JFrame {

	private CirclePanel fanCircle = new CirclePanel();
	private boolean onOrOff = false;
	boolean fanOnOrOff = false;
	boolean setTstart = false ; 
	private int xFst = 0;
	private int yFst = 90;
	private int x;
	private int y;
	Timer setT;
	Timer timer;
	Fan fan ;
	JPanel Buttons;
	Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 6);
	JButton button[] = new JButton[4];	
	
	int timeCount;
	int setSecond = 0;
	public Fan() {
		Buttons = new JPanel();
		fanCircle.setLayout(null);
		fanCircle.setBackground(Color.BLACK);
		String[] btn = {"", "", "", ""};
		
		for(int i = 0;i <=2;i++) {
			button[i] = new RoundButton(btn[i]);
			fanCircle.add(button[i]);
			button[i].setFont(font);
		}
		button[0].setBounds(85,330,20,20);
		button[1].setBounds(110,335,20,20);
		button[2].setBounds(135,332,20,20);
		button[3] = new RoundButton2(btn[3]);
		button[3].setBounds(60,300,30,30);
		
		fanCircle.add(button[3],BorderLayout.SOUTH);
		for(int i = 0;i <= 3;i++) {
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//make the velocity of fan fast when click the button 強
					if(e.getSource() == button[0]) {
						angularVelocity(200);
					}
					//make the velocity of fan middle when click the button 中
					if(e.getSource() == button[1]) {
						angularVelocity(145);
					}
					//make the velocity of fan slow when click the button 慢
					if(e.getSource() == button[2]) {						
						angularVelocity(90);
					}
					//turn off the fan when click the button 關
					if(e.getSource() == button[3]) {
						turnOff();	
					}
				}
			});
		}
		/* The funtion of setting stop time */
		JButton set = new JButton(setSecond + " secs");
		JButton up = new JButton("↑");
		JButton down = new JButton("↓");
		set.setBounds(50,400,80,60);
		up.setBounds(130,400,55,30);
		down.setBounds(130,430,55,30);
		fanCircle.add(set);
		fanCircle.add(up);
		fanCircle.add(down);
		set.setBackground(Color.BLACK);
		set.setForeground(Color.RED);
		up.setBackground(Color.BLACK);
		up.setForeground(Color.RED);
		down.setBackground(Color.BLACK);
		down.setForeground(Color.RED);
		set.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stopWhenTimeSUp(1000*setSecond);
			}
		});
		up.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSecond = setSecond + 10;
				set.setText(setSecond + "secs");
			}
		});
		down.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setSecond = setSecond - 10;
				set.setText(setSecond + "secs");
			}
		});
		
		add(fanCircle, BorderLayout.CENTER);
	}

	//adjust the velocity of fan method
	public void angularVelocity(int v){
		if(onOrOff  == true){
			timer.stop();
		}
		onOrOff = true;
		timer = new Timer(v,new ActionListener(){      
					public void actionPerformed(ActionEvent e) {
						fanCircle.fanRotate(180);
					}
				});
		timer.start();
	}
	
	public void stopWhenTimeSUp(int time) {
		if(setTstart == true ){
			setT.stop();
			setTstart = false;
		}
		setT = new Timer(time,new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {				
				turnOff();				
			}
		});
		setT.setRepeats(false);
		setT.start();
		setTstart = true;
	}
	
	//turn off fan method
	public void turnOff(){
		setT.stop();
		timer.stop();
		fanOnOrOff = false;
	}
	
	//create fan method
	public void createNew() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		fan = new Fan();
		fan.setTitle("Fan");
		fan.setSize(250,500);
		fan.setLocation(1300,400);
		fan.setDefaultCloseOperation(Fan.EXIT_ON_CLOSE);
		fan.setVisible(true);
		fan.setResizable(false); 
		fanOnOrOff = true;
	}
	
	//close fan method
	public void closeFan(){
		if(setTstart == true ){
			setT.stop();
			setTstart = false;
		}
		fan.dispose();
		onOrOff = false;
	}

	class CirclePanel extends JPanel {
		/* The Radius of the Fan */
		private int radius = 100;
		
		public void fanRotate(double theta) {
			xFst = (int)(xFst*Math.cos(Math.toRadians(theta)) - yFst*Math.sin(Math.toRadians(theta)));
			yFst = (int)(xFst*Math.sin(Math.toRadians(theta)) + yFst*Math.cos(Math.toRadians(theta)));
			repaint();	
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_ON);
			/* Draw a Fan */
			//stem of the fan
			g.drawRect(getWidth()/2-20,getWidth()/2+radius-2,40,102);
			g.setColor(Color.BLACK);
			g.fillOval(getWidth()/2 - 75, getWidth()/2+radius*2-38, 150, 75);
			//make the line thick  
			g2.setStroke(new BasicStroke(3.0f));
			g.setColor(Color.BLUE);		
			//bottom of the fan
			g.drawOval(getWidth()/2 - 75, getWidth()/2+radius*2-38, 150, 75);
			g.setColor(Color.BLACK);
			g.fillRect(getWidth()/2-20,getWidth()/2+radius-2,40,102);			
			g.setColor(Color.GRAY);
			/* Draw 3 blades */
			for(int i = 0;i <=2 ; i++) {
				x = (int)(xFst*Math.cos((Math.PI*2*i)/3) - yFst*Math.sin((Math.PI*2*i)/3));
				y = (int)(xFst*Math.sin((Math.PI*2*i)/3) + yFst*Math.cos((Math.PI*2*i)/3));
				x+= getWidth()/2;
				y+= getWidth()/2;
				g2.drawLine(getWidth()/2,getWidth()/2,x,y);
			}
			g.setColor(Color.BLUE);
			
			g.drawLine(getWidth()/2-20,getWidth()/2+radius-2,getWidth()/2-20,getWidth()/2+radius*2);
			g.drawLine(getWidth()/2+20,getWidth()/2+radius-2,getWidth()/2+20,getWidth()/2+radius*2);
			//draw the head of fan
			g.drawOval(getWidth() / 2 - radius, getWidth() / 2 - radius, 2 * radius, 2 * radius);
			g.drawOval(getWidth() / 2+1 - radius, getWidth() / 2 - radius+1, 2 * radius-2, 2 * radius-2);
			g.drawOval(getWidth() / 2+2 - radius, getWidth() / 2 - radius+2, 2 * radius-4, 2 * radius-4);
			
			//return the initial size  
			g2.setStroke(new BasicStroke(1.0f));
			for(int i=0 ;i<30 ; i++ ){
				double Fx =  radius*Math.cos(Math.toRadians(i*12));
				double Fy =  radius*Math.sin(Math.toRadians(i*12));
				Fx+= getWidth()/2;
				Fy+= getWidth()/2;
				g2.draw(new Line2D.Double(getWidth()/2,getWidth()/2,Fx,Fy));
			}
		}
	}
	
	public class RoundButton extends JButton {
		public RoundButton(String label) {
			super(label);
			setContentAreaFilled(false);
		}

		protected void paintComponent(Graphics g) {
			g.setColor(Color.GRAY);
			g.fillOval(0, 0, 20, 20); 
			super.paintComponent(g); 
		}
		
		protected void paintBorder(Graphics g) {
			g.setColor(getForeground()); 

		}
	}
	
	public class RoundButton2 extends JButton {
		public RoundButton2(String label) {
			super(label);
			setContentAreaFilled(false);
		}

		protected void paintComponent(Graphics g) {
			g.setColor(Color.RED);
			g.fillOval(0, 0, 30, 30); 
			super.paintComponent(g); 
		}
		
		protected void paintBorder(Graphics g) {
			g.setColor(getForeground()); 
		}
	}
}
