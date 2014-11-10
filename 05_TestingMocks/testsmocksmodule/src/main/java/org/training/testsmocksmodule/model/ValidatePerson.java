package org.training.testsmocksmodule.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vasyl_Melnychuk on 11/10/2014.
 */
public class ValidatePerson {
    public static final Set<String> POSITIONS = new HashSet<String>(Arrays.asList(new String[]{"Developer", "Tester", "Manager"}));
    public static boolean isValid(Person person) {
        boolean valid = false;
        if (isFirstNameValid(person) && isLastNameValid(person) && isPositionValid(person))
            valid = true;
        return valid;
    }
    private static boolean isFirstNameValid(Person person) {
        char[] chars = person.getFirstName().toCharArray();
        if (Character.isLowerCase(chars[0])) {
            throw new PersonValidationException("firsName should start with uppercase letter");
        }
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                throw new PersonValidationException("firsName " + person.getFirstName() + " is contains non-letter chars");
            }
        }
        return true;
    }
    private static boolean isLastNameValid(Person person) {
        char[] chars = person.getLastName().toCharArray();
        if (Character.isLowerCase(chars[0])) {
            throw new PersonValidationException("lastName should start with uppercase letter");
        }
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                throw new PersonValidationException("lastName " + person.getLastName() + " contains non-letter chars");
            }
        }
        return true;
    }
    private static boolean isPositionValid(Person person) {
        if (!POSITIONS.contains(person.getPosition())) {
            throw new PersonValidationException("position " + person.getPosition() + " is not valid");
        }
        return true;
    }
}
