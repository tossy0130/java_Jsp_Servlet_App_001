package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import beans.ShainBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ShainLogic;

/**
 * Servlet implementation class ShainIndex
 */
@WebServlet("/ShainIndex")
public class ShainIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShainIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShainLogic shainLogic = new ShainLogic();
		
		try {
			// リスト取得
			ArrayList<ShainBean> shainList = shainLogic.getAllShain();
			
			// 社員リストをセットする
			request.setAttribute("shainList", shainList);
			
			// index.jsp へ転送
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
			
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			
			// エラーページへ飛ばす
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request,response);
			
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
