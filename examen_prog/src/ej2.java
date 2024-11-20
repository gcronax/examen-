import java.io.*;


public class ej2 {
    public static void main(String[] args) {
        String nombreArchivo= "productos.csv";
        String nombretxt="productos.txt";
        int contador=0;
        try {
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            FileWriter fileWriter = new FileWriter(nombretxt, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("***** LISTADO DE PRODUCTOS *****");

            String[] cabezera = new String[3];
            while ((linea = bufferedReader.readLine()) != null) {
                String[] atributos = separador(linea);
                if (contador==0){
                    cabezera=atributos;
                }else {
                    printWriter.println(cabezera[0]+":  "+atributos[0].toUpperCase());
                    printWriter.println(cabezera[1]+":  "+atributos[1].replace(".",",")+" €");
                    printWriter.println(cabezera[2]+":  "+atributos[2]);
                }
                printWriter.println(" ");
                contador++;
            }
            printWriter.close();
            bufferedReader.close();
            System.out.println("Lectura de '" + nombreArchivo + "' OK");
            System.out.println("Escritura de '" + nombretxt + "' OK");
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public static String[] separador(String linea_input) {
        return linea_input.split(",");
    }
}
