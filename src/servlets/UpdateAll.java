package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVCStuff.GameModel;
import gameStuff.Player;

/**
 * Servlet implementation class TakeCard
 */
@WebServlet("/UpdateAll")
public class UpdateAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAll() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Integer> playersCantCards = GameModel.getInstance().getCantCardPerPlayer();
		Object[][] sumCardPlayers = new Object[playersCantCards.size()][2];
		for(int i = 0;i<playersCantCards.size();i++) {
			sumCardPlayers[i][0] = GameModel.getInstance().getPlayers().get(i).getName();
			sumCardPlayers[i][1] = playersCantCards.get(i);
		}
		PrintWriter writer = response.getWriter();
		writer.write(GameModel.getInstance().convertToJson(sumCardPlayers));
		writer.flush();
		
	}

}
