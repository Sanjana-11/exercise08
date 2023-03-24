package hack;

import java.util.List;
import java.util.Scanner;

public class BrowserHistory {
	private static List<String> newHistory;
	String addOption;

	BrowserHistory() {

	}

	public void addHistory(List<String> newHistory) {
		do {
			System.out.println("Do you wish to add an entry?");
			Scanner sc = new Scanner(System.in);
			addOption = sc.nextLine();

			if ("no".equalsIgnoreCase(addOption)) {
				break;
			}
			try {
				System.out.println("Enter url");
				Scanner sc1 = new Scanner(System.in);
				String url = sc1.nextLine();
				if (url.matches(".*\\d.*")) {
					throw new NonNumericInputException("Invalid input: numeric characters are not allowed.");
				}
				newHistory.add(url);
			} catch (NonNumericInputException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while ("yes".equalsIgnoreCase(addOption));

	}

	public static void setHistory(List<String> newHistory) {
		BrowserHistory.newHistory = newHistory;
	}

	public static List<String> getHistory() {
		return newHistory;
	}

}
