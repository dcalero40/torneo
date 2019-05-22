package com.company;

import java.util.Scanner;

public class Jugador {
    Scanner in = new Scanner(System.in);
    int ID;
    String nombre;
    String apellidos;
    int idEquipo;

    public void iniciar(int id){
        ID=id;

        System.out.println("Introduce el nombre del jugador: ");
        nombre=in.nextLine();

        System.out.println("Introduce los apellidos del jugador: ");
        apellidos=in.nextLine();
    }
}
