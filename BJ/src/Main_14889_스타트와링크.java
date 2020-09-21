import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N, table[][], lSum, sSum, diff;	//인원수, 능력표, 링크팀 능력 합, 스타트팀 능력 합, 두 팀의 차이(answer)
	static boolean isZero, isST[] ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	//인원수
		//배열 객체 생성
		table = new int[N][N];
		isST = new boolean[N];
		//입력부
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		diff = Integer.MAX_VALUE;
		comb(0, 0);
		
		System.out.println(diff);
	}
	
	
	/**
	 * 
	 * @param idx -> isST 배열 인덱스
	 * @param tNum -> true 개수(스타트 팀에 속한 사람이면 true)
	 */
	public static void comb(int idx, int tNum) {
		if (isZero) {
			return;
		}
		if (tNum == N/2) {	//스타트팀이 세 명이 되면
			abilitySum();
			return;
		}
		if (idx >= N)	//인덱스 넘어가면 return
			return;
		
		isST[idx] = true;
		comb(idx+1, tNum+1);
		isST[idx] = false;
		comb(idx+1, tNum);
	}
	public static void abilitySum() {
		sSum = 0;
		lSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isST[i] && isST[j]) {
					sSum += table[i][j];
				} else if (!isST[i] && !isST[j]) {
					lSum += table[i][j];
				}
			}
		}
		
		int tmpDiff = sSum - lSum >= 0 ? sSum - lSum : lSum - sSum;
		if (diff > tmpDiff) {
			diff = tmpDiff;
			if (diff == 0) {
				isZero = true;
			}
		}
		
	}

}