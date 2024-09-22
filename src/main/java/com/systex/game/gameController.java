package com.systex.game;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.systex.service.GuessGame;

/**
 * Servlet implementation class gameController
 */
public class gameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher view;
		GuessGame gg = new GuessGame(10, 3);
		System.out.println(gg.getLuckyNumber());
		HttpSession session = request.getSession();
		session.setAttribute("guessgame", gg);
		view = request.getRequestDispatcher("guess.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher view;
		int ans = Integer.parseInt(request.getParameter("guess"));
		HttpSession session = request.getSession();
		GuessGame gg  = (GuessGame)session.getAttribute("guessgame");
		if(gg.guess(ans) && gg.getRemains()>=0) { //right answer
			view = request.getRequestDispatcher("youWin.jsp");
			view.forward(request, response);
		}
		else if(gg.getRemains()>0) {
			session.setAttribute("guessgame", gg);
			String hint = "猜錯了，還有"+gg.getRemains()+"次!";
			request.setAttribute("hint", hint);
			view = request.getRequestDispatcher("guess.jsp");
			view.forward(request, response);
		}
		else {
			String hint = "答案是"+gg.getLuckyNumber()+"!";
			request.setAttribute("hint", hint);
			view = request.getRequestDispatcher("youLose.jsp");
			view.forward(request, response);
		}
	}

}
