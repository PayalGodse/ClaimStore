package com.mitchell.examples.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mitchell.examples.jdbc.ConnectionFactory;
import com.mitchell.examples.jdbc.DbUtil;

public class DeleteClaim {

	public DeleteClaim() {
		// TODO Auto-generated constructor stub
	}


		private Connection connect = null;
		private Statement statement = null;
		private PreparedStatement preparedStatement = null;
		private ResultSet resultSet = null;

		public void deleteClaim(String no) {
			try {

				connect = ConnectionFactory.getConnection();
				System.out.println("connection: " + connect);
				statement = connect.createStatement();
				preparedStatement = connect
						.prepareStatement("DELETE FROM mitchellclaimtype WHERE claimNumber = ?");
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