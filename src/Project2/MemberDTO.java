package Project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;




public class MemberDTO {
	MemberDTO memDTO;
	MemberDAO memDAO;
	//회원 Member (기제)
//////////////////////////////////////////////////////
private String Mid;
private String Mname;
private Date Mcdate;
private int Mpoint;

//메뉴 Menu (유섭)
//////////////////////////////////////////////////////

private String MMcode;
private String MPcode;
private String MPname;
private int MNpric;

//결제 Pay (지석)
//////////////////////////////////////////////////////

private Date Pdate;
private String Pnumber;
private int Pcash;
private int Pcheck;
private String Pid;
private int Pprice;

//주문 Order (정기)
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

   

   
  	public MemberDTO() {
		this.memDAO = memDAO;
	}

public MemberDTO getMemDT() {
	return memDTO;
}

public void setMemDT(MemberDTO memDT) {
	this.memDTO = memDT;
}

public String getMid() {
	return Mid;
}

public void setMid(String mid) {
	Mid = mid;
}

public String getMname() {
	return Mname;
}

public void setMname(String mname) {
	Mname = mname;
}

public Date getMcdate() {
	return Mcdate;
}

public void setMcdate(Date mcdate) {
	Mcdate = mcdate;
}

public int getMpoint() {
	return Mpoint;
}

public void setMpoint(int mpoint) {
	Mpoint = mpoint;
}



public int getMNpric() {
	return MNpric;
}

public void setMNpric(int mNpric) {
	MNpric = mNpric;
}



public String getMMcode() {
	return MMcode;
}

public void setMMcode(String mMcode) {
	MMcode = mMcode;
}

public String getMPcode() {
	return MPcode;
}

public void setMPcode(String mPcode) {
	MPcode = mPcode;
}

public String getMPname() {
	return MPname;
}

public void setMPname(String mPname) {
	MPname = mPname;
}

public Date getPdate() {
	return Pdate;
}

public void setPdate(Date pdate) {
	Pdate = pdate;
}

public String getPnumber() {
	return Pnumber;
}

public void setPnumber(String pnumber) {
	Pnumber = pnumber;
}

public int getPcash() {
	return Pcash;
}

public void setPcash(int pcash) {
	Pcash = pcash;
}

public int getPcheck() {
	return Pcheck;
}

public void setPcheck(int pcheck) {
	Pcheck = pcheck;
}

public String getPid() {
	return Pid;
}

public void setPid(String pid) {
	Pid = pid;
}

public int getPprice() {
	return Pprice;
}

public void setPprice(int pprice) {
	Pprice = pprice;
}

public Date getOdate() {
	return Odate;
}

public void setOdate(Date odate) {
	Odate = odate;
}

public int getOnum() {
	return Onum;
}

public void setOnum(int onum) {
	Onum = onum;
}

public int getOseq() {
	return Oseq;
}

public void setOseq(int oseq) {
	Oseq = oseq;
}

public String getOcode() {
	return Ocode;
}

public void setOcode(String ocode) {
	Ocode = ocode;
}

public int getOprice() {
	return Oprice;
}

public void setOprice(int oprice) {
	Oprice = oprice;
}

public int getOstock() {
	return Ostock;
}

public void setOstock(int ostock) {
	Ostock = ostock;
}

public String getOid() {
	return Oid;
}

public void setOid(String oid) {
	Oid = oid;
}

public int getOcheck() {
	return Ocheck;
}

public void setOcheck(int ocheck) {
	Ocheck = ocheck;
}

public int getOpack() {
	return Opack;
}

public void setOpack(int opack) {
	Opack = opack;
}

public static void setInstance(MemberDAO dao) {
}
}
