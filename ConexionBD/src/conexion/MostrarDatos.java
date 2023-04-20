package conexion;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MostrarDatos {
	
	Connection conn=null;
	String bd="world";
	String user="root";
	String pass="Skidrow1968";
	String ip="localhost";
	String puerto="3306";
	
	String cadena="jdbc:mysql://" + ip + ":" + puerto + "/" + bd;
	
	public void mostrarDatos() {
	    try {
	        conn = DriverManager.getConnection(cadena, user, pass);
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT Name, Population FROM country");
	        JTextArea textArea = new JTextArea();
	        while (rs.next()) {
	            String name = rs.getString("Name");
	            int population = rs.getInt("Population");
	            textArea.append("Name: " + name + ", Population: " + population/1000000 + "\n");
	        }
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        scrollPane.setPreferredSize(new Dimension(400, 300));
	        JOptionPane.showMessageDialog(null, scrollPane);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos: " + e.toString());
	    } finally {
	        try {
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Ocurrio un error al cerrar la conexion: " + e.toString());
	        }
	    }
	}


}