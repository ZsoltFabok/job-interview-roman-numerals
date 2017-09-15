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
					System.out.println(convert(numArray[i]));
				}
			}
		} catch (final IOException e) {
			System.err.println("IOException reading System.in" + e);
		}
	}

	public static String convert(String numStr) {
		String Roman = "";

		final String onesArray[] = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		final String tensArray[] = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		final String hundredsArray[] = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		int num = Integer.parseInt(numStr);

		final int ones = num % 10;

		num = (num - ones) / 10;
		final int tens = num % 10;

		num = (num - tens) / 10;
		final int hundreds = num % 10;

		num = (num - hundreds) / 10;
		for (int i = 0; i < num; i++) {
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

		return String.valueOf(Roman);
	}
}