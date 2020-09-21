import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_1786_찾기 {

	static int strLeng, patternLeng, pi[];
	static char[] tmp;
	static String str, pattern;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		strLeng = str.length();
		pattern = br.readLine();
		patternLeng = pattern.length();

		tmp = new char[patternLeng];
		for (int i = 0; i < patternLeng; i++) {
			tmp[i] = pattern.charAt(i);
		}

		pi = new int[patternLeng];
		int j = 0;
		for (int i = 1; i < tmp.length; i++) {
			while (j > 0 && tmp[i] != tmp[j]) {
				j = pi[j - 1];
			}
			if (tmp[i] == tmp[j]) {
				pi[i] = ++j;
			}
		}

		LinkedList<Integer> list = KMP();
		System.out.println(list.size());
		for (int i : list) {
			System.out.println(i);
		}
	}

	private static LinkedList<Integer> KMP() {
		LinkedList<Integer> list = new LinkedList<>();
		int j = 0;

		char arrA[] = new char[strLeng];
		for (int i = 0; i < strLeng; i++) {
			arrA[i] = str.charAt(i);
		}
		char arrB[] = new char[patternLeng];
		for (int i = 0; i < patternLeng; i++) {
			arrB[i] = pattern.charAt(i);
		}
		for (int i = 0; i < strLeng; i++) {
			while (j > 0 && arrA[i] != arrB[j]) {
				j = pi[j - 1];
			}
			if (arrA[i] == arrB[j]) {
				if (j == arrB.length - 1) {
					j = pi[j];
					list.add(i - arrB.length + 2);
				} else {
					j++;
				}
			}
		}
		return list;
	}

}
