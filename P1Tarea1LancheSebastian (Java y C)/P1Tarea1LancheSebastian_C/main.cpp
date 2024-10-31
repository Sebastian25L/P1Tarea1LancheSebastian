#include <iostream>
#include <fstream>
#include <locale.h>

using namespace std;

// Declaración de variables
float Lanche_nota1, Lanche_nota2, Lanche_nota3;

void Lanche_guardarNotas() {
    float Lanche_promedio = (Lanche_nota1 + Lanche_nota2 + Lanche_nota3) / 3;

    // Se guardan las notas en el archivo
    ofstream archivo("Lanche_notas.txt", ios::app);
    if (!archivo) {
        cout << "Error al abrir el archivo." << endl;
        return;
    }
    archivo << "***-***-***-***" << endl;
    archivo << "Nota 1: " << Lanche_nota1 << endl;
    archivo << "Nota 2: " << Lanche_nota2 << endl;
    archivo << "Nota 3: " << Lanche_nota3 << endl;
    archivo << "Promedio: " << Lanche_promedio << endl;
    archivo << "***-***-***-***" << endl;
    archivo.close();
    cout << "Sus notas han sido guardadas exitosamente." << endl;
}

void Lanche_ingresarNotas() {
    // Se ingresan las notas del estudiante
    do {
        cout << "Ingrese la primera nota (0-20): ";
        cin >> Lanche_nota1;
        // Se valida el rango de calificación
        if (Lanche_nota1 < 0 || Lanche_nota1 > 20) {
            cout << "Ingrese una nota válida entre 0 y 20." << endl;
        }
    } while (Lanche_nota1 < 0 || Lanche_nota1 > 20);

    do {
        cout << "Ingrese la segunda nota (0-20): ";
        cin >> Lanche_nota2;
        // Se valida el rango de calificación
        if (Lanche_nota2 < 0 || Lanche_nota2 > 20) {
            cout << "Ingrese una nota válida entre 0 y 20." << endl;
        }
    } while (Lanche_nota2 < 0 || Lanche_nota2 > 20);

    do {
        cout << "Ingrese la tercera nota (0-20): ";
        cin >> Lanche_nota3;
        // Se valida el rango de calificación
        if (Lanche_nota3 < 0 || Lanche_nota3 > 20) {
            cout << "Ingrese una nota válida entre 0 y 20." << endl;
        }
    } while (Lanche_nota3 < 0 || Lanche_nota3 > 20);

    cout << "***-***-***-***-***" << endl;
    Lanche_guardarNotas();
}

void Lanche_verPromedio() {
    float Lanche_promedio = (Lanche_nota1 + Lanche_nota2 + Lanche_nota3) / 3;
    cout << "El promedio es: " << Lanche_promedio << endl;
    cout << (Lanche_promedio >= 14 ? "¡Usted ha aprobado!" : "¡Usted ha reprobado!") << endl;
    cout << "***-***-***-***-***" << endl;
}

void Lanche_menu() {
    int Lanche_opcion;
    do {
        cout << "Sistema de notas de los estudiantes" << endl;
        cout << "1. Ingresar notas" << endl;
        cout << "2. Ver promedio" << endl;
        cout << "3. Salir" << endl;
        cout << "Seleccione una opción: ";
        cin >> Lanche_opcion;
        cout << "***-***-***-***-***" << endl;

        switch (Lanche_opcion) {
            case 1:
                Lanche_ingresarNotas();
                break;
            case 2:
                Lanche_verPromedio();
                break;
            case 3:
                cout << "Gracias por usar el programa. Saliendo ..." << endl;
                break;
            default:
                cout << "Intente de nuevo, por favor." << endl;
        }
    } while (Lanche_opcion != 3);
}

int main() {
    setlocale(LC_ALL, "spanish");
    Lanche_menu();
    return 0;
}
