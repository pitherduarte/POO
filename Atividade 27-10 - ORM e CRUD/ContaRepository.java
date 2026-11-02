import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;

public class ContaRepository {
    private Dao<ContaBancaria, Integer> dao;

    public ContaRepository(Database banco) throws SQLException {
        dao = DaoManager.createDao(banco.getConnection(), ContaBancaria.class);
        TableUtils.createTableIfNotExists(banco.getConnection(), ContaBancaria.class);
    }

    // CREATE
    public void create(ContaBancaria conta) throws SQLException {
        dao.create(conta);
        // O SQLite gera o ID; usamos esse numero para montar a conta.
        String numero = "0001 / " + String.format("%06d", conta.getId()) + "-0";
        conta.setNumeroConta(numero);
        dao.update(conta);
    }

    // READ
    public ContaBancaria loadFromId(int id) throws SQLException {
        return dao.queryForId(id);
    }

    public List<ContaBancaria> loadAll() throws SQLException {
        return dao.queryForAll();
    }

    // UPDATE
    public void update(ContaBancaria conta) throws SQLException {
        dao.update(conta);
    }

    // DELETE
    public void delete(ContaBancaria conta) throws SQLException {
        dao.delete(conta);
    }
}
