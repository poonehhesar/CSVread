package CSVMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readCSV {
	static String currentString = "";
	static boolean weHaveQuotation = false;

	private static String COMMA_DELIMITER = ",";
	private static ArrayList<ArrayList<String>> wholeSheet = new ArrayList<>();

	public static ArrayList<ArrayList<String>> getWholeSheet() {
		if (wholeSheet.isEmpty()) {
			loadCSV();
		}

		return wholeSheet;
	}

	public static void loadCSV() {

		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNext()) {

				wholeSheet.add(getRows(scanner.nextLine()));

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		for (int i = 0; i < wholeSheet.size(); i++) {
			// loopa genom values inne i records
			List<String> localValues = wholeSheet.get(i);
			System.out.println(localValues.size());
		}

	}

	private static ArrayList<String> getRows(String row) {

		ArrayList<String> rowValues = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(row)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				currentString += rowScanner.next();
				if (!currentString.isEmpty()) {
					if (currentString.charAt(0) == '"')
						weHaveQuotation = true;
					if (currentString.charAt(currentString.length() - 1) == '"')
						weHaveQuotation = false;
				}
				if (!weHaveQuotation) {
					rowValues.add(currentString);
					currentString = "";
					continue;
				}
				currentString += ",";
			}

			return rowValues;
		}

	}

	public static void printCSV() {
		for (ArrayList<String> row : wholeSheet) {

			System.out.println(row);

		}

	}

}