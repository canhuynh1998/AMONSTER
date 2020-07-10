package cancan;
import java.util.*;
import java.io.*;
import character.*;
import error.ProjectException;
import fileeditor.*;
public class Main {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here
//
        try {
            Monster[] monsters = FileIO.readMonster("Monster.txt");
            welcome();
            Player player1 = new Player(userName());
            player1=FileIO.gameContinue(player1);
            operation(player1 , monsters);

        } catch (ProjectException e) {
            System.out.println(e.toString());
        }
    }

/*
welcome() function
 */
    private static void welcome()
    {
        System.out.println("~~~~WELCOME TO AMONSTER~~~~");
    }

/*
userName() function
asking for the user name of player
*/
    private static String userName()
    {
        System.out.println("Enter your username :");
        return in.nextLine();
    }

/*
champChoice() function
get user's input and check if the input is valid.
 */
    private static int champChoice()
    {
        int choice = in.nextInt();
        if(choice<0 || choice >3)
        {
            System.out.printf("Input Error! Try again \n");
        }
        return choice;
    }

/*
level1(Champion,Monster) function
level 1 of the game.
 */
    private static void fighting(Player player1, Monster[] fat)
    {
        System.out.println("What is your attacking stategy ?");
        System.out.println("1.Gun\t 2.Magic\t 3.Defense yourself");
        Random rand = new Random();
        int level = player1.getLevel()-1;
        do{
            int monsterChoice = rand.nextInt(3-1)+1;
            int champChoice = champChoice();
            if(monsterChoice>champChoice){
                player1.getChamp().setHealth(fat[level].getPhysicalRate());
                System.out.println(player1.getChamp().getName()+" health's is decreased by "+fat[level].getPhysicalRate());
                System.out.println(player1.getChamp().getName()+" health's is "+player1.getChamp().getHealthCap());
            }else if(monsterChoice<champChoice)
            {
                fat[level].setHealthDecreasse(player1.getChamp().getPhysicalRate());
                System.out.println(fat[level].getName()+" health's is decreased by "+player1.getChamp().getPhysicalRate());
                System.out.println(fat[level].getName()+" health's is "+fat[level].getHealthCap());
            }else{
                System.out.println("Same weapon!!!! DRAW MATCHHHH!!!");
            }
        }while(player1.getChamp().getHealthCap()>0 && fat[level].getHealthCap()>0);
        endLevel(level, player1, fat);
    }

/*
endLevel(Monster,Champion) function
Prompt ending of a level and if user won, ask for increase in attribute
 */
    private static void endLevel(int level, Player player1, Monster[] monsters)
    {
        if(monsters[level].getHealthCap()<=0)
        {
            System.out.println("You defeated "+monsters[level].getName()+" !!!");
            increaseAttribute(player1);
            System.out.println("You passesd level "+player1.getLevel());
            player1.setLevel();
            System.out.println("Getting to level "+player1.getLevel());
        }else{
            System.out.println("You got defeated!!!");
        }
    }

/*
increaseAttribute(Champion)
Take 2 attributes and increase Champion's ability
 */
    private static void increaseAttribute(Player player1)
    {
        player1.getChamp().setPhysical(2);
        System.out.println(player1.getChamp().getName()+" physical attribute's is increased by 2!!!!");
    }

/*
operation() function
the action of the game
*/
    private static void operation(Player player1 , Monster[] fat) {
        boolean stop = false;
        while (!stop){
            System.out.println("Level " + player1.getLevel());
            fighting(player1, fat);
            //Prompt to continue of the game
            stop = quitGame(player1);
        }
    }
/*
saveGame() function
prompt player to save the game  && (player1.getLevel() < fat.length - 1)) {
*/
    private static void saveGame(Player player1){
        try 
        {
            System.out.println("Do you want to save your progress ? Y/N");
            String option =  in.nextLine();
            if( (option != "y") || (option !="Y")){
                FileIO.saved(player1);
                goodBye();
            }else{
                goodBye();
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
/*
quitGame() function
check if player wants to quit
*/
    private static boolean quitGame(Player player1){
        System.out.println("Do you want to go to the next level ? Y/N");
        String option = in.nextLine();
        if ((option != "y") || (option !="Y")) {
            in.nextLine();
            saveGame(player1);
            return true;
        } else {
            return false;
        }
    }
/*
goodBye() function
 */
    private static void goodBye(){
        System.out.println("~~~~~~~~END GAME~~~~~~~~");
    }
/*
1.còn cái menu
2.clean up code
3.github

 */
}
