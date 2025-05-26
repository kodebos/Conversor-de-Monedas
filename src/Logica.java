import java.util.Scanner;

public class Logica {
    int opcionUsuario;
    Operacion operacion = new Operacion();
    Menu nuevoMenu = new Menu();
    Scanner input = new Scanner(System.in);

    public void logicaPrograma() {

        do {
            nuevoMenu.mostrarMenu();
            opcionUsuario = input.nextInt();
            switch (opcionUsuario) {
                case 1:
                    ejecutarConversion("USD", "BOB");
                    break;
                case 2:
                    ejecutarConversion("BOB", "USD");
                    break;
                case 3:
                    ejecutarConversion("USD", "ARS");
                    break;
                case 4:
                    ejecutarConversion("ARS", "USD");
                    break;
                case 5:
                    ejecutarConversion("USD", "BRL");
                    break;
                case 6:
                    ejecutarConversion("BRL", "USD");
                    break;
            }
        } while (opcionUsuario != 7);
    }

    public void ejecutarConversion(String divisa1, String divisa2) {
        double cantidad;
        System.out.println("Por favor ingresa la cantidad que deseas convertir:");
        cantidad = input.nextDouble();
        double resultado = operacion.operacionConversion(divisa1, divisa2, cantidad);
        System.out.println("***********************************************");
        System.out.println(cantidad + " " + divisa1 + " son " + resultado + " " + divisa2);
        nuevoMenu.menu2();
        int segundaOpcion = input.nextInt();
        if (segundaOpcion == 2) {
            opcionUsuario = 7;
            System.out.println("Gracias por usar el programa!");
        }
    }
}
