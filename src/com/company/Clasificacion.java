package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Clasificacion {

    static HashMap<String, Integer> clasif = new HashMap<>();

    static void cargarResultados() throws IOException {
        BufferedReader inputStream = new BufferedReader(new FileReader(Resultado.fileResultado));

        String SEPARATOR=" : ";
        String line;
        while((line = inputStream.readLine()) != null){
            String[] values = line.split(SEPARATOR);

            if (clasif.containsKey(values[0])){
                clasif.put(values[0], clasif.get(values[0])+Integer.parseInt(values[1]));

            } else {
                clasif.put(values[0], Integer.parseInt(values[1]));
            }

            if (clasif.containsKey(values[2])){
                clasif.put(values[2], clasif.get(values[2])+Integer.parseInt(values[3]));

            } else {
                clasif.put(values[2], Integer.parseInt(values[3]));
            }
        }
        inputStream.close();
        while (!clasif.isEmpty()) {
            int num = 0;
            String nombre = "";
            for (String key : clasif.keySet()) {
                if (clasif.get(key) > num) {
                    num = clasif.get(key);
                    nombre = key;
                }
            }
            System.out.println(nombre + " : " + num);
            clasif.remove(nombre);
        }
    }


    public static void cargarResultadosEquipos(ArrayList<Equipo> equipoArrayList) throws IOException {
        BufferedReader inputStream = new BufferedReader(new FileReader(Resultado.fileResultado));

        String SEPARATOR=" : ";
        String line;
        while((line = inputStream.readLine()) != null){
            String[] values = line.split(SEPARATOR);

            if (clasif.containsKey(values[0])){
                clasif.put(values[0], clasif.get(values[0])+Integer.parseInt(values[1]));

            } else {
                clasif.put(values[0], Integer.parseInt(values[1]));
            }

            if (clasif.containsKey(values[2])){
                clasif.put(values[2], clasif.get(values[2])+Integer.parseInt(values[3]));

            } else {
                clasif.put(values[2], Integer.parseInt(values[3]));
            }
        }
        inputStream.close();



            for (String key : clasif.keySet()) {
                int num = 0;
                String nombre = "";
                    num = clasif.get(key);
                    nombre = key;
                    for (Equipo equipo : equipoArrayList) {
                        for (Jugador jugador : equipo.jugadorArrayList) {
                            if(jugador.nombre.equals(nombre)){
                                equipo.puntos+=num;
                            }

                        }
                    }
            }


        for (Equipo equipo : equipoArrayList){
            System.out.println(equipo.nombre+" : "+ equipo.puntos);
        }
    }
}
/*
    ARRAY                      HASH
   array[0] = 3               hash.put(0, 3);
   int a = array[0]           int a = hash.get(0)

   array[0] = array[0]+3      hash.put(0, hash.get(0)+3)



for(String key : clasif.keySet()){

}


 */

/*
   pos:     0   1     2
   val:   1000 2000  200


   key    luis  pepe  juan
   val:    4      3    3


 */