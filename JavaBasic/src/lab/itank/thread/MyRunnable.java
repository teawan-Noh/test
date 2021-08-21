package lab.itank.thread;

public class MyRunnable implements Runnable{ //일거리만 있으면 된다

	@Override
	public void run() {
		go();
		
	}
	
	public void go() {
		//실행결과 예측성을 높이는 방법
		try {
			Thread.sleep(2000); //2초동안 잠깐 쉬어라
		} catch (Exception e) {
			e.printStackTrace();
		}
		doMore();
	}
	
	public void doMore() {
		System.out.println(Thread.currentThread().getName());
	}
	


}
