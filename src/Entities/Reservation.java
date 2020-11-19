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
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Reservation : roomNumber:" + roomNumber + ", checkin:" + cs.format(checkin) + ", checkout:" + cs.format(checkout)
				+ ", duration()=" + duration() + "Nights";
	}
	
}
