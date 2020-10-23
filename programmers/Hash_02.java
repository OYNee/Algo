import java.util.Arrays;
import java.util.Comparator;

public class Hash_02 {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);

		answer = findAnswer(phone_book);
		return answer;
	}

	public static void main(String[] args) {
		boolean answer = true;

		String[] phone_book = { "9", "119", "1195524421" };
		// 여기서는 접두사가 같은것끼리만 길이 비교해서 sort 하면 되기 때문에 아래처럼 짤 필요 없이 sort 하면 됨
		Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.length(), o2.length());
			}
		});
		answer = findAnswer(phone_book);

		System.out.println(answer);
	}

	private static boolean findAnswer(String[] phone_book) {
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
		return true;
	}

}
