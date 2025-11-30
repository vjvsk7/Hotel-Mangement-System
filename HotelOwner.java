import java.util.*;
public class HotelOwner {
    private String Ownerid;
    private String Ownername;
    private List<Hotel>Ownedhotels;

    public HotelOwner(String ownerid, String ownername, List<Hotel> ownedhotels) {
        this.Ownerid = ownerid;
        this.Ownername = ownername;
        this.Ownedhotels =ownedhotels!=null?ownedhotels: new ArrayList<>();
    }

    public List<Hotel> getOwnedhotels() {
        return Ownedhotels;
    }

    public boolean addhotel(Hotel hotel){
        if(hotel==null)return false;
        if(Ownedhotels.contains(hotel))return false;
        Ownedhotels.add(hotel);
        return true;
    }
    public boolean removehotel(Hotel hotel){
        if(Ownedhotels.contains(hotel)){
            Ownedhotels.remove(hotel);
            return true;
        }
        return false;
    }
    public void updatehotel(Hotel hotel,String newname) {
        if (Ownedhotels.contains(hotel)) {
            hotel.setHotelname(newname);
        }
    }
        public void displayownedhotels(){
            for(Hotel ownedhotel:Ownedhotels){
                System.out.println("Hotel."+ownedhotel.getHotelname());
                System.out.println("City:"+ownedhotel.getcity());;
            }
        }



}
