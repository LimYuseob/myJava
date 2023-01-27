package projetctgu;

import java.util.Date;

public class OrderDTO {

	private Date odate;
	private String onum;
	private int oseq;
	private String mname;
	private String pcode;
	private String pname;
	private int price;
	private int pprice;
	private int stock;
	private String id;
	private String memchk;
	private String pack;
	private Object[][] allOrder;
	private String payDiv;
	private String mcode;
	private String onum_new;
    private String name;
    
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	private String cDate;
    private int point;
	
	public String getOnum_new() {
		return onum_new;
	}
	public void setOnum_new(String onum_new) {
		this.onum_new = onum_new;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPayDiv() {
		return payDiv;
	}
	public void setPayDiv(String payDiv) {
		this.payDiv = payDiv;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	
	public String getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public String getOnum() {
		return onum;
	}
	public void setOnum(String onum) {
		this.onum = onum;
	}
	public int getOseq() {
		return oseq;
	}
	public void setOseq(int oseq) {
		this.oseq = oseq;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemchk() {
		return memchk;
	}
	public void setMemchk(String memchk) {
		this.memchk = memchk;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Object[][] getAllOrder() {
		return allOrder;
	}
	public void setAllOrder(Object[][] allOrder) {
		this.allOrder = allOrder;
	}
	public void setOdate(String valueOf) {
		// TODO 자동 생성된 메소드 스텁
		
	}
}
