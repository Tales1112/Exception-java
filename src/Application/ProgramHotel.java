package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entities.Reservation;

public class ProgramHotel {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat cs = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Room number:");
		int n = sc.nextInt();
		System.out.println("Check-in Date");
		Date checkIn = cs.parse(sc.next());
		System.out.println("Check-out Date");
		Date checkOut = cs.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reseration: Check-out date must be after check-in Date");

		} else {
			Reservation reservation = new Reservation(n, checkIn, checkOut);
			System.out.println("Reservation:" + reservation.toString());

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in Date");
			checkIn = cs.parse(sc.next());
			System.out.println("Check-out Date");
			checkOut = cs.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reseration: Check-out date must be after check-in Date");

			} else {

				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation" + reservation);
			}
		}

		sc.close();
	}

}
