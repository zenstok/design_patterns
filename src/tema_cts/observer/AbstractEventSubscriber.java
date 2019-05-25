package tema_cts.observer;

import java.util.ArrayList;

public class AbstractEventSubscriber {
	public ArrayList<EventListener> eventListeners = new ArrayList<>();
	
	public ArrayList<AbstractEvent> getSubscribedEvents() {
		ArrayList<AbstractEvent> events = new ArrayList<>();
		for(EventListener el: eventListeners) {
			events.add(el.getEvent());
		}
		return events;
	}
	
	public void addEventListener(AbstractEvent event, EventHandler eventHandler) {
		//adding this object as a subscriber for the event gave as parameter
		event.addSubscriber(this);
		
		//adding a new event listener for this object
		eventListeners.add(new EventListener(event, eventHandler));
	}

}
