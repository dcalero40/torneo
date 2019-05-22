package com.company;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //variables
        File fileEquipos = new File("Equipos");
        int id=0;
        boolean seguir=true;
        int opcion;
        Menu menu = new Menu();
        ArrayList<Equipo> equipoArrayList = new ArrayList<Equipo>();

        if(fileEquipos.exists()){
            cargarFichero(equipoArrayList,fileEquipos);
            id = equipoArrayList.get(equipoArrayList.size()-1).jugadorArrayList.get(equipoArrayList.get(equipoArrayList.size()-1).jugadorArrayList.size()-1).ID+1;
        }
        System.out.println(id);



        while (seguir){
            id=menu.menu(equipoArrayList, id, fileEquipos);
            System.out.println("¿DESEA SEGUIR? (1 si | 0 NO)");
            opcion= in.nextInt();
            if (opcion==0)seguir=false;
        }

        actualizarFicheroEquiposParticipantes(equipoArrayList,fileEquipos);





    }

    //FUNCIONES FICHEROS

    static void  actualizarFicheroEquiposParticipantes( ArrayList<Equipo> equipoArrayList, File fileEquipos) throws IOException {
        File tmpFile = new File(fileEquipos.getAbsolutePath() + "tmp");
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(tmpFile));
        String separator=" : ";
        for (int i = 0; i <equipoArrayList.size() ; i++) {
            outputStream.write("Nombre del equipo : "+ equipoArrayList.get(i).nombre+"\n");
            for (int j = 0; j <equipoArrayList.get(i).jugadorArrayList.size(); j++) {

                outputStream.write(equipoArrayList.get(i).jugadorArrayList.get(j).ID+separator);
                outputStream.write(equipoArrayList.get(i).jugadorArrayList.get(j).nombre+separator);
                outputStream.write(equipoArrayList.get(i).jugadorArrayList.get(j).apellidos+"\n");
            }
            outputStream.write("--------------------------------------------------------------\n");
        }
        outputStream.close();
        tmpFile.renameTo(fileEquipos);
    }



    public void escribirClasificacion(ArrayList equipoArrayList){
        //leer estructuras y pasarlos a fichero
    }

    static void mostrarFichero(File fileEquipos)throws IOException{
        String cadena;
        FileReader leerEquipos = new FileReader(fileEquipos);
        BufferedReader leer = new BufferedReader(leerEquipos);
        while((cadena = leer.readLine())!=null) {
            System.out.println(cadena);
        }
        leer.close();
    }

    static void cargarFichero(ArrayList equipoArrayList, File fileEquipos)throws IOException{
        String cadena;
        FileReader leerEquipos = new FileReader(fileEquipos);
        BufferedReader leer = new BufferedReader(leerEquipos);

        Equipo equipo=new Equipo();
        while((cadena = leer.readLine())!=null) {

            String[] parts = cadena.split(" : ");


            if(parts.length==2){
                equipo.nombre=parts[1];
            }

            else if (parts.length>2){
                Jugador jugador = new Jugador();
                jugador.ID=Integer.parseInt(parts[0]);
                jugador.nombre=parts[1];
                jugador.apellidos=parts[2];
                equipo.jugadorArrayList.add(jugador);
            }

            else if (parts.length==1){
                equipo.idUltimo=equipo.jugadorArrayList.get(equipo.jugadorArrayList.size()-1).ID;
                equipoArrayList.add(equipo);

                equipo=new Equipo();
            }

        }

        leer.close();

    }

}
