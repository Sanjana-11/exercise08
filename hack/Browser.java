package hack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Browser {

	public List<String> getHistory() {

		List<String> historyList = new ArrayList<>();
		try {
			System.out.println("Enter no. of entries");
			Scanner sc = new Scanner(System.in);
			int urlCount = sc.nextInt();
			
			for (int i = 0; i < urlCount; i++) {
				System.out.println("Enter url");
				Scanner sc1 = new Scanner(System.in);
				String url = sc1.nextLine();
				if (url.matches(".*\\d.*")) {
					throw new NonNumericInputException("Invalid input: numeric characters are not allowed.");
				}
				historyList.add(url);

			}
		} catch (NonNumericInputException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return historyList;
	}

	public void writeHistory(List<String> historyList) throws IOException {
		try {
			FileWriter writer = new FileWriter("/home/sanjana-pt7186/Documents/History.txt");
			for (String url : historyList) {
				writer.append(url + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<String> readHistory() throws IOException {
		List<String> newHistory = new ArrayList<>();

		try {
			FileReader reader = new FileReader("/home/sanjana-pt7186/Documents/History.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				newHistory.add(line);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return newHistory;
	}

}
