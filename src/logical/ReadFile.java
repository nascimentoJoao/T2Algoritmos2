package logical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static Integer MAX_TUBES;
	public static Integer MAX_LEVELS;

	public Tuple[][] start(String filename) throws IOException {
		File file = new File(filename);
		BufferedReader in = new BufferedReader(new FileReader(file));

		Tuple[][] matrix = null;
		String content;

		String[] matrix_size = in.readLine().split(" ");

		MAX_LEVELS = Integer.parseInt(matrix_size[1]);
		MAX_TUBES = Integer.parseInt(matrix_size[0]);

		System.out.println("The max height is " + MAX_LEVELS + " and the total tubes is " + MAX_TUBES + ".");

		matrix = new Tuple[MAX_TUBES][MAX_LEVELS];

		while ((content = in.readLine()) != null) {
			String[] values = content.split(" ");
			Integer tube = Integer.parseInt(values[0]);
			Integer level = Integer.parseInt(values[1]);
			Integer lead_to_tube = Integer.parseInt(values[2]);
			Integer into_level = Integer.parseInt(values[3]);

			matrix[tube][level] = new Tuple(lead_to_tube, into_level);
		}

		return matrix;
	}

}
