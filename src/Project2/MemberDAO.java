package Project2;

import java.io.IOException;
import java.sql.Date;

public class MemberDAO {

	MemberDTO memDTO;
	// 회원 Member (기제)
//////////////////////////////////////////////////////
	private String Mid;
	private String Mname;
	private Date Mcdate;
	private int Mpoint;

	// 메뉴 Menu (유섭)
	//////////////////////////////////////////////////////

	private String MNcode;
	private String MNname;
	private int MNpric;
	private int MNgroup;

	// 결제 Pay (지석)
	//////////////////////////////////////////////////////

	private Date Pdate;
	private String Pnumber;
	private int Pcash;
	private int Pcheck;
	private String Pid;
	private int Pprice;

	// 주문 Order (정기)
	//////////////////////////////////////////////////////
	private Date Odate;
	private int Onum;
	private int Oseq;
	private String Ocode;
	private int Oprice;
	private int Ostock;
	private String Oid;
	private int Ocheck;
	private int Opack;
	
	
	
	
	

	private static MemberDAO dao = new MemberDAO();

	public static MemberDAO getInstance() {
		
		return dao;
	}

	public MemberDAO() {
		memDTO = new MemberDTO();

	}

	public static void main(String[] args) {
	}
}
