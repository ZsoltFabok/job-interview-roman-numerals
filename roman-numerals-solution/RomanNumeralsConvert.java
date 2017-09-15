import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanNumeralsConvert {
	
	public final static String onesArray[] = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
	public final static String tensArray[] = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	public final static String hundredsArray[] = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };

	private static String[] numArray;

	public static void main(String[] args) {

		readInput();

		validate();

		convert();

		printResult();

	}

	public static void readInput() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));) {
			String line;
			while ((line = in.readLine()) != null) {
				line = line.replace("\"", "").trim();
				numArray = line.split("\\s+");
			}
		} catch (final IOException e) {
			System.err.println("IOException reading System.in" + e);
		}
	}

	public static void validate() {
		for (int i = 0; i < numArray.length; i++) {
			final String numStr = numArray[i];
			boolean e = true;
			for (int k = 0; k < numStr.length(); k++) {
				if (Character.isDigit(numStr.charAt(k)) == false) {
					numArray[i] = numArray[i] + ", illegal argument error - is not valid digital number.";
					e = false;
					break;
				}
			}

			if (e) {
				final int num = Integer.parseInt(numStr);
				if (num > 3999 || num < 1) {
					numArray[i] = numArray[i] + ", range bound error - number should be in the range [1 - 3999].";
				}
			}
		}
	}

	public static void convert() {
		for (int i = 0; i < numArray.length; i++) {
			final String numStr = numArray[i];

			if (numStr.contains("error")) {
				continue;
			}
			
			String Roman = "";
			int num = Integer.parseInt(numStr);

			final int ones = num % 10;

			num = (num - ones) / 10;
			final int tens = num % 10;

			num = (num - tens) / 10;
			final int hundreds = num % 10;

			num = (num - hundreds) / 10;
			for (int n = 0; n < num; n++) {
				Roman += "M";
			}

			if (hundreds >= 1) {
				Roman += hundredsArray[hundreds - 1];
			}

			if (tens >= 1) {
				Roman += tensArray[tens - 1];
			}

			if (ones >= 1) {
				Roman += onesArray[ones - 1];
			}

			numArray[i] = String.valueOf(Roman);
		}
	}

	public static void printResult() {
		for (int i = 0; i < numArray.length; i++) {
			System.out.println(numArray[i]);
		}

	}
}