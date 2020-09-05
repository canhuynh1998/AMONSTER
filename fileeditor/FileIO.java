package fileeditor;

import character.Monster;
import character.Player;
import error.ProjectException;

import java.io.*;
import java.util.StringTokenizer;

public class FileIO {

    /*
    saved(Player) function
    used to save user progress in the game.
    it will try to save again.
     */
    public static void saved(Player character) throws ProjectException {
        try {
            FileOutputStream file = new FileOutputStream(character.getUserName() + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(character);
            out.close();
            System.out.println("Username " + character.getUserName() + " is saved successfully");
        } catch (Exception e) {
            throw new ProjectException(character);
        }
    }

    /*
    gameContinue(Player) function
    looking for the saved file of the Player
     */
    public static Player gameContinue(Player character) {
        try {
            FileInputStream infile = new FileInputStream(character.getUserName() + ".txt");
            ObjectInputStream in = new ObjectInputStream(infile);
            Player oldPlayer = (Player) in.readObject();
            return oldPlayer;
        } catch (IOException e) {
            return ProjectException.fixFindingProblem();
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
            return null;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        } finally {

        }
    }

    /*
    readMonster() function
    Each line is 1 Monster object
    */
    public static Monster[] readMonster(String filename) throws ProjectException {
        try {
            int i = 0;
            Monster[] monsArr = new Monster[monsterLineCheck(filename)];
            FileReader file = new FileReader(filename);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            buff.readLine();    //skip the first line.
            while (!eof) {
                String line = buff.readLine();
                if (i > monsterLineCheck(filename) || line == null) {
                    eof = true;
                } else {
                    monsArr[i] = new Monster();
                    StringTokenizer token = new StringTokenizer(line);
                    while (token.hasMoreTokens()) {
                        monsArr[i].setName(token.nextToken());
                        monsArr[i].setHealthCap(Float.parseFloat(token.nextToken()));
                        monsArr[i].setPhysicalRate(Float.parseFloat(token.nextToken()));
                    }
                    i++;
                }
            }
            buff.close();
            return monsArr;
        } catch (IOException e) {
            throw new ProjectException(filename);
        } finally {

        }
    }

    /*
    monsterLineCheck(String) function
    checking the line in the Monster input file
    so the Monster array can be instantiate.
     */
    public static int monsterLineCheck(String filename) throws ProjectException {
        try {
            int count = 0;
            FileReader file = new FileReader(filename);
            BufferedReader buff = new BufferedReader(file);
            while (buff.readLine() != null) {
                count++;
            }
            return count;
        } catch (IOException e) {
            throw new ProjectException(filename);
        }
    }
}
