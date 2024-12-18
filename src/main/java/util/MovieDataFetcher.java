package util;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class MovieDataFetcher {
    public List<byte[]> getAllMovieImages() {
        List<byte[]> images = new ArrayList<>();
        Connection conn = Database.getInstance();
        String query = "SELECT Image FROM Movie";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) images.add(rs.getBytes("Image"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }
    
    public int getMovieCount() {
        int count = 0;
        Connection conn = Database.getInstance();
        String query = "SELECT COUNT(*) AS total FROM Movie";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) count = rs.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public double getTotalIncome() {
        double totalIncome = 0.0;
        Connection conn = Database.getInstance();
        String query = "SELECT SUM(TotalPrice) AS totalIncome FROM [Ticket] WHERE BookingStatus = 'success'";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) totalIncome = rs.getDouble("totalIncome");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalIncome;
    }
    
    public int getSoldTicketCount() {
        int count = 0;
        Connection conn = Database.getInstance();
        String query = 
                "SELECT COUNT(t.TicketID) AS TotalTickets " +
                "FROM Ticket t " +
                "LEFT JOIN TicketSeat ts ON t.TicketID = ts.TicketID " +
                "LEFT JOIN SeatSchedule ss ON ts.SeatScheduleID = ss.SeatScheduleID " +
                "LEFT JOIN Schedule sch ON ss.ScheduleID = sch.ScheduleID " +
                "LEFT JOIN Movie m ON sch.MovieID = m.MovieID " +
                "LEFT JOIN [User] c ON t.CustomerID = c.UserID " +
                "LEFT JOIN [User] s ON t.StaffID = s.UserID;";
        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) count = rs.getInt("TotalTickets");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public int getCustomerCount() {
        int count = 0;
        Connection conn = Database.getInstance();
        String query = "SELECT COUNT(*) AS totalCustomers FROM [Account] WHERE Role = 'Customer'";
        try (PreparedStatement pstm = conn.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()) {
            if (rs.next()) count = rs.getInt("totalCustomers");
        } catch (SQLException e) {e.printStackTrace();}
        
        return count;
    }
}
