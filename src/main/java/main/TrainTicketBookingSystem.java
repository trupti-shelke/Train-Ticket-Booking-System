package main;

import java.util.Scanner;

import dao.TrainDAO;
import entity.Train;
import service.BookingService;

public class TrainTicketBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Train");
            System.out.println("2. View Train");
            System.out.println("3. Search Train");
            System.out.println("4. Book Ticket");
            System.out.println("5. View Booking");
            System.out.println("6. Cancel Booking");
            System.out.println("7. Update Train Fare");
            System.out.println("8. Delete Train");
            System.out.println("9. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            switch(choice) {

            case 1:

                Train t = new Train();

                System.out.print("Enter Train Id : ");
                t.setTrainId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Train Name : ");
                t.setTrainName(sc.nextLine());

                System.out.print("Enter Source : ");
                t.setSource(sc.nextLine());

                System.out.print("Enter Destination : ");
                t.setDestination(sc.nextLine());

                System.out.print("Enter Fare : ");
                t.setFare(sc.nextDouble());

                System.out.print("Enter Available Seats : ");
                t.setAvailableSeats(sc.nextInt());

                TrainDAO dao1 = new TrainDAO();
                dao1.addTrain(t);

                break;

            case 2:

                TrainDAO dao = new TrainDAO();
                dao.viewTrain();

                break;

            case 3:

                sc.nextLine();

                System.out.print("Enter Source : ");
                String source = sc.nextLine();

                System.out.print("Enter Destination : ");
                String destination = sc.nextLine();

                TrainDAO dao2 = new TrainDAO();
                dao2.searchTrain(source, destination);

                break;

            case 4:

                BookingService bs = new BookingService();
                bs.bookTicket();

                break;

            case 5:

                TrainDAO dao3 = new TrainDAO();
                dao3.viewBooking();

                break;

            case 6:

                System.out.print("Enter Booking ID : ");
                int bookingId = sc.nextInt();

                TrainDAO dao4 = new TrainDAO();
                dao4.cancelBooking(bookingId);

                break;

            case 7:

                System.out.print("Enter Train ID : ");
                int trainId = sc.nextInt();

                System.out.print("Enter New Fare : ");
                double fare = sc.nextDouble();

                TrainDAO dao5 = new TrainDAO();

                dao5.updateTrainFare(trainId, fare);

                break;

            case 8:

                System.out.print("Enter Train ID : ");
                int deleteId = sc.nextInt();

                TrainDAO dao6 = new TrainDAO();

                dao6.deleteTrain(deleteId);

                break;

            case 9:

                System.exit(0);

                break;
            default:

                System.out.println("Invalid Choice");
            }
        }
    }
}