package miniprojects;

public class Tank {
	private double ver;
	private double hor;
	private double h8;
	private double sh; // 높이-gt 보다 크면안됨
	private double wh; // 높이-gt 보다 크면안됨
	private double gt; // gt는 0보다 작으면 안됨
	private double L;

	public void setVer(double ver) {
		this.ver = ver;
	}
	public void setHor(double hor) {
		this.hor = hor;
	}
	public void setH8(double h8) {
		this.h8 = h8;
	}
	public void setSH(double sh) {
		this.sh = sh;
	}
	public void setWH(double wh) {
		this.wh = wh;
	}
	public void setGT(double gt) {
		this.gt = gt;
	}		
	
	public double getVer() {
		return this.ver;
	}
	public double getHor() {
		return this.hor;
	}
	public double getH8() {
		return this.h8;
	}
	public double getWH() {
		return this.wh;
	}
	public double getSH() {
		return this.sh;
	}
	public double getGT() {
		return this.gt;
	}	
	
	public Tank() {
		
	}
	
	public Tank(double ver, double hor, double h8) {
		this.ver = ver;
		this.hor = hor;
		this.h8 = h8;
	}
	public Tank(double ver, double hor, double h8, double sh, double wh, double gt) {
		this.ver = ver;
		this.hor = hor;
		this.h8 = h8;
		this.sh = sh;
		this.wh = wh;
		this.gt = gt;
	}	
	
	public String printTank(double ver, double hor, double h8, double sh, double wh, double gt) {
		return (ver == 0 ? "" : (ver+ " ")) + (hor == 0 ? "" : (hor+ " ")) + (h8 == 0 ? "" : (h8+ " ")) + (sh == 0 ? "" : (sh+ " ")) + (wh == 0 ? "" : (wh+ " " )) + (gt == 0 ? "" : (gt + " "));
	}
}
