public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        UserManager userManager=new UserManager();
        User Admin=new User("adminvsk@gmail.com","123@Sakthi",Role. MASTER_ADMIN);
        boolean adduser= userManager.adduser(Admin);
        User hotelowner=new User("hotelowner@gmail.com","123@Hotel1",Role.HOTEL_ADMIN);
        userManager.adduser(hotelowner);
        HotelManager hotelManager=new HotelManager();
        HotelInput hotelInput=new HotelInput();
        Hotel newhotel=hotelInput.collecthoteldetails();
        hotelManager.addhotel(newhotel);
        hotelManager.displayhotelsandrooms();
        Payment paymentprocessor=new CreditCardPayment();
        BookingManager bookingManager=new BookingManager(hotelManager.getroomsmap(),paymentprocessor);
    }
}