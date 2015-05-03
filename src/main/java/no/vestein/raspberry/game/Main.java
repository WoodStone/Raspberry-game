package no.vestein.raspberry.game;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;


public class Main {
	
	
	
	public static Button up = new Button(RaspiPin.GPIO_00, 0, -1);
	public static Button down = new Button(RaspiPin.GPIO_02, 0, 1);
	public static Button right = new Button(RaspiPin.GPIO_03, 1, 0);
	public static Button left = new Button(RaspiPin.GPIO_04, -1, 0);
	
	public static void main(String[] args) throws InterruptedException {
		final GpioController gpio = GpioFactory.getInstance();
		
		Board board = Board.getInstance();
		board.printBoard();
		
		for (;;) {
			Thread.sleep(10000);
		}
		
		//gpio.shutdown();
	}
	


}
