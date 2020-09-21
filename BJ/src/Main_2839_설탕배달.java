import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Yoomnee
 * 
 *	큰 봉지를 많이 쓰는 것이 좋다 -> 나눠떨어지면 나누는 것이 가장 좋음.
 *	큰 봉지를 가장 많이 쓰면서 나눠 떨어지는 때 -> 작은 봉지로 소금양을 덜어내면서 체크
 *
 *	tc, m 입력받기
 *	while(소금의 양이 0보다 클 때까지) {
 *		1) 큰봉지로 바로 나누어 떨어지는 경우가 가장 best 가장 먼저 검사
 *		2) 작은봉지로 소금양 덜어내기 & 봉지수 올리기
 *	}
 *	소금의 양이 0이면 답 출력
 *	미만이면 -1 출력
 *	
 */
public class Main_2839_설탕배달 {
	/**
	 *	smallBag = 작은 봉지 3kg
	 *	bigBag = 큰 봉지 5kg
	 *	M = 배달할 소금의 양
	 *	ans = 최소 봉지 개수(답)
	 */
	static int smallBag = 3, bigBag = 5, M, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼리더 객체 생성
		
			M = Integer.parseInt(br.readLine());	// 배달해야 하는 소금의 양을 입력받기
			ans = 0;	// 매 testCase마다 0으로 초기화
			
			while ( M > 0 ) {	// 소금의 양이 0보다 클 때까지
				if (M % bigBag == 0) {	// 5kg으로 나눠떨어지면
					ans += M / bigBag;	// 여태까지의 봉지수 + 사용될 큰 봉지 개수(소금양 / 5kg)
					M = 0;	// 나눠떨어졌으므로 소금양은 0이 된다.
				} else {
					M -= smallBag;	// 소금양에서 3kg씩 덜어내기
					++ans;	// 봉지수 올리기
				}
			}	// end of while
			
			if (M == 0 ) 	// 소금양이 0이면
				System.out.println(ans);	// 봉지수 출력
			else 	// 배달할 수 없는 경우
				System.out.println(-1);	// -1 출력
			
	}	//end of main
}	//end of class
