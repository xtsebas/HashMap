package Controller;

import java.util.*;

public class MapFactory {
   public static Map MapFactory(String fpath, int expression){
       Map ActualMap = null;
       switch (expression){
           case 1:
               ActualMap= Operations.ListtoMap(fpath, new HashMap<String, ArrayList>());
               break;
           case 2:
               ActualMap= Operations.ListtoMap(fpath, new TreeMap<String, ArrayList>());
               break;
           case 3:
               ActualMap= Operations.ListtoMap(fpath, new LinkedHashMap<String, ArrayList>());
               break;
           default:
               System.out.println("Sorry, You didn't select some of our options");
               break;
       }

       return ActualMap;
   }
}
