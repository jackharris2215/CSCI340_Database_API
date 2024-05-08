package App.Domain;

public class Tea {
    private String name;
    private String type;
    private float brewTemp;
    private String brewTime;
    private float brewQuantity;
    private float amount;

    public String getName() {return name;}
    public String getType() {return type;}
    public float getBrewTemp() {return brewTemp;}
    public String getBrewTime() {return brewTime;}
    public float getBrewQuantity() {return brewQuantity;}
    public float getAmount() {return amount;}

    public void setName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}
    //Semantic constraints
    public void setBrewTemp(float brewTemp) {this.brewTemp = Math.max(0, brewTemp);}
    public void setBrewTime(String brewTime) {this.brewTime = brewTime;}
    public void setBrewQuantity(float brewQuantity) {this.brewQuantity = Math.max(0, brewQuantity);}
    public void setAmount(float amount) {this.amount = Math.max(0, amount);}

}
