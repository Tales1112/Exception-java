package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entities.Reservation;
import model.exceptions.DomainException;

public class ProgramHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat cs = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Room number:");
			int n = sc.nextInt();
			System.out.println("Check-in Date");
			Date checkIn = cs.parse(sc.next());
			System.out.println("Check-out Date");
			Date checkOut = cs.parse(sc.next());

			Reservation reservation = new Reservation(n, checkIn, checkOut);
			System.out.println("Reservation:" + reservation.toString());

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in Date");
			checkIn = cs.parse(sc.next());
			System.out.println("Check-out Date");
			checkOut = cs.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);

			System.out.println("Reservation" + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation:" + e.getLocalizedMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
