import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author Yoomnee
 * 
 * 작성일: 2020년 3월 30일
 * 작성자: 오유민
 * 
 * 알고리즘 키워드: 시뮬레이션
 * 
 * 굴리기!
 * 	- 동쪽으로 굴리면 값을 무조건 1->3, 3->6, 6->4, 4->1
 * 	- 서쪽으로 굴리면 값을 무조건 1->4, 4->6, 6->3, 3->1
 *  - 북쪽으로 굴리면 값을 무조건 1->2, 2->6, 6->5, 5->1
 * 	- 남쪽으로 굴리면 값을 무조건 1->5, 5->6, 6->2, 2->1
 * 
 * 
 *
 */
public class Main_14499_주사위굴리기 {
	//주사위 객체
	static class Dice {
		int x;	//x좌표
		int y;	//y좌표
		int[] dice = new int[7];	//각 면의 값
		
		public Dice(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static int N, M, K, map[][];	//N: 행, M: 열, K: 명령의 개수, dice: 주사위, map: 맵
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력부
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Dice d = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 굴리기(동서남북 경우로 나뉨) -> 값 복사(두 가지 경우로 나뉨)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			//굴리기
			int tmp = 0;
			boolean moved = false;
			switch (dir) {
			case 1:	//동
				//이동 가능한가 체크(불가능하면 break)
				if (d.y > M-2) 
					break;
				//가능하면 값이동
				moved = true;	//움직임 true로
				d.y++;	// 좌표값 바꾸기
				tmp = d.dice[1];
				d.dice[1] = d.dice[3];
				d.dice[3] = d.dice[6];
				d.dice[6] = d.dice[4];
				d.dice[4] = tmp;
				break;
			case 2:	//서
				if (d.y < 1) 
					break;
				moved = true;
				d.y--;
				tmp = d.dice[1];
				d.dice[1] = d.dice[4];
				d.dice[4] = d.dice[6];
				d.dice[6] = d.dice[3];
				d.dice[3] = tmp;
				break;
			case 3:	//북
				if (d.x < 1) 
					break;
				moved = true;
				d.x--;
				tmp = d.dice[1];
				d.dice[1] = d.dice[5];
				d.dice[5] = d.dice[6];
				d.dice[6] = d.dice[2];
				d.dice[2] = tmp;
				break;
			case 4:	//남
				if (d.x > N-2) 
					break;
				moved = true;
				d.x++;
				tmp = d.dice[1];
				d.dice[1] = d.dice[2];
				d.dice[2] = d.dice[6];
				d.dice[6] = d.dice[5];
				d.dice[5] = tmp;
				break;
			}
			if (moved) {
				sb.append(d.dice[1] +"\n");	// 윗면 값 추가
				//값 복사
				if (map[d.x][d.y] == 0) {	//1. 칸 숫자가 0인 경우
					map[d.x][d.y] = d.dice[6];
				} else {	//2. 칸 숫자가 0이 아닌 경우
					d.dice[6] = map[d.x][d.y];
					map[d.x][d.y] = 0;
				}
				
			}
			
			
		}
		
		System.out.print(sb.toString());
		
		
	}	//end of main
}	//end of class
