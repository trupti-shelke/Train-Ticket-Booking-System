package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.Train;

public class TrainDAO {
	public void addTrain(Train t) {

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("insert into train values(?,?,?,?,?,?)");

			ps.setInt(1, t.getTrainId());
			ps.setString(2, t.getTrainName());
			ps.setString(3, t.getSource());
			ps.setString(4, t.getDestination());
			ps.setDouble(5, t.getFare());
			ps.setInt(6, t.getAvailableSeats());

			ps.executeUpdate();

			System.out.println("Train Added Successfully");

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public void viewTrain() {

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from train");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getDouble(5) + " " + rs.getInt(6));

			}

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public void searchTrain(String source, String destination) {

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        PreparedStatement ps =
	                con.prepareStatement(
	                "select * from train where source=? and destination=?");

	        ps.setString(1, source);
	        ps.setString(2, destination);

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {

	            System.out.println(rs.getInt(1)
	                    +" "+rs.getString(2));
	        }

	    } catch(Exception e) {

	        System.out.println(e);
	    }
	}
	public void viewBooking() {

	    try {

	        Connection con = DBConnection.getConnection();

	        Statement st = con.createStatement();

	        ResultSet rs = st.executeQuery("select * from booking");

	        System.out.println("\n===== BOOKING DETAILS =====");

	        while(rs.next()) {

	            System.out.println("Booking ID : " +
	                    rs.getInt("booking_id"));

	            System.out.println("Passenger Name : " +
	                    rs.getString("passenger_name"));

	            System.out.println("Train ID : " +
	                    rs.getInt("train_id"));

	            System.out.println("---------------------");
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
	public void cancelBooking(int bookingId) {

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql =
	                "delete from booking where booking_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, bookingId);

	        int i = ps.executeUpdate();

	        if(i > 0) {

	            System.out.println("Booking Cancelled Successfully");
	        }
	        else {

	            System.out.println("Booking ID Not Found");
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }
	}
	public void updateTrainFare(int trainId, double fare) {

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql =
	                "update train set fare=? where train_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setDouble(1, fare);
	        ps.setInt(2, trainId);

	        int i = ps.executeUpdate();

	        if(i > 0) {
	            System.out.println("Train Updated Successfully");
	        }
	        else {
	            System.out.println("Train Not Found");
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void deleteTrain(int trainId) {

	    try {

	        Connection con = DBConnection.getConnection();

	        String sql =
	                "delete from train where train_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, trainId);

	        int i = ps.executeUpdate();

	        if(i > 0) {
	            System.out.println("Train Deleted Successfully");
	        }
	        else {
	            System.out.println("Train Not Found");
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}


