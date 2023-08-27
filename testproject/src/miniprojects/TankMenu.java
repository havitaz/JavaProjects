package miniprojects;

import java.util.*;

public class TankMenu {
	private Scanner sc = new Scanner(System.in);
	private TankController tc = new TankController();
	private Tank t = new Tank();
	
	public void TankMenu() {
		while(true) {
		System.out.println("1. 수치 입력 ");
		System.out.println("2. 수치 수정 ");
		System.out.println("3. 초기화 ");
		System.out.println("4. 물량 계산 ");
		System.out.println("5. 바닥재 계산 ");
		System.out.println("6. 출력 ");
		System.out.println("7. L >> Gallon 변환 ");
		System.out.println("8. 프로그램 종료 ");
		System.out.print("번호 입력 : ");	

		int mn = sc.nextInt();
			if (mn == 1) {
				insertVer();
			} else if (mn == 2) {
				printTV();
				editTV();
			} else if (mn == 3) {
				resetInput();
			} else if (mn == 4) {
				printTV();
				calcTV();
			} else if (mn == 5) {
				calcTSH();
			} else if (mn == 6) {
				printTV();
			} else if (mn == 7) {
				altGallon();
			} else if (mn == 8) {
				System.out.print("프로그램 종료");
				return;
			}
		}
		}

		public void insertVer() {
			
			double vi = 0;
			boolean validInput = false;			
			do {	
				System.out.print("가로 (cm): ");
				String viInput = sc.next();
				try {
					vi = Double.parseDouble(viInput);
					validInput = true;
					t.setVer(vi);
				} catch (NumberFormatException e) {
					System.out.println("잘못된 입력입니다.");
				}
			}while (!validInput);
			
			
			double hi = 0;
			validInput = false;
			do {
				System.out.print("세로 (cm): ");
				String hiInput = sc.next();
				try {
					hi = Double.parseDouble(hiInput);
					validInput = true;
					t.setHor(hi);
				} catch (NumberFormatException e) {
					System.out.println("잘못된 입력입니다.");
				}
			}while (!validInput);
			
								
			double h8i = 0;
				do {
					try {
						System.out.print("높이 (cm): ");
						h8i = sc.nextDouble();
						t.setH8(h8i);
						break;
					} catch (Exception e) {
						System.out.println("숫자를 입력하세요.");
						sc.next();
					}
				}while(true);
				
							
			System.out.print("상세 정보를 입력하시겠습니까?. (Y/N) : ");
			String a = sc.next();
 
			if (a.equalsIgnoreCase("Y")) {
				
				
				double shi = 0;
				do {
					try {
						System.out.print("바닥재 높이 (cm): ");
						shi = sc.nextDouble();
						t.setSH(shi);
						break;
				} catch (Exception e) {
					System.out.println("숫자를 입려하세요.");
					sc.next();
				}
			}while(true);		
					
				
				double whi = 0;
				do {
					try {
						System.out.print("수위 (cm): ");
						whi = sc.nextDouble();
						t.setWH(whi);
						break;
				} catch (Exception e) {
					System.out.println("숫자를 입력하세요.");
					sc.next();
				}
			}while(true);
				
				
				
				double gt = 0;
				do {
					try {
						System.out.print("유리 두께 (mm): ");
						gt = sc.nextDouble();
						t.setGT(gt);
						break;
					}catch (Exception e) {
						System.out.println("숫자를 입력하세요.");
						sc.next();
					}
				}while(true);
			
				
				tc.add(vi, hi, h8i, shi, whi, gt);
				
			} else if (a.equalsIgnoreCase("N")){
				tc.add(vi, hi, h8i);
			} else {
				System.out.println("잘못된 입력입니다. 입력하신 값만 적용됩니다.");
				tc.add(vi, hi, h8i);
			}
		}		
		
		public void resetInput() {
			System.out.println("정말 초기화 하시겠습니까 (y/n) : ");
			sc.nextLine();
			String sl = sc.nextLine();
			if(sl.equalsIgnoreCase("y")) {
				tc.remove();
				System.out.println("초기화 되었습니다.");
			} else {
				System.out.println("취소 되었습니다");
			}						
		}
		
		public void calcTV() {
			if (t== null) {
				System.out.print("값이 없습니다.");
			} else {
				System.out.print("상세 정보를 입력하셨습니까? (Y/N) : ");
				String a = sc.next();
				 //입력된 값이 없음에도 y 누르면 값이 출력됨
				//if(t.getWH()==0 || t.getGT() == 0 || t.getH8() == 0 || t.getHor() == 0 || t.getSH() == 0 || t.getVer() == 0 || t.getWH() == 0) {	
					if (a.equalsIgnoreCase("y")) {
							System.out.print("총 물량은.. : ");
							System.out.println(tc.calcTank(t.getVer(), t.getHor(), t.getH8(), t.getSH(), t.getWH(), t.getGT()) + "L ");
							System.out.print("수조의 무게는.. : ");
							System.out.println(tc.calcGW(t.getVer(), t.getHor(), t.getH8(), t.getGT()) + "kg");
			
						
					} else if (a.equalsIgnoreCase("n")){
						System.out.print("총 물량은..  : ");
						System.out.println(tc.calcTank(t.getVer(), t.getHor(), t.getH8()) + "L ");
						
					} else {
						System.out.println("잘못된 입력입니다.");
					}
			}
		}

