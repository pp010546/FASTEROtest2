package com.fastero.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fastero.dao.SQL.OrderMasterSQL;
import com.fastero.dao.intf.OderMasterDAOIn;
import com.fastero.dao.intf.UserStoreConnDAOIn;
import com.fastero.model.vo.OrderMasterVO;
import com.fastero.model.vo.UserStoreConnVO;

public class UserStoreConnDAOIm implements UserStoreConnDAOIn {

	private static DataSource ds = null;
	private static OrderMasterSQL SQL = null;

	public UserStoreConnDAOIm() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/FASTERO");
			SQL = new OrderMasterSQL();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserStoreConnVO> getAll() {
		List<UserStoreConnVO> list = new ArrayList<>();
		UserStoreConnVO vo = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(SQL.GET_ALL);) {
			System.out.println("連線成功");
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
//					user_id, store_id, status, status_update_time
					vo = new UserStoreConnVO();
					
					vo.setUserId(rs.getInt("user_id"));
					vo.setStoreId(rs.getInt("store_id"));
					vo.setStatus(rs.getInt("status"));
					vo.setStatusUpdateTime(rs.getString("status_update_time"));
					
					list.add(vo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error();
		}

		return list;
	}

}
