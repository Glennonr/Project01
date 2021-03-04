package Project01;

/**
 * Enum for all of the People types that are assigned to People object
 */
public enum PeopleType
{
    warrior ("Soldier"),
    wizard  ("Tricky"),
    healer ("Cleric");

    private String description;

    /**
     * Assigns the types parameter to the description variable
     * @param types extra identifier for People type
     */
    PeopleType (String types)
    {
        description = types;
    }

    /**
     * Gets the description
     * @return description string variable for People type
     */
    public String getDescription()
    {
        return description;
    }
}
