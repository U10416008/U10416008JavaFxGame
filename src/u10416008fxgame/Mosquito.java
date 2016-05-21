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


public class Mosquito extends JFrame {
	Mosquito mos;
	JTextArea number;
	JLabel stone;
	JPanel mosPanel;
	JPanel mosPanel2;
	Timer timer ;
	Timer timer1 ;
	Font font = new Font(Font.SANS_SERIF, Font.BOLD, 216);
	Font font1 = new Font(Font.SANS_SERIF, Font.BOLD, 24);
	Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 72);
	JButton mosL[] = new JButton[20];
	
	JLabel label;
	int magicStone = 1;
	int mosNumber ;
	int randomXLocation ;
	int randomYLocation ;
	int hitRate;
	int n =0;
	double success[] = new double[1000];
	double getStone[] = new double[1000];
	int t = 0;
	boolean finish = false; 
	boolean off = false;
	boolean oneMore = false ;
	boolean timerStart = false;
	public Mosquito(){
		mosNumber = (int)(Math.random()*20)+1;
		//get Random numbers
		for(int i = 0; i <1000 ; i++){
			success[i] = Math.random();
		}
		for(int i = 0; i <1000 ; i++){
			getStone[i] = (int)(Math.random()*5);
		}
		
		mosPanel = new JPanel();
		mosPanel2 = new JPanel();
		number = new JTextArea();
		number.setFont(font1);
		number.setBackground(Color.BLACK);
		number.setForeground(Color.RED);
		mosPanel.setLayout(null);
		label = new JLabel("FINISH!!");
		label.setFont(font);
		label.setForeground(Color.BLACK);
		label.setBounds(50,50,900,700);
		stone = new JLabel("X"+magicStone,new ImageIcon("stone.jpg"),SwingConstants.RIGHT);
		
		
		//get random locations
		for(int i = 0;i < mosNumber;i++){
			mosL[i] = new MosButton("");
			randomXLocation = (int)(Math.random()*950);
			randomYLocation = (int)(50+Math.random()*650);
			mosPanel.add(mosL[i]);
			mosL[i].setBounds(randomXLocation,randomYLocation,20,20);
		}
		
		mosPanel.setBackground(Color.RED);
		mosPanel2.setBackground(Color.BLACK);
		number.setText("Have "+ mosNumber +" Mosquitos");
		number.setEditable(false);
		mosPanel.add(stone);
		stone.setBounds(800,0,100,50);
		mosPanel2.add(number,BorderLayout.NORTH);
		add(mosPanel,BorderLayout.CENTER);
		add(mosPanel2,BorderLayout.NORTH);
		timer = new Timer(200,new ActionListener(){      
					public void actionPerformed(ActionEvent e) {
											
						mosPanel.setBackground(Color.RED);
											
					}
				});
		timer1 = new Timer(10000,new ActionListener(){      
					public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(mos,"要花一顆魔法石復活嗎?","被蚊子叮死了!!",
						JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
						timerStart = true;
						if (result == JOptionPane.YES_OPTION){
							if(magicStone == 0){
								timer1.stop();
								JOptionPane.showMessageDialog(mos,"再買更多石!!!",
                                "沒魔法石了", JOptionPane.WARNING_MESSAGE);
								mosPanel.add(label);
								label.setText("<html>GAME<br>　OVER</html>");
								number.setText("The LOSER!!!!!");
							}else{
								timer1.stop();
								magicStone--;
								stone.setText("X"+magicStone);
								timer1.start();
							}
						}else{
							timer1.stop();
							mosPanel.add(label);
							label.setText("<html>GAME<br>　OVER</html>");
							number.setText("The LOSER!!!!!");
						}				
					}
				});
							
		timer.setRepeats(false);
		timer1.setRepeats(false);
		
		//kill mosquitos
		for(int j = 0; j < mosNumber;j++){
			mosL[j].addActionListener(new ActionListener() {
					@Override 
						public void actionPerformed(ActionEvent e) {
							

										
							for(int m = 0 ; m <20; m++){
								
								if(e.getSource() == mosL[m]){
									t++;
									if(timerStart == false){
										timer1.start();
										
									}
									if((int)(success[t]*(Math.exp(1+(n+1)/mosNumber))) == 1){
										
										mosPanel.setBackground(Color.YELLOW);
										
										timer.start();
										mosL[m].setVisible(false);
										if(n+1 == mosNumber){
											timer1.stop();
											hitRate = (int)((n+1)*100/(t));
											number.setText("The Hero!!! Kill " + Integer.toString(n+1) +" Mosquitos in "
															+ Integer.toString(t)+" times. Your Hit Rate is "+hitRate+"%" );
											mosPanel.add(label);
											mosPanel.setBackground(Color.RED);
					
											
											
										}else{
											if(getStone[t] == 1){
												magicStone++;
												stone.setText("X"+magicStone);
											}
											n++;
											number.setText("Kill "+Integer.toString(t) +" times! Still Have " 
															+ Integer.toString(mosNumber-n) + " Mosquitos");
										}
										
									}else{
										number.setText("MISS");
										
										mosL[m].setBounds((int)(Math.random()*950),(int)(Math.random()*650),20,20);
									}
									
								}
							}
						}
			}
			);
		}
		
		
		
	}
	
	
	//close Mos
	public void closeMos(){
		mos.dispose();
	}
	public void createNew(){
		mos = new Mosquito();
		mos.setTitle("打爆蚊子!!!");
		mos.setLocation(300,50);
		mos.setSize(1000,800);
		mos.setDefaultCloseOperation(mos.EXIT_ON_CLOSE);
		mos.setVisible(true);
		mos.setResizable(false); 
	}
	//draw buttons
	public class MosButton extends JButton {


		public MosButton(String label) {
			
			super(label);
			setContentAreaFilled(false);
		}

		protected void paintComponent(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillOval(0, 0, 10, 8);
			g.fillOval(10, 0, 10, 8);
			super.paintComponent(g); 
		}
		protected void paintBorder(Graphics g) {
			g.setColor(getForeground()); 

		}
		
	}
}
