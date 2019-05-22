package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);

    public int menu(ArrayList<Equipo> equipoArrayList, int id, File fileEquipos) throws IOException {
        System.out.println("1.EQUIPO");
        System.out.println("2.PARTICIPANTES");
        System.out.println("3.RESULTADO");
        System.out.println("4.CLASIFICACIÓN");

        int opcion=in.nextInt();

        switch (opcion){
            case 1:
                 menuEquipo(equipoArrayList, id, fileEquipos);
                Main.actualizarFicheroEquiposParticipantes(equipoArrayList, fileEquipos);
                return id;

            case 2:
                menuParticipantes(equipoArrayList, id, fileEquipos);
                Main.actualizarFicheroEquiposParticipantes(equipoArrayList, fileEquipos);
                return id;

            case 3:
                //mostrar resultado
                menuResultado();
                Main.actualizarFicheroEquiposParticipantes(equipoArrayList, fileEquipos);
                return id;

            case 4:
                menuClasificacion(equipoArrayList, id, fileEquipos);
                Main.actualizarFicheroEquiposParticipantes(equipoArrayList, fileEquipos);
                return id;
        }
        return id;
    }

    private void menuResultado() throws IOException {
        System.out.println("1.INTRODUCIR RESULTADO");
        System.out.println("2.LISTAR RESULTAODS");

        int opcion=in.nextInt();

        switch (opcion){
            case 1:
                Resultado.introducir();
                break;

            case 2:

                break;

        }
    }

    public int menuEquipo(ArrayList<Equipo> equipoArrayList, int id, File fileEquipos) throws IOException {
        System.out.println("1.INSCRIBIR");
        System.out.println("2.MODIFICAR");
        System.out.println("3.BORRAR");
        System.out.println("4.LISTAR");

        boolean existe=false;
        boolean preguntaOtraVez=true;

        Equipo equipo=new Equipo();
        int opcion = in.nextInt();

        switch (opcion) {
            case 1:
                //INSCRIBIR
                equipo.iniciar_Equipo(id);
                equipoArrayList.add(equipo);
                id=equipo.idUltimo;
                return id;

            case 2:
                //MODIFICAR
                while (preguntaOtraVez) {
                    System.out.println("¿Que equipo quieres modificar?");
                    in.nextLine();
                    String nombre=in.nextLine();
                    System.out.println(nombre);
                    for (int i = 0; i < equipoArrayList.size(); i++) {
                        if (equipoArrayList.get(i).nombre.equals(nombre)) {
                            equipoArrayList.get(i).modificarEquipo(id);
                            id=equipo.idUltimo;
                            existe = true;
                            preguntaOtraVez=false;
                            equipoArrayList.remove(i);
                        }
                    }
                    if (!existe) {
                        System.out.println("El equipo introducido no existe. ¿Desea introducir otro nombre de equipo para modificar? (1 si | 0 no)");
                        int seguir = in.nextInt();
                        if (seguir != 1) preguntaOtraVez = false;
                    }
                }
                return id;

            case 3:
                //BORRAR


                   while (preguntaOtraVez) {
                    System.out.println("¿Que equipo quieres borrar?");
                    in.nextLine();
                    String nombre=in.nextLine();
                    System.out.println(nombre);
                    for (int i = 0; i < equipoArrayList.size(); i++) {
                        if (equipoArrayList.get(i).nombre.equals(nombre)) {
                            existe = true;
                            preguntaOtraVez=false;
                            equipoArrayList.remove(i);
                        }
                    }
                    if (!existe) {
                        System.out.println("El equipo introducido no existe. ¿Desea introducir otro nombre de equipo para borrar? (1 si | 0 no)");
                        int seguir = in.nextInt();
                        if (seguir != 1) preguntaOtraVez = false;
                    }
                }

                return id;

            case 4:
                //LISTAR
                equipoArrayList.forEach(e -> System.out.println(e));
                return id;
        }
        return id;
    }

    public int menuParticipantes(ArrayList<Equipo> equipoArrayList, int id, File fileEquipos){
        System.out.println("1.INSCRIBIR");
        System.out.println("2.MODIFICAR");
        System.out.println("3.BORRAR");
        System.out.println("4.LISTAR");

        boolean existe=false;
        boolean preguntaOtraVez=true;
        Equipo equipo=new Equipo();

        int opcion=in.nextInt();
        switch (opcion){
            case 1:
                //INSCRIBIR
                while (preguntaOtraVez) {
                    System.out.println("¿A que equipo quieres añadir un jugador?");
                    in.nextLine();
                    String nombre=in.nextLine();
                    for (int i = 0; i < equipoArrayList.size(); i++) {
                        if (equipoArrayList.get(i).nombre.equals(nombre)) {
                            equipoArrayList.get(i).añadirJugador();
                            id=equipo.idUltimo;
                            existe = true;
                            preguntaOtraVez=false;
                        }
                    }
                    if (!existe) {
                        System.out.println("El equipo introducido no existe. ¿Desea introducir otro nombre de equipo para añadirle un jugador? (1 si | 0 no)");
                        int seguir = in.nextInt();
                        if (seguir != 1) preguntaOtraVez = false;
                    }
                }

                return id;

            case 2:
                //MODIFICAR
                while (preguntaOtraVez) {
                    System.out.println("¿A que equipo quieres modificarle un jugador?");
                    in.nextLine();
                    String nombre=in.nextLine();
                    for (int i = 0; i < equipoArrayList.size(); i++) {
                        if (equipoArrayList.get(i).nombre.equals(nombre)) {
                            for (int j = 0; j <equipoArrayList.get(i).jugadorArrayList.size() ; j++) {
                                System.out.print(equipoArrayList.get(i).jugadorArrayList.get(j).nombre+" ");
                            }
                            System.out.print("Que jugador quieres editar:");
                            String nombrej=in.nextLine();
                            for (int j = 0; j <equipoArrayList.get(i).jugadorArrayList.size() ; j++) {
                                if (equipoArrayList.get(i).jugadorArrayList.get(j).nombre.equals(nombrej)){
                                    System.out.println("Introduce el nuevo nombre:");
                                    equipoArrayList.get(i).jugadorArrayList.get(j).nombre=in.nextLine();

                                    System.out.println("Introduce los nuevos apellidos:");
                                    equipoArrayList.get(i).jugadorArrayList.get(j).apellidos=in.nextLine();
                                }
                            }

                            existe = true;
                            preguntaOtraVez=false;
                        }
                    }
                    if (!existe) {
                        System.out.println("El equipo introducido no existe. ¿Desea introducir otro nombre de equipo para añadirle un jugador? (1 si | 0 no)");
                        int seguir = in.nextInt();
                        if (seguir != 1) preguntaOtraVez = false;
                    }
                }
                return id;

            case 3:
                //BORRAR
                while (preguntaOtraVez) {
                    System.out.println("¿A que equipo quieres eliminar un jugador?");
                    in.nextLine();
                    String nombre=in.nextLine();
                    for (int i = 0; i < equipoArrayList.size(); i++) {
                        if (equipoArrayList.get(i).nombre.equals(nombre)) {
                            for (int j = 0; j <equipoArrayList.get(i).jugadorArrayList.size() ; j++) {
                                System.out.print(equipoArrayList.get(i).jugadorArrayList.get(j).nombre+" ");
                            }
                            System.out.print("Que jugador quieres eliminar:");
                            String nombrej=in.nextLine();
                            equipoArrayList.get(i).jugadorArrayList.removeIf(jugador-> jugador.nombre.equals(nombrej));
                            existe = true;
                            preguntaOtraVez=false;
                        }
                    }
                    if (!existe) {
                        System.out.println("El equipo introducido no existe. ¿Desea introducir otro nombre de equipo para eliminarle un jugador? (1 si | 0 no)");
                        int seguir = in.nextInt();
                        if (seguir != 1) preguntaOtraVez = false;
                    }
                }
                return id;

            case 4:
                //LISTAR
                while (preguntaOtraVez) {
                    System.out.println("¿De que equipo quieres mostrar los jugadores?");
                    in.nextLine();
                    String nombre=in.nextLine();
                    for (int i = 0; i < equipoArrayList.size(); i++) {
                        if (equipoArrayList.get(i).nombre.equals(nombre)) {
                            equipoArrayList.get(i).jugadorArrayList.forEach(jugador -> System.out.println(jugador.ID +" : "+jugador.nombre+ " : "+jugador.apellidos ));
                            existe = true;
                            preguntaOtraVez=false;
                        }
                    }
                    if (!existe) {
                        System.out.println("El equipo introducido no existe. ¿Desea introducir otro nombre de equipo para listar sus jugadores? (1 si | 0 no)");
                        int seguir = in.nextInt();
                        if (seguir != 1) preguntaOtraVez = false;
                    }
                }
                return id;
        }
        return id;
    }

    public void menuClasificacion(ArrayList<Equipo> equipoArrayList, int id, File fileEquipos) throws IOException {
        System.out.println("1.MOSTRAR CLASIFICACIÓN POR EQUIPOS");
        System.out.println("2.MOSTRAR CLASIFICACION POR PARTICIPANTES");

        int opcion = in.nextInt();

        switch (opcion) {
            case 1:
                //MOSTRAR POR EQUIPOS
                Clasificacion.cargarResultadosEquipos(equipoArrayList);
                break;

            case 2:
                //MOSTRAR POR PARTICIPANTES
                Clasificacion.cargarResultados();
                break;

        }
    }



}
