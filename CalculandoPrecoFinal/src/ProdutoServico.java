public class ProdutoServico {

    private double valorProduto;
    private double frete;
    private double seguro;
    private String ufOrigem;
    private String ufDestino;
    private double valorServico;
    private double aliquotaISS;
    private double margemLucro;

    public ProdutoServico(double valorProduto, double frete, double seguro, String ufOrigem, String ufDestino, double valorServico, double aliquotaISS, double margemLucro) {
        this.valorProduto = valorProduto;
        this.frete = frete;
        this.seguro = seguro;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
        this.valorServico = valorServico;
        this.aliquotaISS = aliquotaISS;
        this.margemLucro = margemLucro;
    }

    public double calcularIPI() {
        double baseCalculo = valorProduto + frete + seguro;
        return baseCalculo * 0.0015;
    }

    public double calcularICMS() {
        double aliquotaICMS = 0.0;

        if (ufOrigem.equalsIgnoreCase("SP")) {
            if (ufDestino.equalsIgnoreCase("RJ")) {
                aliquotaICMS = 0.12;
            } else if (ufDestino.equalsIgnoreCase("DF")) {
                aliquotaICMS = 0.07;
            }
        }

        return valorProduto * aliquotaICMS;
    }

    public double calcularISS() {
        return valorServico * (aliquotaISS / 100);
    }

    // Método que calcula o preço final
    public double calcularPrecoFinal() {
        double valorIPI = calcularIPI();
        double valorICMS = calcularICMS();
        double valorISS = calcularISS();

        double custoTotal = valorProduto + frete + seguro + valorIPI + valorICMS + valorISS;
        double lucro = custoTotal * (margemLucro / 100);
        return custoTotal + lucro;
    }
}
