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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Controller extends JFrame{
	Font font = new Font(Font.SANS_SERIF, Font.BOLD, 12);
	Font font1 = new Font(Font.SANS_SERIF, Font.BOLD, 18);
	Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 24);
	Font font3 = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	Television TV = new Television();
	ElectricMosquitoZapper EMZ = new ElectricMosquitoZapper();
	Fan fan = new Fan();
	UserManual UM = new UserManual();
	Mosquito mos = new Mosquito();
	Timer timer;
	Timer timer1;
	static Controller frame;
	boolean fanOn = false;
	boolean TVon = false;
	boolean ChannelInput = false;
	boolean HundredChannel = false;
	boolean change = false;
	boolean tooLoud = false;
	boolean noSound = false;
	boolean setFan = false;
	boolean emzOn = false;
        
	String[] s = {"電視","確認","靜音","電風扇","1","2","3","弱","4","5","6","中","7","8","9","強",
					"100","0","互換","關","頻道↑","頻道↓","音量+","音量-","殺蚊子!"};
	String[] c = {"1","2"};
	String volume = "Volume｜｜｜｜｜｜｜｜｜｜";
	int m = (int)(Math.random()*120) + 1;
	

	public Controller(){
		
		
		JPanel p1 = new JPanel();
		JLabel label = new JLabel("ALMIGHTY CONTROLLER");
		JButton button[] = new JButton[40];
		p1.setLayout(null);
		p1.setBackground(Color.GRAY);
		//add button
		for(int i = 0; i <=24 ; i++){
			
			button[i] = new JButton(s[i]);
			p1.add(button[i]);
			button[i].setFont(font);
			button[i].setForeground(Color.ORANGE);
			button[i].setBackground(Color.BLACK);
			
		}
		button[0].setFont(font2);
		button[1].setFont(font2);
		
		button[0].setBounds(25,35,245,55);
		button[1].setBounds(25,105,160,55);
		button[2].setBounds(195,105,75,55);
		button[3].setBounds(280,35,75,125);
		button[24].setBackground(Color.RED);
		button[24].setBounds(25,500,330,75);
		button[24].setFont(font3);
		
		for(int i = 4; i <= 7 ; i++){
			button[i].setBounds(25+85*(i-4),175,75,35);
		}
		for(int i = 8; i <= 11 ; i++){
			button[i].setBounds(25+85*(i-8),245,75,35);
		}
		for(int i = 12; i <= 15 ; i++){
			button[i].setBounds(25+85*(i-12),315,75,35);
		}
		for(int i = 16; i <= 19 ; i++){
			button[i].setBounds(25+85*(i-16),385,75,35);
		}
		for(int i = 20; i <= 23 ; i++){
			button[i].setBounds(25+85*(i-20),455,75,35);
		}
		
		button[0].setForeground(Color.GREEN);
		button[3].setForeground(Color.GREEN);
		for(int i = 7; i <=19 ; i = i+4){
			button[i].setForeground(Color.RED);
		}
		p1.add(label);
		
		label.setFont(font3);
		label.setForeground(Color.BLACK);
		label.setBounds(10,580,380,80);
		
		JPanel p2 = new JPanel(new BorderLayout());
		JTextArea a = new JTextArea("THIS IS ALMIGHTY CONTROLLER");
		a.setForeground(Color.RED);
		a.setBackground(Color.BLACK);
		a.setFont(font1);
		p2.add(a,BorderLayout.NORTH);
		add(p1,BorderLayout.CENTER);
		add(p2, BorderLayout.NORTH);
		a.setEditable(false);
		
		//Turn on the TV 
		for(int i = 0 ; i <= 24 ; i++){
			
			button[i].addActionListener(new ActionListener() {
				@Override 
					public void actionPerformed(ActionEvent e) {
						timer1 = new Timer(200,new ActionListener(){      
								public void actionPerformed(ActionEvent e) {											
									a.setBackground(Color.BLACK);											
								}
								});
						timer = new Timer(2000,new ActionListener(){      
								public void actionPerformed(ActionEvent e) {
											
									TV.inputChannel(Integer.toString(m));                        
									TV.channelImage(Integer.toString(m));
									TV.frame1.b.setText(volume);
									c[1]= TV.Channel();
											
								}
								});
						
						timer.setRepeats(false);
						timer1.setRepeats(false);
						
						
						//Turn on/off the TV
						if(e.getSource() == button[0]){
							
							
							if(TVon == false){
								if(emzOn == true){
									a.setText("專心打蚊子啦!");
								}else{
									a.setText("WELCOME TO ALMIGHTY CONTROLLER");
									TV.createNew();								
									timer.start();		
									TVon = true ;
									ChannelInput = true;
								}
								
							}else{
								m = Integer.parseInt(TV.Channel());
								volume = TV.frame1.b.getText();
								a.setText("SLEEP");								
								TV.closeTV();
								TVon = false;
								change = false;
							}
							
						}
						
						
						//input channel
						if(e.getSource() == button[1]){
							
							if(TVon == true){
								if(TV.takeABreak == true){
									JOptionPane.showMessageDialog(frame,"休息啦!!",
									"別碰我", JOptionPane.WARNING_MESSAGE);
								}else{
									if(HundredChannel == true){
								
										if((setFan == false&&Integer.parseInt(a.getText())<=120 && 
											Integer.parseInt(a.getText())>=100)&& a.getText().length()<=3){
									
											TV.inputChannel(a.getText());
											TV.channelImage(a.getText());
											c[0] = c[1];
											c[1] = a.getText();																			
											a.setText("Almighty!!!!!!!");
																		
										}else if(a.getText().equals("0")){
											if(setFan == false){
											a.setText("SET FAN SECOND");
											setFan = true;
											}else{
											a.setText("Input Channel");
											setFan = false;
											}
							
										}else if(setFan == true){
											fan.fan.stopWhenTimeSUp(1000*(Integer.parseInt(a.getText())));
									
										}else{
									
											a.setText("Input Channel");
											TV.inputChannel("Again");
										
										}
									}else{
								
										if((setFan == false&&Integer.parseInt(a.getText())<=120 && 
											Integer.parseInt(a.getText())>=1)&& a.getText().length()<=3){
									
									
											TV.inputChannel(a.getText());
											TV.channelImage(a.getText());									
											c[0] = c[1];
											c[1] = a.getText();																											
											a.setText("Almighty!!!!!!!");	
										
									
									
										}else if(a.getText().equals("0")){
											if(setFan == false){
												a.setText("SET FAN SECOND");
												setFan = true;
											}else{
												a.setText("Input Channel");
												setFan = false;
											}
							
										}else if(setFan == true){
											fan.fan.stopWhenTimeSUp(1000*(Integer.parseInt(a.getText())));
									
										}else{
									
											a.setText("wrong channel");
											TV.inputChannel("Again");
									
										}
									
									}
								}
							}else{
							
								if(setFan == true){
									fan.fan.stopWhenTimeSUp(1000*(Integer.parseInt(a.getText())));									
								}
							
								if(a.getText().equals("0")){
									if(setFan == false){
										a.setText("SET FAN SECOND");
										setFan = true;
									}else{
										a.setText("");
										setFan = false;
									}
							
								}
							}
							
							
							a.setBackground(Color.GREEN);
							timer1.start();
							ChannelInput = true;
							HundredChannel = false;
						}
						
						//input number 1~9
						for(int k = 4 ; k <=6 ; k++){
							
							if(e.getSource() == button[k]){
								if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
								}else{
								
									if(ChannelInput == true ){									
										a.setText("");
										ChannelInput = false;									
									}								
									a.append(s[k]);
									if(TVon == true && setFan == false){
										TV.inputChannel(a.getText());
									}
								
								}
							}
						}
						for(int k = 8 ; k <=10 ; k++){
							
							if(e.getSource() == button[k]){
								if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
								}else{								
									if(ChannelInput == true){									
										a.setText("");
										ChannelInput = false;									
									}								
									a.append(s[k]);
									if(TVon == true && setFan == false){
										TV.inputChannel(a.getText());
									}
								
								}
							}
						}					
						for(int k = 12 ; k <=14 ; k++){
							if(e.getSource() == button[k]){
								if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
								}else{
									if(ChannelInput == true ){									
										a.setText("");
										ChannelInput = false;									
									}								
									a.append(s[k]);
									if(TVon == true && setFan == false){
										TV.inputChannel(a.getText());
									}
								}
							}
						}
						
						//100
						if(e.getSource() == button[16]){
							if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
							}else{		
								a.setText("");
								ChannelInput = false;
								HundredChannel = true;							
								a.append("1");
								TV.inputChannel(a.getText());
							}
							
						}
						//input number 0
						if(e.getSource() == button[17]){
							if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
							}else{
								if(ChannelInput == true){								
										a.setText("");
										ChannelInput = false;									
									}								
								a.append(s[17]);
								if(TVon == true && setFan == false){
									TV.inputChannel(a.getText());
								}
							}
							
						}
						
						//channel up 	
						if(e.getSource() == button[20]){
							if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
							}else{
								timer1.start();
								a.setBackground(Color.GREEN);
								if(Integer.parseInt(TV.Channel())>= 120){
								
									TV.inputChannel("1");
									TV.channelImage("1");
									if(change == true){
										c[1] = c[0]; 
										c[0] = TV.Channel();									
									}else{
										c[0] = c[1];
										c[1] = TV.Channel();									
									}
								
								}else{
								
									TV.inputChannel(Integer.toString(Integer.parseInt(TV.Channel())+1));
									TV.channelImage(TV.Channel());
									if(change == true){
										c[1] = c[0]; 
										c[0] = TV.Channel();									
									}else{
										c[0] = c[1];
										c[1] = TV.Channel();									
									}
								}
							}
						}
						//channel down 
						if(e.getSource() == button[21]){
							if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
							}else{
								timer1.start();
								a.setBackground(Color.GREEN);
								if(Integer.parseInt(TV.Channel()) <= 1){
								
									TV.inputChannel("120");
									TV.channelImage("120");
									if(change == true){
										c[1] = c[0]; 
										c[0] = TV.Channel();									
									}else{
										c[0] = c[1];
										c[1] = TV.Channel();									
									}
								
								}else{
					
									TV.inputChannel(Integer.toString(Integer.parseInt(TV.Channel())-1));
									TV.channelImage(TV.Channel());
									if(change == true){
										c[1] = c[0]; 
										c[0] = TV.Channel();
									}else{
										c[0] = c[1];
										c[1] = TV.Channel();									
									}
								
								}
							}
						}
						
						//Control Volume +
						if(e.getSource() == button[22]){
							if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
							}else{
								timer1.start();
								a.setBackground(Color.GREEN);							
							
								if(TV.frame1.b.getText().equals("Volume｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜")){
									TV.tooLoud();
									tooLoud = true;
									a.setText("太大聲囉");
								}
								if(tooLoud == false){
									TV.frame1.b.setVisible(true);
									TV.volumeUp();
									a.setText("Almighty!!!!!!!");
								}
								if(noSound == true){
								
									TV.frame1.b.setText("Volume");
									noSound = false;
								
								}
							}
							
						}
						//Control Volume -
						if(e.getSource() == button[23]){
							if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
							}else{
								timer1.start();
								a.setBackground(Color.GREEN);							
								a.setText("Almighty!!!!!!!");
								if(tooLoud == true){
									TV.frame1.b.setText("Volume｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜｜");
								
									tooLoud = false;
								}
								if(noSound == true || TV.frame1.b.getText().equals("Volume")){
									TV.noSound();
									a.setText("太小聲囉");
									noSound = true;
								}
								if(noSound == false){
									TV.volumeDown();
								}
							}
						}
						//Control noVolume 
						if(e.getSource() == button[2]){	
							if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
							}else{
								timer1.start();
								a.setBackground(Color.GREEN);							
								TV.noSound();
								noSound = true;
							}
						}
						
						//Back previous Channel
						
						if(e.getSource() == button[18]){
							if(TV.takeABreak == true){
								JOptionPane.showMessageDialog(frame,"休息啦!!",
                                  "別碰我", JOptionPane.WARNING_MESSAGE);
							}else{
								timer1.start();
								a.setBackground(Color.GREEN);
								if(change == true){
									a.setText("Almighty!!!!!!!");
									TV.frame1.a.setText(c[1]);
									TV.channelImage(TV.Channel());
									change = false;
								}else{
									a.setText("Almighty!!!!!!!");
									TV.frame1.a.setText(c[0]);
									TV.channelImage(TV.Channel());
									change = true;
								}
							}
						}		
						
						//fan button
						
						if(e.getSource() == button[3]){
							if(emzOn == true){
								a.setText("專心打蚊子啦!");
							}else{
								timer1.start();
								a.setBackground(Color.GREEN);
								if(fanOn == false){
									a.setText("WELCOME TO ALMIGHTY FAN");
									fan.createNew();
									fanOn = true ;
									ChannelInput = true;
								}else{
									a.setText("BYE");									
									fan.closeFan();
									fanOn = false ;
								}
							}
						}
						if(e.getSource() == button[7]){
							timer1.start();
							a.setBackground(Color.GREEN);
							a.setText("Almighty!!!!!!!");
							fan.fan.angularVelocity(200);
						}
						if(e.getSource() == button[11]){
							timer1.start();
							a.setBackground(Color.GREEN);
							a.setText("Almighty!!!!!!!");
							fan.fan.angularVelocity(150);
						}
						if(e.getSource() == button[15]){
							timer1.start();
							a.setBackground(Color.GREEN);
							a.setText("Almighty!!!!!!!");
							fan.fan.angularVelocity(90);
						}
						if(e.getSource() == button[19]){
							timer1.start();
							a.setBackground(Color.GREEN);
							a.setText("Almighty!!!!!!!");							
							fan.fan.turnOff();		
						}
						//kill mosquitos
						if(e.getSource() == button[24]){
							timer1.start();
							a.setBackground(Color.GREEN);
							if(emzOn == false){
								EMZ.createNew();
								emzOn = true;
								a.setText("KILL MOSQUITOSSSSSS!!!!!");
								if(TVon == true){
									TV.timer.stop();
									TV.closeTV();
									TVon = false;
									m = Integer.parseInt(TV.Channel());
									volume = TV.frame1.b.getText();
								}
								if(fanOn == true){
									
									fan.closeFan();
									fanOn = false;
								}
							}else{
								EMZ.closeEMZ();
								emzOn = false;
								a.setText("GOOD!!!");
								ChannelInput = true;
								if(TVon == false){
									
									TV.createNew();
									TVon = true;
									timer.start();
								}
								if(fanOn == false){
									fan.createNew();
									fanOn = true;
								}
							}
						}

						}
				}
				);
		}
				
	
	}	
	public void createNew(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true); 
                UM.creatNew();
                
		frame = new Controller();
		frame.setTitle("遙控器");
		frame.setSize(400,700);
		frame.setLocation(0,100);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			int result = JOptionPane.showConfirmDialog(frame, 
                   "要離開豬窩了嗎?",
                   "舒服的豬窩",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.WARNING_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {System.exit(0);}
			}   
		});
		frame.setVisible(true);
		frame.setResizable(false);
	}
        public void closeController(){    
            
            frame.dispose();       
        }
}


