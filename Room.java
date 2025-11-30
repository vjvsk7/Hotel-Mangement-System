public class Room {
    private final int roomNumber;
    private final RoomType roomType;
    private boolean available;

    public Room(int roomNumber, RoomType roomType, boolean available) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.available = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
