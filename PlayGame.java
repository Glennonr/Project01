package Project01;
import Project01.Nation;
import Project01.People;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

public class PlayGame {

    ArrayList<Nation> allLivingNations = new ArrayList<>();
    ArrayList<People> worldLivingPopulation = new ArrayList<>();
    Random generator;

    /**
     * Creates new random number generator for new game
     */
    public PlayGame() {
        Date seed = new Date();
        generator = new Random(seed.getTime());
    }

    /**
     * Updates and gets the population of people alive in the game
     * using the nations they are from
     * @param nations list of nations that are still in the game
     */
    public void getWorldLivingPopulation(ArrayList<Nation> nations) {
        // add all living people to world list
        worldLivingPopulation.clear();
        //System.out.println(allLivingNations);
        for(int nation = 0; nation < nations.size(); nation++)
            //System.out.println(nations.get(nation));
            worldLivingPopulation.addAll(nations.get(nation).getNationPopulation());
        //System.out.println(worldLivingPopulation);
    }

    /**
     * Gets all nations that have living players in them
     * @param nations list of nations that are still in the game
     */
    public void getAllLivingNations(ArrayList<Nation> nations) {
        getWorldLivingPopulation(nations);
        allLivingNations.clear();
        for(int nation = 0; nation < nations.size(); nation++) {
            if(nations.get(nation).isNationAlive())
            {
                allLivingNations.add(nations.get(nation));
            }
        }
        //System.out.print(allLivingNations);
    }

    /**
     * Gets two players to have an encounter
     * If players are from the same nation, nothing happens
     * If players are from different nations, ugly encounter occurs,
     * where each player takes a random amount of damage from 0-20
     * @param p1 first player in encounter
     * @param p2 second player in encounter
     */
    public void encounter(People p1, People p2) {
        // need to fix this to take strategies into account.
        if(p1.getNation() != p2.getNation()) {
            System.out.print(p1 + " encounters " + p2);
            int p1Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            int p2Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            p1.reduceLifePoints(p1Damage);
            p2.reduceLifePoints(p2Damage);

            System.out.println("\t\tp1 damage is " + p1Damage + ". p2 damage is " + p2Damage + ".");
        }
    }

    /**
     * Plays through round as long as there are more than one nation still
     * in game and larger living population than number of encounters in round
     * @param nations list of nations that are still in the game
     * @return whether or not the number of living nations is less than 2
     */
    public Boolean playOneRound(ArrayList<Nation> nations) {
        getAllLivingNations(nations);
        int index = 0;
        while((allLivingNations.size() > 1) && (index < worldLivingPopulation.size())) {
            //encounter(worldLivingPopulation.get(pointers.get(index)), worldLivingPopulation.get(pointers.get(index+1)));
            //System.out.println((worldLivingPopulation.size()-1) + "\t" + limit + "\t" + index + "\t" + (index+1));
            int p1Index = generator.nextInt(worldLivingPopulation.size());
            int p2Index;
            do
                p2Index = generator.nextInt(worldLivingPopulation.size());
            while(p1Index == p2Index);
            encounter(worldLivingPopulation.get(p1Index), worldLivingPopulation.get(p2Index));
            getAllLivingNations(nations);
            if(allLivingNations.size() < 2)
                break;
            index = index + 1;
        }
        return (allLivingNations.size() < 2);
    }

    /**
     * Gets winner of game, no winner if no nations with living players,
     * otherwise winning nation is only remaining nation with living
     * players
     * @return winning nation
     */
    public String getWinner() {
        if (allLivingNations.size() == 0)
            return "No Winner!";
        else
            return allLivingNations.get(0).getNationName();
    }
}
