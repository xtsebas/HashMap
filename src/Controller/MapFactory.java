package Controller;

import Model.LinkedHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
               ActualMap = (Map) new LinkedHashMap();
               break;
           default:
               System.out.println("Sorry, You didn't select some of our options");
               break;
       }

       return ActualMap;
   }
}
