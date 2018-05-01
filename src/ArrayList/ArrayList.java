package ArrayList;

import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        List<String> list = new java.util.ArrayList<>();
        list.add("Adam");
        list.add("Joel");
        list.add("Anna");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
