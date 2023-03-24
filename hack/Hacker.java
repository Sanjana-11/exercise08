package hack;

import java.io.IOException;
import java.util.List;

public class Hacker {
	public static void main(String[] args) throws IOException {

		Browser browser = new Browser();
		BrowserHistory history = new BrowserHistory();
		List<String> historyList = browser.getHistory();
		browser.writeHistory(historyList);
		List<String> newHistory = browser.readHistory();
		history.addHistory(newHistory);
		BrowserHistory.setHistory(newHistory);
		newHistory = BrowserHistory.getHistory();
		browser.writeHistory(newHistory);

	}

}
