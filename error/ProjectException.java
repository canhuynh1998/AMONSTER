package error;
import character.*;
import java.util.*;
public class ProjectException extends Exception {
    static Scanner in = new Scanner(System.in);

    public ProjectException(){
        super();
        printProblem();
    }

/*
Overloaded constructor
This will look for the Player file again.
 */
    public ProjectException(Player character)
    {
        super();
        fixSavingProblem(character);
    }

/*
Overloaded constructor
This will look for the Monster input file.
 */
    public ProjectException(String filename)
    {
        super();
        fixInputFile(filename);
    }

    public void printProblem() { System.out.println("ProjectException"); }

/*
Solution for the finding the username problem.
This function will create a new username and new champion
*/
    public static Player fixFindingProblem() {
        System.out.println("Username is not found !! Create new username");
        System.out.println("New username :");
        Player newPlayer = new Player(in.nextLine());
        String Champname= Champion.championCreation();
        Champion newChamp = new Champion(Champname);
        newPlayer.setChamp(newChamp);
        newPlayer.getChamp().print();
//        newPlayer.print();
//        //newChamp.print();
        System.out.println("New username and champion are created :D !");
        return newPlayer;
    }

/*
Solution for the saving username problem.
This will ask for the correct username.
 */
    public static void fixSavingProblem(Player character)
    {
        System.out.println("Can not save the game!! Let try again.");
        ProjectException.fixSavingProblem(character);
    }

/*
Solution for the reading Monster file.
This will look up the file again.
 */
    public static void fixInputFile(String filename){
        System.out.println("Can not find the input file for Monster! Let do it again!");
        ProjectException.fixInputFile(filename);
    }
}
