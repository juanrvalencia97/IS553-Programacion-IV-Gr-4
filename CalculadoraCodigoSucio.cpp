#include <iostream>
#include <cmath>

using namespace std;

/*Funcion principal, en la cual se realizan cada uno de los procesos necesarios para obtener los respectivos calculos:*/
int main() {
	//Variables para el operador y los numeros a utilzar en las operaciones
 char o; double a, b, c;
 //solicitar al usuario que ingres un operador
 cout << "Ingrese un operador (+, -, *, /, %, r, p, e, n, l, s, c, t): ";
 //se lee el operador ingresado por el usuario
 cin >> o;
 //mediante la estrucutra de flujo switch se realizan las operaciones segun el operador escogido
 switch (o) {
 	//operacion de suma
    case '+':
    cout << "Ingrese dos numeros: "; cin >> a >> b; c = a + b;
    break;
    //operacion de resta
    case '-':
    cout << "Ingrese dos numeros: "; cin >> a >> b; c = a - b;
    break;
    //operacion de multiplicacion
    case '*':
    cout << "Ingrese dos numeros: "; cin >> a >> b; c = a * b;
    break;
	//operacion de division
    case '/':
    cout << "Ingrese dos numeros: "; cin >> a >> b;
    if (b != 0) { c = a / b; } else {
    cout << "Error." << endl;
    return 1; 
    }
    break;
    //operacion de modulo
    case '%':
    cout << "Ingrese dos numeros: "; cin >> a >> b; c = fmod(a, b);
    break;
    //operacion de raiz
    case 'r':
    cout << "Ingrese dos numeros: "; cin >> a >> b; c = pow(b, 1.0 / a);
    break;
    //operacion de potencia
    case 'p':
    cout << "Ingrese dos numeros: "; cin >> a >> b; c = pow(a, b);
    break;
    //operacion de exponencial
    case 'e':
    cout << "Ingrese dos numeros: "; cin >> a; c = exp(a);
    break;
    //operacion de logaritmo natural
    case 'n':
    cout << "Ingrese un numero: "; cin >> a;
    //verificacion de numeros mayores a cero para cumplir con el dominio del logaritmo
	if (a > 0) { c = log(a);} else
	 {
    cout << "Error." << endl;
    return 1; 
    }
    break;
    //operacion del logaritmo base x
    case 'l':
    cout << "Ingrese dos numeros: "; cin >> a >> b; 
	if (a > 0 && b > 0 && b != 1){ c = log(a)/log(b);} else {
	cout << "Error."<< endl;
	return 1;
	}
	break;
    //operacion de seno
    case 's':
    cout << "Ingrese un numero: "; cin >> a; c = sin(a * M_PI / 180.0); 
    break;
    //operacion de coseno
    case 'c':
    cout << "Ingrese un numero: "; cin >> a; c = cos(a * M_PI / 180.0); 
    break;
    //operacion de tangente
    case 't':
    cout << "Ingrese un numero: "; cin >> a; c = tan(a * M_PI / 180.0); 
    break;
    //para cuando el usuario no ingrese alguna de las operaciones existentes
    default:
    cout << "Error." << endl;
    return 1;
    }
//Se imprime el resultado de la operacion, y se retorna 0 para indicar exito del programa
    cout << c << endl; return 0; 
}

