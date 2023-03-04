package View;

import Controller.Operations;

import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        int follow = 1;
        Scanner in = new Scanner(System.in);
        String file= "C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HashMap\\ListadoProducto.txt";
        System.out.println("BIENVENIDO AL MERCADO MERCADONA\nComo desea realizar sus acciones:\n1. HashMap\n2. TreeMap\n3. LinkedHashMap");
        int option = in.nextInt(); in.nextLine();
        while (follow == 1){
            System.out.println("Que desea realizar: \n1. Agregar\n2. Buscar\n3. Ordenar\n4. Mostrar todo");
            int choose = in.nextInt(); in.nextLine();
            switch (choose){
                case 1:
                    Operations.addProduct(file,option);
                    break;
                case 2:
                    Operations.SearchProduct(file, option);
                    break;
                case 3:
                    break;
                case 4:
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
