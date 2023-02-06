package Day32_Io_Net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;




public class AAAA {

   private AAAA() throws IOException {
      check();
   }
   
   private void check() throws IOException {
      Properties prop = new Properties();
      prop.load(ClassLoader.getSystemResourceAsStream("jjg5.properties"));
      FileOutputStream fos = null;
      String userPass;
      String checkPass = prop.getProperty("pw");
      String newPass;
      
      System.out.println(checkPass);
      
      userPass = JOptionPane.showInputDialog("기존 비밀번호를 입력하세요");
     try {
		
      if(!userPass.equals(checkPass)){
    	  System.out.println("틀림");}
    	  if(userPass.equals(checkPass)){
    		  System.out.println("같음");
      }
      while(true) {
    	  
      
      
      if(userPass.equals(checkPass)) {
    	  newPass = JOptionPane.showInputDialog("새로운 비밀번호를 입력하세요");
          prop.setProperty("pw", newPass);
          prop.store(new FileOutputStream("D:\\jjg\\myjava\\src\\jjg5.properties"),
                        null);
          //System.out.println(newPass);
       
          JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
          fos.close();
          break;
      }
      else if(!userPass.equals(checkPass)) {
         
         JOptionPane.showInputDialog("비밀번호가 틀립니다. 다시 입력하세요");
         userPass = JOptionPane.showInputDialog("기존 비밀번호를 입력하세요");
         continue;
         
         
        
         }
      
      }
      fos.close();
     } catch (Exception e) {
    	 // TODO: handle exception
    	 System.out.println(e.getMessage());
     } 
      }

      
      
   

   public static void main(String[] args) throws IOException  {
      
      AAAA s = new AAAA();
      
      

   }

}