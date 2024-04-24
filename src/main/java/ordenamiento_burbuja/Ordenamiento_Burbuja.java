/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ordenamiento_burbuja;

import java.util.Scanner;


/**
 *
 * @author anayc
 */
public class Ordenamiento_Burbuja {

    public static void main(String[] args) {

  Scanner scanner = new Scanner(System.in);
  
        System.out.println("Ingrese el número de cartas que desea ordenar: ");
        int numCartas = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        
        Carta[] cartas = new Carta[numCartas];
        for (int i = 0; i < numCartas; i++) {
            System.out.println("Ingrese el valor de la carta " + (i+1) + " (2-10, J, Q, K, A): ");
            String valor = scanner.nextLine();
            System.out.println("Ingrese el palo de la carta " + (i+1) + " (Corazones, Diamantes, Picas, Tréboles): ");
            String palo = scanner.nextLine();
            cartas[i] = new Carta(valor, palo);
        }
        
        ordenarPorBurbuja(cartas);
        
        System.out.println("Las cartas ordenadas son:");
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }

    public static void ordenarPorBurbuja(Carta[] cartas) {
        int n = cartas.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                // Comparar por valor y luego por palo
                if (compararCartas(cartas[j], cartas[j+1]) > 0) {
                    // Intercambiar las cartas
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j+1];
                    cartas[j+1] = temp;
                }
            }
        }
    }

    public static int compararCartas(Carta carta1, Carta carta2) {
        // Comparar por valor
        int comparacionValor = carta1.getValor().compareTo(carta2.getValor());
        if (comparacionValor != 0) {
            return comparacionValor;
        } else {
            // Si los valores son iguales, comparar por palo
            return carta1.getPalo().compareTo(carta2.getPalo());
        }
    }
}
       