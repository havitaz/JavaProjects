package aaaaaaaaa;

public class TankController {
	
	public static final double GA = 0.264172;
	
	Tank t = new Tank();
		
	public void add(double ver, double hor, double h8) {
		t = new Tank (ver, hor, h8);
	}
	
	public void add(double ver, double hor, double h8, double sh, double wh, double gt) {
		t = new Tank (ver, hor, h8, sh, wh, gt);
	}
		
	public String inform() {
		return t == null ? "데이터 없음" : (t.getVer() == 0 ? "" : "가로 : " + t.getVer() + "cm, ") + (t.getHor() == 0 ? "" : "세로 : " + t.getHor() + "cm, ")+ (t.getH8() == 0 ? "" : "높이 : " + t.getH8() + "cm, ")+ (t.getSH() == 0 ? "" : "바닥재 높이 : " + t.getSH() + "cm, ")+  (t.getWH() == 0 ? "" : "수위 : " + t.getWH() + "cm, ") + (t.getGT() == 0 ? "" : "유리 두께 : " + t.getGT() + "mm ");
	}
	
	public Tank remove() {
//		t.setGT(0);
//		t.setH8(0);
//		t.setHor(0);
//		t.setSH(0);
//		t.setVer(0);
//		t.setWH(0);
		t = null;
		return t;
	}
	
	public void modifyVer(double ver) {
		if (t != null) {
		t.setVer(ver);
		System.out.println("변경 완료");	
		} else {
			System.out.println("수정할 값이 없습니다.");
		}
	}
	public void modifyHor(double hor) {
		if (t != null) {
		t.setHor(hor);
		System.out.println("변경 완료");	
		} else {
			System.out.println("수정할 값이 없습니다.");
		}
	}
	public void modifyH8(double h8) {
		if (t != null) {
		t.setH8(h8);
		System.out.println("변경 완료");
		} else {
			System.out.println("수정할 값이 없습니다.");
		}
	}
	public void modifySh(double sh) {
		if (t != null) {
		t.setSH(sh);
		System.out.println("변경 완료");	
		} else {
			System.out.println("수정할 값이 없습니다.");
		}
	}
	public void modifyWh(double wh) {
		if (t != null) {
		t.setWH(wh);
		System.out.println("변경 완료");	
		} else {
			System.out.println("수정할 값이 없습니다.");
		}
	}
	public void modifyGT(double gt) {
		if (t != null) {
		t.setGT(gt);
		System.out.println("변경 완료");
		} else {
			System.out.println("수정할 값이 없습니다.");
		}
	}

	

	
	public double calcTank(double ver, double hor, double h8) {
		//t = new Tank (ver, hor, h8);
		return t == null ? 0 : t.getVer() * t.getHor() * t.getH8() / 1000;
		//return ver * hor * h8 / 1000;
	}
	
	public double calcTank(double ver, double hor, double h8, double sh, double wh, double gt) {
		//t = new Tank (ver, hor, h8, sh, wh, gt);
		return t == null ? 0 : (((t.getVer() - t.getGT() * 0.1 * 2) * (t.getHor() - t.getGT() * 0.1 * 2) * (t.getH8() - t.getSH() - (t.getGT() * 0.1) - t.getWH()) / 1000));
		//return (((ver - gt * 0.1 * 2) * (hor - gt * 0.1 * 2) * (h8 - sh - (gt * 0.1) - wh) / 1000));
	}
	
	public double calcSand(double ver, double hor, double h8) {
		//t = new Tank (ver, hor, h8);
		//return (ver * hor * h8) / 1000;
				return t == null ? 0 : (t.getVer() * t.getHor() * t.getH8()) / 1000;
	}

	public double calcGW(double ver, double hor, double h8, double gt) {
		//double bottom = ((ver - gt * 0.1 * 2 )* 0.01) * ((hor - gt * 0.1 * 2) * 0.01) * gt * 2.5; //10.56
		//double side = ((((hor - gt * 0.1 * 2)* 0.01) * (h8 * 0.01)) * gt * 2.5) * 2; //6.75 //6.48
		//double bf = ((ver * 0.01) * (h8 * 0.01) * gt * 2.5) * 2; //12.15

		//double bottom = ((t.getVer() - t.getGT() * 0.1 * 2 )* 0.01) * ((t.getHor() - t.getGT() * 0.1 * 2) * 0.01) * t.getGT() * 2.5; //10.56
		//double side = ((((t.getHor() - t.getGT() * 0.1 * 2)* 0.01) * (t.getH8() * 0.01)) * t.getGT() * 2.5) * 2; //6.75 //6.48
		//double bf = ((t.getVer() * 0.01) * (t.getH8() * 0.01) * t.getGT() * 2.5) * 2; //12.15
		return t == null ? 0 : (((t.getVer() - t.getGT() * 0.1 * 2 )* 0.01) * ((t.getHor() - t.getGT() * 0.1 * 2) * 0.01) * t.getGT() * 2.5) + (((((t.getHor() - t.getGT() * 0.1 * 2)* 0.01) * (t.getH8() * 0.01)) * t.getGT() * 2.5) * 2) + (((t.getVer() * 0.01) * (t.getH8() * 0.01) * t.getGT() * 2.5) * 2);
	}
	
	public double altGallon(double l) {
		return l * GA;
	}
}
