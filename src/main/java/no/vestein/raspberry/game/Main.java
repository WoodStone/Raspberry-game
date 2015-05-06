package no.vestein.raspberry.game;

import java.io.Console;

import com.pi4j.io.gpio.GpioFactory;


public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		Board board = Board.getInstance();
		Renderer renderer = new Renderer(board);
		board.addListener(renderer);
				
		ButtonController buttonController = new ButtonController();
		buttonController.addButtons(Button.values());
		
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
