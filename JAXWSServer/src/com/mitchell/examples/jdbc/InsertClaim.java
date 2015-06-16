package com.mitchell.examples.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import com.mitchell.examples.claim.MitchellClaimType;
import com.mitchell.examples.claim.ObjectFactory;
import com.mitchell.examples.jdbc.ConnectionFactory;
import com.mitchell.examples.jdbc.DbUtil;

public class InsertClaim {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private MitchellClaimType claim;
	private Unmarshaller jaxbUnmarshaller;
	
	public InsertClaim() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public void insertClaim(){
//		MitchellClaimType claim = null;
		 try {
			 
				File file = new File("create-claim.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				//claim = (MitchellClaimType) jaxbUnmarshaller.unmarshal(file);
				
				JAXBElement<MitchellClaimType> jaxbElement =(JAXBElement<MitchellClaimType>)jaxbUnmarshaller.unmarshal(file);
				
				claim = jaxbElement.getValue();
				
			//	JAXBElement<MitchellClaimType> jaxbElement = (JAXBElement<MitchellClaimType>)jaxbUnmarshaller.unmarshal(file);
				//claim = jaxbElement.getValue();
				System.out.println(claim.getClaimantFirstName() + " "+claim.getClaimNumber());
		 
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }
		 
		 System.out.println("INserting record");
		 try {
			connect = ConnectionFactory.getConnection();
		 String insertTableSQL = "INSERT INTO mitchellclaimtype"
					+ "(id,claimNumber,firstName,lastName,status,lossdate,adjusterId) "
					+ "VALUES"
					+ "(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connect.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, 5);
			preparedStatement.setString(2, claim.getClaimNumber());
			preparedStatement.setString(3, claim.getClaimantFirstName());
			preparedStatement.setString(4, claim.getClaimantLastName());
			preparedStatement.setString(5, claim.getStatus());
			//preparedStatement.setInt(7, claim.getLossInfo());
			XMLGregorianCalendar instance = claim.getLossDate();
			java.util.Date d = (java.util.	Date) instance.toGregorianCalendar().getTime();  
			java.sql.Date sqlDt = new java.sql.Date(d.getTime());
			preparedStatement.setDate(6, sqlDt);
			preparedStatement.setString(7, claim.getAssignedAdjusterID());
			//preparedStatement.setInt(9, claim.getVehicles());

			
			// execute insert SQL stetement
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
