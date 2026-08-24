import java.util.List;
import java.util.ArrayList;

public class ContaBancaria{
    private String agencia;
    private String numeroConta;
    private List<ChavePix> chaves;
    private double saldo;
    private boolean status;

    public ContaBancaria(String agencia, String numeroConta){
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        saldo = 0.0;
        status = true;
        chaves = new ArrayList<>();
    }

    public boolean atualizarContaBancaria(String agencia, String numeroConta){
        if (!status){
            return false;
        }
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        return true;
    }

    public boolean removerContaBancaria(){
        if (!status){
            return false;
        }
        status = false;
        return true;
    }

    public boolean transferirValor(double valor, ChavePix chave){
        if (!status || valor <= 0){
            return false;
        }
        if (saldo >= valor && chave != null && chave.getContaBancaria() != null){
            if (chave.getContaBancaria().receberValor(valor)) {
                saldo -= valor;
                return true;
            }
        }
        return false;
    }

    public boolean receberValor(double valor){
        if (!status || valor <= 0){
            return false;
        }
        saldo += valor;
        return true;
    }

    public boolean associarChave(ChavePix chave){
        if (!status || chave == null ||chaves.contains(chave)){
            return false;
        }
        chaves.add(chave);
        return true;
    }

    public boolean isStatus() {
        return status;
    }

    public double getSaldo() {
        return saldo;
    }
}