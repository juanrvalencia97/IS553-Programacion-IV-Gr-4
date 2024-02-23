/*CALCULADORA SENCILLA
* Autor: Juan Alejandro Rojas Valencia
* Objetivo: Proporcionar una herramienta que permita realizar operaciones matematicas basicas al usuario
*/

#include <iostream>
#include <cmath>

//Directivas del prepocesador para incluir las librerias necesarias  para las funciones de limpiar pantalla, 
//para cualquier OS
#ifdef _WIN32
#include <windows.h>
#else
#include <cstdlib>
#endif

/*==================================================================================================================================================
BLOQUE DE FUNCIONES OPERACIONALES*/

double sumar(double num1, double num2) {
    return num1 + num2;
}

double restar(double num1, double num2) {
    return num1 - num2;
}

double multiplicar(double num1, double num2) {
    return num1 * num2;
}

//en esta funcion se garantiza evitar la division entre cero
double dividir(double num1, double num2) {
    if (num2 != 0) {
        return num1 / num2;
    } else {
        throw std::invalid_argument("Error: No se puede dividir por cero.");
    }
}

double calcularModulo(double num1, double num2) {
    return fmod(num1, num2);
}

double calcularRaiz(double indice, double numero) {
    return pow(numero, 1.0 / indice);
}

double calcularPotencia(double base, double exponente) {
    return pow(base, exponente);
}

double calcularExponenciacion(double numero) {
    return exp(numero);
}

//se verifica que el dominio del logaritmo sea mayor a cero
double calcularLogaritmoNatural(double numero) {
    if (numero > 0) {
        return log(numero);
    } else {
        throw std::invalid_argument("Error: El logaritmo de un numero no positivo no esta definido.");
    }
}

//se verifica que el dominio  y la base del logaritmo sea mayor a cero y que la base ses diferente de 1
double calcularLogaritmoEnBase(double base, double numero) {
    if (numero > 0 && base > 0 && base != 1) {
        return log(numero) / log(base);
    } else {
        throw std::invalid_argument("Error: El logaritmo de un numero no positivo o en base 1 no esta definido.");
    }
}

double calcularSeno(double angulo) {
    return sin(angulo * 3.1416 / 180.0); // Convertir grados a radianes
}

double calcularCoseno(double angulo) {
    return cos(angulo * 3.1416 / 180.0); // Convertir grados a radianes
}

double calcularTangente(double angulo) {
    return tan(angulo * 3.1416 / 180.0); // Convertir grados a radianes
}

/*==================================================================================================================================================
FUNCIONES DE LIMPIEZA DE PANTALLA*/

//Utiles para diferentes sistemas operativos
#ifdef _WIN32
void limpiarPantalla(){
	system("cls");
}
#else
void limpiarPantalla(){
	system("clear");
}
#endif

/*==================================================================================================================================================
 MENU DE USUARIO:
*/
void mostrarMenu() {
    std::cout << "Operaciones disponibles:\n\n";
    std::cout << "+: Suma\n";
    std::cout << "-: Resta\n";
    std::cout << "*: Multiplicacion\n";
    std::cout << "/: Division\n";
    std::cout << "%: Modulo\n";
    std::cout << "r: Raiz\n";
    std::cout << "p: Potencia\n";
    std::cout << "e: Exponenciacion\n";
    std::cout << "n: Logaritmo Natural\n";
    std::cout << "l: Logaritmo base x\n";
    std::cout << "s: Seno\n";
    std::cout << "c: Coseno\n";
    std::cout << "t: Tangente\n";
    std::cout << "\n Ingrese el operador deseado: ";
}
/*==================================================================================================================================================
FUNCION CALCULADORA
*/
 
 void calculadora() {
	char operador;
    double num1, num2, resultado;

    do {
        mostrarMenu();
        std::cin >> operador;
        limpiarPantalla();

        try {
            switch (operador) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                    std::cout << "Ingrese dos numeros: ";
                    std::cin >> num1 >> num2;
                    break;
                case 'r':
                case 'p':
                case 'l':
                    std::cout << "Ingrese el primer numero (base/indice): ";
                    std::cin >> num1;
                    std::cout << "Ingrese el segundo numero (exponente/numero): ";
                    std::cin >> num2;
                    break;
                case 'e':
                case 'n':
                case 's':
                case 'c':
                case 't':
                    std::cout << "Ingrese el numero: ";
                    std::cin >> num1;
                    break;
                default:
                    throw std::invalid_argument("Operador no valido.");
            }

            switch (operador) {
                case '+':
                    resultado = sumar(num1, num2);
                    break;
                case '-':
                    resultado = restar(num1, num2);
                    break;
                case '*':
                    resultado = multiplicar(num1, num2);
                    break;
                case '/':
                    resultado = dividir(num1, num2);
                    break;
                case '%':
                    resultado = calcularModulo(num1, num2);
                    break;
                case 'r':
                    resultado = calcularRaiz(num1, num2);
                    break;
                case 'p':
                    resultado = calcularPotencia(num1, num2);
                    break;
                case 'e':
                    resultado = calcularExponenciacion(num1);
                    break;
                case 'n':
                    resultado = calcularLogaritmoNatural(num1);
                    break;
                case 'l':
                	resultado = calcularLogaritmoEnBase(num1, num2);
                	break;
                case 's':
                    resultado = calcularSeno(num1);
                    break;
                case 'c':
                    resultado = calcularCoseno(num1);
                    break;
                case 't':
                    resultado = calcularTangente(num1);
                    break;
            }

            std::cout << "Respuesta: " << num1 << " " << operador << " " << num2 << " = " << resultado << std::endl;

            std::cout << "Desea continuar con otra operacion? (s/n): ";
            char continuar;
            std::cin >> continuar;

            if (continuar != 's' && continuar != 'S') {
                break;
            }
            
            limpiarPantalla();
            
        } catch (const std::exception& e) {
            std::cerr << e.what() << std::endl;
        } 

    } while (true);

}
/*==================================================================================================================================================
FUNCION PRINCIPAL - MAIN*/
int main() {
	calculadora();
    return 0;
}

