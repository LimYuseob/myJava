package projetctgu;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class CheckId {
	private Connection conn;
	private JFrame cofch;
	private JPanel contentPane;
	private JLabel lblJoin;
	private JTextField tfUsername;
	private ImageIcon img;
	String checkId;
	OrderDTO odto;
	
	private static CheckId cheId = new CheckId();
	
	
	public static CheckId getInstance() {
		return cheId;
	}
	
	public CheckId() {
		initialize();
	}
	
	public int isMember(String id) {
		int result = 0;
		
		String sql = "Select count(id) from mem Where id = ?";
		try{
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			//조회(Select)는 executeQuery(sql)을 실행해야 합니다
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			return result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
		
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
	

	private void initialize() {
		odto = new OrderDTO();
		cofch = new JFrame("Java Coffie SHOP");
		cofch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cofch.setSize(300, 300);
		cofch.setLocationRelativeTo(null);
		img = new ImageIcon("Menuimg\\cup-2.png");
		cofch.setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		cofch.setContentPane(contentPane);
		
		lblJoin = new JLabel("회원로그인");
		lblJoin.setBounds(37, 86, 120, 20);
		Font f1 = new Font("돋움", Font.BOLD, 20); //궁서 바탕 돋움
		contentPane.setLayout(null);
		lblJoin.setFont(f1);
		contentPane.add(lblJoin);
		
		JLabel lblUsername = new JLabel("휴대폰번호");
		lblUsername.setBounds(37, 127, 69, 20);
		contentPane.add(lblUsername);
		
	
		
		
		
		tfUsername = new JTextField();
		tfUsername.setBounds(118, 120, 139, 35);
		contentPane.add(tfUsername);
		String id = tfUsername.getText();
		odto.setId(id);
		
		
		
		JButton chbtn = new JButton("입력완료");
		chbtn.setBounds(118, 180, 139, 29);
		contentPane.add(chbtn);
		
		cofch.setVisible(true);
		img = new ImageIcon("Menuimg\\cofbg2.jpg");
		Image mem1 = img.getImage();
	    Image mem2 = mem1.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	    img =  new ImageIcon(mem2);
	    JLabel lb3 = new JLabel(null,img,JLabel.CENTER);
	    lb3.setBounds(0, 0, 300, 300);
	    contentPane.add(lb3);
		//회원가입완료 액션
	    
		chbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource().equals(chbtn)) {
		               String id = tfUsername.getText();
		               cheId.odto.setId(id);
				if(isMember(odto.getId()) == 0) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다");
					
				}else {
					cheId.odto.setMemchk("Y");
					System.out.println("로그인하신 ID는 : " + cheId.odto.getId());
					Pay.getInstance();
					cofch.dispose();
				}
			}
		}
			
	});
  }
}
