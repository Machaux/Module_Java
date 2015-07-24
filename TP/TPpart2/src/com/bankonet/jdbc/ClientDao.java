package com.bankonet.jdbc;

import java.sql.*;
import java.lang.Class;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bankonet.model.*;

public class ClientDao {

	private Connection connection = null;
	private final String DRIVER_NAME= "com.mysql.jdbc.Driver";
	private final String DB_URL="jdbc:mysql:///banque";
	private final String DB_LOGIN="root";
	private final String DB_PASSWORD="";
	
	public ClientDao() {
		
		try {
		Class.forName(DRIVER_NAME);
		connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
		}
		catch (SQLException exception)
		{
			System.out.println("erreur de création de connection");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("impossible de charger le driver"); 
		}
		
	}
	
	public void closeConnection(){
		if (connection != null){
			try{
				connection.close();
			}
			catch (Exception e)
			{
				System.out.println("erreur à la fermeture");
			}
		}
	}
	
	public List<Client> lireCLient(){
		List<Client> clientList = new ArrayList<Client>();
		Statement st =null;
		ResultSet rs =null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM CLIENT");
			while (rs.next()){
				Client client = new Client (Integer.toString(rs.getInt("ID")),rs.getString("NOM"),rs.getString("PRENOM"));
				clientList.add(client);
			}
		} catch (Exception exception){
				exception.printStackTrace();
		}
		finally{
			if (rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("erreur lors de la fermeture de ResultSet");
				}
			}
			if (st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("erreur lors de la fermeture du Statement");
				}
			}
			
		}
		return clientList;
	}

	
	
	public Client lireCLient(int id){
		Client client = null;
		PreparedStatement st =null;
		ResultSet rs = null;
			try {
				st = connection.prepareStatement("SELECT ID, NOM, PRENOM FROM CLIENT WHERE ID= ?");
				st.setInt(1, id);
				rs = st.executeQuery();
				while (rs.next()){
					client = new Client (Integer.toString(id),rs.getString("NOM"),rs.getString("PRENOM"));
				}
			} catch (Exception exception){
					exception.printStackTrace();
			}
			finally{
				if (rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
						System.out.println("erreur lors de la fermeture de ResultSet");
					}
				}
				if (st != null){
					try {
						st.close();
					} catch (SQLException e) {
						System.out.println("erreur lors de la fermeture du Statement");
					}
				}
				
			}
	return client;
}
	
	public List<CompteCourant> lireComptesCourant(Client unClient){
		String id = unClient.getIdentifiant();
		List<CompteCourant> listeComptes = new ArrayList<CompteCourant>();
		PreparedStatement st =null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement("SELECT ID, LIBELLE, SOLDE, DECOUVERTAUTORISE FROM COMPTE WHERE ID_CLIENT= ? AND DISCRIMINANT='CC'");
			st.setInt(1, Integer.parseInt(id));
			System.out.println(Integer.parseInt(id));
			rs = st.executeQuery();
			while (rs.next()){
				CompteCourant cc = new CompteCourant(rs.getInt("ID"), rs.getString("LIBELLE"), rs.getFloat("SOLDE"), rs.getFloat("DECOUVERTAUTORISE"));
				listeComptes.add(cc);
			}
		} catch (Exception exception){
				exception.printStackTrace();
		}
		finally{
			if (rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("erreur lors de la fermeture de ResultSet");
				}
			}
			if (st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("erreur lors de la fermeture du Statement");
				}
			}
			
		}
		return listeComptes;
	}
	
	public List<CompteEpargne> lireComptesEpargne(Client unClient){
		String id = unClient.getIdentifiant();
		List<CompteEpargne> listeComptes = new ArrayList<CompteEpargne>();
		PreparedStatement st =null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement("SELECT ID, LIBELLE, SOLDE, DISCRIMINANT, PLAFOND, TAUX FROM COMPTE WHERE ID_CLIENT= ? AND DISCRIMINANT='CE'");
			st.setInt(1, Integer.parseInt(id));
			System.out.println(Integer.parseInt(id));
			rs = st.executeQuery();
			while (rs.next()){
				CompteEpargne cc = new CompteEpargne(rs.getInt("ID"), rs.getString("LIBELLE"), rs.getFloat("SOLDE"), rs.getDouble("TAUX"));
				listeComptes.add(cc);
			}
		} catch (Exception exception){
				exception.printStackTrace();
		}
		finally{
			if (rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("erreur lors de la fermeture de ResultSet");
				}
			}
			if (st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("erreur lors de la fermeture du Statement");
				}
			}
			
		}
		return listeComptes;
	}
	
	public void ecrireClient(Client client){
		PreparedStatement st =null;
		
		try {
			st = connection.prepareStatement("INSERT INTO CLIENT ( NOM, PRENOM) VALUES (?,?)");
			st.setString(1, client.getNom());
			st.setString(2, client.getPrenom());
			st.executeUpdate();
			
		} catch (Exception exception){
				exception.printStackTrace();
		}
		finally{
			if (st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("erreur lors de la fermeture du Statement");
				}
			}
			
		}
	}
	
	public void ecrireCompte(CompteCourant compteCourant,Client client){
		PreparedStatement st =null;
		
		try {
			st = connection.prepareStatement("INSERT INTO COMPTE ( LIBELLE, SOLDE, ID_CLIENT, DECOUVERTAUTORISE, DISCRIMINANT) VALUES (?,?,?,?,'CC')");
			st.setString(1, compteCourant.getLibelle());
			st.setFloat(2, compteCourant.getSolde());
			st.setInt(3, Integer.parseInt(client.getIdentifiant()));
			st.setString(2, client.getIdentifiant());
			st.executeUpdate();
			
		} catch (Exception exception){
				exception.printStackTrace();
		}
		finally{
			if (st != null){
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("erreur lors de la fermeture du Statement");
				}
			}
			
		}
	}
	
}
