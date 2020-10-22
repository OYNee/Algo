import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Iterator 란?
// Map 이란?
// Hash Set 이란?
public class Hash_01 {
	public static void main(String[] args) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		String answer = "";

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		setHashMap(participant, completion, hm);
		answer = findAns(hm);

		System.out.println(answer);
	}

	private static String findAns(HashMap<String, Integer> hm) {
		Set set = hm.entrySet();
		Iterator iterator = set.iterator();
		
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			int value = (int) entry.getValue();
			if (value != 0) {
				return (String) entry.getKey();
			}
		}
		throw new RuntimeException("no answer");
	}

	private static void setHashMap(String[] array_1, String[] array_2, HashMap<String, Integer> hm) {
		for (String element : array_1)
			hm.put(element, hm.getOrDefault(element, 0) + 1);
		for (String element : array_2)
			hm.put(element, hm.get(element) - 1);
	}

}
