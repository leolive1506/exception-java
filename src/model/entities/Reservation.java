package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
  private Integer roomNumber;
  private Date checkIn;
  private Date checkOut;
  private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

  public Reservation() {
  }
  
  public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException{
    if (!checkOut.after(checkIn)) {
      throw new DomainException("Check-out date must be after check-in date");
    }
    this.roomNumber = roomNumber;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public Integer getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {
    this.roomNumber = roomNumber;
  }

  public Date getCheckIn() {
    return checkIn;
  }

  public Date getCheckOut() {
    return checkOut;
  }

  public long duration() {
    long diff = checkOut.getTime() - checkIn.getTime();
    // duration in dias
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }

  public void updateDates(Date checkIn, Date checkOut) throws DomainException {
    Date now = new Date();
    if (checkIn.before(now) || checkOut.before(now)) {
      throw new DomainException("Error in reservation: Reservation date for update must be future dates");
    } 
    
    if (!checkOut.after(checkIn)) {
      throw new DomainException("Error in reservation: check-out date must be after check-in date");
    }

    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  @Override
  public String toString() {
    return "Room "
      + roomNumber
      + ", check-in: "
      + SDF.format(checkIn)
      + ", check-out: "
      + SDF.format(checkOut)
      + ", "
      + duration()
      + " nights";
  }

  
  
}
