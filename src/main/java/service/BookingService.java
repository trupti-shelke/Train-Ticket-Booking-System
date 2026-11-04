package service;

import dao.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class BookingService {

    public void bookTicket() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Passenger Name : ");
        String name = sc.nextLine();

        System.out.print("Train Id : ");
        int trainId = sc.nextInt();

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "insert into booking(passenger_name,train_id) values(?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, trainId);

            int i = ps.executeUpdate();

            if(i > 0) {

                System.out.println("Ticket Booked Successfully");
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}