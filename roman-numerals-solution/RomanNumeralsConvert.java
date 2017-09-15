import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanNumeralsConvert {
	
	public final static String onesArray[] = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
	public final static String tensArray[] = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	public final static String hundredsArray[] = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };

	public final static String TEST_MOD = "-test";
	public final static String ONE = "I";
	public final static String TWELVE = "XII";
	public final static String ONE_HUNDRED_AND_THREE = "CIII";

	private static String[] numArray;

	public static void main(String[] args) {

		if (args.length > 0) {
			if (args.length > 1 || !TEST_MOD.equals(args[0])) {
				System.out.println("Only one flag supports: - test");
			} else {
				runTest();
			}
		} else {
			readInput();

			validate();

			convert();

			printResult();
		}

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

	public static void runTest() {
		numArray = new String[5];
		
		numArray[0] = "1";
		numArray[1] = "12";
		numArray[2] = "103";

		numArray[3] = "10char3";
		numArray[4] = "10399911";

		validate();

		convert();

		System.out.print("1 => " + numArray[0]);
		if (ONE.equals(numArray[0])) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}

		System.out.print("12 => " + numArray[1]);
		if (TWELVE.equals(numArray[1])) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}

		System.out.print("103 => " + numArray[2]);
		if (ONE_HUNDRED_AND_THREE.equals(numArray[2])) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}

		System.out.print("10char3 => " + numArray[3]);
		if ("10char3, illegal argument error - is not valid digital number.".equals(numArray[3])) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}

		System.out.print("10399911 => " + numArray[4]);
		if ("10399911, range bound error - number should be in the range [1 - 3999].".equals(numArray[4])) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}
	}
}