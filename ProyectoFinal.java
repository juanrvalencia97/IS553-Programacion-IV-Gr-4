/* Parcial #1
* Autor: Juan Alejandro Rojas Valencia
* Objetivo: Crear un programa basico que permita registrar usuarios e iniciar sesion en un sistema de reservas de hotel.      
*/

//Clases externas utilizadas
import java.util.ArrayList;
import java.util.Scanner;

//Clase principal del proyecto
public class ProyectoFinal {

    //Objeto scanner utilizado para la entrada de datos externa
    public static Scanner leerDatoTeclado = new Scanner(System.in);

    //Lista que almacena los datos de usuarios registrados en el sistema.
    public static ArrayList<String[]> usuarios = new ArrayList<>();

    //Constantes utilizadas para el manejo de datos de inicio de sesion en el array "usuario" mediante indices.
    public static final int TIPO_IDENTIFICACION = 0;
    public static final int DOCUMENTO_IDENTIFICACION = 1;
    public static final int NOMBRES = 2;
    public static final int APELLIDOS = 3;
    public static final int CORREO_ELECTRONICO = 4;
    public static final int DIRECCION_RESIDENCIA = 5;
    public static final int CIUDAD_RESIDENCIA = 6;
    public static final int TELEFONO_CONTACTO = 7;
    public static final int CONTRASENA = 8;

    //Metodo principal donde se inicia la ejecucion del programa mediante el llamado del menu.
    public static void main(String[] args) {
        mostrarMenuLoginRegistro();
    }

    //Metodo que muestra el menu de inicio de sesion y registro de usuarios.
    public static void mostrarMenuLoginRegistro() {
        boolean salir = false;
        do {
            System.out.println("Bienvenido a MyHotel ...");
            System.out.println("Mas que un lugar para descansar.");
            System.out.println("--------------------------------------------");
            System.out.println("Ingrese la opcion deseada:");
            System.out.println("1. Registrarse como cliente.");
            System.out.println("2. Iniciar Sesion.");
            System.out.println("3. Salir. ");

            int opcion = leerDatoTeclado.nextInt();
            leerDatoTeclado.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    solicitarDatosDeRegistro(); //Se hace el llamado del metodo para el formulario de registro
                    break;
                case 2:
                    boolean loginExitoso = iniciarSesion(); //Se hace el llamado del metodo para iniciar sesion
                    //Se verifica si se inicia sesion correctamente mediante un booleano
                    if (loginExitoso) {
                        System.out.println("Usuario logueado correctamente. ");
                    } else {
                        System.out.println("Usuario incorrecto, intente una vez más. ");
                    }
                    break;
                case 3:
                    System.out.println("¡Hasta pronto!"); //mensaje de salida
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor seleccione nuevamente.");
                    break;
            }
        } while (!salir);
    }

    //Metodo que solicita los datos de registro del usuario.
    public static void solicitarDatosDeRegistro() {
        System.out.println("Tipo de identificación:");
        String tipoIdentificacion = leerDatoTeclado.nextLine();

        System.out.println("Documento de identificación:");
        String documentoIdentificacion = leerDatoTeclado.nextLine();

        System.out.println("Nombres:");
        String nombres = leerDatoTeclado.nextLine();

        System.out.println("Apellidos:");
        String apellidos = leerDatoTeclado.nextLine();

        System.out.println("Correo electrónico:");
        String correoElectronico = leerDatoTeclado.nextLine();

        System.out.println("Dirección de residencia:");
        String direccionResidencia = leerDatoTeclado.nextLine();

        System.out.println("Ciudad de residencia:");
        String ciudadResidencia = leerDatoTeclado.nextLine();

        System.out.println("Teléfono de contacto:");
        String telefonoContacto = leerDatoTeclado.nextLine();

        System.out.println("Contraseña:");
        String contrasena = leerDatoTeclado.nextLine();

        System.out.println("Confirmar Contraseña:");
        String confirmarContrasena = leerDatoTeclado.nextLine();

        //se comprueba si las contrasenas coinciden, en caso verdadero se registra el usuario
        if (!contrasena.equals(confirmarContrasena)) {
            System.out.println("Las contraseñas no coinciden. Intente nuevamente.");
            solicitarDatosDeRegistro();//llamado recursivo para llenar los datos nuevamente
        } else {
            registrarUsuario(tipoIdentificacion, documentoIdentificacion, nombres, apellidos, correoElectronico,
                    direccionResidencia, ciudadResidencia, telefonoContacto, contrasena);
            System.out.println("Usuario registrado exitosamente.");
        }
    }

    //metodo para asignar los datos de usuario en el array.
    public static void registrarUsuario(String tipoIdentificacion, String documentoIdentificacion, String nombres,
            String apellidos, String correoElectronico, String direccionResidencia, String ciudadResidencia,
            String telefonoContacto, String contrasena) {
        String[] usuario = new String[10];
        usuario[TIPO_IDENTIFICACION] = tipoIdentificacion;
        usuario[DOCUMENTO_IDENTIFICACION] = documentoIdentificacion;
        usuario[NOMBRES] = nombres;
        usuario[APELLIDOS] = apellidos;
        usuario[CORREO_ELECTRONICO] = correoElectronico;
        usuario[DIRECCION_RESIDENCIA] = direccionResidencia;
        usuario[CIUDAD_RESIDENCIA] = ciudadResidencia;
        usuario[TELEFONO_CONTACTO] = telefonoContacto;
        usuario[CONTRASENA] = contrasena;
        //Se agrega usuario con sus datos como un nuevo componente del ArrayList usuarios
        usuarios.add(usuario);
    }

    //Metodo que solicita los datos de inicio de sesion del usuario, si ya se ha registrado.
    public static boolean iniciarSesion() {
        int intentosFallidos = 0;
        //Se utiliza un booleano para verificar si se inicia sesion correctamente.
        boolean loginExitoso = false;
        do{
            System.out.println("Correo electrónico:");
            String correoElectronico = leerDatoTeclado.nextLine();

            System.out.println("Contraseña:");
            String contrasena = leerDatoTeclado.nextLine();

        
            //Se itera sobre la lista para verificar que el usuario exista y que las credenciales sean correctas.
            for (String[] usuario : usuarios) {
                if (usuario[CORREO_ELECTRONICO].equals(correoElectronico) && usuario[CONTRASENA].equals(contrasena)) {
                    return true;
                }
            }

            intentosFallidos++;
            //Si se supera el numero de intentos fallidos se sale del programa.
            if (intentosFallidos >= 3) {
                System.out.println("Ha alcanzado el limite de intentos fallidos. Saliendo del programa.");
                System.exit(0);
            }else{
                System.out.println("Credenciales incorrectas, intente nuevamente.");
            }
        }while(!loginExitoso);

        return false;
    }
}
