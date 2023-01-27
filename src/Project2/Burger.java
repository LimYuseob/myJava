package Project2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import org.w3c.dom.html.HTMLIsIndexElement;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class Burger extends JFrame {

	private JPanel contentPane;
	ArrayList<String> orderList = new ArrayList<String>();
	ArrayList<Integer> priceList = new ArrayList<Integer>();
	int sum=0;
	String res = "";
	JList list;
	JTextArea txtrD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Burger frame = new Burger();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Burger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("** \uAD7F\uBC84\uAC70 \uD584\uBC84\uAC70 \uC785\uB2C8\uB2E4 **");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(56, 24, 223, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB4DC\uC2E4 \uBA54\uB274\uB97C \uC120\uD0DD\uD558\uC138\uC694");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1.setBounds(376, 24, 223, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnHotBurger = new JButton("\uB9E4\uC6B4 \uC18C\uC2A4 \uD584\uBC84\uAC70 : 4500");
		btnHotBurger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderList.add("매운 소스 햄버거");
				priceList.add(4500);
				
				
			}
		});
		btnHotBurger.setBounds(75, 127, 193, 35);
		contentPane.add(btnHotBurger);
		
		JButton btnShrimpBurger = new JButton("\uC57C\uCC44 \uC0C8\uC6B0 \uD584\uBC84\uAC70 : 4500");
		btnShrimpBurger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderList.add("야채 새우 햄버거");
				priceList.add(4500);
			}
		});
		btnShrimpBurger.setBounds(75, 286, 193, 35);
		contentPane.add(btnShrimpBurger);
		
		
		JButton btnBeefBurger = new JButton("\uB354\uBE14 \uBE44\uD504 \uD584\uBC84\uAC70 : 7000");
		btnBeefBurger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderList.add("더블 비프 햄버거");
				priceList.add(7000);
			}
		});
		btnBeefBurger.setBounds(394, 127, 193, 35);
		contentPane.add(btnBeefBurger);
		
		JButton btnTomatoBurger = new JButton("\uC138\uACB9 \uD1A0\uB9C8\uD1A0 \uD584\uBC84\uAC70 : 5500");
		btnTomatoBurger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderList.add("세겹 토마토 햄버거");
				priceList.add(5500);
				
			}
		});
		btnTomatoBurger.setBounds(394, 286, 193, 35);
		contentPane.add(btnTomatoBurger);

		JButton btnOrder = new JButton("\uC8FC\uBB38\uD569\uB2C8\uB2E4");
		btnOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i=0 ; i<=orderList.size()-1;i++ ) {
					res += String.format("%s : %d\n", orderList.get(i), priceList.get(i));
					sum+=priceList.get(i);
					
				}
				res += String.format("\n합계 금액 : %d\n", sum);
//				JOptionPane.showMessageDialog(null, res);
				JOptionPane.showConfirmDialog(btnOrder , res, "주문목록", JOptionPane.YES_NO_OPTION);
				res="";
				sum=0;
				orderList.clear();
				priceList.clear();
				list.setEnabled(true);
			}
		});
		btnOrder.setBackground(Color.ORANGE);
		btnOrder.setBounds(75, 425, 193, 66);
		contentPane.add(btnOrder);
		
		JButton btnReset = new JButton("\uCDE8\uC18C\uD569\uB2C8\uB2E4");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(btnReset, "취소했습니다.");
				orderList.clear();
				priceList.clear();
				list.setEnabled(true);
			}
		});
		btnReset.setBackground(Color.YELLOW);
		btnReset.setBounds(394, 425, 193, 66);
		contentPane.add(btnReset);
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!list.getValueIsAdjusting()) {
					int index1=list.getSelectedIndex();
					String indexElement1 =(String) list.getModel().getElementAt(index1);
				if(indexElement1.equals("노량진")) {
					sum-=1000;
				}
				list.setEnabled(false);
			}
			}	
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"\uB178\uB7C9\uC9C4", "\uB178\uB7C9\uC9C4 \uC678"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(75, 546, 181, 44);
		contentPane.add(list);
		
		txtrD = new JTextArea();
		txtrD.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
			}
		});
		txtrD.setText(String.format("%d개 선택",orderList.size()));
		txtrD.setBounds(394, 529, 193, 108);
		contentPane.add(txtrD);
	}
}