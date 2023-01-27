package Project2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class test3 {
   JPanel[] m=new JPanel[10];

   JLabel[] l1 =new JLabel[10];
   JLabel[] l2 =new JLabel[10];
   JLabel[] l3=new JLabel[10];
   JLabel[] l4 =new JLabel[10];
   JButton[] But =new JButton[9];
   JButton[] minus =new JButton[10];
   JButton[] plus =new JButton[10];
   HashMap<Integer, List> od=new HashMap<>();
   String[] ma=new String[10];
   int[] pri=new int[10];
   int[] su=new int[10];
   int[] a=new int[10];
   String[] pc=new String[10];
   String[] pcc=new String[10];
   HashMap<Object ,Object> map=new HashMap<>();
   boolean[] b=new boolean[10];
   private static int f;
   
   int[] pri1 = {1500,2000,2500,4500,3000,3000,2500,3000,3000,4500};
   Object[] ma1 = {"캡틴아메리카노" ,"카페라뗴","카페모카","의라차차", "홍차", "유자차", "랜덤에이드", "레몬에이드","체리에이드"};
   String[] pc1 = {"0000000001","0000000002","0000000003","0000000001","0000000002","0000000003","0000000001","0000000002","0000000003"};
   String[] pcc1 = {"01","01","01","02","02","02","03","03","03"};
   private JFrame frmHyperCoffeeShop;

   static Menu menu;
   private ImageIcon img;
   int i = 0;
   int gg=0;

private JPanel table;

private Object[] ut=new Object[9];
   
   
 
   /**
    * Launch the application.
    */

   /**
    * Create the application.
    */
   public test3() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      
      //여기서부터는 GUI
      
      frmHyperCoffeeShop = new JFrame("Java Coffie SHOP");//GUI제목타이틀
      frmHyperCoffeeShop.setTitle("Java Coffee SHOP");
      frmHyperCoffeeShop.setBounds(0, 0, 600, 800);
      img = new ImageIcon("Menuimg\\cup-2.png");
      frmHyperCoffeeShop.setIconImage(img.getImage());
      frmHyperCoffeeShop.setLocationRelativeTo(frmHyperCoffeeShop);
      frmHyperCoffeeShop.setResizable(false);
      frmHyperCoffeeShop.setVisible(true);
      frmHyperCoffeeShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      //메인패널
      JPanel cards = new JPanel(new CardLayout());
      cards.setBounds(0, 0, 600, 500);
      
      
      
      
      //커피 패널
      
      
      JPanel card1 = new JPanel();
     
      
      
      
      card1.setBounds(0, 0, 600,500);
      
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
      
      card1.setBackground(new Color(255, 255, 0));
      card1.setBounds(0, 0, 586, 51);
      card1.setLayout(null);
      
      
      img = new ImageIcon("Menuimg\\captincof.jpg");
      Image capimg1 = img.getImage();
      Image capimg2 = capimg1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(capimg2);
      But[0] = new JButton(img);
      But[0].setBounds(51, 169, 127, 123);
      card1.add(But[0]);
         
        
      
      img = new ImageIcon("Menuimg\\cafelat.jpg");
      Image latimg1 = img.getImage();
      Image latimg2 = latimg1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(latimg2);
      But[1] = new JButton(img);
      But[1].setBounds(229, 169, 127, 123);
      card1.add(But[1]);
      
      img = new ImageIcon("Menuimg\\cafemoka.jpg");
      Image mokimg1 = img.getImage();
      Image mokimg2 = mokimg1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(mokimg2);
      But[2] = new JButton(img);
      But[2].setBounds(407, 169, 127, 123);
      card1.add(But[2]);
      
      JLabel lblNewLabel_1 = new JLabel("<html><body><center>캡틴아메리카노<br>1500원</center></body></html>");
      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1.setBackground(Color.WHITE);
      lblNewLabel_1.setBounds(55, 302, 118, 40);
      card1.add(lblNewLabel_1);
      
      JLabel lblNewLabel_1_1 = new JLabel("<html><body><center>카페라떼<br>2000원</center></body></html>");
      lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1_1.setBackground(Color.WHITE);
      lblNewLabel_1_1.setBounds(259, 302, 66, 40);
      card1.add(lblNewLabel_1_1);
      
      JLabel lblNewLabel_1_1_1 = new JLabel("<html><body><center>카페모카<br>2500원</center></body></html>");
      lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1_1_1.setBackground(Color.WHITE);
      lblNewLabel_1_1_1.setBounds(437, 302, 66, 40);
      card1.add(lblNewLabel_1_1_1);
      
      JLabel lblNewLabel = new JLabel("Welcome Java Coffee SHOP");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel.setBounds(145, 10, 295, 31);
      card1.add(lblNewLabel);
      
      
      
      
      
      //여기서부터 티
      
      JPanel card2 = new JPanel();
      card2.setBounds(0, 0, 600,500);
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
      
      card2.setBackground(new Color(255, 255, 0));
      card2.setBounds(0, 0, 586, 51);
      card2.setLayout(null);
      
      
      
      img = new ImageIcon("Menuimg\\lachacha.jpg");
      Image lacha1 = img.getImage();
      Image lacha2 = lacha1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(lacha2);
      But[3] = new JButton(img);
      But[3].setBounds(51, 169, 127, 123);
      card2.add(But[3]);
      
      img = new ImageIcon("Menuimg\\hongcha.jpg");
      Image hcha1 = img.getImage();
      Image hcha2 = hcha1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(hcha2);
      But[4] = new JButton(img);
      But[4].setBounds(229, 169, 127, 123);
      card2.add(But[4]);
      
      img = new ImageIcon("Menuimg\\ujacha.jpg");
      Image ucha1 = img.getImage();
      Image ucha2 = ucha1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(ucha2);
      But[5] = new JButton(img);
      But[5].setBounds(407, 169, 127, 123);
      card2.add(But[5]);
      
      JLabel lblNewLabe2_1 = new JLabel("<html><body><center>으라차차<br>4500원</center></body></html>");
      lblNewLabe2_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe2_1.setBackground(Color.WHITE);
      lblNewLabe2_1.setBounds(81, 302, 66, 40);
      card2.add(lblNewLabe2_1);
      
      JLabel lblNewLabe2_1_1 = new JLabel("<html><body><center>홍차<br>3000원</center></body></html>");
      lblNewLabe2_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe2_1_1.setBackground(Color.WHITE);
      lblNewLabe2_1_1.setBounds(265, 302, 55, 40);
      card2.add(lblNewLabe2_1_1);
      
      JLabel lblNewLabe2_1_1_1 = new JLabel("<html><body><center>유자차<br>3000원</center></body></html>");
      lblNewLabe2_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe2_1_1_1.setBackground(Color.WHITE);
      lblNewLabe2_1_1_1.setBounds(443, 302, 55, 40);
      card2.add(lblNewLabe2_1_1_1);
      
      JLabel lblNewLabel2 = new JLabel("Welcome Java Coffee SHOP");
      lblNewLabel2.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel2.setBounds(145, 10, 295, 31);
      card2.add(lblNewLabel2);
      
    
      //여기서부터 에이드
      
      JPanel card3 = new JPanel();
      card3.setBounds(0, 0, 600,500);
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
      
      card3.setBackground(new Color(255, 255, 0));
      card3.setBounds(0, 0, 586, 51);
      
   
      img = new ImageIcon("Menuimg\\randomade.jpg");
      Image raade1 = img.getImage();
      Image raade2 = raade1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(raade2);
      But[6] = new JButton(img);
      But[6].setBounds(51, 169, 127, 123);
      card3.add(But[6]);
      
      img = new ImageIcon("Menuimg\\lemonade.jpg");
      Image leade1 = img.getImage();
      Image leade2 = leade1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(leade2);
      But[7] = new JButton(img);
      But[7].setBounds(229, 169, 127, 123);
      card3.add(But[7]);
      
      img = new ImageIcon("Menuimg\\cheade.jpg");
      Image chade1 = img.getImage();
      Image chade2 = chade1.getScaledInstance(127, 123, Image.SCALE_SMOOTH);
      img =  new ImageIcon(chade2);
      But[8] = new JButton(img);
      But[8].setBounds(407, 169, 127, 123);
      card3.add(But[8]);
      
      JLabel lblNewLabe3_1 = new JLabel("<html><body><center>랜덤에이드<br>2500원</center></body></html>");
      lblNewLabe3_1.setBounds(73, 302, 83, 40);
      lblNewLabe3_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe3_1.setBackground(Color.WHITE);
      card3.add(lblNewLabe3_1);
      
      JLabel lblNewLabe3_1_1 = new JLabel("<html><body><center>레몬에이드<br>3000원</center></body></html>");
      lblNewLabe3_1_1.setBounds(251, 302, 83, 40);
      lblNewLabe3_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe3_1_1.setBackground(Color.WHITE);
      card3.add(lblNewLabe3_1_1);
      
      JLabel lblNewLabe3_1_1_1 = new JLabel("<html><body><center>체리에이드<br>3000원</center></body></html>");
      lblNewLabe3_1_1_1.setBounds(429, 302, 83, 40);
      lblNewLabe3_1_1_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabe3_1_1_1.setBackground(Color.WHITE);
      card3.add(lblNewLabe3_1_1_1);
      
      JLabel lblNewLabel3 = new JLabel("Welcome Java Coffee SHOP");
      lblNewLabel3.setBounds(145, 10, 295, 31);
      lblNewLabel3.setFont(new Font("굴림", Font.BOLD, 20));
      card3.add(lblNewLabel3);
      
      
     
      //여기까지 에이드
      
      
     
      ////// 정기
   
//      JScrollPane scrollPane = new JScrollPane(table);
//      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//      scrollPane.setBounds(0, 500, 490, 300);
//      card1.add(scrollPane);
      
      
      //jtable정기
      table = new JPanel();
//    scrollPane.setViewportView(table);
      
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setBounds(0, 500, 490, 200);
      scrollPane.setViewportView(table);
      table.setLayout(null);
      
      
      
       JButton asd=new JButton("주문");
       asd.setBounds(500, 550, 80, 80);
       
       
     
      for(int i=0;i<But.length;i++) {
         //판넬 데이터 유무 확인
         int j = i;
         b[i]=false;
         
         map.put(i, "0");
         
         //판넬 구현 
         m[i]=new JPanel();
         m[i].setBounds(0, 0+50*i, 490,50);
         m[i].setBackground(Color.white);
         table.add(m[i]);
         m[i].setLayout(null);
         m[i].setVisible(b[i]);
         
         
         //메뉴 라벨 
         
         
         l1[i]=new JLabel("메뉴 "+(i+1));
         
         m[i].add(l1[i]);
         l1[i].setBounds(0, 0, 50, 50);
         l1[i].setVisible(true);
         
         //커피명
         l2[i]=new JLabel(ma[i]);
         m[i].add(l2[i]);
         l2[i].setBounds(70, 0, 100, 50);
         l2[i].setVisible(true);
         
         
         //가격
         l3[i]=new JLabel(String.valueOf( pri[i]));
         m[i].add(l3[i]);
         l3[i].setBounds(230, 0, 100, 50);
         l3[i].setVisible(true);
         //수량
         l4[i]=new JLabel(String.valueOf(su[i]));
         l4[i]=new JLabel();
         m[i].add(l4[i]);
         l4[i].setBounds(390, 0, 30, 50);
         l4[i].setVisible(true);
         //플러스 마이나스
            
         img = new ImageIcon("Menuimg\\mi.png");
            img =  new ImageIcon(new ImageIcon("Menuimg\\mi.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
            
         minus[i]=new JButton(img);
         minus[i].setBorderPainted(false);
         minus[i].setFocusPainted(false);
         minus[i].setContentAreaFilled(false);
 		
         m[i].add(minus[i]);
         minus[i].setBounds(310, 0, 50, 50);
         minus[i].setVisible(true);
         
         img = new ImageIcon("Menuimg\\pl.png");
         img =  new ImageIcon(new ImageIcon("Menuimg\\pl.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
         
         plus[i]=new JButton(img);
         plus[i].setBorderPainted(false);
         plus[i].setFocusPainted(false);
         plus[i].setContentAreaFilled(false);
         m[i].add(plus[i]);
         plus[i].setBounds(423, 0, 50, 50);
         plus[i].setVisible(true);
         
         //수량
         
         
         plus[i].addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            
               
                  su[j]++;
                  l4[j].setText(String.valueOf(su[j]));
                  l3[j].setText(String.valueOf(pri[j]*su[j]));
            }
         });
         minus[i].addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
            if(su[j] > 1) {
                  su[j]--;
                  l4[j].setText(String.valueOf(su[j]));
                  l3[j].setText(String.valueOf(pri[j]*su[j]));
         }else if(su[j] <= 1) {
                     su[j]=0;
                     ma[j]="";
                     pri[j]=0;
                     pc[j]="";
                     b[j]=false;
                     l4[j].setText(String.valueOf(su[j]));
                     l2[j].setText(ma[j]);
                     l3[j].setText(String.valueOf(pri[j]*su[j]));
                     m[j].setVisible(b[j]);
                     for(int z=0;z<9;z++) {
                     if(b[z+1]==true) {
                         System.out.println("d");
                        l2[z].setText(ma[z]=ma[z+1]);
                        l3[z].setText(String.valueOf((pri[z]=pri[z+1])*(su[z]=su[z+1])));
                        l4[z].setText(String.valueOf(su[z]=su[z+1]));
                        m[z].setVisible(b[z]=b[z+1]);
                        pc[z]=pc1[z+1];
                     

                        
                        
                        
                     
                     }else if(b[z+1]==false) {
//                        pc[j]=pc[j+1];
                        m[z].setVisible(false);
                        su[z]=0;
                        ma[z]="";
                        pri[z]=0;
                        pc[z]="";
                        b[z]=false;
                        
                     }
                     }
                  }
               
            }
         });
         
      
         
         
         But[j].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
               System.out.println("1");
               for(int z=0;z<But.length;z++) {
                  
            
                  if(b[z]==true&&ma[z]==ma1[j]) {
                     su[z]++;
                     l4[z].setText(String.valueOf(su[z]));
                     l3[z].setText(String.valueOf(pri[z]*su[z]));
                     f=z;
            
                     break;
                     
                  }else if(b[z]==false){
                     b[z]=true;
                     m[z].setVisible(b[z]);
                     
                     pc[z]=pc1[j];
                     
                     su[z]++;
                     l4[z].setText(String.valueOf(su[z]));
                  
                     //메뉴 명
                     ma[z]=(String) ma1[j]; 
                     l2[z].setText(ma[z]);
                     //가격
                     pri[z]=(int) pri1[j];
                     l3[z].setText(String.valueOf(pri[z]*su[z]));
                     f=z;
                     pcc[z]=pcc1[j];
                     
                     break;
                  }
            //if 끝
               }
               
               
               
               
            }
         });
         
         }

      
       asd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.out.println( "인덱스"+f);
                  
                List<List<Object>> myList = new ArrayList<List<Object>>();
                for (int i = 0; i <f+1; i++)  {       
                  myList.add( Arrays.asList(pcc[i]+pc[i], pri[i], ma[i],pri[i])); 
                
                }
                    for (int i = 0; i < 3; i++)  {
                        for (int j = 0; j < 3; j++) {
                            System.out.println("myList[" + i + "][" + j + "] = "
                                    + myList.get(i).get(j));
                        }
                    }
      
               }
            });   
       
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
      
       
       img = new ImageIcon("Menuimg\\cofb3.jpg");
       frmHyperCoffeeShop.getContentPane().setLayout(null);
       JLabel lb4 = new JLabel(null,img,JLabel.CENTER);
       lb4.setBounds(0, 0, 600, 800);
       frmHyperCoffeeShop.setContentPane(lb4);
      
      frmHyperCoffeeShop.getContentPane().add(cards);
      frmHyperCoffeeShop.getContentPane().add(scrollPane);
      frmHyperCoffeeShop.getContentPane().add(asd);
      
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
    new test3();
     
   }
}