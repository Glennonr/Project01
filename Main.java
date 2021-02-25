package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;


public class Main {


    public static void main(String[] args)
    {
       int NUMBER_OF_NATIONS = 3;
       int gameLifePoints = 2000;
       ArrayList<Nation> nations = new ArrayList<>() ; // nations create tribes create people
       PlayGame game = new PlayGame();
	   nations.add(new Nation("Idiots", gameLifePoints / NUMBER_OF_NATIONS));
	   nations.add(new Nation("Minions", gameLifePoints / NUMBER_OF_NATIONS));
	   nations.add(new Nation("Richie's Nation", gameLifePoints /NUMBER_OF_NATIONS));
	   // could add and delete nations. return number of nations + 1 from add and number of nations -1 from remove.
	   for(int i = 0; i < 40; i++)
       {
           System.out.println("Round number: " + i);
           if (game.playOneRound(nations))
           {
               System.out.println("There is a winner!");
               break; // game over
           }
       }

	   System.out.println("The winning nation is " + game.getWinner() + ".");
    }
}
