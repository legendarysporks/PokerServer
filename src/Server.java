import objects.*;

import java.io.IOException;
import java.util.HashMap;

public class Server extends GenericServer{

	private LocalPlayer p1 = new LocalPlayer();
	private LocalPlayer dealer = new LocalPlayer();
	private Deck deck = new Deck();

	private HashMap<ClientProxy, String> nameList = new HashMap<>();

	@Override
	protected void handleMessageFromClient(ClientProxy client, Command command, String message) {
		switch(command){
			case ACTION:

		}
	}

	protected void removeClient(ClientProxy client) {
		super.removeClient(client);
		String name = nameList.get(client);
		nameList.remove(client);
	}

	public static void main(String args[])
	{
		try{
			Server test = new Server();
			test.start(55556);
		}
		catch(IOException i){
			System.out.println(i);
		}
	}
}
