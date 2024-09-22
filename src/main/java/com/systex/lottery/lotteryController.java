package com.systex.lottery;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

import com.systex.service.LotteryService;

/**
 * Servlet implementation class lotteryController
 */
public class lotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lotteryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher view;
		LinkedList<String>errorMsgs = new LinkedList<>();
		request.setAttribute("errors", errorMsgs);
		
		//Retrieve Form Data
		String group = request.getParameter("group");
		String exclude = request.getParameter("exclude");
		//Validate Form Data
		if(group == null || group.trim().isEmpty()) {
			errorMsgs.add("組數必須填寫");
		}
		
		if(exclude == null || exclude.trim().isEmpty()) {
			errorMsgs.add("排除欄位必須填寫");
		}
		if(!errorMsgs.isEmpty()) {
			view=request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
			return; //把控制權還Container
		}
		int groupNum = 0;
		try {
		    groupNum = Integer.parseInt(group);
		  } catch (NumberFormatException e) {
		    errorMsgs.add("組數欄位請填寫數字");
		}
		LinkedList<Integer> excludeNum = new LinkedList<>();
		for(String n : exclude.split(" ")){
			try {
				excludeNum.add(Integer.parseInt(n));
			  } catch (NumberFormatException e) {
			    errorMsgs.add("請輸入正確排除數字");
			    break;
			}
        }
		if(!errorMsgs.isEmpty()) {
			view=request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
			return; //把控制權還Container
		}
		//Invoke Biz Logic
		try {
			LotteryService lSer = new LotteryService();
			request.setAttribute("results", lSer.getNumbers(groupNum, excludeNum));
			view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			errorMsgs.add(e.getMessage());
			view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
