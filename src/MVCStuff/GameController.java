package MVCStuff;

import java.util.List;
import java.util.Stack;

import cardStuff.Card;
import gameStuff.Player;

public class GameController {
	
	//private GameModel model = GameModel.getInstance();
	//private GameView view = GameView.getInstance();
	
	private static GameController game = null;
	
	private GameController() {}
	
	public static GameController getInstance() {
		if (game == null) {
			game = new GameController();
		}
		return game;
	}
	
	public void actionUNO(Player player) {
		GameModel.getInstance().validateUNO(player);
	}
	public void actionPutCard(int posCardInHand,Player player) {
		GameModel.getInstance().validatePutCard(posCardInHand,player);
	}
	public void actionTakeCard(Player player) {
		GameModel.getInstance().giveCards(player, 1);
	}
	public boolean actionStart() {
		return GameModel.getInstance().startGame();
	}
	public void actionAddMe(Player player) {
		GameModel.getInstance().addPlayer(player);
	}
	public void updatePlayers(Card lastCard, String messageForAll, List<Integer> sumCardPlayers) {
		GameView.getInstance().updatePlayers(lastCard,messageForAll,sumCardPlayers);
	}
	public void updatePlayer(Player player, String message) {
		GameView.getInstance().updatePlayer(player,message);
	}
	public Player SearchPlayerByIP(String pIP) {
		for (Player pPlayer : GameModel.getInstance().getPlayers()) {
			if (pPlayer.getIpAdress().equals(pIP)) {
				return pPlayer;
			}
		}
		return null;
		
	}
	
	
}
