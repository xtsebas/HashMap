package Controller;

import java.util.*;

public class MapFactory {
   public static Map MapFactory(int expression){
       Map ActualMap = null;
       switch (expression){
           case 1:
               ActualMap= new HashMap<String, ArrayList>();
               break;
           case 2:
               ActualMap= new TreeMap<String, ArrayList>();
               break;
           case 3:
               ActualMap = new LinkedHashMap<String, ArrayList>();
               break;
           default:
               System.out.println("Sorry, You didn't select some of our options");
               break;
       }

       return ActualMap;
   }
}
