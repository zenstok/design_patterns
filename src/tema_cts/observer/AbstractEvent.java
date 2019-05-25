package tema_cts.observer;
import java.util.ArrayList;


public abstract class AbstractEvent {

	ArrayList<AbstractEventSubscriber> subscribers = new ArrayList<>();
	
	public void addSubscriber(AbstractEventSubscriber subscriber) {
		if(!subscribers.contains(subscriber))
			this.subscribers.add(subscriber);
	}
	
	public void removeSubscriber(int i) {
		this.subscribers.remove(i);
	}
	
	public void notifySubscribers() throws Exception {
		for(AbstractEventSubscriber subscriber:subscribers) {
			//for each subscriber we loop its eventListeners list and if we find an event that matches this event we trigger the handler associated
			for(EventListener el: subscriber.eventListeners) {
				if(el.getEvent() == this) {
					el.getEventHandler().handleEvent(this);
				}
			}
		}
	}
	
	public int numberOfSubscribers() {
		return subscribers.size();
	}
	
	
}
