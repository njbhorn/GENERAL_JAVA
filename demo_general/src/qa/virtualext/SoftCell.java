package qa.virtualext;

public class SoftCell implements SayHello, WaveGoodbye {

	@Override
	public void sendMsg() {
		// TODO Auto-generated method stub
		SayHello.super.sendMsg();
		WaveGoodbye.super.sendMsg();


		System.out.println("Say hello, wave goodbye...");
	}



}
