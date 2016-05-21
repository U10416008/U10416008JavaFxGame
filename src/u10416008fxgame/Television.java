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
import javax.swing.event.*;



public class Television extends JFrame{
	
	JTextArea a , b;
	JPanel p1;
	JPanel p2;
	Television frame1;
	JLabel picture;
	StringBuffer sb ;
	Timer timer;
	Timer timer1;
	Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 36);
	String str2 ;
	int second = 0;
	boolean start = false;
	boolean takeABreak = false;
	//Construter set the size,color,font and background
	public Television(){
			
		a = new JTextArea("Channel:");
		b = new JTextArea("Volume");
		//b.setVisible(false);
		a.setBackground(Color.BLACK);
		b.setBackground(Color.BLACK);
		a.setFont(font);
		a.setForeground(Color.MAGENTA);
		b.setFont(font);
		b.setForeground(Color.RED);
		
		p1 = new JPanel();
		p1.setBackground(Color.BLACK);
		p2 = new JPanel(new BorderLayout());
		p2.add(a,BorderLayout.NORTH);
		
		p2.add(p1,BorderLayout.CENTER);
		add(p2, BorderLayout.NORTH);
		add(b,BorderLayout.SOUTH);
		a.setEditable(false);
		b.setEditable(false);
		timer = new Timer(30000,new ActionListener(){      
					public void actionPerformed(ActionEvent e) {
							timer.stop();
							second = getSecond(second) + 30;							
							int result = JOptionPane.showConfirmDialog(frame1,"你已經看了" + getSecond(second)+"秒了，要繼續看嗎",
							"看太久囉", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							if(result == JOptionPane.YES_OPTION){
								timer.start();	
							}else{
								second = 0;
								frame1.a.setVisible(false);
								frame1.b.setVisible(false);
								takeABreak = true;
								timer1.start();
								picture.setIcon(new ImageIcon("break.jpg"));	
							}							
					}
				});
		timer1 = new Timer(30000,new ActionListener(){
					public void actionPerformed(ActionEvent e){
						frame1.a.setVisible(true);
						frame1.b.setVisible(true);
						takeABreak = false;
						channelImage(frame1.a.getText());
						timer.start();
					}
				});
		timer.setRepeats(false);
		timer1.setRepeats(false);
		
	}
	public int getSecond(int s){
		return s;
	}
	//Turn off TV method
	public void closeTV(){
		timer.stop();
		getSecond(0);
		frame1.dispose();
		
	}
	//return the string in textArea(Channel)
	public String Channel(){
		
		return frame1.a.getText();
		
	}
	//input the channel  
	public void inputChannel(String s) {
		
		frame1.a.setText(s);
		
	}
	//display TV image
	public void channelImage(String c){
		if(c.equals("1")||c.equals("01")||c.equals("001")){
	
			frame1.a.setText("1");
			picture.setIcon(new ImageIcon("SMPTE_Color_Bars.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("2")||c.equals("02")||c.equals("002")){

			frame1.a.setText("2");
			picture.setIcon(new ImageIcon("SMPTE_Color_Bars.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("3")||c.equals("03")||c.equals("003")){

			frame1.a.setText("3");
			picture.setIcon(new ImageIcon("SMPTE_Color_Bars.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("4")||c.equals("04")||c.equals("004")){

			frame1.a.setText("4");
			picture.setIcon(new ImageIcon("SMPTE_Color_Bars.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("5")||c.equals("05")||c.equals("005")){

			frame1.a.setText("5");
			picture.setIcon(new ImageIcon("ch05.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("6")||c.equals("06")||c.equals("006")){
			
			frame1.a.setText("6");
			picture.setIcon(new ImageIcon("ch06.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("7")||c.equals("07")||c.equals("007")){
			
			frame1.a.setText("7");
			picture.setIcon(new ImageIcon("SMPTE_Color_Bars.jpg"));		
			frame1.repaint();
		}else if(c.equals("8")||c.equals("08")||c.equals("008")){
			
			frame1.a.setText("8");
			picture.setIcon(new ImageIcon("ch08.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("9")||c.equals("09")||c.equals("009")){
			
			frame1.a.setText("9");
			picture.setIcon(new ImageIcon("ch09.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("10")||c.equals("010")){
			
			frame1.a.setText("10");
			picture.setIcon(new ImageIcon("ch10.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("12")||c.equals("012")){
			
			frame1.a.setText("12");
			picture.setIcon(new ImageIcon("ch12.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("18")||c.equals("018")){
			
			frame1.a.setText("18");
			picture.setIcon(new ImageIcon("ch18.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("19")||c.equals("019")){
			
			frame1.a.setText("19");
			picture.setIcon(new ImageIcon("ch19.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("20")||c.equals("020")){
			
			frame1.a.setText("20");
			picture.setIcon(new ImageIcon("ch20.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("21")||c.equals("021")){
			
			frame1.a.setText("21");
			picture.setIcon(new ImageIcon("ch21.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("22")||c.equals("022")){
			
			frame1.a.setText("22");
			picture.setIcon(new ImageIcon("ch22.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("23")||c.equals("023")){
			
			frame1.a.setText("23");
			picture.setIcon(new ImageIcon("ch23.jpg"));
			frame1.repaint();
									
		}else if(c.equals("24")||c.equals("024")){
			
			frame1.a.setText("24");
			picture.setIcon(new ImageIcon("ch24.jpg"));
			frame1.repaint();
									
		}else if(c.equals("25")||c.equals("025")){
			
			frame1.a.setText("25");
			picture.setIcon(new ImageIcon("ch25.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("26")||c.equals("026")){
			
			frame1.a.setText("26");
			picture.setIcon(new ImageIcon("ch26.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("28")||c.equals("028")){
			
			frame1.a.setText("28");
			picture.setIcon(new ImageIcon("ch28.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("29")||c.equals("029")){
			
			frame1.a.setText("29");
			picture.setIcon(new ImageIcon("ch29.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("31")||c.equals("031")){
			
			frame1.a.setText("31");
			picture.setIcon(new ImageIcon("ch31.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("36")||c.equals("036")){
			
			frame1.a.setText("36");
			picture.setIcon(new ImageIcon("ch36.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("51")||c.equals("051")){
			
			frame1.a.setText("51");
			picture.setIcon(new ImageIcon("ch51.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("52")||c.equals("052")){
			
			frame1.a.setText("52");
			picture.setIcon(new ImageIcon("ch52.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("55")||c.equals("055")){
			
			frame1.a.setText("55");
			picture.setIcon(new ImageIcon("ch55.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("61")||c.equals("061")){
			
			frame1.a.setText("61");
			picture.setIcon(new ImageIcon("ch61.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("62")||c.equals("062")){
			
			frame1.a.setText("62");
			picture.setIcon(new ImageIcon("ch62.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("71")||c.equals("071")){
			
			frame1.a.setText("71");
			picture.setIcon(new ImageIcon("ch71.jpg"));		
			frame1.repaint();
			
		}else if(c.equals("89")||c.equals("089")){
			
			frame1.a.setText("89");
			picture.setIcon(new ImageIcon("ch89.jpg"));		
			frame1.repaint();
			
		}else{
			
			if(frame1.a.getText().substring(0,1).equals("0")){
				frame1.a.setText(frame1.a.getText().replaceFirst("0",""));
			}
			picture.setIcon(new ImageIcon("SMPTE_Color_Bars.jpg"));
			frame1.repaint();
		
		}
		frame1.add(picture,BorderLayout.CENTER);
			
	}
	
	// sound is too loud method
	public void tooLoud(){
		
			frame1.b.setText("你在大聲什麼啦");
		
	}
	//make no sound method
	public void noSound(){
		frame1.b.setText("靜音");
	}
	//make sound louder method
	public void volumeUp(){
		frame1.b.append("｜");
		
	}
	//make sound lower method
	public void volumeDown(){
		sb = new StringBuffer(frame1.b.getText());
		sb.delete(6,7);
		frame1.b.setText(sb.toString());
	}
	
	
	//Turn on TV method
	public void createNew() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame1 = new Television();
		picture	= new JLabel(new ImageIcon("Welcome.jpg"));
		frame1.add(picture,BorderLayout.CENTER);
		
		frame1.setTitle("電視");
		frame1.setLocation(400,50);
		frame1.setSize(900,720);
		
		frame1.setDefaultCloseOperation(Television.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		frame1.setResizable(false);
		timer.start();
		
	}
}


