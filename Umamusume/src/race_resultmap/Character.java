package race_resultmap;

public class Character {
	String name;

	public static void result() {

		int[] num = new int[10];
		int arrival = 0;

		for (int i : num) {
			if (i == 1) {
				arrival++;

			} else if (i == 2) {
				arrival++;

			} else if (i == 3) {
				arrival++;

			} else {
				
				
			}
			System.out.println(arrival);
		}

	}
}
