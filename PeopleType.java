package Project01;

public enum PeopleType
{
    warrior ("Soldier"),
    wizard  ("Tricky"),
    healer ("Cleric");

    private String description;

    PeopleType (String types)
    {
        description = types;
    }


    public String getDescription()
    {
        return description;
    }
}
