package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	SimpleDateFormat cs = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new DomainException("Error in reseration: Check-out date must be after check-in Date");

		}
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

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Error in reseration: Check-out date must be after check-in Date");

		}

		this.checkin = checkIn;
		this.checkout = checkOut;

	}

	@Override
	public String toString() {
		return "Reservation : roomNumber:" + roomNumber + ", checkin:" + cs.format(checkin) + ", checkout:"
				+ cs.format(checkout) + ", duration()=" + duration() + "Nights";
	}

}
