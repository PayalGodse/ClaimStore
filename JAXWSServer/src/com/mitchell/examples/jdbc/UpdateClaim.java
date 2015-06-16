package com.mitchell.examples.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mitchell.examples.jdbc.ConnectionFactory;
import com.mitchell.examples.jdbc.DbUtil;

public class UpdateClaim {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public UpdateClaim() {
		// TODO Auto-generated constructor stub
	}
	public void updateClaim(String no) {
		try {
			connect = ConnectionFactory.getConnection();
			String updateSQL = "UPDATE mitchellclaimtype"
					+ "SET STATUS = 'CLOSED' WHERE claimNumber = ?";
			PreparedStatement preparedStatement = connect
					.prepareStatement(updateSQL);
			preparedStatement.setString(1, no);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			DbUtil.close(connect);
			DbUtil.close(statement);
			DbUtil.close(preparedStatement);
		}
	}
}
