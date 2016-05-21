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

public class UserManual extends JFrame {
	
	UserManual UM;
	JLabel picture = new JLabel();
	Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
	
	public UserManual() {
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("UMBG.jpg");
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		Container c = getContentPane();
		JPanel jp = new JPanel();
		c.add(jp);
		
		String UMContent = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s",
		"使用說明:",
		"A:電視機主控板 B:電風扇主控板 C:電蚊拍開關",
		"★★★★★★★★★使用說明可以直接右上關閉★★★★★★★★★",
		"------------------------A------------------------",
		"1.電視開機需要等候歡迎畫面消失才能開始遙控",
		"2.每次輸入都要按確認，頻道號小於100者可以直接輸入後確認",
		"EX.第6台:[6][確認]、第102台:[100][0][2][確認]",
		"3.使用[0]可以進入風扇延遲模式，可以藉此自訂風扇轉速",
		"EX.[0][確認][5][0][確認]>>將風扇旋轉延遲設定為50毫秒",
		"[0][確認]>>轉換控制風扇或電視",
		"------------------------B------------------------",
		"使用方法同一般風扇",
		"------------------------C------------------------",
		"點擊後會出現一個電蚊拍，按下電蚊拍上的按鈕可以開始殺蚊子小遊戲",
		"關閉電蚊拍:先按電蚊拍的按鈕，再按[殺蚊子]",
		"※務必將蚊子殺完再關閉※");
		JTextArea mainContent = new JTextArea(UMContent);
		mainContent.setFont(font);
		mainContent.setForeground(Color.BLACK);
		mainContent.setEditable(false);
		mainContent.setOpaque(false);
		picture.setIcon(new ImageIcon("UserManualPicture.jpg"));	
		c.add(picture,BorderLayout.NORTH);
		c.add(mainContent,BorderLayout.CENTER);
	}
	
	public void creatNew() {
		UM = new UserManual();
		UM.setTitle("使用手冊");
		UM.setLocation(400,50);
		UM.setSize(660,800);
		UM.setVisible(true);
		UM.setResizable(false);
	}
	
	public void closeUserManual(){
		UM.dispose();
	}
}