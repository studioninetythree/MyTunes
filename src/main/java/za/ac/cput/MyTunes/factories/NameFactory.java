package za.ac.cput.MyTunes.factories;

import za.ac.cput.MyTunes.domain.Name;

public class NameFactory {

    public static Name createName(String firstName, String middleName, String lastName) {
        return new Name.Builder(lastName).firstName(firstName).middleName(middleName).build();
    }

}
