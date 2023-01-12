package jfcEx;
/*
 * JTable : 데이터를 엑셀(그리드) 형식으로 보여주는 컴포넌트.
 * 데이터와 컬럼명은 배열,DataModel,Vector 로 줄 수 있는데,
 * 처음은 배열로만 생성해 봅니다.
 * 
 * 데이터 값으로는 첫번째 파라미터인 다중배열이 사용되는데, 하나의 Inner 배열이
 * 하나의 Row 를 구성합니다.
 * 컬럼명또한 배열로 주게되면, 자동으로 순차적으로 배치되어집니다.
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableEX1 extends JFrame{
	
	JRootPane jrp;
	Container con;
	
	//데이터를 구성하는 다중배열 초기화
	String[][] str = {{"1_1","1_2","1_3","1_4"},{"2_1","2_2","2_3","2_4"},
			{"3_1","3_2","3_3","3_4"}};
	//컬럼명을 구성하는 싱글배열 초기화
	String str1[] = {"1번 컬럼","2번 컬럼","3번 컬럼"};
	JTable jt = new JTable();
	//데이터가 가변일때는 반드시 스크롤이 필요함..
	JScrollPane jsp = new JScrollPane(jt);
	
	public JTableEX1() {
		this.init();
		this.start();
		
		this.setSize(300, 200);
		this.setVisible(true);
	}
	void init() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North",new JLabel("JTable 예제", JLabel.CENTER));
		
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		jp.add(new JButton("확인"));
		jp.add(new JButton("취소"));
		
		con.add("South",jp);
		con.add("Center",jsp);
		
	}
	void start() {
		
	}

	public static void main(String[] args) {
		new JTableEX1();
	}

}
