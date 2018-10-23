package gameStuff;

import java.util.ArrayList;
import java.util.List;

import MVCStuff.GameController;
import cardStuff.Card;


public class Player {
	
	private String name;
	private List<Card> hand = new ArrayList<Card>();
	private String ipAdress;
	private boolean UNO = false;

	
	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
	
	public Player(String pName, String pIpAdress) {
		setName(pName);
		ipAdress = pIpAdress;
		GameController.getInstance().actionAddMe(this);
	}
	public boolean isUNO() {
		return UNO;
	}
	public void join() {
		
	}
	public void setUNO(boolean pUNO) {
		UNO = pUNO;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		name = pName;
	}
	public List<Card> getHand() {
		return hand;
	}
	public void takeCard() {
		GameController.getInstance().actionTakeCard(this);
	}
	public void putCard(int CardInHand) {
		GameController.getInstance().actionPutCard(CardInHand,this);
	}
	public void UNO() {
		GameController.getInstance().actionUNO(this);
		}
	public void start() {
		GameController.getInstance().actionStart();
	}
	
}


