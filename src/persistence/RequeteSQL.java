package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Conseiller;

public class RequeteSQL {
	public static void sauverEnBase(Conseiller cons) {
		String url="jdbc:mysql://localhost/agence";
		String login="root";
		String passwd="";
		Connection cn=null;
		Statement st=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver ok");
			cn= DriverManager.getConnection(url, login, passwd);
			System.out.println("Connexion réussie");
			
			//TODO Trouver l'erreur SQL
			st=cn.createStatement();
			String sql="INSERT INTO `conseiller`(`id`, `nom`, `prenom`, `age`) VALUES ('"+cons.getId()+","+cons.getNom()+","+cons.getPrenom()+","+cons.getAge()+"')";
			st.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
