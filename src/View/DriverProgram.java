package View;

import Controller.MapFactory;
import Controller.Operations;

import java.util.Map;
import java.util.Scanner;

public class DriverProgram {
    /**
     * Main program
     * @param args
     */
    public static void main(String[] args) {
        int follow = 1;
        Scanner in = new Scanner(System.in);
        String file= "C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HashMap\\ListadoProducto.txt";
        System.out.println("BIENVENIDO AL MERCADO MERCADONA\nComo desea realizar sus acciones:\n1. HashMap\n2. TreeMap\n3. LinkedHashMap");
        int option = in.nextInt(); in.nextLine();
        Map UserMap = MapFactory.MapFactory(file, option);
        while (follow == 1){
            System.out.println("Que desea realizar: \n1. Agregar\n2. Buscar\n3. Mostrar informacion de usuario\n4. Ordenar informacion de usuario\n5. Mostrar todo\n6. Mostrar todo ordenado");
            int choose = in.nextInt(); in.nextLine();
            switch (choose){
                case 1:
                    Operations.addProduct(UserMap);
                    break;
                case 2:
                    Operations.SearchProduct(UserMap);
                    break;
                case 3:
                    Operations.userProducts();
                    break;
                case 4:
                    Operations.sortUserProducts();
                    break;
                case 5:
                    Operations.showEverything(UserMap);
                    break;
                case 6:
                    Operations.sortEverything(UserMap);
                    break;
                default:
                    System.out.println("No eligio ninguna de nuestras opciones");
                    break;
            }
            System.out.println("Desea realizar mas busquedas?\n1. SI\n2. NO");
            follow = in.nextInt();
        }
    }
}
