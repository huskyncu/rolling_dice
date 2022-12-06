package fp;

import java.util.Timer;
import java.util.TimerTask;

class Delayer extends TimerTask{
	@Override
	public void run() {}
}

public class Delay {
	public Delay(int second) {
		var timer=new Timer();
		timer.schedule(new Delayer(), second);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer.cancel();
	}
}
