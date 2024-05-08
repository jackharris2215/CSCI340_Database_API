package App.Domain;

public class Sells {
    private String storeId;
    private int productId;
    private String teaName;

    public void setStoreId(String id){this.storeId = id;}
    public void setProductId(int productId){this.productId = productId;}
    public void setTeaName(String teaName){this.teaName = teaName;}

    public String getStoreId(){ return this.storeId; }
    public int getProductId(){ return this.productId; }
    public String getTeaName(){ return this.teaName; }

}
