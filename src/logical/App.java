package logical;

import java.io.IOException;
import java.util.HashMap;

public class App {

	public static void main(String[] args) throws IOException {

		System.out.println("Starting!\n");

		long start = System.currentTimeMillis();

		ReadFile helper = new ReadFile();
		Tuple[][] matrix = helper.start("caso8.txt");
		HashMap<Integer, Integer> tube_total = new HashMap<>();

		int tubeControl = 0;
		int tube = 0;
		int level = 0;
		int aux_tube = 0;
		int aux_level = 0;
		int maxLevel = ReadFile.MAX_LEVELS;
		int maxTube = ReadFile.MAX_TUBES;
		try {

			while (true) {

				if (level == maxLevel) {
					if (tube_total.get(tube) == null) {
						tube_total.put(tube, 1);
					} else {
						tube_total.put(tube, tube_total.get(tube) + 1);
					}

					tubeControl++;
					tube = tubeControl;
					level = 0;
				}

				if (tubeControl == maxTube) {
					break;
				}

				if (matrix[tube][level] != null) {
					aux_tube = matrix[tube][level].Tube;
					aux_level = matrix[tube][level].Level;
					tube = aux_tube;
					level = aux_level;
				} else {
					level++;
				}

			}
		} catch (Exception error) {
			System.out.println("Error was: " + error);
			System.out.println("Tube: " + tube);
			System.out.println("Level: " + level);
		}

		System.out.println("Game over, cowboy!");
		System.out.println("Results: " + tube_total.toString());

		long end = System.currentTimeMillis();

		System.out.println("Time elapsed: " + ((end - start) / 1000F) + " seconds.");

	}

}
