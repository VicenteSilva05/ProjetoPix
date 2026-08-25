import java.util.ArrayList;
import java.util.List;

public class CadastroUsuario {

    static class Conta {
        String nome, telefone, cpf, email, senha;

        public Conta(String nome, String telefone, String cpf, String email, String senha) {
            this.nome = nome;
            this.telefone = telefone;
            this.cpf = cpf;
            this.email = email;
            this.senha = senha;
        }
    }

    private List<Conta> contas = new ArrayList<>();

    public Conta buscarPorCpf(String cpf) {
        for (Conta conta : contas) {
            if (conta.cpf.equals(cpf)) {
                return conta;
            }
        }
        return null;
    }

    public void adicionarUsuario(String nome, String telefone, String cpf, String email, String senha) {
        if (buscarPorCpf(cpf) != null) {
            System.out.println("Erro: Já existe uma conta cadastrada com o CPF " + cpf);
            return;
        }
        contas.add(new Conta(nome, telefone, cpf, email, senha));
        System.out.println("Conta criada com sucesso!");
    }

    public Conta login(String email, String senha) {
        for (Conta conta : contas) {
            if (conta.email.equals(email) && conta.senha.equals(senha)) {
                System.out.println("Login realizado com sucesso! Bem-vindo, " + conta.nome);
                return conta;
            }
        }
        System.out.println("Email ou senha incorretos.");
        return null;
    }
}