import java.util.*;
public class HotelInput {
    Scanner in=new Scanner(System.in);
    HashMap<Integer,Room>localroommap=new HashMap<>();
    public Hotel collecthoteldetails() {
        System.out.println("Enter your hotel name");
        String hotelname=in.next();
        in.nextLine();
        System.out.println("Please enter how many rooms do you want to add");
        int Noofrooms= in.nextInt();
        in.nextLine();
        for(int i=1;i<=Noofrooms;i++){
            System.out.println("please enter the room number");
            int Firstroomno=in.nextInt();
            in.nextLine();
            System.out.println("The roomtypes are STANDARD(1000/DAY),DELUXE(2000/DAY),SUITE(4000/DAY)");
            System.out.println("Please enter your preferred type in capital letters");
            String roomtype=in.next().toUpperCase();
            in.nextLine();
            RoomType type = RoomType.valueOf(roomtype.toUpperCase());
            System.out.println("enter your room availability yes or no");
            String availability=in.next();
           availability= availability.toLowerCase();
            boolean available=false;
           if(availability.equals("yes")||(availability.equals("true"))){
               available=true;
           }else{
               System.out.println("Please enter valid input");
           }
           Room newroom=new Room(Firstroomno,type,available);
           localroommap.put(Firstroomno,newroom);

        }
        System.out.println("Please enter your hotel location " +
               " MADURAI,\n" +
                "    CHENNAI,\n" +
                "    COIMBATORE,\n" +
                "    TRICHY,\n" +
                "    BANGALORE");
      String location=in.next().toUpperCase();
      Cities locationenum=Cities.valueOf(location);
      if(location==null){
          System.out.println("Please enter valid location from list");
      }
      Hotel hotel1=new Hotel(hotelname,localroommap,locationenum);
      return hotel1;

    }
    public Room collectroomdetails(){
        System.out.println("Please enter the room number ");
        int roomno= in.nextInt();
        in.nextLine();

        System.out.println("The room types are STANDARD(1000/DAY), DELUXE(2000/DAY), SUITE(4000/DAY)");
        System.out.println("Please enter your preferred type in CAPITAL letters:");
        String roomtype = in.next().toUpperCase();
        RoomType type = RoomType.valueOf(roomtype);

        System.out.println("Enter room availability (yes/no):");
        String availability = in.next().toLowerCase();
        boolean available = availability.equals("yes") || availability.equals("true");

        return new Room(roomno, type, available);

    }
}
