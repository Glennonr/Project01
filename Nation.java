package Project01;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import Project01.Tribe;
import Project01.People;

public class Nation {
    private static final int NUMBER_OF_TRIBES = 3;  // Number of tribes per nation
    private int nationLifePoints;
    public static int nationCount = 0;
    private String nationName;
    private ArrayList<Tribe> tribes = new ArrayList<>();
    private ArrayList<People> population = new ArrayList<>();
    private ArrayList<People> livingPopulation = new ArrayList<>();


    /**
     * Creates a Nation and adds a fixed amount of tribes to the nation with equal life points.
     * @param name The name of the Nation.
     * @param lifePoints The amount of life points for the Nation.
     */
    public Nation(String name, int lifePoints) {
        nationCount++;
        nationName = name;
        nationLifePoints = lifePoints;
        for(int i = 0; i < NUMBER_OF_TRIBES; i++) {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / NUMBER_OF_TRIBES));
        }
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);  // Add the whole population initially
    }


    public Boolean isNationAlive()
    {
        return (nationLifePoints > 0);
    }

    /**
     * Iterate over all tribes in the Nation and if it has living members,
     * add its life points to the nations life points.
     * @return An ArrayList of living tribes.
     */
    public ArrayList<People> getNationPopulation() {
        nationLifePoints = 0;
        livingPopulation.clear();
        for (Tribe value : this.tribes) {
            if (value.isTribeAlive()) {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(value.getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += value.getTribeLifePoints();
            }
        }
        return livingPopulation;
    }


    public String getNationName()
    {
        return nationName;
    }


    public void printTribesStatus() {
        for(int tribe = 0; tribe < 1; tribe++) {
            if(tribes.get(tribe).isTribeAlive()) {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            }
            else {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    public String toString() {
        String result = "\0";
        result = nationName;
        for (Tribe tribe : tribes) {
            result = result + '\n' + tribe.toString();
        }
        result = result + '\n';
        return result;
    }
}
