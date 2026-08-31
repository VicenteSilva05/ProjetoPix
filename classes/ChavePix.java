import java.util.UUID;

public class ChavePix {
    private String tipoChave;
    private String numeroChave;
    private ContaBancaria contaBancaria;

    public ChavePix() {
    }

    public ChavePix(String tipoChave, String numeroChave, ContaBancaria contaBancaria) {
        this.tipoChave = tipoChave;
        this.numeroChave = numeroChave;
        this.contaBancaria = contaBancaria;
    }

    // Getters e Setters
    public String getTipoChave() {
        return tipoChave;
    }

    public void setTipoChave(String tipoChave) {
        this.tipoChave = tipoChave;
    }

    public String getNumeroChave() {
        return numeroChave;
    }

    public void setNumeroChave(String numeroChave) {
        this.numeroChave = numeroChave;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }


    public static ChavePix gerarChaveAleatoria(ContaBancaria contaBancaria) {
        String chaveAleatoria = UUID.randomUUID().toString();
        return new ChavePix("Aleatoria", chaveAleatoria, contaBancaria);
    }

    public boolean validarChave() {
        if (tipoChave == null || numeroChave == null || numeroChave.isEmpty()) {
            return false;
        }

        switch (tipoChave.toUpperCase()) {
            case "CPF":
                return numeroChave.matches("\\d{11}");
            case "CNPJ":
                return numeroChave.matches("\\d{14}");
            case "EMAIL":
                return numeroChave.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
            case "TELEFONE":
                return numeroChave.matches("\\+?\\d{10,13}");
            case "ALEATORIA":
                return numeroChave.matches(
                    "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}"
                );
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "ChavePix{" +
                "tipoChave='" + tipoChave + '\'' +
                ", numeroChave='" + numeroChave + '\'' +
                ", contaBancaria=" + contaBancaria +
                '}';
    }
}
