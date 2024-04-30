import java.util.Scanner;

public class Contador {

    public static void main(String[] args){
        int firstParam,secondParam;
        // We can pass parameters directly to the executable params
        if (args.length < 2){
            Scanner terminal = new Scanner(System.in);
            System.out.println("Digite o primeiro parâmetro");
            firstParam = terminal.nextInt();
            System.out.println("Digite o segundo parâmetro");
            secondParam = terminal.nextInt();
            terminal.close();
        }else {
            firstParam = Integer.parseInt(args[0]);
            secondParam = Integer.parseInt(args[1]);
        }

        try {
            count(firstParam,secondParam);
        } catch (ParametrosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    static void count(int firstParam, int secondParam) throws ParametrosInvalidosException{
        if(firstParam > secondParam){
            throw new ParametrosInvalidosException("O parâmetro um deve ser menor que o parâmetro dois");
        }
        // Executes the loop even if both parameters are negative.
        int count = Math.abs(secondParam - firstParam);
        for(int i = 1; i <= count; i++){
            System.out.printf("Imprimindo o número %d\n", i);
        }
    }
}
