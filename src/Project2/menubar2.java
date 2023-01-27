package Project2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class menubar2 {
   private JFrame frmHyperCoffeeShop;
   static MemberDTO memDT;
   static Menu menu;
   private ImageIcon img;
   int i = 0;
   
   
 
   /**
    * Launch the application.
    */

   /**
    * Create the application.
    */
   public menubar2() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      
      //여기서부터는 GUI
      
      frmHyperCoffeeShop = new JFrame("Java Coffie SHOP");//GUI제목타이틀
      frmHyperCoffeeShop.getContentPane().setBackground(new Color(240, 240, 240));
      frmHyperCoffeeShop.setBackground(new Color(240, 240, 240));
      frmHyperCoffeeShop.setTitle("Java Coffee SHOP");
      frmHyperCoffeeShop.setBounds(0, 0, 600, 800);
      img = new ImageIcon("Menuimg\\cup-2.png");
      frmHyperCoffeeShop.setIconImage(img.getImage());
      frmHyperCoffeeShop.setLocationRelativeTo(frmHyperCoffeeShop);
      frmHyperCoffeeShop.setResizable(false);
      frmHyperCoffeeShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
      
      //메인패널
      JPanel cards = new JPanel(new CardLayout());
      cards.setBounds(0,50,600,600);
      
      
      
      
      //커피 패널
      
      
      JPanel card1 = new JPanel();
     
      
      
      
      card1.setBounds(0, 0, 600,800);
      
      JButton btnCOF = new JButton("COFFEE");
      btnCOF.setBackground(new Color(255, 255, 255));
      btnCOF.setFont(new Font("굴림", Font.BOLD, 20));
      btnCOF.setBounds(54, 66, 120, 50);
      card1.add(btnCOF);
      
      JButton btnTEA = new JButton("TEA");
      btnTEA.setBackground(new Color(255, 255, 255));
      btnTEA.setFont(new Font("굴림", Font.BOLD, 20));
      btnTEA.setBounds(247, 66, 91, 50);
      card1.add(btnTEA);
      
      JButton btnADE = new JButton("ADE");
      btnADE.setBackground(new Color(240, 240, 240));
      btnADE.setFont(new Font("굴림", Font.BOLD, 20));
      btnADE.setBounds(425, 66, 91, 50);
      card1.add(btnADE);
      
      card1.setBackground(new Color(255, 255, 255));
      card1.setBounds(0, 0, 586, 51);
      card1.setLayout(null);
      
      
      img = new ImageIcon("Menuimg\\captincof.jpg");
      Image capimg1 = img.getImage();
      Image capimg2 = capimg1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(capimg2);
      JButton button = new JButton(img);
      button.setBounds(51, 169, 127, 123);
      card1.add(button);
         
        
      
      img = new ImageIcon("Menuimg\\cafelat.jpg");
      Image latimg1 = img.getImage();
      Image latimg2 = latimg1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(latimg2);
      JButton button_1 = new JButton(img);
      button_1.setBounds(229, 169, 127, 123);
      card1.add(button_1);
      
      img = new ImageIcon("Menuimg\\cafemoka.jpg");
      Image mokimg1 = img.getImage();
      Image mokimg2 = mokimg1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(mokimg2);
      JButton button_1_1 = new JButton(img);
      button_1_1.setBounds(407, 169, 127, 123);
      card1.add(button_1_1);
      
      JLabel lblNewLabel_1 = new JLabel("<html><body><center>캡틴아메리카노<br>1500원</center></body></html>");
      lblNewLabel_1.setForeground(new Color(255, 255, 255));
      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1.setBackground(new Color(255, 255, 255));
      lblNewLabel_1.setBounds(55, 302, 118, 40);
      card1.add(lblNewLabel_1);
      
      JLabel lblNewLabel_1_1 = new JLabel("<html><body><center>카페라떼<br>2000원</center></body></html>");
      lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
      lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1_1.setBackground(new Color(255, 255, 255));
      lblNewLabel_1_1.setBounds(259, 302, 66, 40);
      card1.add(lblNewLabel_1_1);
      
      JLabel lblNewLabel_1_1_1 = new JLabel("<html><body><center>카페모카<br>2500원</center></body></html>");
      lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
      lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1_1_1.setBackground(new Color(255, 255, 255));
      lblNewLabel_1_1_1.setBounds(437, 302, 66, 40);
      card1.add(lblNewLabel_1_1_1);
      
      JLabel lblNewLabel = new JLabel("Welcome Java Coffee SHOP");
      lblNewLabel.setForeground(new Color(255, 255, 255));
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel.setBounds(145, 10, 295, 31);
      card1.add(lblNewLabel);
      
      
      
      
      
      //여기서부터 티
      
      JPanel card2 = new JPanel();
      card2.setBounds(0, 0, 600,600);
      JButton btnCOF2 = new JButton("COFFEE");
      btnCOF2.setBackground(new Color(240, 240, 240));
      btnCOF2.setFont(new Font("굴림", Font.BOLD, 20));
      btnCOF2.setBounds(54, 66, 120, 50);
      card2.add(btnCOF2);
      
      JButton btnTEA2 = new JButton("TEA");
      btnTEA2.setBackground(new Color(240, 240, 240));
      btnTEA2.setFont(new Font("굴림", Font.BOLD, 20));
      btnTEA2.setBounds(247, 66, 91, 50);
      card2.add(btnTEA2);
      
      JButton btnADE2 = new JButton("ADE");
      btnADE2.setBackground(new Color(240, 240, 240));
      btnADE2.setFont(new Font("굴림", Font.BOLD, 20));
      btnADE2.setBounds(425, 66, 91, 50);
      card2.add(btnADE2);
      
      card2.setBackground(new Color(255, 255, 255));
      card2.setBounds(0, 0, 586, 51);
      card2.setLayout(null);
      
      
      
      img = new ImageIcon("Menuimg\\lachacha.jpg");
      Image lacha1 = img.getImage();
      Image lacha2 = lacha1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(lacha2);
      JButton button_2 = new JButton(img);
      button_2.setBounds(51, 169, 127, 123);
      card2.add(button_2);
      
      img = new ImageIcon("Menuimg\\hongcha.jpg");
      Image hcha1 = img.getImage();
      Image hcha2 = hcha1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(hcha2);
      JButton button_1_2 = new JButton(img);
      button_1_2.setBounds(229, 169, 127, 123);
      card2.add(button_1_2);
      
      img = new ImageIcon("Menuimg\\ujacha.jpg");
      Image ucha1 = img.getImage();
      Image ucha2 = ucha1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(ucha2);
      JButton button_1_1_1 = new JButton(img);
      button_1_1_1.setBounds(407, 169, 127, 123);
      card2.add(button_1_1_1);
      
      JLabel lblNewLabe2_1 = new JLabel("<html><body><center>으라차차<br>4500원</center></body></html>");
      lblNewLabe2_1.setForeground(new Color(255, 255, 255));
      lblNewLabe2_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe2_1.setBackground(Color.WHITE);
      lblNewLabe2_1.setBounds(81, 302, 66, 40);
      card2.add(lblNewLabe2_1);
      
      JLabel lblNewLabe2_1_1 = new JLabel("<html><body><center>홍차<br>3000원</center></body></html>");
      lblNewLabe2_1_1.setForeground(new Color(255, 255, 255));
      lblNewLabe2_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe2_1_1.setBackground(Color.WHITE);
      lblNewLabe2_1_1.setBounds(265, 302, 55, 40);
      card2.add(lblNewLabe2_1_1);
      
      JLabel lblNewLabe2_1_1_1 = new JLabel("<html><body><center>유자차<br>3000원</center></body></html>");
      lblNewLabe2_1_1_1.setForeground(new Color(255, 255, 255));
      lblNewLabe2_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe2_1_1_1.setBackground(Color.WHITE);
      lblNewLabe2_1_1_1.setBounds(443, 302, 55, 40);
      card2.add(lblNewLabe2_1_1_1);
      
      JLabel lblNewLabel2 = new JLabel("Welcome Java Coffee SHOP");
      lblNewLabel2.setForeground(new Color(255, 255, 255));
      lblNewLabel2.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel2.setBounds(145, 10, 295, 31);
      card2.add(lblNewLabel2);
      
    
      //여기서부터 에이드
      
      JPanel card3 = new JPanel();
      card3.setBounds(0, 0, 600,600);
      card3.setLayout(null);
      JButton btnCOF3 = new JButton("COFFEE");
      btnCOF3.setBounds(54, 66, 120, 50);
      btnCOF3.setBackground(new Color(255, 255, 255));
      btnCOF3.setFont(new Font("굴림", Font.BOLD, 20));
      card3.add(btnCOF3);
      
      JButton btnTEA3 = new JButton("TEA");
      btnTEA3.setBounds(247, 66, 91, 50);
      btnTEA3.setBackground(new Color(255, 255, 255));
      btnTEA3.setFont(new Font("굴림", Font.BOLD, 20));
      card3.add(btnTEA3);
      
      JButton btnADE3 = new JButton("ADE");
      btnADE3.setBounds(425, 66, 91, 50);
      btnADE3.setBackground(new Color(255, 255, 255));
      btnADE3.setFont(new Font("굴림", Font.BOLD, 20));
      card3.add(btnADE3);
      
      card3.setBackground(new Color(255, 255, 255));
      card3.setBounds(0, 0, 586, 51);
      
   
      img = new ImageIcon("Menuimg\\randomade.jpg");
      Image raade1 = img.getImage();
      Image raade2 = raade1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(raade2);
      JButton button_3 = new JButton(img);
      button_3.setBounds(51, 169, 127, 123);
      card3.add(button_3);
      
      img = new ImageIcon("Menuimg\\lemonade.jpg");
      Image leade1 = img.getImage();
      Image leade2 = leade1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(leade2);
      JButton button_1_3 = new JButton(img);
      button_1_3.setBounds(229, 169, 127, 123);
      card3.add(button_1_3);
      
      img = new ImageIcon("Menuimg\\cheade.jpg");
      Image chade1 = img.getImage();
      Image chade2 = chade1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(chade2);
      JButton button_1_1_2 = new JButton(img);
      button_1_1_2.setBounds(407, 169, 127, 123);
      card3.add(button_1_1_2);
      
      JLabel lblNewLabe3_1 = new JLabel("<html><body><center>랜덤에이드<br>2500원</center></body></html>");
      lblNewLabe3_1.setForeground(new Color(255, 255, 255));
      lblNewLabe3_1.setBounds(73, 302, 83, 40);
      lblNewLabe3_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe3_1.setBackground(Color.WHITE);
      card3.add(lblNewLabe3_1);
      
      JLabel lblNewLabe3_1_1 = new JLabel("<html><body><center>레몬에이드<br>3000원</center></body></html>");
      lblNewLabe3_1_1.setForeground(new Color(255, 255, 255));
      lblNewLabe3_1_1.setBounds(251, 302, 83, 40);
      lblNewLabe3_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe3_1_1.setBackground(Color.WHITE);
      card3.add(lblNewLabe3_1_1);
      
      JLabel lblNewLabe3_1_1_1 = new JLabel("<html><body><center>체리에이드<br>3000원</center></body></html>");
      lblNewLabe3_1_1_1.setForeground(new Color(255, 255, 255));
      lblNewLabe3_1_1_1.setBounds(429, 302, 83, 40);
      lblNewLabe3_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe3_1_1_1.setBackground(Color.WHITE);
      card3.add(lblNewLabe3_1_1_1);
      
      JLabel lblNewLabel3 = new JLabel("Welcome Java Coffee SHOP");
      lblNewLabel3.setForeground(new Color(255, 255, 255));
      lblNewLabel3.setBounds(145, 10, 295, 31);
      lblNewLabel3.setFont(new Font("굴림", Font.BOLD, 20));
      card3.add(lblNewLabel3);
      
      
     
      //여기까지 에이드
      
      
      
      card1.add("cof",btnCOF);
      card1.add("tea",btnTEA);
      card1.add("ade",btnADE);
      
      card2.add("cof",btnCOF2);
      card2.add("tea",btnTEA2);
      card2.add("ade",btnADE2);
      
      card3.add("cof",btnCOF3);
      card3.add("tea",btnTEA3);
      card3.add("ade",btnADE3);
      
      cards.add(card1,"cof");
      cards.add(card2,"tea");
      cards.add(card3,"ade");
      
      
      
      
      frmHyperCoffeeShop.getContentPane().add(cards);
      
      img = new ImageIcon("Menuimg\\cofb3.jpg");
      JLabel lb1 =new JLabel(null,img,JLabel.CENTER);
      lb1.setBounds(0,0,600,800);
      card1.add(lb1);
      
      img = new ImageIcon("Menuimg\\cofb3.jpg");
      JLabel lb2 = new JLabel(null,img,JLabel.CENTER);
      lb2.setBounds(0,0,600,800);
      card2.add(lb2);
      
      img = new ImageIcon("Menuimg\\cofb3.jpg");
      JLabel lb3 = new JLabel(null,img,JLabel.CENTER);
      lb3.setBounds(0, 0, 600, 800);
      card3.add(lb3);
      
      CardLayout cl = (CardLayout)cards.getLayout();
      
      btnCOF.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			cl.first(cards);
		}
	});
      btnTEA.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			cl.next(cards);
		}
	});
      btnADE.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			cl.last(cards);
		}
	});
      
      btnCOF2.addActionListener(new ActionListener() {
  		
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			
  			cl.first(cards);
  		}
  	});
        btnADE2.addActionListener(new ActionListener() {
  		
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			cl.last(cards);
  		}
  	});
        btnCOF3.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    			cl.first(cards);
    		}
    	});
          btnTEA3.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			cl.previous(cards);
    		}
    	});
          btnADE3.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			cl.last(cards);
    		}
    	});
      
          
      
      
   
      
         
      
      }
      
      
      
      

   public static void main(String[] args) {
   
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               menubar2 window = new menubar2();
               window.frmHyperCoffeeShop.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
}