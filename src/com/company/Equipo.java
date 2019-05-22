package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Equipo {
    Scanner in = new Scanner(System.in);
    int introducir;
    int puntos;
    ArrayList<Jugador> jugadorArrayList =new ArrayList<Jugador>();
    String nombre;
    int idUltimo;

    public void iniciar_Equipo(int id){
        System.out.println("Introduce el nombre del equipo:");
        nombre=in.nextLine();

        System.out.println("¿Desea introducir jugadores? (1 SI | 0 NO)");
        introducir=in.nextInt();

            while(introducir!=0){
                Jugador jugador = new Jugador();
                jugador.iniciar(id);
                //augmentar id
                id++;

                jugadorArrayList.add(jugador);


                System.out.println("¿Desea introducir más jugadores? (1 SI | 0 NO)");
                introducir=in.nextInt();
            }
            idUltimo=id;
    }
    public void añadirJugador(){

            Jugador jugador = new Jugador();
            jugador.iniciar(idUltimo+1);
            //augmentar id
            jugadorArrayList.add(jugador);

        idUltimo+=2;
    }


    public void modificarEquipo(int id) {
        System.out.println("Introduce los nuevos datos para el equipo "+nombre);
        iniciar_Equipo(id);
    }

    @Override
    public String toString() {
        String s;
        s = "Nombre del equipo: "+nombre+"\n";

        for (int i = 0; i <jugadorArrayList.size() ; i++) {
            s += jugadorArrayList.get(i).ID+" : ";
            s += jugadorArrayList.get(i).nombre+" : ";
            s += jugadorArrayList.get(i).apellidos;
            s += "\n";
        }

        return s;
    }
}
