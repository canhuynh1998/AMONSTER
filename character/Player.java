package character;

import java.io.Serializable;

public class Player implements Serializable {
    private String userName;
    private int level;
    private Champion champ;
    private Monster monster;

    public Player(String name)
    {
        this.userName=name;
        this.level=1;
    }
    /***********SETTER**********/
    public void setMonster(Monster monster) { this.monster = monster; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setLevel(){this.level++;}

    public  void setChamp(Champion champ) { this.champ = champ; }

    /**********GETTER**********/
    public Champion getChamp() { return champ; }

    public Monster getMonster() { return monster; }

    public String getUserName() { return userName; }

    public int getLevel(){return level; }


    public void print()
    {
        System.out.println("Username : "+this.userName);
        System.out.println("Champion :");
       this.champ.print();
    }
}
