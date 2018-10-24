package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVCStuff.GameController;
import gameStuff.Player;

/**
 * Servlet implementation class GritarUNO
 */
@WebServlet("/GritarUNO")
public class GritarUNO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GritarUNO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String player_ipAdress = request.getRemoteAddr();
		
		Player player = GameController.getInstance().SearchPlayerByIP(player_ipAdress);
		PrintWriter writer = response.getWriter();
		
		if (player != null) {
			player.UNO();
			//GameController.getInstance().actionUNO(player);
			 
			writer.write("Gritaste Uno");
			writer.flush();
		}
		else {
			writer.write("No se encontro al jugador");
			writer.flush();
		}
	}

}
