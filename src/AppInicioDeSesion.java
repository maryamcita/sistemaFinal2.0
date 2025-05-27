import java.util.Scanner;

public class AppInicioDeSesion {

    // Arreglo global para acumular las respuestas de todos los estudiantes
    static int[] resumenNotasTotales = new int[5];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String usuarioEstudiante = "estudiante1";
        String contrasenaEstudiante = "1234";

        String usuarioMaestro = "maestro1";
        String contrasenaMaestro = "abcd";

        System.out.println("Por favor ingrese su rol:");
        System.out.println("1. Estudiante");
        System.out.println("2. Maestro");

        String rol = sc.nextLine();

        if (rol.equals("1")) {
            System.out.println("Ingrese su nombre de usuario:");
            String usuarioIngresadoEst = sc.nextLine();

            System.out.println("Ingrese su contraseña:");
            String contrasenaIngresadaEst = sc.nextLine();

            if (usuarioIngresadoEst.equals(usuarioEstudiante) && contrasenaIngresadaEst.equals(contrasenaEstudiante)) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido estudiante!");
                realizarEvaluacion(sc);
            } else {
                System.out.println("Credenciales incorrectas.");
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Volver a intentar");
                System.out.println("2. Cambiar contraseña");
                String opcionEst = sc.nextLine();

                if (opcionEst.equals("1")) {
                    System.out.println("Ingrese su nombre de usuario:");
                    usuarioIngresadoEst = sc.nextLine();

                    System.out.println("Ingrese su contraseña:");
                    contrasenaIngresadaEst = sc.nextLine();

                    if (usuarioIngresadoEst.equals(usuarioEstudiante) && contrasenaIngresadaEst.equals(contrasenaEstudiante)) {
                        System.out.println("Inicio de sesión exitoso. ¡Bienvenido estudiante!");
                        realizarEvaluacion(sc);
                    } else {
                        System.out.println("Segundo intento fallido. Debe recuperar su contraseña.");
                        System.out.println("Por favor digite su correo institucional:");
                        String correoInstitucional = sc.nextLine();

                        if (correoInstitucional.contains("@cesde.net")) {
                            System.out.println("Correo válido. Verifique el código que acaba de llegar y escríbalo aquí:");
                            String codigo = sc.nextLine();
                            System.out.println("Código recibido. Se enviará un enlace para restablecer la contraseña.");
                        } else {
                            System.out.println("Correo no válido, por favor ingrese uno institucional.");
                        }
                    }
                } else if (opcionEst.equals("2")) {
                    System.out.println("Para recuperar su contraseña, digite su correo institucional:");
                    String correoInstitucional = sc.nextLine();

                    if (correoInstitucional.contains("@cesde.net")) {
                        System.out.println("Correo válido. Verifique el código que acaba de llegar y escríbalo aquí:");
                        String codigo = sc.nextLine();
                        System.out.println("Código recibido. Se enviará un enlace para restablecer la contraseña.");
                    } else {
                        System.out.println("Correo no válido, por favor ingrese uno institucional.");
                    }
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        } else if (rol.equals("2")) {
            System.out.println("Ingrese su nombre de usuario:");
            String usuarioIngresadoMaestro = sc.nextLine();

            System.out.println("Ingrese su contraseña:");
            String contrasenaIngresadaMaestro = sc.nextLine();

            if (usuarioIngresadoMaestro.equals(usuarioMaestro) && contrasenaIngresadaMaestro.equals(contrasenaMaestro)) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido maestro!");
            } else {
                System.out.println("Credenciales incorrectas.");
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Volver a intentar");
                System.out.println("2. Cambiar contraseña");
                String opcion = sc.nextLine();

                if (opcion.equals("1")) {
                    System.out.println("Ingrese su nombre de usuario:");
                    usuarioIngresadoMaestro = sc.nextLine();

                    System.out.println("Ingrese su contraseña:");
                    contrasenaIngresadaMaestro = sc.nextLine();

                    if (usuarioIngresadoMaestro.equals(usuarioMaestro) && contrasenaIngresadaMaestro.equals(contrasenaMaestro)) {
                        System.out.println("Inicio de sesión exitoso. ¡Bienvenido maestro!");
                    } else {
                        System.out.println("Segundo intento fallido. Debe recuperar su contraseña.");
                        System.out.println("Digite su correo profesional:");
                        String correo = sc.nextLine();

                        if (correo.contains("@cesde.net")) {
                            System.out.println("Correo válido. Verifique el código que acaba de llegar y escríbalo aquí:");
                            String codigo = sc.nextLine();
                            System.out.println("Código recibido. Se enviará un enlace para restablecer la contraseña.");
                        } else {
                            System.out.println("Correo no válido, por favor ingrese uno profesional.");
                        }
                    }
                } else if (opcion.equals("2")) {
                    System.out.println("Digite su correo profesional:");
                    String correo = sc.nextLine();

                    if (correo.contains("@cesde.net")) {
                        System.out.println("Correo válido. Verifique el código que acaba de llegar y escríbalo aquí:");
                        String codigo = sc.nextLine();
                        System.out.println("Código recibido. Se enviará un enlace para restablecer la contraseña.");
                    } else {
                        System.out.println("Correo no válido.");
                    }
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        } else {
            System.out.println("Rol no reconocido. Intente nuevamente.");
        }

        sc.close();

        // Mostrar resumen total de notas al final (acumuladas por todos los estudiantes)
        System.out.println("\n---- RESUMEN TOTAL DE NOTAS DE TODOS LOS ESTUDIANTES ----");
        for (int i = 0; i < resumenNotasTotales.length; i++) {
            System.out.println((i + 1) + " estrella(s): " + resumenNotasTotales[i] + " respuesta(s)");
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

            resumenNotasTotales[nota - 1]++; // Acumula nota en el arreglo global

            String estrellas = "*".repeat(nota);
            System.out.println("La nota es: " + estrellas);
        }

        System.out.println("¡Gracias por completar la evaluación!");
    }
}
