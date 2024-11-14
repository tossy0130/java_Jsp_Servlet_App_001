package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import beans.ShainBean;
import jakarta.servlet.http.HttpServletRequest;

public class ShainLogic {
	
	/*
	 *  Delete 処理
	 */
	public void deleteShain(int id) throws  SQLException, NamingException {
		
		//社員を削除するSQL
		String sql = "delete  from shain where id=?";
		//SQL実行の準備
		try (Connection con = ConnectionBase.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);) {
		//パラメータをSQLにセット
		pstmt.setInt(1, id);
		//SQL文を表示
		System.out.println(pstmt.toString());
		//SQL実行
		pstmt.executeUpdate();
		}
		
	}
	
	
	/*
	 *  Update 処理
	 */
	public void updateShain(ShainBean shainBean) throws SQLException, NamingException {
		//社員を更新するSQL
		String sql = "update shain set name=?, sei=?, nen=?,  address=? where id=?";
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			//パラメータをSQLにセット
			pstmt.setString(1, shainBean.getName());
			pstmt.setString(2, shainBean.getSei());
			pstmt.setInt(3, shainBean.getNen());
			pstmt.setString(4, shainBean.getAddress());
			pstmt.setInt(5, shainBean.getId());
			//SQL文を表示
			System.out.println(pstmt.toString());
			//SQL実行
			pstmt.executeUpdate();
		}
	}
	
	
	/*
	 *  SELECT 1件抽出
	 */
		
		//社員IDから社員情報を取得
		public ShainBean getShainBean(int id ) throws SQLException, NamingException {
		//社員情報を初期化
		ShainBean shainBean = new ShainBean();
		//社員を取得するSQL
		String sql = "select id, name, sei, nen, address from shain where id=?";
		//SQL実行の準備
		try (Connection con = ConnectionBase.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);) {
		//パラメータをSQLにセット
		pstmt.setInt(1, id);
		//SQL文を表示
		System.out.println(pstmt.toString());
		//SQL実行
		ResultSet rs = pstmt.executeQuery();
		//取得した行数を繰り返す
		while (rs.next()) {
		//取得した値を社員Beanにセット
		shainBean.setId(id);
		shainBean.setName(rs.getString("name"));
		shainBean.setSei(rs.getString("sei"));
		shainBean.setNen(rs.getInt("nen"));
		shainBean.setAddress(rs.getString("address"));
		}
		}
		return shainBean;
		}
	
	/*
	 *  リクエストから、社員Beanを作成
	 */
	public ShainBean getShainBean(HttpServletRequest request) {
		
		// 社員Bean の初期化
		ShainBean shainBean = new ShainBean();
		
		// リクエストから社員Beanの作成 （フォームの値を入れる）
		shainBean.setId(Integer.parseInt(request.getParameter("id")));
		shainBean.setName(request.getParameter("name"));
		shainBean.setSei(request.getParameter("sei"));
		shainBean.setNen(Integer.parseInt(request.getParameter("nen")));
		shainBean.setAddress(request.getParameter("address"));
		
		// 社員Bean を返す
		return shainBean;
		
	}
	
	/*
	 *  社員を登録
	 */
	public void insertShain(ShainBean shainBean) throws SQLException, NamingException {
		
		// 社員を登録
		String sql = "INSERT into shain(id, name, sei, nen, address) values (?, ?, ?, ?, ?);";
		
		try (Connection con = ConnectionBase.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			
			// パラメータをSQLにセット , ゲッターで値をセット
			pstmt.setInt(1, shainBean.getId());
			pstmt.setString(2, shainBean.getName());
			pstmt.setString(3, shainBean.getSei());
			pstmt.setInt(4, shainBean.getNen());
			pstmt.setString(5, shainBean.getAddress());
			
			// SQL文を出力
			System.out.println(pstmt.toString());
			
			// SQL文実行
			pstmt.executeUpdate();
		}
		
	}
	
	
	/*
	 * SELECT 全社員 検索
	 */
	public ArrayList<ShainBean> getAllShain() throws SQLException, NamingException {
		
		ArrayList<ShainBean> shainList = new ArrayList<ShainBean>();
		
		// 社員を取得する SQL
		String sql = "SELECT id, name, sei, nen, address FROM shain";
		
		// SQL 実行
		try (Connection con = ConnectionBase.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			// SQL文を表示
			System.out.println(pstmt.toString());
			
			// SQL 実行
			ResultSet rs = pstmt.executeQuery();
			
			// 取得した行数を繰り返す
			while(rs.next()) {
				
				// 初期化
				ShainBean shainBean = new ShainBean();
				
				// 値を格納
				shainBean.setId(rs.getInt("id"));
				shainBean.setName(rs.getString("name"));
				shainBean.setSei(rs.getString("sei"));
				shainBean.setNen(rs.getInt("nen"));
				shainBean.setAddress(rs.getString("address"));
				
				// リストに追加
				shainList.add(shainBean);
				
				// 値を出力
				/*
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("sei"));
				System.out.println(rs.getInt("nen"));
				System.out.println(rs.getString("address"));
				System.out.println("----------");
				*/
			}
		}
		
		return shainList;
		
	}

}
