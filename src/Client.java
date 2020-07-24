import objects.*;

import java.io.DataInputStream;
import java.io.IOException;

public class Client extends GenericClient{
	private LocalPlayer p1 = new LocalPlayer();
	private LocalPlayer dealer = new LocalPlayer();

	private DataInputStream keyboardInput = null;
	private Thread toServerThread;

	private String name;

	public Client(String name) {
		this.name = name;
	}

	@Override
	protected void handleMessageFromServer(Command command, String message) {

	}

	public void start(String address, int port) {
		super.start(address, port);
		// establish a connection
		// takes keyboardInput from terminal
		keyboardInput = new DataInputStream(System.in);


		// keep reading until "Over" is keyboardInput
		toServerThread = new ToServerThread();
		toServerThread.start();

		// close the connection
	}

	public void stop() {
		super.stop();
		toServerThread.interrupt();
	}

	private class ToServerThread extends Thread {
		public void run() {


		}
	}

	public static void main(String args[])
	{
		Client client = new Client(args[0]);
		client.start("127.0.0.1", 55556);
	}
}
