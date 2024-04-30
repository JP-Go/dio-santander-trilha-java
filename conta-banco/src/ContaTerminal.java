import java.util.Scanner;
import java.util.regex.Pattern;

public class ContaTerminal {
  public static void main(String[] args) throws Exception {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Por favor digite o número da agência: ");
      String agencia = scanner.next();
      System.out.print("Por favor digite o número da conta: ");
      int conta = scanner.nextInt();
      System.out.print("Por favor digite seu nome (somente letras maiúsculas e espaços): ");
      // Flushes the newline character left over by nextInt
      scanner.nextLine();
      String nome = "";
      if (scanner.hasNextLine()){
          nome = scanner.nextLine();
      }
      System.out.print("Por favor digite o saldo inicial: ");
      double saldo = scanner.nextDouble();

      System.out.printf("Olá, %s, obrigado por criar uma conta em nosso banco, sua agência é %s," + 
            " conta %d e seu saldo %.2f já está disponível para saque\n", nome, agencia, conta, saldo);

      System.out.println("####################  Fim de transação  ######################");

      scanner.close();
  }
}
