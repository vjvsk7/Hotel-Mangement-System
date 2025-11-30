import java.util.*;

public class HotelManager {
private Map<String,Hotel>hotels=new HashMap<>();
        public boolean addhotel(Hotel hotel){
            if(hotel==null||hotels.containsKey(hotel.getHotelname())){
                return false;
            }
            hotels.put(hotel.getHotelname(),hotel);
            return true;
        }
        public boolean removehotel(String hotelname){
            if(hotels.containsKey(hotelname)){
                hotels.remove(hotelname);
                return true;
            }else{
                return false;
            }
        }
        public boolean updatehotelname(String oldname,String newname){
            if(hotels.containsKey(oldname)&&!hotels.containsKey(newname)){
                Hotel hotel=hotels.remove(oldname);
                hotel.setHotelname(newname);
                hotels.put(newname,hotel);
                return true;
            }
            return false;
        }
        public List<Hotel> searchhotelbycity(Cities city){
            List<Hotel>result=new ArrayList<>();
            for(Hotel hotel:hotels.values()){
                if(hotel.getcity()==city){
                    result.add(hotel);
                }

            }
            return result;
        }
        public Collection<Hotel>getallhotels(){
            return hotels.values();
        }
        public Map<Integer,Room>getroomsmap(){
            Map<Integer,Room>roomsmap=new HashMap<>();
            for(Hotel hotel:hotels.values()){
                roomsmap.putAll(hotel.getRoomsmap());
            }
            return roomsmap;
        }

        public void displayhotelsandrooms(){
            if(hotels.isEmpty()){
                System.out.println("No hotels available ");
                return;
            }else{
                for(Hotel hotel:hotels.values()){
                    System.out.println("Hotel:"+hotel.getHotelname()+ "Location:"+hotel.getcity());
                    System.out.println("Rooms:");
                    for(Room room:hotel.getRoomsmap().values()){
                        System.out.println("Room number:"+room.getRoomNumber());
                        System.out.println("Room type:"+room.getRoomType());
                        System.out.println("Room:"+room.isAvailable());
                    }
                }

            }

        }
        public Hotel gethotelbyname(String hotelname){
            return hotels.get(hotelname);
        }
    public void displaypublicHotels() {
        System.out.println("Available Hotels:");
        for (Hotel h : hotels.values()) { // assuming you store hotels in a map
            System.out.println( " | Name: " + h.getHotelname());
        }
    }




}
