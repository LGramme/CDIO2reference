package controller;

import socket.DummySocketHandler;
import socket.ISocketController;
import weight.DummyConsoleController;
import weight.IWeightInterfaceController;
/**
 * Simple class to fire up application and inject implementations
 * @author Christian
 *
 */
public class Main {

	public static void main(String[] args) {
		ISocketController socketHandler = new DummySocketHandler();
		IWeightInterfaceController uiController = new DummyConsoleController();
		//Injecting socket and uiController into mainController - Replace with improved versions...
		IMainController mainCtrl = new DummyMainController(socketHandler, uiController);
		//.init and .start could be merged
		mainCtrl.start();
		
	}
}
