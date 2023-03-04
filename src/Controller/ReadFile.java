package Controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    /**
     *Lee la ruta del archivo donde se encuentra
     * @param fpath
     * @return file
     */
    public static List<List> text(String fpath){
        List<String> line = new ArrayList<>();
        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            int lineaActual = 2;
            while (myReader.hasNextLine()) {
                String linea = myReader.nextLine();
                if (lineaActual > 1) {
                    line.add(linea);
                }
                lineaActual++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List file= ListofLists(line);
        return file;
    }
    private static List ListofLists(List list){
        List<List<String>> listaResultados = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String elemento= (String) list.get(i);
            String[] partes = elemento.split("\\|");
            listaResultados.add(Arrays.asList(partes));
        }
        return listaResultados;
    }
}