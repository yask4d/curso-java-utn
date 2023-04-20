package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
	
	Connection conn=null;
	String bd="world";
	String user="root";
	String pass="Skidrow1968";
	String ip="localhost";
	String puerto="3306";
	
	String cadena="jdbc:mysql://" + ip + ":" + puerto + "/" + bd;
	
	public Connection miConexion()
	{
		try {
			conn = DriverManager.getConnection(cadena, user, pass);
			JOptionPane.showMessageDialog(null,"Conexion realizada");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrio un error" + " al conectarse " + e.toString());
		}
		return conn;		
	}
}






