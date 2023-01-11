package jfcEx;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDialogEx extends JFrame implements ActionListener {
	
	private Container con;
	private FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
	private JLabel lb = new JLabel("ID : " + JLabel.LEFT);
	private JTextField jf = new JTextField(10);
	private JDialog jb = new JDialog(this,"팝업창");
	private Container dlgcon;//Dialog 도 컨테이너 타입이기 때문에 배치 관리자 및
	//컨테이너가 필요함. dlgcon 은 다이얼로그 배치 컨테이너 로 사용됨.
	JLabel dlglb = new JLabel("사용 가능한 ID입니다",JLabel.CENTER);
	BorderLayout bd = new BorderLayout();
	
	public JDialogEx() {
		init();
		start();
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	private void init() {
		con = this.getContentPane();//컨테이너 리턴.
		con.setLayout(f1);
		con.add(lb);
		con.add(jf);
		
		//다이얼로그에도 컴포넌트를 add 시키려면 작업대인 Container 가 필요합니다.
		dlgcon = jb.getContentPane();
		//레이아웃 지정
		dlgcon.setLayout(bd);
		//다이얼로그에 라벨 add
		dlgcon.add("Center",dlglb);
		jb.setSize(200, 200);
		jb.setLocation(500, 500);
	}
	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//텍스트박스에 액션 이벤트 연동합니다.
		jf.addActionListener(this);
		jb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jf) {
			jb.setVisible(true);
		}
		
	}

}
