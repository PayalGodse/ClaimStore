package com.mitchell.examples.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mitchell.examples.jdbc.ConnectionFactory;
import com.mitchell.examples.jdbc.DbUtil;

public class ReadClaim {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ReadClaim() {

	}

	public void readClaim() {
		try {

			connect = ConnectionFactory.getConnection();
			System.out.println("connection: " + connect);
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from mitchellclaimtype");

			while (resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				Date date = resultSet.getDate("lossDate");
				int vehicleId = resultSet.getInt("vehicleInfo");

				preparedStatement = connect
						.prepareStatement("select * from vehicleinfotype where id=?");
				preparedStatement.setInt(1, vehicleId);
				ResultSet resultSet1 = preparedStatement.executeQuery();

				System.out.println("First Name: " + firstName);
				System.out.println("Last name: " + lastName);
				System.out.println("Date: " + date);
				if (resultSet1.next()) {
					System.out.println("Vehicle id: "
							+ resultSet1.getString("vin"));
					System.out.println("Make Description: "
							+ resultSet1.getString("makeDesc"));
					System.out.println("Model Description: "
							+ resultSet1.getString("modelDesc"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			DbUtil.close(connect);
			DbUtil.close(statement);
			DbUtil.close(preparedStatement);
		}
	}

	public void readClaim(String from, String to) {
		try {

			connect = ConnectionFactory.getConnection();
			System.out.println("connection: " + connect);
			statement = connect.createStatement();
			preparedStatement = connect
					.prepareStatement("SELECT * FROM mitchellclaimtype WHERE  (lossdate BETWEEN ? AND ?)");
			preparedStatement.setDate(1, Date.valueOf(from));
			preparedStatement.setDate(2, Date.valueOf(to));
			resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					String firstName = resultSet.getString("firstName");
					String lastName = resultSet.getString("lastName");
					Date date = resultSet.getDate("lossDate");
					int vehicleId = resultSet.getInt("vehicleInfo");

					preparedStatement = connect
							.prepareStatement("select * from vehicleinfotype where id=?");
					preparedStatement.setInt(1, vehicleId);
					ResultSet resultSet1 = preparedStatement.executeQuery();

					System.out.println("First Name: " + firstName);
					System.out.println("Last name: " + lastName);
					System.out.println("Date: " + date);
					if (resultSet1.next()) {
						System.out.println("Vehicle id: "
								+ resultSet1.getString("vin"));
						System.out.println("Make Description: "
								+ resultSet1.getString("makeDesc"));
						System.out.println("Model Description: "
								+ resultSet1.getString("modelDesc"));
					}
				}
				
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			DbUtil.close(connect);
			DbUtil.close(statement);
			DbUtil.close(preparedStatement);
		}

	}
}
