package jfcEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class FormEx2__Event1 extends JFrame {

	private Container con;
	//Icon 타입중에 이미지 Icon 객체를 이용해서 Image 를 얻어냅니다.
	private ImageIcon im;
	private ImageIcon im1;
	JButton bt1 = new JButton("이건 1버튼입니다.");
	JButton bt2 = new JButton("이건 2버튼입니다.");
	JButton bt3 = new JButton("이건 3버튼입니다.");
	JButton bt4 = new JButton("이건 4버튼입니다.");
	
		public FormEx2__Event1() {
			super("이건 JFrame 타이틀 제목입니다.");
			init();// --> 초기화 메서드 호출해서 레이아웃이나, 컨테이너에 붙일
			//컴포넌트 add 하거나 생성 하는 작업을 수행 합니다.
			start();//이벤트 연결, 등록 및 쓰래드 작업등, 컨테이너가 화면에 보이기 전에
			//수행할 작업등을 정의합니다.
			
			
			this.setIconImage(im.getImage());
			this.setIconImage(im1.getImage());
			this.setSize(300, 200);
			
			//이번엔 영역객체인 Dimension 을 이용해서 프레임을 화면 중간에 띄웁니다.
			//이때 사용하는 대표적 객체가 Tookit 이라는 객체입니다.
			//static 메서드를 이용해서 얻어내는데, 화면의 크기, 해상도, 음성 출력등
			//시스템 전반적인 내용을 리턴하는 객체입니다.
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension dm = tk.getScreenSize();
			Dimension dm1 = this.getSize();
			
			int x = (int)(dm.getWidth()/2 - dm.getWidth()/2);
			int y = (int)(dm.getHeight()/2 - dm.getHeight()/2);
			
			//좌표값을 정의한 Point 객체를 이용해서 위 좌표값을 설정함.
			Point p = new Point(x, y);
			
			this.setLocation(p);
			this.setVisible(true);
		}
	private void init() {
		im = new ImageIcon("Icon.png");
		im1 = new ImageIcon("cup-2.png");
		//JFrame 에서 contentPane() 을 호출하여 Container 를 얻어낸다.
		//이 위에 컴포넌트를 부탁한다.
		con = this.getContentPane();
		//배치관리자를 컨테이너에 지정합니다.FlowLayout 배치관리자입니다.
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton bt5 = new JButton("이건 5버튼입니다.", im);
		
		bt1.setEnabled(false);
		bt2.setMnemonic('a');
		bt3.setHorizontalAlignment(SwingConstants.RIGHT);
		bt3.setVerticalAlignment(SwingConstants.TOP);
		bt4.setMnemonic('b');
		bt1.setPressedIcon(im);
		bt1.setRolloverIcon(im1);
		
		bt1.setBounds(50, 50, 100, 100);//버튼크기지정
		bt2.setBackground(Color.blue);
		bt3.setEnabled(false);//버튼 비활성화 시키기
		//Color 객체는 기본컬러에 대한 상수를 이용하거나, RGB 를 이용한
		//생성자를 호출하여 해당 색상에 대한 컬러 객체를 얻어낼수 있습니다.
		bt4.setForeground(Color.cyan);//문자열컬러변경
		//Font 객체를 이용해서 서체,굵기,크기, 등을 지정할 수 있습니다.
		//생성자를 확인해 보시면 쉽게 알수 있습니다.
		bt5.setFont(new Font("궁서체",Font.BOLD,20));
		
		bt5.setOpaque(true);//투명도 설정
		bt5.setToolTipText("안녕하세요 이건 툴팁 내용입니다.");
		bt5.updateUI();
		
		con.add(bt1);
		con.add(bt2);
		con.add(bt3);
		con.add(bt4);
		con.add(bt5);
	}
	//x 를 누르면 프로그램 종료하도록 이벤트를 적용 합니다.
	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컴포넌트에 이벤트를 등록한다..addXXXListner(구현객체) 를 이용하면 된다.
		bt1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁
				//마우시가 클릭되면 자동호출되는 메서드입니다.
				System.out.println(e.getSource()+ " 를 클릭하셨습니다.");
				System.out.println(e);
				//이벤트 대상 객체를 찾아보기..getSource()
				if(e.getSource() == bt1) {
					//bt1 버튼을 활성화 시키고, 5초동안 지가 지를 클릭하도록 반듭니다.
					bt1.setEnabled(true);
					bt1.doClick(5000);
				}
			}
		});
	}
	
	
	public static void main(String[] args) {
		
		new FormEx2__Event1();
		//JFrame 을 구성하는 방법
		//1.생성자를 호출하여 구성하기
		//2.상속을 받아, 받은 클래스가 JFrame 되기
		
		//프레임 객체를 생성합니다.
		//JFrame jf = new JFrame();
		//프레임 사이즈를 정한다.
		//jf.setSize(300, 500);
		//jf.setLocation(300, 300);
	}

}
