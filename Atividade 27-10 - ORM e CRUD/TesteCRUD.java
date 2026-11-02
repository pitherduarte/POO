import java.sql.SQLException;

public class TesteCRUD {
    private static final String ARQUIVO = "masterbank.db";

    public static int cadastrar() throws SQLException {
        Database banco = new Database(ARQUIVO);
        try {
            ContaRepository repositorio = new ContaRepository(banco);
            ContaBancaria conta = new ContaBancaria("Roberto Troncoso", 100.0);
            repositorio.create(conta);
            System.out.println("Conta cadastrada: " + conta);
            return conta.getId();
        } finally {
            banco.close();
        }
    }

    public static void consultar(int id) throws SQLException {
        Database banco = new Database(ARQUIVO);
        try {
            ContaRepository repositorio = new ContaRepository(banco);
            ContaBancaria conta = repositorio.loadFromId(id);
            if (conta == null) {
                System.out.println("Conta nao encontrada.");
            } else {
                System.out.println(conta);
            }
        } finally {
            banco.close();
        }
    }

    public static void listar() throws SQLException {
        Database banco = new Database(ARQUIVO);
        try {
            ContaRepository repositorio = new ContaRepository(banco);
            for (ContaBancaria conta : repositorio.loadAll()) {
                System.out.println(conta);
            }
        } finally {
            banco.close();
        }
    }

    public static void depositar(int id, double valor) throws SQLException {
        Database banco = new Database(ARQUIVO);
        try {
            ContaRepository repositorio = new ContaRepository(banco);
            ContaBancaria conta = repositorio.loadFromId(id);
            if (conta != null) {
                conta.depositar(valor);
                repositorio.update(conta);
                System.out.println("Deposito realizado: " + conta);
            } else {
                System.out.println("Conta nao encontrada.");
            }
        } finally {
            banco.close();
        }
    }

    public static void sacar(int id, double valor) throws SQLException {
        Database banco = new Database(ARQUIVO);
        try {
            ContaRepository repositorio = new ContaRepository(banco);
            ContaBancaria conta = repositorio.loadFromId(id);
            if (conta == null) {
                System.out.println("Conta nao encontrada.");
            } else if (conta.sacar(valor)) {
                repositorio.update(conta);
                System.out.println("Saque realizado: " + conta);
            } else {
                System.out.println("Saldo insuficiente ou valor invalido.");
            }
        } finally {
            banco.close();
        }
    }

    public static void excluir(int id) throws SQLException {
        Database banco = new Database(ARQUIVO);
        try {
            ContaRepository repositorio = new ContaRepository(banco);
            ContaBancaria conta = repositorio.loadFromId(id);
            if (conta != null) {
                repositorio.delete(conta);
                System.out.println("Conta excluida: " + id);
            } else {
                System.out.println("Conta nao encontrada.");
            }
        } finally {
            banco.close();
        }
    }
}
