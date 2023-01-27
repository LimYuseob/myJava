package projetctgu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginDAO {
   private JFrame cofcr;
   private JPanel contentPane;
   private JLabel lblJoin;
   private JTextField tfUsername;
   private ImageIcon img;
   Date date_now = new Date(System.currentTimeMillis());
   SimpleDateFormat new_date = new SimpleDateFormat("yyyy-MM-dd");
   OrderDTO dto;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               LoginDAO window = new LoginDAO();
               window.cofcr.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public LoginDAO() {
      initialize();
   }
      private static Connection getConnection() {                                                                        //DB에 커넥트
            Connection conn = null;
            try {
               conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yuseob", "1234");
               System.out.println("연결 완료!!");
            } catch (SQLException e) {
                System.out.println("DB를 연결하지 못했습니다");
            }
            return conn;
         }
         
      public int checkMember(String id) {
            int result = 0;
            String sql = "Select count(id) from MEM Where id = ?";
            try {
               Connection conn = getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql);
               pstmt.setString(1, id);
               
               //조회(Select) 는 executeQuery(sql) 을 실행해야 합니다.
               ResultSet rs = pstmt.executeQuery();

               if(rs.next()) {
                  result = rs.getInt(1);
               } else {
                  result = rs.getInt(0);
               }
               System.out.println();
               rs.close();
               pstmt.close();
               return result;
            }catch (Exception e) {
               System.out.println("회원 조회시 예외 발생" + e.getMessage());
            }
            return result;
         }
   public boolean userInsert() {                                                                                                //dto 삽입
         String sql = " INSERT INTO MEM(ID, NAME, CDATE, POINT) " 
                  + " VALUES(?, ?, ?, ?) ";
         
         Connection conn = getConnection();
         PreparedStatement psmt = null;
         
         int count = 0;
         System.out.println("ID :" + dto.getId());
         System.out.println("cDate :" + dto.getcDate());
         
         try {
            psmt = conn.prepareStatement(sql);
            // 첫번째, 두번째, 세번째 데이터를 넣기
            
            psmt.setString(1, dto.getId()); 
            psmt.setString(2, dto.getName()); 
            psmt.setString(3, dto.getcDate());
            psmt.setInt(4, 10);
            
            
            count = psmt.executeUpdate();
            System.out.println("cnt : " + count);
         } catch (SQLException e) {
            System.out.println("회원 가입에 문제가 생겼습니다.");
         } finally {
            // DB close 필수!
             // 접속이 된 것
            try {
               if(conn != null) {
                  conn.close();
               }
               if(psmt != null) {
                  psmt.close();
               }
            } catch (SQLException e) {
               e.printStackTrace();
            
            }
         }
         return count > 0 ? true : false; 
      }


   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      dto = new OrderDTO();
      cofcr = new JFrame("Java Coffie SHOP");
      cofcr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      cofcr.setSize(300, 300);
      cofcr.setLocationRelativeTo(null);
      img = new ImageIcon("Menuimg\\cup-2.png");
      cofcr.setIconImage(img.getImage());
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      cofcr.setContentPane(contentPane);
      
      lblJoin = new JLabel("회원가입");
      lblJoin.setBounds(37, 86, 101, 20);
      Font f1 = new Font("돋움", Font.BOLD, 20); //궁서 바탕 돋움
      contentPane.setLayout(null);
      lblJoin.setFont(f1);
      contentPane.add(lblJoin);
      
      JLabel lblUsername = new JLabel("휴대폰번호");
      lblUsername.setBounds(37, 127, 69, 20);
      contentPane.add(lblUsername);
      
   
      
      
      
      tfUsername = new JTextField();
      tfUsername.setBounds(118, 120, 139, 35);
      contentPane.add(tfUsername);
      String id = tfUsername.getText();
      dto.setId(id);
      
      
      
      JButton crbtn = new JButton("입력완료");
      crbtn.setBounds(118, 180, 139, 29);
      contentPane.add(crbtn);
      
      cofcr.setVisible(true);
      img = new ImageIcon("Menuimg\\cofbg2.jpg");
      Image mem1 = img.getImage();
       Image mem2 = mem1.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
       img =  new ImageIcon(mem2);
       JLabel lb3 = new JLabel(null,img,JLabel.CENTER);
       lb3.setBounds(0, 0, 300, 300);
       contentPane.add(lb3);
      //회원가입완료 액션
       
       System.out.println(dto.getId());
      crbtn.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            final String CONFIRM = "[0-9]+";   
            if(e.getSource().equals(crbtn)) {
               String id = tfUsername.getText();
               dto.setId(id);
               
                if(((dto).getId()).matches(CONFIRM) && dto.getId().length() == 11) {
                     System.out.println(checkMember(dto.getId()));
                     
                     if(checkMember(dto.getId()) != 0) {
                        JOptionPane.showMessageDialog(null, "중복된 휴대폰 번호입니다.");
                        return;
                     }   
                        dto.setcDate(new_date.format(date_now));
                        JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
                        boolean result = userInsert();
                        cofcr.dispose();
                        
                     }else {
                        JOptionPane.showMessageDialog(null, "정상적인 휴대폰번호 형식이 아닙니다.\n다시 입력해주세요");
                  } 
               
               
            }
               }
         
      });
}
}