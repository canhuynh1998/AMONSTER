package character;

import java.io.Serializable;
import java.util.*;

public class Champion implements Serializable {
    static Scanner in = new Scanner(System.in);

    private String name;
    private float HealthCap;	//máu
    private int physical;	//attribute for physical strength
    private float physicalRate;	//damn vật lý

    public Champion(String name)
    {
        this.name = name;
        this.HealthCap=20.0f;
        this.physicalRate=4.0f;
        this.physical=4;
    }

    /**********SETTER**********/
    public void setPhysical(int attribute)
    {
        this.physical+=attribute;
        this.physicalRate+=attribute*10.0f;
        this.HealthCap+=attribute*2.0f;
    }

    public void setHealth(float healthDecrease) { this.HealthCap-=healthDecrease; }

    /**********GETTER**********/
    public String getName() { return this.name; }

    public float getHealthCap() { return this.HealthCap; }

    /*Physical attribute*/
    private int getPhysical() { return this.physical; }

    /*Physical damage*/
    public float getPhysicalRate() { return this.physicalRate; }

    /*
    championCreation() funciton
    asking for the name of champion
    /to instantiate new Champion()
    */
    public static String championCreation()
    {
        System.out.println("Please enter your champion's name");
        return in.nextLine();
    }

    public  void print()
    {
        System.out.printf("Name : %s , Health Cap : %2.2f , Physical Damage : %2.2f , Physical Attribute : %d\n",
                this.name, this.HealthCap,this.physicalRate,this.physical);
    }

}
