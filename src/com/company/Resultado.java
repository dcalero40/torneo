package com.company;

import java.io.*;
import java.util.Scanner;

public class Resultado {
    static  File fileResultado = new File("Resultados");
    static void introducir() throws IOException {

        BufferedReader inputStream = new BufferedReader(new FileReader(fileResultado));

        File tmpFile = new File(fileResultado.getAbsolutePath() + "tmp");
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(tmpFile));

        String separator=" : ";
        Scanner in = new Scanner(System.in);

        String line;
        while((line = inputStream.readLine()) != null){
            outputStream.write(line+"\n");
        }
        inputStream.close();

            boolean seguir=true;
        while(seguir) {
            System.out.println("INTRODUCE EL NOMBRE DEL 1ER JUGADOR:");
            String nombre1=in.nextLine();

            System.out.println("INTRODUCE LOS PUNTOS DEL 1ER JUGADOR:");
            int puntos1=in.nextInt();

            System.out.println("INTRODUCE EL NOMBRE DEL 2NDO JUGADOR:");
            in.nextLine();
            String nombre2=in.nextLine();

            System.out.println("INTRODUCE LOS PUNTOS DEL 2NDO JUGADOR:");
            int puntos2=in.nextInt();

            outputStream.write(nombre1 + separator + puntos1 + separator + nombre2 + separator + puntos2 + "\n");

            System.out.println("¿DESEA SEGUIR AÑADIENDO RESULTADOS?(1 SI |0 NO)");
            int numSeguir=in.nextInt();
            in.nextLine();
            if (numSeguir==0){
                seguir=false;
            }
        }
        outputStream.close();
        tmpFile.renameTo(fileResultado);
    }
}
