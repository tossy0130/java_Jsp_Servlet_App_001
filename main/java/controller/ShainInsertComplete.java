package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import beans.ShainBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ShainLogic;

/**
 * Servlet implementation class ShainInsertComplete
 */
@WebServlet("/ShainInsertComplete")
public class ShainInsertComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShainInsertComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 文字コード指定
		request.setCharacterEncoding("UTF-8");
		// 社員ロジックの作成
		ShainLogic shainLogic = new ShainLogic();
		
		try {
			
			// 社員Bean の作成　（フォームの値を取得）
			ShainBean shainBean = shainLogic.getShainBean(request);
			// DB へ反映　（フォームの値を DBへ insert する）
			shainLogic.insertShain(shainBean);
			// リダイレクト , index.jsp へ
			response.sendRedirect("ShainIndex");
			
		} catch ( SQLException | NamingException e) {
			e.printStackTrace();
			// エラーページへの転送
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
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
