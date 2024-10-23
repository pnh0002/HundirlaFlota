//package Arreglos;

import java.util.Scanner;

public class HundirLaFlota {
    public static void tableroOP(String[][] oponente){

        Scanner entrada = new Scanner(System.in);
        int contador = 3;
        int aleatorioF = 0;
        int aleatorioC = 0;
        int filas = oponente.length;
        int columnas = oponente[0].length;

        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                oponente[i][j] = " x ";
            }
        }

        while(contador!=0){
            aleatorioF = (int) (Math.random()*4) ;
            aleatorioC = (int) (Math.random()*4) ;
            
            if(oponente[aleatorioF][aleatorioC].equals(" B ")){

            }else{
                oponente[aleatorioF][aleatorioC] = " B ";
                contador--;
            }
    
            
        }
        /*Ver tabla enemiga 
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                System.out.print(oponente[i][j]);
            }
            System.out.println();
        }
            */

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] oponente = new String[4][4];
        String[][] tablero = new String[4][4];
        eleccionPos(tablero);
        tableroOP(oponente);
        int filas = tablero.length;
        int columnas = tablero[0].length;



        System.out.println();
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
        int fila = 0;
        int columna = 0;

        int contadorAliado = 3;
        int contadorOponente = 3;

        do {
            System.out.println("Dispara una fila: ");
            try {
                fila = sc.nextInt();

            } catch (Exception e) {
                System.err.println("Te has equivocado, te pido un número: ");
                System.err.println("Reiniciando la petición del tablero");
                System.exit(0);
            }
            System.out.println("Dispara una columna: ");
            try {
                columna = sc.nextInt();

            } catch (Exception e) {
                System.err.println("Te has equivocado, te pido un número: ");
                System.err.println("Reiniciando la petición del tablero");
                System.exit(0);
            }
            int f = tablero.length;
            int c = tablero[0].length;

            System.out.println(fila +" "+columna );
            System.out.println(oponente[fila][columna]);

            if(oponente[fila][columna].equals(" x ")){
                System.out.println("Agua!");
            } else if (oponente[fila][columna].equals(" B ")) {
                System.out.println("Hundido!");
                contadorAliado--;
                System.out.println(contadorAliado);
                oponente[fila][columna] = " o "; 
            }

            int diparoFila = (int) (Math.random() * 4);
            int diparoColumna = (int) (Math.random() * 4);

            System.out.println("Oponente dispara en fila "+diparoFila+" columna "+diparoColumna);


            if(tablero[diparoFila][diparoColumna].equals(" x ")){
                System.out.println("Agua!");
            } else if (tablero[diparoFila][diparoColumna].equals(" B ")) {
                System.out.println("Hundido!");
                contadorOponente--;
                tablero[diparoFila][diparoColumna] = " o "; 
            }
            /*Visualizar tabla oponente 
            for(int i = 0; i < filas; i++) {
                for(int j = 0; j < columnas; j++) {
                    System.out.print(oponente[i][j]);
                }
                System.out.println();
            }
            */
            System.out.println();
            for(int i = 0; i < filas; i++) {
                for(int j = 0; j < columnas; j++) {
                    System.out.print(tablero[i][j]);
                }
                System.out.println();
            }
        }while(contadorAliado!=0&&contadorOponente!=0);

        if(contadorAliado==0){
            System.out.println("Ganador Jugador 1");
        }else if(contadorOponente==0){
            System.out.println("Ganador Oponente");
        }

    }

    public static void eleccionPos(String[][] tablero){
        Scanner sc = new Scanner(System.in);
        int contador = 3;
        int fila = 0;
        int columna = 0;
        int filas = tablero.length;
        int columnas = tablero[0].length;


        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                tablero[i][j] = " x ";
            }
        }


        while(contador!=0){
            System.out.println("Dime una fila: ");
            try{
                fila = sc.nextInt();

            }catch (Exception e){
                System.err.println("Te has equivocado, te pido un número: ");
                System.err.println("Reiniciando la petición del tablero");
                System.exit(0);
            }
            System.out.println("Dime una columna: ");
            try{
                columna = sc.nextInt();

            }catch (Exception e){
                System.err.println("Te has equivocado, te pido un número: ");
                System.err.println("Reiniciando la petición del tablero");
                System.exit(0);
            }
            tablero[fila][columna] = " B ";
            contador--;
        }
    }
}
