package character;

public class Monster {
    private String name;
    private float HealthCap;	//máu
    private float physicalRate;	//damn vật lý

    public Monster(){}

    /***********SETTER**********/
    public void setPhysicalRate(float physicalRate) { this.physicalRate = physicalRate; }

    public void setHealthCap(float healthCap) { this.HealthCap = healthCap ; }

    public void setHealthDecreasse(float championDamange){ this.HealthCap-=championDamange; }

    public void setName(String name) { this.name = name; }


    /**********GETTER**********/
    public String getName() { return name; }

    public float getHealthCap() { return HealthCap; }

    public float getPhysicalRate() { return physicalRate; }

    public void print()
    {
        System.out.println("Name : "+this.name);
        System.out.println("Health Cap : "+this.HealthCap);
        System.out.println("Physical Rate : "+this.physicalRate);
    }



}
