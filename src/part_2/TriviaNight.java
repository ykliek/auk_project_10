package part_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class TriviaNight {
	private String eventName;
	private String eventDate;
	private int numberOfParticipants;
	private String mainTheme;
	private String registerUrl;
	private String chatUrl;
	private String eventLocation;
	private String eventDescription;

	public TriviaNight(String eventName, String eventDate, int numberOfParticipants, String mainTheme,
	                   String registerUrl, String chatUrl, String eventLocation, String descriptionFilePath) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.numberOfParticipants = numberOfParticipants;
		this.mainTheme = mainTheme;
		this.registerUrl = registerUrl;
		this.chatUrl = chatUrl;
		this.eventLocation = eventLocation;
		this.eventDescription = readDescriptionFromFile(descriptionFilePath);
	}

	private String readDescriptionFromFile(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				contentBuilder.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Error reading the description file.";
		}
		return contentBuilder.toString();
	}

	public String getEventName() {
		return eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public String getMainTheme() {
		return mainTheme;
	}

	public String getRegisterUrl() {
		return registerUrl;
	}

	public void setRegisterUrl(String registerUrl) {
		this.registerUrl = registerUrl;
	}

	public String getChatUrl() {
		return chatUrl;
	}

	public void setChatUrl(String chatUrl) {
		this.chatUrl = chatUrl;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void describeEvent() {
		System.out.println("Event Name: " + eventName);
		System.out.println("Event Date: " + eventDate);
		System.out.println("Number of Participants: " + numberOfParticipants);
		System.out.println("Main Theme: " + mainTheme);
		System.out.println("Register URL: " + registerUrl);
		System.out.println("Chat URL: " + chatUrl);
		System.out.println("Event Location: " + eventLocation);
		System.out.println("Event Description: " + eventDescription);
	}
}

class TriviaNightCollection {
	private int count;
	private TriviaNight[] events;

	public TriviaNightCollection(int initialCapacity) {
		events = new TriviaNight[initialCapacity];
		count = 0;
	}

	public void add(TriviaNight newEvent) {
		if (count == events.length) {
			// Expand the array if needed
			TriviaNight[] newEvents = new TriviaNight[count * 2];
			System.arraycopy(events, 0, newEvents, 0, count);
			events = newEvents;
		}
		events[count++] = newEvent;
	}

	public void printOne(int i) {
		if (i >= 0 && i < count) {
			events[i].describeEvent();
		} else {
			System.out.println("Invalid index.");
		}
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println("Event #" + (i + 1));
			events[i].describeEvent();
		}
	}

	public void find(String searchString) {
		for (int i = 0; i < count; i++) {
			if (events[i].getEventName().contains(searchString) ||
					events[i].getEventDate().contains(searchString) ||
					events[i].getMainTheme().contains(searchString) ||
					events[i].getEventLocation().contains(searchString) ||
					events[i].getEventDescription().contains(searchString)) {
				events[i].describeEvent();
			}
		}
	}

	public void sort() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - i - 1; j++) {
				if (events[j].getNumberOfParticipants() > events[j + 1].getNumberOfParticipants()) {
					TriviaNight temp = events[j];
					events[j] = events[j + 1];
					events[j + 1] = temp;
				}
			}
		}
	}
}