		public void calcTSH() {
			System.out.print("수조의 가로 길이 (cm) : ");
			double vi = sc.nextDouble();
			t.setVer(vi);
			System.out.print("수조의 세로 길이 (cm) : ");
			double hi = sc.nextDouble();
			t.setHor(hi);
			System.out.print("원하는 높이 (cm) : ");
			double shi = sc.nextDouble();
			t.setH8(shi);
			tc.add(vi, hi, shi);
			System.out.println(tc.calcSand(t.getVer(), t.getHor(), t.getH8()) + "L(kg) 가 필요합니다.");
			tc.remove();
		}
		
		public void editTV() {
			int menum = 0;
				do {
					System.out.println("수정하실 수치를 선택하세요.");
					System.out.println("1. 가로 (cm)");
					System.out.println("2. 세로 (cm)");
					System.out.println("3. 높이 (cm)");
					System.out.println("4. 바닥재 높이 (cm)");
					System.out.println("5. 수위 (cm)");
					System.out.println("6. 유리 두께 (mm)");
					System.out.println("7. 돌아가기");
					System.out.print("번호 입력 : ");
					try {
						menum = sc.nextInt();
						sc.nextLine();
					}catch (InputMismatchException e) {
						System.out.println();
						sc.nextLine();
						continue;
					}
					
					if(menum == 1) {												
						if(t.getVer() != 0) {
							do {
								try {
									System.out.print("가로 (cm) : ");
									tc.modifyVer(sc.nextDouble());
									break;
								} catch (Exception e) {
									System.out.println("숫자를 입력하세요.");
									sc.next();
								}
							} while(true);						
						} else {
							System.out.print("수정할 값이 없습니다.");
						}
		
					} else if (menum == 2) {
						if(t.getHor() != 0) {
							do {
								try {
									System.out.print("세로 (cm) : ");
									tc.modifyHor(sc.nextDouble());
									break;
								} catch (Exception e) {
									System.out.println("숫자를 입력하세요.");
									sc.next();
								}
							}while(true);						
						} else {
							System.out.println("수정할 값이 없습니다.");
						}		
						
					} else if (menum == 3) {												
						if(t.getH8() != 0) {
							do {
								try {
									System.out.print("높이 (cm) : ");
									tc.modifyH8(sc.nextDouble());
									break;
								}catch (Exception e) {
									System.out.println("숫자를 입력하세요.");
									sc.next();
								}								
							}while(true);
						} else {
							System.out.println("수정할 값이 없습니다.");
						}
											
					} else if (menum == 4) {
						if(t.getSH() != 0) {
							do {
								try {
									System.out.print("바닥재 높이 (cm) : ");
									tc.modifySh(sc.nextDouble());
									break;
								} catch(Exception e) {
									System.out.println("숫자를 입력하세요.");
									sc.next();
								}
							} while(true);					
						} else {
							System.out.println("수정할 값이 없습니다.");
						}
												
					} else if (menum == 5) {
						if (t.getWH() != 0) {
							do {
								try {
									System.out.print("수위 (cm) : ");
									tc.modifyWh(sc.nextDouble());	
									break;
								} catch (Exception e) {
									System.out.println("숫자를 입력하세요.");
									sc.next();
								}
							} while(true);			
						} else {
							System.out.println("수정할 값이 없습니다.");
						}					
						
					} else if (menum == 6) {
						if(t.getGT() != 0) {
							do {
								try {
									System.out.print("유리 두께 (mm) : ");
									tc.modifyGT(sc.nextDouble());
									break;
								} catch(Exception e) {
									System.out.println("숫자를 입력하세요.");
									sc.next();
								}
							} while(true);
						} else {
							System.out.println("수정할 값이 없습니다.");
						}												
						
					} else if (menum == 7) {
						return;
					} else {
						System.out.println("잘못된 번호입니다 다시 입력해주세요.");
					}								
			}while(menum != 7);
		}			
		
		public void printTV() {
			System.out.println(tc.inform());
		}
	
		public void altGallon() {
			System.out.println("물량을 입력해주세요. : ");
			System.out.println(tc.altGallon(sc.nextDouble()) + " Gallon");
			
		}
}
