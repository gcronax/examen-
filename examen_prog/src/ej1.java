import java.util.Objects;
import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        System.out.println(6.5/2);

        Scanner scan= new Scanner(System.in);
        String pedido_add;
        int option;
        float cuenta=0;
        do {
            System.out.println("*** Selecciona un plato o bebida ***");
            System.out.print("  1. Pizza (12,50 €)\n" +
                    "  2. Hamburguesa (10,00 €)\n" +
                    "  3. Agua (1,50 €)\n" +
                    "  4. Refresco (2,50 €)\n" +
                    "Introduce opción (1-4): ");
            option= scan.nextInt();
            switch (option){
                case 1:
                    cuenta= (float) (cuenta+(12.5));
                    break;
                case 2:
                    cuenta= (float) (cuenta+(10.0));
                    break;
                case 3:
                    cuenta= (float) (cuenta+(1.5));
                    break;
                case 4:
                    cuenta= (float) (cuenta+(2.5));
                    break;
                default:
                    System.out.println("!!!! La opción no es válida !!!!");
            }
            System.out.print("¿Quieres añadir otro producto al pedido? (S/N): ");
            pedido_add= scan.next();
        }while (!Objects.equals(pedido_add, "n")&&Objects.equals(pedido_add, "s"));
        System.out.println("Total del pedido: "+cuenta+" €");
        System.out.println("Introduce el número de comensales: ");
        int comensales= scan.nextInt();;
        try {
            if (comensales==0){
                throw new ArithmeticException();
            }else {
                System.out.println("Total por persona: "+cuenta/comensales +" €");
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir por 0");
        }

    }
}
