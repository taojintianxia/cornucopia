package tools.guava.eventbus;

import org.junit.Test;

import com.google.common.eventbus.EventBus;

public class BusEventExample {
	@Test
	public void testReceiveEvent() throws Exception {

		EventBus eventBus = new EventBus("test");
		EventListener listener = new EventListener();

		eventBus.register(listener);

		
		eventBus.post(new Event(200));
		eventBus.post(new Event(300));
		eventBus.post(new Event(400));

		System.out.println("LastMessage:" + listener.getLastMessage());
	}

}
