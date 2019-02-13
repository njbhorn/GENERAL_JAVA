package qa.virtualext;

public interface SayHello {

	public default void sendMsg() {
		System.out.println("Say Hello...");
	}

}
