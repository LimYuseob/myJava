package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class LoginDAO2 {

   private MemberDTO2 dto;
   Date date_now = new Date(System.currentTimeMillis());
   SimpleDateFormat new_date = new SimpleDateFormat("yyyy-MM-dd");
   int a = 0;
   
   public LoginDAO2() {                                                //브릿지
      dto = new MemberDTO2();
      crId();
   }
   
//   public void Membercheck(String id) {
//      Connection conn = getConnection();
//      }

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
   
   public void crId(){                                                                                             //아이디(전화번호) 넣는 영역
      final String CONFIRM = "[0-9]+";   
//      getConnection();
//      Connection conn = null;
//      String sql = "" + "SELECT ID, NAME, CDATE, POINT" + "FROM MEM " + "WHERE ID=?";
//      PreparedStatement pstmt = conn.prepareStatement(sql);
//      ResultSet rs = pstmt.executeQuery();
      
      

      dto.setId(JOptionPane.showInputDialog("휴대폰 번호를 입력하세요"));

      
      if (((dto).getId()).matches(CONFIRM) && dto.getId().length() == 11) {
         System.out.println(checkMember(dto.getId()));
         if(checkMember(dto.getId()) != 0) {
            System.out.println("중복된 휴대폰 번호입니다.");
            crId();               
         } else {
            JOptionPane.showMessageDialog(null, "휴대폰 번호가 정상적으로 입력되었습니다.");
         }
//         Membercheck();
         // 이름 입력 폼();
      } else {
         JOptionPane.showMessageDialog(null, "정상적인 휴대폰번호 형식이 아닙니다.\n다시 입력해주세요");
         crId();
      }
      Crname();
      boolean result = userInsert();
      
   }

   private void Crname() {                                                                                                   //이름 넣는 영역
      final String CONFIRM = "^[가-힣]*$";
      
      
      dto.setName(JOptionPane.showInputDialog(null, "이름을 입력해주세요."));
      if (dto.getName().matches(CONFIRM)) {

         JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.\n회원 가입일 : " + new_date.format(date_now));
         dto.setcDate(new_date.format(date_now));
         
         System.out.println(dto.getId());
         System.out.println(dto.getName());
         System.out.println(dto.getcDate());
         
      } else {
         JOptionPane.showConfirmDialog(null, "정상적인 이름 형식이 아닙니다.\n 다시 입력바랍니다.");
         Crname();
      }
      getConnection();
   }

   
   
   
   
   
   private static Connection getConnection() {                                                                        //DB에 커넥트
      Connection conn = null;
      try {
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##beautea37", "123");
         System.out.println("연결 완료!!");
      } catch (SQLException e) {
          System.out.println("DB를 연결하지 못했습니다");
      }
      return conn;
   }
   
   
   
   public boolean userInsert() {                                                                                                //dto 삽입
      String sql = " INSERT INTO MEM(ID, NAME, CDATE, POINT) " 
               + " VALUES(?, ?, ?, ?) ";
      
      Connection conn = getConnection();
      PreparedStatement psmt = null;
      
      int count = 0;
      System.out.println("ID :" + dto.getId());
      System.out.println("Name :" + dto.getName());
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
         e.printStackTrace();
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



   public static void main(String[] args) {
      new LoginDAO2();
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   }
}