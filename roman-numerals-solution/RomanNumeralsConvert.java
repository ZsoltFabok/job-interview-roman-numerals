import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanNumeralsConvert {

	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));) {
			String line;
			while ((line = in.readLine()) != null) {
				line = line.replace("\"", "").trim();
				final String[] numArray = line.split("\\s+");

				for (int i = 0; i < numArray.length; i++) {
					System.out.println(numArray[i]);
				}
			}
		} catch (final IOException e) {
			System.err.println("IOException reading System.in" + e);
		}
	}
}