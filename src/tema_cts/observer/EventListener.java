package tema_cts.observer;

public class EventListener {
	private AbstractEvent event;
	private EventHandler eventHandler;
	
	public EventListener(AbstractEvent event, EventHandler eventHandler) {
		super();
		this.event = event;
		this.eventHandler = eventHandler;
	}

	public AbstractEvent getEvent() {
		return event;
	}

	public EventHandler getEventHandler() {
		return eventHandler;
	}
}
