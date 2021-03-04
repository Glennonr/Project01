package Project01;

import java.util.ArrayList;
import Project01.People;
import Project01.PeopleType;

public class Tribe {
    private static final int NUMBER_OF_PEOPLE = 3;  // Number of people per tribe
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * Creates a Tribe with 3 Members and adds them all to living members list.
     * @param nation Nation that the tribe belongs to.
     * @param tribe The Tribe's name.
     * @param lifePoints The life points of the tribe.
     */
    public Tribe(String nation, String tribe, int lifePoints) {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        members.add(new People(nationName, tribeName, PeopleType.warrior, tribeLifePoints / NUMBER_OF_PEOPLE));
        members.add(new People(nationName, tribeName, PeopleType.wizard, tribeLifePoints / NUMBER_OF_PEOPLE));
        members.add(new People(nationName, tribeName, PeopleType.healer, tribeLifePoints / NUMBER_OF_PEOPLE));
        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     * Iterate over all people in the tribe and if they are alive,
     * add their life points to the tribe life points.
     * @return ArrayList of the living members of the tribe.
     */
    public ArrayList<People> getLivingTribeMembers() {
        livingMembers.clear();
        tribeLifePoints = 0;
        for (People member : members) {
            if (member.isPersonAlive()) {
                livingMembers.add(member);
                tribeLifePoints += member.getLifePoints();
                //System.out.println(members.get(person));
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }
    /*
    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(people.get(i));
        }
    }
*/


    public int getTribeSize()
    {
        return livingMembers.size();
    }

    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }

    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    public String getTribeName()
    {
        return tribeName;
    }

    public String toString() {
        String result = "\0";

        result = tribeName;
        for (People member : members) {
            result = result + '\n' + member.toString();
        }
        result = result + '\n';
        return result;
    }

}
