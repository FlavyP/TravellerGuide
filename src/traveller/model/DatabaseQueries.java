package traveller.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.persistence.MyDatabase;

import com.mysql.jdbc.PreparedStatement;

import utility.persistence.MyDatabase;

public class DatabaseQueries
{

   private MyDatabase db;

   public DatabaseQueries()
   {

      try
      {

         db = new MyDatabase("TravellerGuide");

      }

      catch (ClassNotFoundException e)
      {
         System.out.println("Database issue");
         e.printStackTrace();
      }

   }

   public void addHotelToDatabase(String name, String address, String city,
         int nSr, double pSr, int nDr, double pDr, int nTr, double pTr, int nA,
         double pA)
   {
      try
      {
         

         String sql = "INSERT INTO Hotel (name, city, address, numberOfSingleRooms,"
               + "priceOfASingleRooms, numberOfDoubleRooms, priceOfADoubleRooms, "
               + "numberOfTripleRooms, priceOfATripleRooms, numberOfApartments, priceOfAnApartment"
               + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         db.update(sql, name, city, address, nSr, pSr, nDr, pDr, nTr, pTr, nA, pA);

      }

      catch (SQLException e)
      {
         System.out.println("Database issue");
         e.printStackTrace();
      }
   }

}
