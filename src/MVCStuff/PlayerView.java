package MVCStuff;


import java.util.List;

import com.google.gson.Gson;
import cardStuff.Card;

public class PlayerView {//Esta clase es la que se va a enviar a java script
	
	String playerName;
	Card lastCard;
	List<Card> Hand;
	int[] numHandPlayers; //El tamaño del array es la cantidad de jugador que hay, y el array en la posicion i es la cantidad de cartas que tiene en la mano el jugador i
	private String ipAdress;

	
	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public PlayerView(String pPlayerName, String pPlayerIp ) {
		playerName = pPlayerName;
		ipAdress = pPlayerIp;
		GameView.getInstance().getPlayersView().add(this);			

	}
	
	public String convertToJson() {

			Gson json = new Gson();
			System.out.println(json.toJson(this).toString());
			return json.toJson(this);
	}
	/*
	public static void main(String[] args) {
		PlayerView test = new PlayerView("test", "1.123.5");
		System.out.println(test.convertToJson());
	}
	*/
}
