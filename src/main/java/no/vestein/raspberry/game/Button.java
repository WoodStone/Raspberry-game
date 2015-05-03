package no.vestein.raspberry.game;

import java.util.ArrayList;
import java.util.List;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class Button {
	
	private final GpioController gpio = GpioFactory.getInstance();
	private final GpioPinDigitalInput buttonPin;
	private final int dirx;
	private final int diry;
	
	private List<IButtonListener> listeners = new ArrayList<>();
	
	public Button(Pin pin, int dirx, int diry) {
		this.dirx = dirx;
		this.diry = diry;
		listeners.add(Board.getInstance());
		buttonPin = gpio.provisionDigitalInputPin(pin, PinPullResistance.PULL_DOWN);
		
		buttonPin.addListener(new GpioPinListenerDigital() {
			
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				for (IButtonListener listener : listeners) {
					listener.buttonPressed(dirx, diry);
				}
				
			}
		});
		
	}
}
