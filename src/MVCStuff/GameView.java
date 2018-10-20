package MVCStuff;

import java.util.ArrayList;
import java.util.List;

import cardStuff.Card;
import gameStuff.Player;

public class GameView {
	//private GameModel model = GameModel.getInstance();
	private List<PlayerView> PlayersView = new ArrayList<PlayerView>();
	
	public List<PlayerView> getPlayersView() {
		return PlayersView;
	}

	private static GameView view;
	
	public static GameView getInstance() {
		if (view == null) {
			view = new GameView();
		}
		return view;
	}
	
	public void updatePlayers(Card lastCard, String messageForAll, List<Integer> sumCardPlayers) {
		for(PlayerView playerView:PlayersView) {
			playerView.sumCardPlayers = sumCardPlayers;
			playerView.lastCard = lastCard;

		}
	}
	public void updatePlayer(Player player, String message) {
		for(PlayerView playerView:PlayersView) {
			if(player.getIpAdress() == playerView.getIpAdress()) {
				playerView.Hand = player.getHand();
			}
		}
	}
}
