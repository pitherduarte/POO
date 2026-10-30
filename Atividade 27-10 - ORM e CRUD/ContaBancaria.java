import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "contas")
public class ContaBancaria {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String titular;

    @DatabaseField
    private String numeroConta;

    @DatabaseField
    private double saldo;

    // O ORMLite precisa de um construtor sem parametros.
    public ContaBancaria() {
    }

    public ContaBancaria(String titular, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty() || saldoInicial < 0) {
            throw new IllegalArgumentException("Dados da conta invalidos.");
        }
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public int getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O deposito deve ser positivo.");
        }
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public String toString() {
        return "ID: " + id + " | Titular: " + titular
                + " | Agencia/Conta: " + numeroConta
                + " | Saldo: R$ " + saldo;
    }
}
