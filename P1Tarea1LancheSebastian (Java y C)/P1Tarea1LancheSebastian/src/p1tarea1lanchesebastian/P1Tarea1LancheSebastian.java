package p1tarea1lanchesebastian;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class P1Tarea1LancheSebastian {
    // Declaracion de variables
    static float Lanche_nota1, Lanche_nota2, Lanche_nota3;

public static void Lanche_guardarNotas() {
    float Lanche_promedio = (Lanche_nota1 + Lanche_nota2 + Lanche_nota3) / 3;

    // Se guardan las notas y el promedio en archivo CSV
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Lanche_notas.csv", true))) {
        writer.write("Nota 1,Nota 2,Nota 3,Promedio\n");
        writer.write(Lanche_nota1 + "," + Lanche_nota2 + "," + Lanche_nota3 + "," + Lanche_promedio + "\n");
    } catch (IOException e) {
        System.out.println("Error al abrir el archivo CSV.");
    }

    // Se guardan las notas y el promedio en archivo JSON
    JSONObject json = new JSONObject();
    json.put("Nota 1", Lanche_nota1);
    json.put("Nota 2", Lanche_nota2);
    json.put("Nota 3", Lanche_nota3);
    json.put("Promedio", Lanche_promedio); 

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Lanche_notas.json", true))) {
        writer.write(json.toJSONString() + "\n");
    } catch (IOException e) {
        System.out.println("Error al abrir el archivo JSON.");
    }

    System.out.println("Sus notas han sido guardadas exitosamente.");
}

    public static void Lanche_ingresarNotas() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Ingrese la primera nota (0-20): ");
            Lanche_nota1 = scanner.nextFloat();
            if (Lanche_nota1 < 0 || Lanche_nota1 > 20) {
                System.out.println("Ingrese una nota valida entre 0 y 20.");
            }
        } while (Lanche_nota1 < 0 || Lanche_nota1 > 20);

        do {
            System.out.print("Ingrese la segunda nota (0-20): ");
            Lanche_nota2 = scanner.nextFloat();
            if (Lanche_nota2 < 0 || Lanche_nota2 > 20) {
                System.out.println("Ingrese una nota valida entre 0 y 20.");
            }
        } while (Lanche_nota2 < 0 || Lanche_nota2 > 20);

        do {
            System.out.print("Ingrese la tercera nota (0-20): ");
            Lanche_nota3 = scanner.nextFloat();
            if (Lanche_nota3 < 0 || Lanche_nota3 > 20) {
                System.out.println("Ingrese una nota valida entre 0 y 20.");
            }
        } while (Lanche_nota3 < 0 || Lanche_nota3 > 20);

        System.out.println("***-***-***-***-***");
        Lanche_guardarNotas();
        Lanche_verPromedio(); 
    }

    public static void Lanche_verPromedio() {
        float Lanche_promedio = (Lanche_nota1 + Lanche_nota2 + Lanche_nota3) / 3;
        System.out.println("El promedio es: " + Lanche_promedio);
        System.out.println(Lanche_promedio >= 14 ? "¡Usted ha aprobado!" : "¡Usted ha reprobado!");
        System.out.println("***-***-***-***-***");
    }

    public static void Lanche_menu() {
        Scanner scanner = new Scanner(System.in);
        int Lanche_opcion;

        do {
            System.out.println("Sistema de notas de los estudiantes");
            System.out.println("1. Ingresar notas");
            System.out.println("2. Ver promedio");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            Lanche_opcion = scanner.nextInt();
            System.out.println("***-***-***-***-***");

            switch (Lanche_opcion) {
                case 1 -> Lanche_ingresarNotas();
                case 2 -> Lanche_verPromedio();
                case 3 -> System.out.println("Gracias por usar el programa. Saliendo ...");
                default -> System.out.println("Intente de nuevo, por favor.");
            }
        } while (Lanche_opcion != 3);
    }

    public static void main(String[] args) {
        Lanche_menu();
    }
}
