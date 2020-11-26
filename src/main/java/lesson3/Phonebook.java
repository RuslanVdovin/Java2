package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Phonebook {

    private HashMap<String, List<String>> phonebook;

    public Phonebook(){
        this.phonebook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber){
        if(phonebook.containsKey(surname)){
            List<String> numbers = phonebook.get(surname);
            if(!numbers.contains(phoneNumber)){
                numbers.add(phoneNumber);
            } else {
                System.out.println(String.format(
                        "this number %s has already been recorded for the subscriber %s",
                        phoneNumber, surname));
            }
        } else {
            phonebook.put(surname, new ArrayList<>(Arrays.asList(phoneNumber)));
        }
    }

    public List<String> get(String surname){
        if(phonebook.containsKey(surname)){
            System.out.println(String.format("subscriber %s numbers", surname));
            return phonebook.get(surname);
        } else {
            System.out.println(String.format("not subscriber %s data ", surname));
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        phonebook.add("Ivanov", "+7999000555");
        phonebook.add("Ivanov", "8719552233");
        phonebook.add("Ivanov", "89966753159");
        phonebook.add("Jonson", "8915553377");
        phonebook.add("Jonson", "89111777999");
        phonebook.add("Sokolov", "8922358888");
        phonebook.add("Petrov", "89885599337");
        phonebook.add("Grozniy", "776699");

        System.out.println(phonebook.get("Ivanov"));

        System.out.println(phonebook.get("Sokolov"));

        phonebook.add("Ivanov", "+7999000555");

        System.out.println(phonebook.get("Ivanov"));
    }
}


