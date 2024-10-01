import java.util.Scanner;

public class CalculandoPrecoFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do produto: R$ ");
        double valorProduto = scanner.nextDouble();

        System.out.print("Digite o valor do frete: R$ ");
        double frete = scanner.nextDouble();

        System.out.print("Digite o valor do seguro: R$ ");
        double seguro = scanner.nextDouble();

        System.out.print("Digite a UF de origem: ");
        String ufOrigem = scanner.next();

        System.out.print("Digite a UF de destino: ");
        String ufDestino = scanner.next();

        System.out.print("Digite o valor do serviço: R$ ");
        double valorServico = scanner.nextDouble();

        System.out.print("Digite a alíquota do ISS (%): ");
        double aliquotaISS = scanner.nextDouble();

        System.out.print("Digite a margem de lucro (%): ");
        double margemLucro = scanner.nextDouble();

        ProdutoServico produtoServico = new ProdutoServico(
                valorProduto, frete, seguro, ufOrigem, ufDestino, valorServico, aliquotaISS, margemLucro
        );

        double precoFinal = produtoServico.calcularPrecoFinal();
        System.out.printf("Preço final do produto/serviço: R$ %.2f%n", precoFinal);

        scanner.close();
    }
}
