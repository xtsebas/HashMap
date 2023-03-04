package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Operations {
    private static Scanner in = new Scanner(System.in);
    private static Map ListtoMap(String fpath, Map mapselected){
        Map<String, Object> mapList = mapselected;
        List<List> list = ReadFile.text(fpath);

        for (List<String> row : list) {
            String key = row.get(0);
            Object value = row.get(1);

            if (mapList.containsKey(key)) {
                Object currentValue = mapList.get(key);

                if (currentValue instanceof List) {
                    List<Object> valueList = (List<Object>) currentValue;
                    valueList.add(value);
                } else {
                    List<Object> valueList = new ArrayList<>();
                    valueList.add(currentValue);
                    valueList.add(value);
                    mapList.put(key, valueList);
                }
            } else {
                mapList.put(key, value);
            }
        }
        return mapList;
    }
    private static String capitalizeFirstLetter(String str, int expression) {
        String st= "";
        if(str == null || str.isEmpty()) {
            return "\t" + str;
        }
        switch (expression){
            case 0:
                st= "\t" + str.substring(0, 1).toUpperCase() + str.substring(1);
                break;
            case 1:
                st= str.substring(0, 1).toUpperCase() + str.substring(1) + " ";
                break;
        }
        return st;
    }

    public static void SearchProduct(String file, int expression){
        boolean AC= false;
        System.out.println("Ingrese el producto que desea buscar");
        String product = capitalizeFirstLetter(in.nextLine(), 0);
        Map lists= ListtoMap(file, MapFactory.MapFactory(expression));

        for (Object key : lists.keySet()) {
            Object value = lists.get(key);
            if (value instanceof List) {
                List<Object> productList = (List<Object>) value;
                for (Object productValue : productList) {
                    if (productValue.equals(product)) {
                        System.out.println("Categoria | Producto\n" + key + " | " + product);
                        AC=true;
                        break;
                    }
                }
            } else if (value.equals(product)) {
                System.out.println("Categoria | Producto\n" + key + " | " + product);
                AC=true;
                break;
            }
        }
        if (AC){
            System.out.println("Busqueda realizada exitosamente");
        }else {
            System.out.println("No se encontró el producto: " + product);
        }
    }

    public static void addProduct(String file, int expression){
        boolean AC= false;
        System.out.println("Ingrese el producto que desea agregar");
        String product = capitalizeFirstLetter(in.nextLine(), 0);
        System.out.println("Ingrese a la categoria en la cual lo desea agregar");
        String category = capitalizeFirstLetter(in.nextLine(), 1);
        Map lists= ListtoMap(file, MapFactory.MapFactory(expression));
        for (Object key: lists.keySet()){
            Object value = lists.get(key);
            if (lists.get(key) == category){
                if (value instanceof List){
                    List<Object> productList = (List<Object>) value;
                    productList.add(product);
                    lists.put(key, productList);
                    AC=true;
                    break;
                }else {
                    lists.put(key, product);
                    AC=true;
                    break;
                }
            }
        }
        if (AC){
            System.out.println("Agregado exitosamente");
        }else {
            System.out.println("No escogiste una de nuestras categorias");
        }
    }
}
