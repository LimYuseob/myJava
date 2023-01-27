package projetctgu;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Menu {

	String[] ma = new String[10];
	int[] pri = new int[10];
	int[] su = new int[10];
	int[] a = new int[10];
	HashMap<Object, Object> map = new HashMap<>();
	String h;
	boolean b = false;
	JPanel m1;

	String ma1;
	int a1;
	boolean b12 = false;
	JPanel m2;
	Object pri1;

	JPanel[] m = new JPanel[10];

	JLabel[] l1 = new JLabel[10];
	JLabel[] l2 = new JLabel[10];
	JLabel[] l3 = new JLabel[10];
	JButton[] minus = new JButton[10];
	JLabel[] l4 = new JLabel[10];
	JButton[] plus = new JButton[10];
	HashMap<Integer, List> od = new HashMap<>();

	private JFrame frame;
	private Connection conn;
	private DefaultTableModel datamodel;
	Object[] header = { "종류", "상품", "수량", "가격" };// 주문 목록의 항목들
	Object[] order = null;;
	private JPanel table;
	private int row = -1;
	JPanel panel2 = new JPanel();
	JPanel cofMenu = new JPanel();
	JPanel teaMenu = new JPanel();
	JPanel adeMenu = new JPanel();
	JPanel etcMenu = new JPanel();
	JButton add;
	JButton reduce;
	List<List<Object>> myList;
	HashMap<Object,Object[]> e=new HashMap<Object,Object[]>();

	Object[] iceCof = { "커피", "ice커피", 1, 1500 };
	Object[] hotCof = { "00000001","01", "Hot커피", 1, 1500 };
	Object[] espresso = { "커피", "에스프레소", 1, 2000 };
	Object[] blacktea = { "차", "실론티", 1, 3000 };
	Object[] euracha = { "차", "으라차차", 1, 3000 };
	Object[] hubtea = { "차", "허브티", 1, 3000 };
	Object[] greentea = { "차", "녹차", 1, 3000 };
	Object[] lemonade = { "음료", "레몬에이드", 1, 4500 };
	Object[] cherryade = { "음료", "체리에이드", 1, 4500 };
	Object[] random = { "음료", "랜덤에이드", 1, 4500 };
	private JTextField textField;
	private JTextField textField_1;
	OrderDTO odto;
	private String mcode;
	private String price;
	private String pcode;
	private String stock;
	/**
	 * Launch the application.
	 */
	private static Menu instance = new Menu();

	public static Menu getInstance() {
		return instance;

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
	
//		getMenu();
		initialize(); 

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel lblNewLabel = new JLabel("<java coffee>");
		panel.add(lblNewLabel);

		frame.getContentPane().add(panel2, BorderLayout.CENTER);
		panel2.setLayout(null);


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(70, 516, 520, 200);
		panel2.add(scrollPane);

		// jtable정기
		table = new JPanel();
		table.setLayout(null);
		scrollPane.setViewportView(table);

		// 장바구니 판넬 생성

		JPanel[] m = new JPanel[10];

		
		// 장바구니 판넬 버튼 구현

		for (int i = 0; i < 10; i++) {
			// 판넬 데이터 유무 확인
			map.put(i, "0");

			// 판넬 구현
			m[i] = new JPanel();
			m[i].setBounds(0, 0 + 50 * i, 490, 50);
			m[i].setBackground(Color.white);
			table.add(m[i]);
			m[i].setLayout(null);
			m[i].setVisible(b);

			// 메뉴 라벨

			l1[i] = new JLabel("메뉴 " + (i + 1));

			m[i].add(l1[i]);
			l1[i].setBounds(0, 0, 50, 50);
			l1[i].setVisible(true);

			// 커피명
			l2[i] = new JLabel(ma[i]);
			m[i].add(l2[i]);
			l2[i].setBounds(100, 0, 100, 50);
			l2[i].setVisible(true);

			// 가격
			l3[i] = new JLabel(String.valueOf(pri[i]));
			m[i].add(l3[i]);
			l3[i].setBounds(250, 0, 100, 50);
			l3[i].setVisible(true);
			// 수량
			l4[i] = new JLabel(String.valueOf(su[i]));
			l4[i] = new JLabel();
			m[i].add(l4[i]);
			l4[i].setBounds(450, 0, 50, 50);
			l4[i].setVisible(true);
			// 플러스 마이나스
			minus[i] = new JButton("  -  ");
			m[i].add(minus[i]);
			minus[i].setBounds(400, 0, 50, 50);
			minus[i].setVisible(true);

			plus[i] = new JButton("  +  ");
			m[i].add(plus[i]);
			plus[i].setBounds(500, 0, 50, 50);
			plus[i].setVisible(true);

			// 수량
			a[i] = 0;

		}

		JButton asd = new JButton("주문");
		asd.setBounds(567, 516, 190, 80);
		asd.setVisible(true);
		asd.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				onumCreate();
				odto.setOnum(odto.getOnum_new());
				int result = 0;
				
				myList = Arrays.asList(Arrays.asList("01", pri[0], ma[0], su[0]));
						
				System.out.println(myList.get(0).get(0));
				System.out.println(myList.get(0).get(1));
				System.out.println(myList.get(0).get(2));
				System.out.println(myList.get(0).get(3));
				System.out.println(myList.size());
				String sql = "insert into orders(odate, onum, oseq, mcode, pcode, price, stock) values(?,?,?,?,?,?,?)";
				
				Connection con = getConnection();
				PreparedStatement pstmt = null;
				
				try {
				
					for (int i = 0; i < myList.size(); i++) {

					mcode = String.valueOf(myList.get(i).get(0));
					price = String.valueOf(myList.get(i).get(1));
					pcode = String.valueOf(myList.get(i).get(2));
					stock = String.valueOf(myList.get(i).get(3)); 
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, "2023-01-26");
					pstmt.setString(2, odto.getOnum());
					
					pstmt.setInt(3, i+1);//oseq
					
					pstmt.setString(4, String.valueOf(mcode));
					pstmt.setString(5, String.valueOf(pcode));
					pstmt.setString(6, String.valueOf(price));
					pstmt.setString(7, String.valueOf(stock));
					/*
					pstmt.setString(8, dto.getId());
					pstmt.setString(9, dto.getMemchk());
					pstmt.setString(10, dto.getPack());
					*/
					result = pstmt.executeUpdate();
					}
					
					
				}catch (Exception e1) {
					System.out.println("orderDto 오류"+e1.getMessage());
				}finally {
					if(pstmt != null)
						try {
							pstmt.close();
							conn.close();
						}catch (Exception e2) {
							// TODO: handle exception
						}
				}



			}
		});

		panel2.add(asd);

	

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		tabbedPane.setBounds(12, 10, 762, 467);
		tabbedPane.add("     C o f f e e     ", cofMenu);
		tabbedPane.add("     T e a     ", teaMenu);
		tabbedPane.add("     A d e     ", adeMenu);
		tabbedPane.add("     E t c     ", etcMenu);

		// cofMenu
		cofMenu.setBounds(0, 118, 786, 370);
		cofMenu.setLayout(null);
		JButton btnNewButton_3 = new JButton("Ice커피");
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_3.setBounds(47, 10, 150, 150);
		cofMenu.add(btnNewButton_3);



		JButton btnNewButton_4 = new JButton("Hot커피");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 빈곳을 찾을순 있다
				// 이미 있는지는 못찾는다
				int i = 0;
				for (Object key : map.keySet()) {
					Object value = map.get(key);
//			            System.out.println("Iterating, key: " + key);

					if (value == "Hot커피") {
						System.out.println("key of the value 2: " + key);
					} else if (value == "0") {
						key = i;
					}
				}

				if (true) {
					b = true;
					m[i].setVisible(b);

					a[i]++;
					l4[i].setText(String.valueOf(a[i]));

					// 메뉴 명
					ma[i] = String.valueOf(hotCof[1]) ;
					l2[i].setText(ma[i]);
					// 가격
					pri[i] = (int) hotCof[3];
					l3[i].setText(String.valueOf(pri[i]));

				} else {
					a[i]++;
					l3[i].setText(String.valueOf(a[i]));
				}
			}
		});
		btnNewButton_4.setBounds(222, 10, 150, 150);
		cofMenu.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("에스프레소");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				datamodel.addRow(espresso);
			}
		});
		btnNewButton_5.setBounds(395, 10, 150, 150);
		cofMenu.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("상품준비중");
		btnNewButton_6.setBounds(574, 10, 150, 150);
		cofMenu.add(btnNewButton_6);

		textField_1 = new JTextField();
		textField_1.setText("1500원");
		textField_1.setFont(new Font("굴림", Font.BOLD, 20));
		textField_1.setBounds(79, 170, 78, 30);
		cofMenu.add(textField_1);
		textField_1.setColumns(10);

		// teaMenu
		teaMenu.setBounds(0, 118, 786, 370);
		teaMenu.setLayout(null);
		JButton btnNewButton_31 = new JButton("실론티");

		btnNewButton_31.setBounds(47, 10, 150, 150);
		teaMenu.add(btnNewButton_31);

		JButton btnNewButton_41 = new JButton("허브티");

		btnNewButton_41.setBounds(222, 10, 150, 150);
		teaMenu.add(btnNewButton_41);

		JButton btnNewButton_51 = new JButton("녹차");

		btnNewButton_51.setBounds(395, 10, 150, 150);
		teaMenu.add(btnNewButton_51);

		JButton btnNewButton_61 = new JButton("으라차차");

		btnNewButton_61.setBounds(574, 10, 150, 150);
		teaMenu.add(btnNewButton_61);

		// adeMenu
		adeMenu.setBounds(0, 118, 786, 370);
		adeMenu.setLayout(null);
		JButton btnNewButton_311 = new JButton("레몬에이드");

		btnNewButton_311.setBounds(47, 10, 150, 150);
		adeMenu.add(btnNewButton_311);

		JButton btnNewButton_411 = new JButton("체리에이드");

		btnNewButton_411.setBounds(222, 10, 150, 150);
		adeMenu.add(btnNewButton_411);

		JButton btnNewButton_511 = new JButton("랜덤에이드");

		btnNewButton_511.setBounds(395, 10, 150, 150);
		adeMenu.add(btnNewButton_511);

		JButton btnNewButton_611 = new JButton("상품준비중");

		btnNewButton_611.setBounds(574, 10, 150, 150);
		adeMenu.add(btnNewButton_611);

		panel2.add(tabbedPane);

	}

	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##jisay", "0000");

			System.out.println("컨넥션 ok 정보 --> " + conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Connection 생성시 예외 발생함");
			System.out.println("예외 내용 : " + e.getMessage());
		}
		return conn;
	}

	public void onumCreate() {
		String sql2 = "select lpad(max(onum) + 1,4,'0') onum_new from orders where odate = ? group by odate";
		ResultSet rs = null;
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			odto = new OrderDTO();
			String ls_date = "2023-01-26";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, ls_date);

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				odto.setOnum_new(rs.getString("onum_new"));
			} else {
				odto.setOnum_new("0001");
				
			}
			pstmt.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	

}