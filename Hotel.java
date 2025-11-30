import java.util.*;
 class Hotel {
     String hotelname;
     Map<Integer,Room>roomsmap;
     Cities cities;
     List<Room>rooms;

     public Hotel(String hotelname,   Map<Integer,Room> roomsmap, Cities cities) {
         this.hotelname = hotelname;
         this.roomsmap=roomsmap;
         this.cities = cities;
     }

     public void setHotelname(String hotelname) {
         this.hotelname = hotelname;
     }

     public String getHotelname() {
         return hotelname;
     }

     public Cities getcity() {
         return cities;
     }

     public Map<Integer, Room> getRoomsmap() {
         return roomsmap;
     }

 }
