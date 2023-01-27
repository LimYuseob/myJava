package projetctgu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Member {

	private JFrame frame;
	private DefaultTableModel datamodel;
	private Connection conn;
	Object[] header = { "종류", "상품", "수량", "가격" };// 주문 목록의 항목들
	Object[][] orders = getOrder();
	OrderDTO odto;
	private JTable table;
	private ImageIcon img;

	/**
	 * Launch the application.
	 */
	private static Member login = new Member();
	
	public static Member getInstance() {
		return login;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member window = new Member();
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
	public Member() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		odto = new OrderDTO();
		frame = new JFrame("Java Coffie SHOP");
		frame.setBounds(0, 0, 600, 800);
		img = new ImageIcon("Menuimg\\cup-2.png");
		frame.setIconImage(img.getImage());
		frame.setLocationRelativeTo(frame);
	    frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		//panel2
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 0, 600, 800);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("주문 목록");
		lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 30));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setBounds(50, 20, 133, 90);
		panel2.add(lblNewLabel_1);
		
		datamodel = new DefaultTableModel(orders, header);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(40, 120, 500, 300);
		panel2.add(scrollPane);
		table = new JTable(datamodel);
		scrollPane.setViewportView(table);
	
		//회원버튼
		JButton btnNewButton = new JButton("회원 주문");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CheckId.getInstance();
				updIdmemchk(odto);
			}
		});
		btnNewButton.setBounds(33, 550, 140, 80);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
		panel2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("비회원 주문");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odto.setMemchk("N");
				Pay.getInstance();
				updIdmemchk(odto);
			}
		});
		btnNewButton_1.setBounds(405, 550, 140, 80);
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 18));
		panel2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("회원 가입");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updIdmemchk(odto);
				new LoginDAO();
			}
		});
		btnNewButton_2.setBounds(220, 550, 140, 80);
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 18));
		panel2.add(btnNewButton_2);
		
		img = new ImageIcon("Menuimg\\cofb3.jpg");
	    JLabel lb1 =new JLabel(null,img,JLabel.CENTER);
	    lb1.setBounds(0,0,600,800);
	    panel2.add(lb1);
		
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
	public Object[][] getOrder() {
		Vector<OrderDTO> members = null;
		Object[][] allOrder = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		if (this.conn == null) {
		}
		String sql = "select c.odate odate, c.onum onum, c.oseq oseq, c.pcode pcode, c.id id, c.memchk memchk, c.pack pack,  a.mname mname , "
				+ "b.pname pname , c.stock stock , c.price price from orders c, menu a, prod b "
				+ "where c.odate = ? and c.onum = ? and a.mcode = c.mcode and a.mcode = b.mcode and c.pcode = b.pcode";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "20230120");
			pstmt.setString(2, "0001");

			rs = pstmt.executeQuery();

			if (rs.next()) {

				members = new Vector<OrderDTO>();

				do {

					odto = new OrderDTO();
					odto.setOdate(rs.getDate("odate"));
					odto.setOnum(rs.getString("onum"));
					odto.setOseq(rs.getInt("oseq"));
					odto.setPname(rs.getString("pname"));
					odto.setPcode(rs.getString("pcode"));
					odto.setPrice(rs.getInt("price"));
					odto.setStock(rs.getInt("stock"));
					odto.setId(rs.getString("id"));
					odto.setMemchk(rs.getString("memchk"));
					odto.setPack(rs.getString("pack"));
					odto.setMname(rs.getString("mname"));

					// odto의 값이 모두 완료되면 members에 담습니다

					members.add(odto);

					allOrder = new Object[members.size()][4];

					for (int i = 0; i < members.size(); i++) {

						allOrder[i][0] = members.get(i).getMname();
						allOrder[i][1] = members.get(i).getPname();
						allOrder[i][2] = members.get(i).getStock();
						allOrder[i][3] = members.get(i).getPrice();

					}
					odto.setAllOrder(allOrder);

				} while (rs.next());
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("null발생 " + e.getMessage());
			e.printStackTrace();
		}

		return allOrder;

	}
	public int updIdmemchk(OrderDTO odto) {
		int result = 0;
		String sql = "update orders set id = ?, memchk = ?"
						  + "where odate = ? and  onum = ?";
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, odto.getId());
			pstmt.setString(2, odto.getMemchk());
			pstmt.setString(3, odto.getcDate());
			pstmt.setString(4, odto.getOnum());
			pstmt.executeUpdate();
		}catch (Exception e1) {
			System.out.println("orderDTO 오류"+e1.getMessage());
			e1.setStackTrace(null);
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
}
