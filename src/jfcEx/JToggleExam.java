package jfcEx;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

/*
 * 토글버튼 : 다중의 버튼중 하나만 선택 가능하도록 정의된 버튼 타입
 * 이 버튼들은 그룹으로 묶어서 관리해야 그 기능이 활성화 되어지는데
 * 이때 사용되는 그룹이 ButtonGroup 입니다.
 */
public class JToggleExam extends JFrame {

	private Container con;
	
	//Grid 레이아웃 : 격자모양으로 컴포넌트를 배치하는 레이아웃
	//아래의 파라미터 4개는 각각, row, column, hgaP(상하여백), vgrap(좌우여백)
	//을 뜻합니다.
	private GridLayout grid = new GridLayout(2, 2, 5, 5);
	private JToggleButton tb = new JToggleButton("1",true);
	//1은 text, true 는 선택여부;
	private JToggleButton tb1 = new JToggleButton("2",false);
	private JToggleButton tb2 = new JToggleButton("3",false);
	private JToggleButton tb3 = new JToggleButton("4",false);
	private JToggleButton tb4 = new JToggleButton("5",false);
	
	//위의 토글 버튼을 그룹으로 관리하는 ButtonGroup 객체 생성
	ButtonGroup bg = new ButtonGroup();
	
	public JToggleExam() {
		init();
		start();
		//this.pack();//VM 에게 프레임사이즈를 일임하는것.
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	private void init() {
		con = this.getContentPane();
		con.setLayout(grid);
		
		//버튼그룹에 버튼을 Add 시킵니다.
		bg.add(tb);
		bg.add(tb1);
		bg.add(tb2);
		bg.add(tb3);
		bg.add(tb4);
		
		//토글버튼을 컨테이너에 Add 시킵니다.
		con.add(tb);
		con.add(tb1);
		con.add(tb2);
		con.add(tb3);
		con.add(tb4);
	}
	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JToggleExam();
	}

}
