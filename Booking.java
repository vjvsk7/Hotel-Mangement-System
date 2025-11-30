import java.util.Date;

public class Booking {
    private final int bookingId;
    private final Room room;
    private final User guest;
    private final Date checkInDate;
    private final Date checkOutDate;
    private boolean active;
    private double totalPrice;

    public Booking(int bookingId, Room room, User guest, Date checkInDate, Date checkOutDate) {
        if (checkOutDate == null || checkInDate == null || !checkOutDate.after(checkInDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }
        this.bookingId = bookingId;
        this.room = room;
        this.guest = guest;
        this.checkInDate = new Date(checkInDate.getTime());
        this.checkOutDate = new Date(checkOutDate.getTime());
        this.active = true;
        this.totalPrice = calculatePrice();
    }

    public double calculatePrice() {
        long diff = checkOutDate.getTime() - checkInDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        if (days == 0) days = 1;
        return days * room.getRoomType().getPrice();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void cancelBooking() {
        this.active = false;
        this.room.setAvailable(true);
    }

    public int getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public User getGuest() {
        return guest;
    }

    public Date getCheckInDate() {
        return new Date(checkInDate.getTime());
    }

    public Date getCheckOutDate() {
        return new Date(checkOutDate.getTime());
    }

    public boolean isActive() {
        return active;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
