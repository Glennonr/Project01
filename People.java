package Project01;

import Project01.PeopleType;

public class People {
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    private String myDescription;
    private int myLifePoints;


    /**
     * Create a person.
     * @param nation The Nation the person belongs to.
     * @param tribe The Tribe the person belongs to.
     * @param person The type of person (Healer, Warrior, or Soldier).
     * @param lifePoints The amount of life points for the person.
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints) {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
    }

    public PeopleType getType()
    {
        return me;
    }

    public String getTribe()
    {
        return myTribe;
    }

    public String getNation()
    {
        return myNation;
    }

    /**
     * Determine if the person's life points is greater than 0.
     * @return Boolean determining if the person is still alive.
     */
    public Boolean isPersonAlive()
    {
        return myLifePoints > 0;
    }

    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * Implement different strategies soon for combat.
     * @param otherPerson Person in combat.
     */
    public void encounterStrategy(People otherPerson) {
        if(myNation.equals(otherPerson.getNation()))
        {
            // There will be an ugly confrontation
            // Groups attack groups. Group can be an individual or several individuals from any set of tribes
            // if a group has enough lifePoints it can capture its opponent and make it part of the group.
            // Captured opponents do not fight or heal very well. The healers can heal people from same nation
            // normally.
        }
        else {
            // there will be a peaceful confrontation
            // warriors - warrior ignore each other if different tribes increase life points
            // healer - healer ignore each other
            // healer - warrior - healer can heal warrior. Heals warrior from same tribe better
        }
    }

    public void reduceLifePoints(int points)
    {
        myLifePoints -= points;
    }


    public String toString() {
        return myNation + "\t" + myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints;
    }
}

