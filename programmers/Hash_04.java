import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// HashMap에 각 장르 별 재생 횟수 저장
// 또다른 HashMap에 각 장르가 가지고 있는 노래 인덱스 번호를 저장하는 HashMap
// 먼저 장르 별 플레이 횟수 구하고
// for
// 
// genRank 인덱스 0번부터 해당 키값의 최대 플레이 횟수 음악 익덱스 두 개를 뽑아낸다
public class Hash_04 {
	static HashMap<String, Integer> hm1 = new HashMap<>();
	static HashMap<String, LinkedList<Integer>> hm2 = new HashMap<>();
	static ArrayList<Integer> answer = new ArrayList<>();

	public static ArrayList<Integer> solution(String[] genres, int[] plays) {

		// HashMap에 각 장르 별 재생 횟수 저장
		setHashMap(genres, plays);
//		System.out.println(hm1.toString() +"\n" + hm2.toString());
		setAlbum(plays);
		System.out.println(answer);
		return answer;
	}

	private static void setAlbum(int[] plays) {
		List<String> keySetList = new ArrayList<>(hm1.keySet());
		Collections.sort(keySetList, (o1, o2) -> (hm1.get(o2).compareTo(hm1.get(o1))));

		int i = 0;
		for (String key : keySetList) {
			HashMap<Integer, Integer> thm = new HashMap<>();
			LinkedList<Integer> l = hm2.get(key);
			Iterator iterator = l.iterator();
			while (iterator.hasNext()) {
				int tmp = (int) iterator.next();
				thm.put(tmp, plays[tmp]);
			}

			List<Integer> keySetList2 = new ArrayList<>(thm.keySet());
			Collections.sort(keySetList2, (o1, o2) -> (thm.get(o2).compareTo(thm.get(o1))));

			// l에 있는 인덱스대로 배열에서 값 뽑아서 해시맵으로 만들기?
			// 곡 재생 횟수 순으로 정렬
			// 두 개 뽑아서 answer 원소가 하나라면 하나만 픽!
			answer.add(keySetList2.get(0));
			if (keySetList2.size() != 1) {
				answer.add(keySetList2.get(1));
			}
		}
	}

	private static void setHashMap(String[] genres, int[] plays) {
		for (int i = 0; i < genres.length; i++) {
			hm1.put(genres[i], hm1.getOrDefault(genres[i], plays[i]) + plays[i]);
			LinkedList<Integer> l = new LinkedList<>();
			if (hm2.get(genres[i]) != null) {
				l = hm2.get(genres[i]);
			}
			l.add(i);
			hm2.put(genres[i], l);
		}
	}

	public static void main(String[] args) {
		String[] genres = { "q", "w", "pop", "p", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		solution(genres, plays);
	}

}
