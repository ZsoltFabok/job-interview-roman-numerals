import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

public class RomanNumeralsConvert {

	public final static String TEST_MOD = "-test";
	public final static String ONE = "I";
	public final static String TWELVE = "XII";
	public final static String ONE_HUNDRED_AND_THREE = "CIII";

	private final static TreeMap<Integer, String> map = new TreeMap<>();
	static {
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}

	public static void main(String[] args) {

		if (args.length > 0) {
			if (args.length > 1 || !TEST_MOD.equals(args[0])) {
				System.out.println("Only one flag supports: - test");
			}

			runTest();

		} else {
			final List<String> numbersList = readInput();

			validate(numbersList);

			convert(numbersList);

			printResult(numbersList);
		}

	}

	private static List<String> readInput() {
		final List<String> numbersList = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			String line;
			while ((line = in.readLine()) != null) {
				line = line.replace("\"", "").trim();
				numbersList.addAll(Arrays.asList(line.split("\\s+")));
			}

		} catch (final IOException e) {
			System.err.println("IOException reading System.in" + e);
			System.exit(1);
		}

		return numbersList;
	}

	private static void validate(List<String> numbersList) {
		final ListIterator<String> listIterator = numbersList.listIterator();
		while (listIterator.hasNext()) {
			final String numStr = listIterator.next();

			boolean e = true;
			for (int k = 0; k < numStr.length(); k++) {
				if (Character.isDigit(numStr.charAt(k)) == false) {
					listIterator.set(numStr + ", illegal argument error - is not valid digital number.");
					e = false;
					break;
				}
			}

			if (e) {
				final int num = Integer.parseInt(numStr);
				if (num > 3999 || num < 1) {
					listIterator.set(numStr + ", range bound error - number should be in the range [1 - 3999].");
				}
			}
		}
	}

	private final static String toRoman(Integer number) {
		final int l = map.floorKey(number);
		if (number == l) {
			return map.get(number);
		}
		return map.get(l) + toRoman(number - l);
	}

	private static void convert(List<String> numbersList) {
		final ListIterator<String> listIterator = numbersList.listIterator();
		while (listIterator.hasNext()) {
			final String numStr = listIterator.next();

			if (numStr.contains("error")) {
				continue;
			}
			
			final Integer num = Integer.valueOf(numStr);

			final int l = map.floorKey(num);
			if (num == l) {
				listIterator.set(map.get(num));
			} else {
				listIterator.set(map.get(l) + toRoman(num - l));
			}
		}
	}

	public static void printResult(List<String> numbersList) {
		numbersList.forEach(System.out::println);
	}

	public static void runTest() {
		final List<String> numbersList = new ArrayList<>();

		numbersList.add("1");
		numbersList.add("12");
		numbersList.add("103");
		numbersList.add("10char3");
		numbersList.add("10399911");

		validate(numbersList);

		convert(numbersList);

		System.out.print("1 => " + numbersList.get(0));
		if (ONE.equals(numbersList.get(0))) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}

		System.out.print("12 => " + numbersList.get(1));
		if (TWELVE.equals(numbersList.get(1))) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}

		System.out.print("103 => " + numbersList.get(2));
		if (ONE_HUNDRED_AND_THREE.equals(numbersList.get(2))) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}

		System.out.print("10char3 => " + numbersList.get(3));
		if ("10char3, illegal argument error - is not valid digital number.".equals(numbersList.get(3))) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}

		System.out.print("10399911 => " + numbersList.get(4));
		if ("10399911, range bound error - number should be in the range [1 - 3999].".equals(numbersList.get(4))) {
			System.out.println(" passed.");
		} else {
			System.out.println(" failed.");
		}
	}
}