
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class DataGenerator {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		int start_value = Integer.parseInt(args[0]);
		int num = Integer.parseInt(args[1]);
		int wrap = Integer.parseInt(args[2]);
		String textFile = args[3];
		
		Random rand = new Random();
		PrintWriter writer = new PrintWriter(textFile, "UTF-8");
		
		
		for(int i = 0; i < num; i++)
		{
			int next = rand.nextInt(wrap) + 1;
			int index = start_value + i;
			writer.println(index + " " + next);
		}
		
		writer.close();
		
	}

}
