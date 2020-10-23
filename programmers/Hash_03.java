import java.util.HashMap;

public class Hash_03 {
	static HashMap<String, Integer> hm = new HashMap<>();
	static int answer = 1;

	public static int solution(String[][] clothes) {
		// 두 번째가 키 값, 키 하나 더 나오면 integer 올리기
		setHashMap(clothes);

		// 옷 조합 값 구하기 (key value * key value ...( key 개수만큼)) + key value 들의 합
		calc();
		return answer - 1;
	}

	public static void main(String[] args) {
		String[][] clothes = { { "yellow_hat", "a" }, { "yellow_hat", "a" }, { "blue_sunglasses", "b" },
				{ "green_turban", "c" }, { "green_turban", "d" } };

		System.out.println(solution(clothes));
	}

	private static void calc() {
		// TODO Auto-generated method stub
		for (Integer cnt : hm.values()) {
			answer *= (cnt + 1);
		}
	}

	private static void setHashMap(String[][] s) {
		for (String[] strings : s) {
			hm.put(strings[1], hm.getOrDefault(strings[1], 0) + 1);
		}
	}

}
