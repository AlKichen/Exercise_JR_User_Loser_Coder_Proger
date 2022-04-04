import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        ArrayList<String> listString = new ArrayList<String>();
        ArrayList<Person> listPerson = new ArrayList<>();

        while (true) {
            key = reader.readLine();
            if (!(key.equals("user") || key.equals("loser") ||
                    key.equals("coder") || key.equals("proger"))) {
                break;
            }
            listString.add(key);
        }
        reader.close();
        for (int i = 0; i < listString.size(); i++) {
            switch (listString.get(i)) {
                case ("user"):
                    listPerson.add(new Person.User());
                    break;
                case ("loser"):
                    listPerson.add(new Person.Loser());
                    break;
                case ("coder"):
                    listPerson.add(new Person.Coder());
                    break;
                case ("proger"):
                    listPerson.add(new Person.Proger());
                    break;
            }
        }
        for (int i = 0; i < listPerson.size(); i++) {
            doWork(listPerson.get(i));
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}