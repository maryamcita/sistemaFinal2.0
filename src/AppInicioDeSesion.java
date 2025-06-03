import java.util.Scanner;

public class AppInicioDeSesion {

    static int[] resumenNotasTotales = new int[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String usuarioEstudiante = "estudiante1";
        String contrasenaEstudiante = "1234";

        String usuarioMaestro = "maestro1";
        String contrasenaMaestro = "abcd";
        
        System.out.println("Por favor ingrese su rol:");
        System.out.println("1. Estudiante");
        System.out.println("2. Maestro");

        String rol = sc.nextLine();
         while (true) { 
        if (rol.equals("1")) {
            
           
            boolean seguirEvaluando = true;
            while (seguirEvaluando) {
                System.out.println("Seleccione el docente que desea calificar:");
                System.out.println("1. Jaime Alberto Zapata");
                System.out.println("2. Luis Fernando Zapata");
                System.out.println("3. Mateo Gomez");
                System.out.println("4. Cristina Avendaño");
                System.out.println("5. Camilo Echeverri");
                String opcion = sc.nextLine();

                switch (opcion) {
                    case "1":
                        System.out.println("Ha seleccionado a Jaime Alberto Zapata.");
                        realizarEvaluacion(sc);
                        break;
                    case "2":
                        System.out.println("Ha seleccionado a Luis Fernando Zapata.");
                        realizarEvaluacion(sc);
                        break;
                    case "3":
                        System.out.println("Ha seleccionado a Mateo Gomez.");
                        realizarEvaluacion(sc);
                        break;
                    case "4":
                        System.out.println("Ha seleccionado a Cristina Avendaño.");
                        realizarEvaluacion(sc);
                        break;
                    case "5":
                        System.out.println("Ha seleccionado a Camilo Echeverri.");
                        realizarEvaluacion(sc);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        continue;
                }

                System.out.println("\n¿Desea calificar a otro docente? (1. sí / 2. no): ");
                String respuesta = sc.nextLine();

                if (respuesta.equalsIgnoreCase("2")) {
                    System.out.println("Reiniciando programa...\n");
                    break; 
                }
            }
        } else if (rol.equals("2")) {
        } else {
            System.out.println("Rol no reconocido. Intente nuevamente.");
        }


        System.out.println("\n---- RESUMEN TOTAL DE NOTAS DE TODOS LOS ESTUDIANTES ----");
        for (int i = 0; i < resumenNotasTotales.length; i++) {
            System.out.println((i + 1) + " estrella(s): " + resumenNotasTotales[i] + " respuesta(s)");
        }
     } 
    }

    public static boolean inicioSesionEstudiante(Scanner sc, String usuario, String contrasena) {
        System.out.println("Ingrese su nombre de usuario:");
        String usuarioIngresado = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasenaIngresada = sc.nextLine();

        if (usuarioIngresado.equals(usuario) && contrasenaIngresada.equals(contrasena)) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido estudiante!");
            return true;
        } else {
            System.out.println("Credenciales incorrectas.");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Volver a intentar");
            System.out.println("2. Cambiar contraseña");
            String opcion = sc.nextLine();

            if (opcion.equals("1")) {
                return inicioSesionEstudiante(sc, usuario, contrasena);
            } else if (opcion.equals("2")) {
                recuperarContrasena(sc, "institucional");
                return false;
            } else {
                System.out.println("Opción no válida.");
                return false;
            }
        }
    }

    public static boolean inicioSesionMaestro(Scanner sc, String usuario, String contrasena) {
        System.out.println("Ingrese su nombre de usuario:");
        String usuarioIngresado = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasenaIngresada = sc.nextLine();

        if (usuarioIngresado.equals(usuario) && contrasenaIngresada.equals(contrasena)) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido maestro!");
            return true;
        } else {
            System.out.println("Credenciales incorrectas.");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Volver a intentar");
            System.out.println("2. Cambiar contraseña");
            String opcion = sc.nextLine();

            if (opcion.equals("1")) {
                return inicioSesionMaestro(sc, usuario, contrasena);
            } else if (opcion.equals("2")) {
                recuperarContrasena(sc, "profesional");
                return false;
            } else {
                System.out.println("Opción no válida.");
                return false;
            }
        }
    }

    public static void recuperarContrasena(Scanner sc, String tipoCorreo) {
        System.out.println("Digite su correo " + tipoCorreo + ":");
        String correo = sc.nextLine();

        if (correo.contains("@cesde.net")) {
            System.out.println("Correo válido. Verifique el código que acaba de llegar y escríbalo aquí:");
            String codigo = sc.nextLine();
            System.out.println("Código recibido. Se enviará un enlace para restablecer la contraseña.");
        } else {
            System.out.println("Correo no válido, por favor ingrese uno " + tipoCorreo + ".");
        }
    }

    public static void realizarEvaluacion(Scanner sc) {
        String[] preguntas = {
            "1) ¿El docente presenta contenidos de manera clara y estructurada?",
            "2) ¿Utiliza recursos didácticos adecuados (presentaciones, videos, prácticas, etc.)?",
            "3) ¿Promueve la participación activa de los estudiantes durante la clase?",
            "4) ¿Relaciona los contenidos con aplicaciones reales o del entorno técnico?",
            "5) ¿Estimula el pensamiento crítico y la resolución de problemas?",
            "6) ¿Se comunica de manera respetuosa y profesional?",
            "7) ¿Escucha y responde adecuadamente a las preguntas de los estudiantes?",
            "8) ¿Está disponible para atender consultas fuera del horario de clase?",
            "9) ¿Informa claramente los criterios de evaluación?",
            "10) ¿Las evaluaciones están relacionadas con los contenidos enseñados?",
            "11) ¿Entrega retroalimentación oportuna sobre el desempeño académico?",
            "12) ¿Muestra compromiso con el proceso educativo?",
            "13) ¿Demuestra dominio del tema o materia que imparte?",
            "14) ¿Es puntual y cumple con los horarios establecidos?",
            "15) ¿En general, estoy satisfecho/a con el desempeño del docente?"
        };

        System.out.println("\n---- INICIO DE EVALUACIÓN DOCENTE ----");

        for (String pregunta : preguntas) {
            System.out.println(pregunta);
            System.out.println("1 - *\n2 - **\n3 - ***\n4 - ****\n5 - *****");
            String respuesta = sc.nextLine();

            int nota = 1;
            try {
                nota = Integer.parseInt(respuesta);
                if (nota < 1 || nota > 5) {
                    System.out.println("Respuesta fuera de rango. Se registra como: *");
                    nota = 1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Respuesta inválida. Se registra como: *");
                nota = 1;
            }

            resumenNotasTotales[nota - 1]++;
            System.out.println("La nota es: " + "*".repeat(nota));
        }

        System.out.println("¡Gracias por completar la evaluación!");
    }
}
