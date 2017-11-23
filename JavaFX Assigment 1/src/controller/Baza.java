package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Ugovor;

/**
 *
 * @author Nermin
 */
public class Baza {
    
   public  static void snimiUgovor(Ugovor ugovor) throws SQLException{
        
        Connection conn=Konekcija.getConnection();
        
        PreparedStatement ps=null;
        String sql="INSERT INTO ugovori (idUgovora,ime,prezime,adresa,brzina,protok,trajanjeUgovora) VALUES (?,?,?,?,?,?,?)";
        ps=conn.prepareStatement(sql);
        ps.setInt(1, 0);
        ps.setString(2, ugovor.getIme());
        ps.setString(3, ugovor.getPrezime());
        ps.setString(4, ugovor.getAdresa());
        ps.setString(5, ugovor.getBrzina());
        ps.setString(6, ugovor.getProtok());
        ps.setString(7, ugovor.getTrajanjeUgovora());
        
        try {
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
   
   
   public static ObservableList<Ugovor> sviUgovori() throws SQLException{
        ObservableList podaci= FXCollections.observableArrayList();
        Connection conn=Konekcija.getConnection();
        String sql="SELECT * FROM ugovori";
        ResultSet rs=conn.createStatement().executeQuery(sql);
        
        while (rs.next()) {
          Ugovor ugovor=new Ugovor();
          ugovor.setidUgovora(rs.getInt("idUgovora"));
          ugovor.setIme(rs.getString("ime"));
          ugovor.setPrezime(rs.getString("prezime"));
          ugovor.setAdresa(rs.getString("adresa"));
          ugovor.setBrzina(rs.getString("brzina"));
          ugovor.setProtok(rs.getString("protok"));
          ugovor.setTrajanjeUgovora(rs.getString("trajanjeUgovora"));
          podaci.add(ugovor);
       }
       return podaci;
   }
   
   public static void brisiUgovor(int id) throws SQLException{
     
       Connection conn=Konekcija.getConnection();
       PreparedStatement ps=null;
       String sql="DELETE FROM Ugovori WHERE idUgovora=?";
       ps=conn.prepareStatement(sql);
       ps.setInt(1,id);
       
         try {
          ps.executeUpdate();
        } catch (Exception e) {
        }
        
   }
 
}