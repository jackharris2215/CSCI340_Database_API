package App.Domain;

public class Employee {
    private int id;
    private String name;
    private String dateOfBirth;
    private int WorkLocation;


    public int getId(){ return this.id;}
    public void setId(int id){ this.id = id;}
    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name;}
    public String getDateOfBirth(){ return this.dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth){ this.dateOfBirth = dateOfBirth; }
    public int getWorkLocation(){ return this.WorkLocation; }
    public void setWorkLocation(int WorkLocation){ this.WorkLocation = WorkLocation; }

}
