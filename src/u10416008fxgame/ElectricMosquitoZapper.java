/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

/**
 *
 * @author user
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class ElectricMosquitoZapper extends JFrame{
	Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 36);
	Font font1 = new Font(Font.SANS_SERIF, Font.BOLD, 24);
	boolean Switch = false;
	Mosquito mos;
	ElectricMosquitoZapper EMZ;
	Killer killer;
	JButton oneMoreTime;
	JButton close;
	
	Timer timer ;
	

	public ElectricMosquitoZapper(){
		
		mos = new Mosquito();
		killer = new Killer();
		JLabel again = new JLabel("還有蚊子!!!!!!!!!");
		JButton kill = new RoundButton("");
		close = new JButton("<html>糞<br>G<br>A<br>M<br>E</html>");
		oneMoreTime = new JButton("<html>再<br>打<br>更<br>多<br>隻</html>");
		killer.add(close);
		close.setBounds(150,300,100,50);
		close.setBackground(Color.BLACK);
		close.setForeground(Color.RED);
		close.setVisible(false);
		killer.add(oneMoreTime);
		oneMoreTime.setBounds(0,300,100,50);
		oneMoreTime.setBackground(Color.BLACK);
		oneMoreTime.setForeground(Color.RED);
		oneMoreTime.setVisible(false);
		killer.setLayout(null);
		killer.setBackground(Color.BLACK);
		killer.add(kill);
		killer.add(again);
		again.setBounds(0,400,250,40);
		again.setFont(font1);
		again.setVisible(false);
		kill.setBounds(115,250,20,20);
		add(killer);
		timer = new Timer(1000,new ActionListener(){      
                    public void actionPerformed(ActionEvent e) {
			close.setVisible(true);
			oneMoreTime.setVisible(true);
                        again.setVisible(true);
                        close.setBounds(125,0,125,400);
                        oneMoreTime.setBounds(0,0,125,400);
                        close.setFont(font2);
                        oneMoreTime.setFont(font2);
                    }
                });
		timer.setRepeats(false);
		//turn on the EMZ
		
		kill.addActionListener(new ActionListener() {
				@Override 
					public void actionPerformed(ActionEvent e) {
						
						
						if(Switch == false){
							mos.createNew();
							Switch = true;
							killer.setBackground(Color.YELLOW);
							
						}else if(Switch == true && mos.mos.number.getText().substring(0,3).equals("The")){
							
							
							timer.start();
							
							
						}else{
							mos.mos.number.setText("KEEP KILLING!!!!");
						}
					}
		}
		);
		close.addActionListener(new ActionListener() {
				@Override 
					public void actionPerformed(ActionEvent e) {
					
						mos.closeMos();
						Switch = false;
						killer.setBackground(Color.BLACK);
						close.setVisible(false);
						oneMoreTime.setVisible(false);
						again.setVisible(false);
					}
		}
		);
		oneMoreTime.addActionListener(new ActionListener() {
				@Override 
					public void actionPerformed(ActionEvent e) {
						close.setVisible(false);
						oneMoreTime.setVisible(false);	
						again.setVisible(false);
						mos.closeMos();
						mos.createNew();
						
					}
		}
		);
		
	}
	public void createNew(){
		EMZ = new ElectricMosquitoZapper();
		
		EMZ.setTitle("電蚊拍");
		EMZ.setSize(250,470);
		EMZ.setLocation(1300,0);
		EMZ.setDefaultCloseOperation(EMZ.EXIT_ON_CLOSE);
		EMZ.setVisible(true);
		EMZ.setResizable(false); 
		
	}
	public void closeEMZ(){
		EMZ.dispose();
		
	}
	//draw electric mosquito zapper
	class Killer extends JPanel {
		int a = 75;
		int b = 100;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(Color.BLUE);					   
			g.fillRect(getWidth()/2-15,getWidth()/2+b-1,30,101);
			g2.setStroke(new BasicStroke(3.0f));
			g.drawOval(getWidth() / 2 - a, getWidth() / 2 - b, 2 * a, 2 * b);
			g2.setStroke(new BasicStroke(1.0f));
			for(int i=0 ;i<=6 ; i++ ){
				double Fx =  a*Math.cos(Math.toRadians(i*15));
				double Fy =  b*Math.sin(Math.toRadians(i*15));
				
				g2.draw(new Line2D.Double(-Fx+getWidth()/2,Fy+getWidth()/2,Fx+getWidth()/2,Fy+getWidth()/2));
				g2.draw(new Line2D.Double(-Fx+getWidth()/2,-Fy+getWidth()/2,Fx+getWidth()/2,-Fy+getWidth()/2));
				g2.draw(new Line2D.Double(Fx+getWidth()/2,-Fy+getWidth()/2,Fx+getWidth()/2,Fy+getWidth()/2));
				g2.draw(new Line2D.Double(-Fx+getWidth()/2,-Fy+getWidth()/2,-Fx+getWidth()/2,Fy+getWidth()/2));
			}
		}
	}
	public class RoundButton extends JButton {

		
		public RoundButton(String label) {
			
			super(label);
			setContentAreaFilled(false);
		}

		protected void paintComponent(Graphics g) {
			g.setColor(Color.RED);
			g.fillOval(0, 0, 20, 20); 
			super.paintComponent(g); 
		}
		protected void paintBorder(Graphics g) {
			g.setColor(getForeground()); 

		}
		
	}
} 
