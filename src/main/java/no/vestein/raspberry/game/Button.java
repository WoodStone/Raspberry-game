package no.vestein.raspberry.game;

import java.util.ArrayList;
import java.util.List;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public enum Button {
	
	UP(RaspiPin.GPIO_00, 0, -1),
	DOWN(RaspiPin.GPIO_02, 0, 1),
	RIGHT(RaspiPin.GPIO_03, 1, 0),
	LEFT(RaspiPin.GPIO_04, -1, 0),;
	
	private final GpioController gpio = GpioFactory.getInstance();
	private final GpioPinDigitalInput buttonPin;
	private final int dirx;
	private final int diry;
	
	private List<ButtonListener> listeners = new ArrayList<>();
	
	Button(Pin pin, int dirx, int diry) {
		this.dirx = dirx;
		this.diry = diry;
		buttonPin = gpio.provisionDigitalInputPin(pin, PinPullResistance.PULL_DOWN);
		
		buttonPin.addListener(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				for (ButtonListener listener : listeners) {
					listener.buttonPressed(dirx, diry);
				}
			}
		});
	}
	
	public void addListener(ButtonListener listener) {
		if (listeners.contains(listener)) return;
		listeners.add(listener);
	}
	
	public void removeListener(ButtonListener listener) {
		if (!listeners.contains(listener)) return;
		listeners.remove(listener);
	}
	
}
