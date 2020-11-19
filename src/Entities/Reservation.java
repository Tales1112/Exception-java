package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	SimpleDateFormat cs = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	@SuppressWarnings("deprecation")
	public Integer duration() {
		return checkout.getDate() - checkin.getDate();
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return ("Error in reservation: Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			return ("Error in reseration: Check-out date must be after check-in Date");

		}

		this.checkin = checkIn;
		this.checkout = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Reservation : roomNumber:" + roomNumber + ", checkin:" + cs.format(checkin) + ", checkout:"
				+ cs.format(checkout) + ", duration()=" + duration() + "Nights";
	}

}
