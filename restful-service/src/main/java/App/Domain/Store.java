package App.Domain;

public class Store {
    private String id;
    private String address;

    public void setId(String id){this.id = id;}
    public void setAddress(String address){this.address = address;}

    public String getId(){ return this.id; }
    public String getAddress(){ return this.address; }

}
