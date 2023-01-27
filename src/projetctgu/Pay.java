package projetctgu;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Pay{

	private DefaultTableModel datamodel;
	JTable jt;
	private JFrame frame;
	private Connection conn;
	private JTextField textField;
	private JTable table;
	private ImageIcon img;
	
	OrderDTO dto;
	int sumPrice;

	private static Pay instance = new Pay();//싱글톤

	public static Pay getInstance() {
		return instance;

	}

	public Pay() {
		setPanel2();//주문 목록 확인창
	}




	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "yuseob", "1234");

			System.out.println("컨넥션 ok 정보 --> " + conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Connection 생성시 예외 발생함");
			System.out.println("예외 내용 : " + e.getMessage());
		}
		return conn;
	}

	public int payDto(OrderDTO dto) {
		int result = 0;
		String sql = "insert into pay(odate, onum, paydiv, id, memchk, pprice) values(?,?,?,?,?,?)";
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, (Date) dto.getOdate());
			pstmt.setString(2, dto.getOnum());
			pstmt.setString(3, dto.getPayDiv());
			pstmt.setString(4, dto.getId());
			pstmt.setString(5, dto.getMemchk());
			pstmt.setInt(6, dto.getPprice());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("payDto 오류"+e.getMessage());
		}finally {
			if(pstmt != null)
				try {
					pstmt.close();
					conn.close();
				}catch (Exception e2) {
					// TODO: handle exception
				}
		}
		return result;
	}
	private void setPanel2() {
		dto = new OrderDTO();
		frame = new JFrame("Java Coffie SHOP");// frame생성
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(0, 0, 600, 800);// frame위치설정
		img = new ImageIcon("Menuimg\\cup-2.png");
		frame.setIconImage(img.getImage());
		frame.setLocationRelativeTo(frame);
	    frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//메인카드패널
		JPanel cards = new JPanel(new CardLayout());
	    cards.setBounds(0,50,600,600);
	    
	    JPanel panel2 = new JPanel();
	    panel2.setBounds(0,0,600,800);
		panel2.setBackground(new Color(255, 255, 255));// 배경색상
		panel2.setLayout(null); // 버튼이나 라벨을 아무데나 붙이기 위해 기본값

		datamodel = new DefaultTableModel(
				Member.getInstance().orders, Member.getInstance().header);// 테이블에 들어갈 data
		jt = new JTable(datamodel);

		jt.setBounds(0, 0, 343, 219);// 테이블 위치
		panel2.add(jt);

		JScrollPane jsp = new JScrollPane(jt);// 스크롤생성
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(40, 120, 500, 300);
		panel2.add(jsp);

		JLabel lblNewLabel_1 = new JLabel("주문 목록");//주문목록 라벨
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		lblNewLabel_1.setBounds(50, 20, 133, 90);
		panel2.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("결제하기");//결제하기 버튼
		btnNewButton.setBounds(300, 600, 200, 50);//버튼 위치 설정
		panel2.add(btnNewButton);
		panel2.setVisible(true);
		
		
		
	    JPanel panel3 = new JPanel();
	    panel2.setBounds(0, 0, 600, 800);
		panel3.setLayout(null);
		JLabel lblNewLabel_4 = new JLabel("주문 목록");//주문 목록 라벨
		lblNewLabel_4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		lblNewLabel_4.setForeground(Color.white);
		lblNewLabel_4.setBounds(50, 20, 133, 90);
		panel3.add(lblNewLabel_4);

		JLabel lblNewLabel_2 = new JLabel("주문 번호");//주문번호 라벨
		lblNewLabel_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setBounds(50, 450, 133, 90);
		panel3.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("<html><body><center>주문이 완료되었습니다.<br>감사합니다. 잠시만 기다려주세요.</center></body></html>");//주문완료 라벨
		lblNewLabel_3.setBounds(80, 630, 600, 90);
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel3.add(lblNewLabel_3);

		textField = new JTextField();//주문번호 나오는 TextField
//		textField.setText(Member.getInstance().odto.getOnum());//Member instance에 세팅한 주문번호 호출
		textField.setBounds(200, 470, 180, 50);
		textField.setFont(new Font("한컴산뜻돋움", Font.BOLD, 50));
		panel3.add(textField);
		textField.setColumns(10);


//		datamodel = new DefaultTableModel(Member.getInstance().orders, Member.getInstance().header);//Member instance에 주문목록을 그대로 가져와서 출력
		table = new JTable(datamodel);//주문목록 table
		table.setBounds(12, 10, 350, 100);
		panel3.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(40, 120, 500, 300);
		panel3.add(scrollPane);
		scrollPane.setViewportView(table);
		
//		for(int i = 0; i<Member.getInstance().orders.length;i++) {//총 금액을 가져오기 위해 Member instance  로직
//			sumPrice += (int) Member.getInstance().orders[i][3];//마찬가지로 
//			dto.setPprice(sumPrice);
//		}
		dto.setPayDiv("1");
		
		JTextField textField_1 = new JTextField();
		textField_1.setText(String.valueOf(sumPrice));
		textField_1.setBounds(200, 560, 146, 32);
		panel3.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("총가격");
		lblNewLabel.setBounds(50, 530, 133, 90);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		panel3.add(lblNewLabel);
		
		payDto(dto);
		
		cards.add(panel2,"pay");
		cards.add(panel3,"payse");
		
		frame.getContentPane().add(cards);
		
		img = new ImageIcon("Menuimg\\cofb3.jpg");
	    JLabel lb1 =new JLabel(null,img,JLabel.CENTER);
	    lb1.setBounds(0,0,600,800);
	    panel2.add(lb1);
	    
	    img = new ImageIcon("Menuimg\\cofb3.jpg");
	    JLabel lb2 =new JLabel(null,img,JLabel.CENTER);
	    lb2.setBounds(0,0,600,800);
	    panel3.add(lb2);
		
		CardLayout cl = (CardLayout)cards.getLayout();
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.last(cards);
			}
		});
	}
	
	
		

	public static void main(String[] args) {
	}
}
