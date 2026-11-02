import java.sql.SQLException;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

public class Database {
    private String nomeArquivo;
    private JdbcConnectionSource conexao;

    public Database(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public JdbcConnectionSource getConnection() throws SQLException {
        if (conexao == null) {
            conexao = new JdbcConnectionSource("jdbc:sqlite:" + nomeArquivo);
        }
        return conexao;
    }

    public void close() throws SQLException {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
            } catch (Exception e) {
                throw new SQLException("Erro ao fechar o banco de dados.", e);
            }
        }
    }
}
