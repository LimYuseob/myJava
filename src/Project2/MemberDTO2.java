package Project2;

import java.util.Date;

public class MemberDTO2 {
      
      private String id;
      private String name;
      private String cDate;

      
      public String getId() {
         return id;
      }

      public void setId(String id) {                           //휴대폰번호 get, set
         this.id = id;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {                     //이름 get, set
         this.name = name;
      }

      public String getcDate() {
         return cDate;
      }

      public void setcDate(String cDate) {                     //회원가입일 get, set
         this.cDate = cDate;
      }

      



      
      
   }