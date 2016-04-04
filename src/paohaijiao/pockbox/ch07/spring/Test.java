package paohaijiao.pockbox.ch07.spring;

public class Test implements Runnable {

	public static void main(String[] args) {
		Thread thread=new Thread(new Test());
		thread.start();
		//thread.start();
		

	}

	@Override
	public void run() {
	  System.out.print("hello");
		
	}

}
