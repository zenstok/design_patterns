package tema_cts.proxy;

import java.util.ArrayList;

public class Log {
	public static ArrayList<String> messages = new ArrayList<>();
	
	public static void addMessage(String message) {
		messages.add(message);
	}
	
}
