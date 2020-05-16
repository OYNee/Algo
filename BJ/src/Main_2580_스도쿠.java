import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2580_스도쿠 {
	static int board[][], blankNum, newXY[];
	static boolean success;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		newXY = new int[2];
		for (int i = 0; i < 9; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = tmp.charAt(j*2)-'0';
				if (board[i][j]==0) {
					++blankNum;
					if (blankNum == 1) {
						newXY[0] = i;
						newXY[1] = j;
					}
				}
			}
		}
		
//		print();
		dfs(0, newXY[0], newXY[1]);
		
		System.out.print(sb);
	}
	
	private static void dfs(int cnt, int r, int c) {	// cnt: 이미 고른 빈칸 갯수
		if (cnt == blankNum) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			success = true;
			return;
		}
//		System.out.println("check: " + newXY[0]+" "+newXY[1]);
		
		int[] oneToNine = new int[9];
		for (int i = 0; i < 9; i++) {
			oneToNine[i] = i+1;
		}
		rCheck(r, oneToNine);
		cCheck(c, oneToNine);
		squareCheck(r, c, oneToNine);
		for (int i = 0; i < 9; i++) {
			if (oneToNine[i] != -1 && !success) {
				board[r][c] = oneToNine[i];
				newXY = findNext(r, c);
				dfs(cnt+1, newXY[0], newXY[1]);
				board[r][c] = 0;
			}
		}
	}
	
	private static void cCheck(int c, int[] oneToNine) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (oneToNine[i] == board[j][c]) {
					oneToNine[i] = -1;
				}
			}
		}
	}

	private static void squareCheck(int r, int c, int[] oneToNine) {
		int sr = r / 3;
		int sc = c / 3;
		for (int k = 0; k < 9; k++) {
			for (int i = sr*3; i < (sr+1)*3; i++) {
				for (int j = sc*3; j < (sc+1)*3; j++) {
					if (oneToNine[k] == board[i][j]) {
						oneToNine[k] = -1;
					}
				}
			}
		}
		
	}

	private static void rCheck(int r, int[] oneToNine) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (oneToNine[i] == board[r][j]) {
					oneToNine[i] = -1;
				}
			}
		}
	}

	private static int[] findNext(int r, int c) {
		boolean firstR = true;
		boolean firstC = true;
		for (int i = r; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (firstR) {
					j = c;
					firstR = false;
				}
				if (board[i][j] == 0 && !firstC) {
					return new int[] {i, j};
				} else {
					firstC = false;
				}
			}
		}
		return new int[] {0, 0};
	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			} 
			System.out.println();
		}
		System.out.println();
	}
}
