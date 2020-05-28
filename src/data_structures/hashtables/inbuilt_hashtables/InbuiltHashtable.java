package data_structures.hashtables.inbuilt_hashtables;

import java.util.Hashtable;
import java.util.Map;

// Java has pre-build HashTables lets see how to use them.
public class InbuiltHashtable {
    public static void main(String[] args) {
        // we can also use HashMap or HashSet.
        Map<String, String> phoneBook = new Hashtable<>();
        // putting keys:values in hashtable phoneBook
        phoneBook.put("Chris", "445454545");
        phoneBook.put("Morris", "4548623233");
        phoneBook.put("Mary", "865656223");

        System.out.println("phoneBook: "+phoneBook);
        //accessing values using keys
        System.out.println("Chris's phoneNo." + phoneBook.get("Chris"));
        //deleting entries using keys
        System.out.println("remove morris: "+phoneBook.remove("Morris"));
        //phoneBook after removing morris
        System.out.println("phoneBook: "+phoneBook);

    }
}
