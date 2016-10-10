package tomhaslam.euler.code;

import java.io.*;

public class Problem0067 extends Problem {	
	
	public long solve()
	{
		/*
		 * read in file
		 * call traverse form problem 18
		 */
		StringBuffer triangleText = new StringBuffer();
		String path = this.getClass().getResource("p067_triangle.txt").getPath();
        File file = new File(path);

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) 
			{
				triangleText.append(line + " ");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] values = triangleText.toString().split(" ");
		int[] triangle = new int[values.length];
		for (int i=0; i<values.length; i++)
			triangle[i] = Integer.parseInt(values[i]);
		
		Problem0018 problem0018 = new Problem0018();
		return problem0018.traversePreviousRow(triangle, 4950, 5050-1);
	}
}
