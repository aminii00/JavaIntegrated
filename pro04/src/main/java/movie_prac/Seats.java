package movie_prac;

import java.util.List;

public class Seats {

	public static final int MAX_ROW=5;
	public static final int MAX_COL=9;
	private String[][] map = new String[MAX_ROW][MAX_COL];
	
	public Seats( List<Reservation> reservations) throws Exception {
		
		for (int i=0; i<MAX_ROW; i++) {
			for (int j=0; j<MAX_COL; j++) {
				map[i][j] = "0";
			}
		}
		
		for (int i=0; i<reservations.size(); i++) {
			Reservation r = reservations.get(i);
			String seatName = r.getSeat();
			mark(seatName);
		}
	}
	
	public void show() {
		System.out.println("----------------------------");
		System.out.println("        S C R E E N         ");
		System.out.println("----------------------------");
		for(int i=0; i<MAX_ROW; i++) {
			System.out.printf("%c", 'A'+i );
			for (int j=0; j<MAX_COL; j++) {
				System.out.printf("%s", map[i][j]);
			}
			System.out.println();
			}
		System.out.println(" 123456789");
	}
	public void mark(String seatName) throws Exception{
			char[] temp = seatName.toCharArray(); // 좌석 명을 문자 배열로 변환
			int row = temp[0] - 'A';
			int col = temp[2] - '1';
			if("x".equals(map[row][col])) {
				throw new Exception ("이미 예매된 좌석입니다..");
			}
			map[row][col] = "x";
		}
}
