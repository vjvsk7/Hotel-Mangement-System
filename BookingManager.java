import java.util.*;

public class BookingManager {
    private final Map<Integer, Booking> bookingMap;
    private final Map<Integer, Room> roomsMap;
    private final Payment paymentProcessor;

    public BookingManager(Map<Integer, Room> roomsMap, Payment paymentProcessor) {
        this.roomsMap = roomsMap;
        this.bookingMap = new HashMap<>();
        this.paymentProcessor = paymentProcessor;
    }

    private boolean isRoomAvailable(Room room, Date checkInDate, Date checkOutDate) {
        for (Booking booking : bookingMap.values()) {
            if (booking.getRoom().equals(room) && booking.isActive()) {
                if (!(checkOutDate.before(booking.getCheckInDate()) || checkInDate.after(booking.getCheckOutDate()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public Booking createBooking(User guest, int roomNumber, Date checkInDate, Date checkOutDate) {
        Room room = roomsMap.get(roomNumber);
        if (room == null) {
            System.out.println("Room with this specific room number is not found.");
            return null;
        }
        if (!isRoomAvailable(room, checkInDate, checkOutDate)) {
            System.out.println("Room not available for selected dates.");
            return null;
        }

        int bookingId = bookingMap.size() + 1;

        Booking booking;
        try {
            booking = new Booking(bookingId, room, guest, checkInDate, checkOutDate);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid booking dates: " + e.getMessage());
            return null;
        }

        double totalPrice = booking.calculatePrice();

        boolean paymentSuccess = paymentProcessor.pay(totalPrice);
        if (!paymentSuccess) {
            System.out.println("Payment failed. Booking not created.");
            return null;
        }

        bookingMap.put(bookingId, booking);
        room.setAvailable(false);

        System.out.println("Booking created successfully with ID: " + bookingId);
        return booking;
    }

    public boolean cancelBooking(int bookingId) {
        Booking booking = bookingMap.get(bookingId);
        if (booking != null && booking.isActive()) {
            booking.cancelBooking();
            boolean refundSuccess = paymentProcessor.refund(booking.getTotalPrice());
            if (refundSuccess) {
                System.out.println("Booking cancelled and refund processed.");
            } else {
                System.out.println("Booking cancelled but refund failed.");
            }
            return true;
        } else {
            System.out.println("Booking not found or already cancelled.");
            return false;
        }
    }

}



