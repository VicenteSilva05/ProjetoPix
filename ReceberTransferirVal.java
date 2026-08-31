public class ReceberTransferirVal {
    private String agencia;
    private String numeroConta;
    private double saldo;
    private boolean status;

    public boolean receberValor(double valor) {
        if (valor > 0 && this.status) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean transferirValor(double valor, ContaBancaria contaDestino) {
        if (this.status && valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.receberValor(valor);
            return true;
        }
        return false;
    }
}