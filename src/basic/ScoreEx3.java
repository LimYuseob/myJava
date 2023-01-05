package basic;
import javax.swing.JOptionPane;

public class ScoreEx3 {
   public static void main(String[] args) {
      /*
       * 배열을 이용해서 3명의 성적관리 프로그램을 만든다. 전체적인 조건은 다 같되 한 명당 모든 성적입력이 올바르지 않을 경우엔 다음 사람
       * 성적이 입력되지 않는다.
       * 
       * 출력시 철수, 영희, 순애 순으로 철수님의 총점 : ? 평균 :
       * 
       * 단 이름값은 입력받지 아니한다.
       */

//   public static void main(String[] args) {
//      // TODO Auto-generated method stub
//      int score = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력하세요"));
//      float average = (float)score/3;
//            
//      
//      String[] fir = { "철수", "영희", "순애" };
//      String[] sec = {                          };
//      String[][] array = new String [fir][sec];
//      
//      System.out.println(person[0] + "님의 총점 : " + score + "평균 : " + );

////////////////////////////////////////////////////////

      /*
       * 선생님 풀이 사용자의 점수 입력받아서, 해당 점수 검증, 문제가 있으면 다시 입력케끔 만약 한 사용자의 점수가 모두 입력되었다면, 해당
       * 점수에 대해 총점, 평균도 한 번에 처리되도록
       */
      int[][] scores = new int[3][4];// 성적 담는 배열
      float[] avgs = new float[scores.length];// 평균 담는 배열
      String name[] = { "철수", "영희", "순애" };
      String subject[] = { "국어", "영어", "수학" };
      int isCorrect = -1; //입력 오류시 즉 점수의 범주가 벗어난 경우 alert출력 flag

      for (int i = 0; i < scores.length; i++) {
         for (int j = 0; j < scores[i].length - 1; j++) {
            do {
               if(isCorrect != 1) {
                  JOptionPane.showMessageDialog(null, "똑바로 쓰세요");
               }
               scores[i][j] = Integer.parseInt(JOptionPane.showInputDialog(name[i] + subject[j] + "점수 입력"));
               isCorrect++;
            } while (scores[i][j] < 0 || scores[i][j] > 100);
            isCorrect = -1;
            // i학생 성적 모두 기입한 상황
            scores[i][scores.length] += scores[i][j];
         } // inner for 끝난다는 의미는? 한 사람의 총점까지 완료됐다는 얘기.
         avgs[i] = (float) (scores[i][scores.length] / 3.0);
      }
      // 이 루프가 끝났다는 의미는 모든 학생의 총점, 평균 모두 완료됐다는 얘기.
      for (int i = 0; i < scores.length; i++) {
         System.out.println(name + " 님의 총점 : " + scores[i][scores.length] + ", 평균 : " + avgs[i]);
      }
   }
}