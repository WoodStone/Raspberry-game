package no.vestein.raspberry.game;

import java.io.Console;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;


public class Main {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Button up = new Button(RaspiPin.GPIO_00, 0, -1);
		Button down = new Button(RaspiPin.GPIO_02, 0, 1);
		Button right = new Button(RaspiPin.GPIO_03, 1, 0);
		Button left = new Button(RaspiPin.GPIO_04, -1, 0);
		
		Board board = Board.getInstance();
		Renderer renderer = new Renderer(board);
		board.addListener(renderer);
				
		ButtonController buttonController = new ButtonController();
		buttonController.addButtons(up, down, right, left);
		
		board.init();
		
		while (true) {
			Console console = System.console();
			String[] input = console.readLine().split(" ");
			
			if (input[0].equals("")) {
				break;
			}
		}
		
		GpioFactory.getInstance().shutdown();
		System.exit(0);
	}

}
