package transactions;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountQ3 {

    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    void addUser(User user)
    {
        String sql = "INSERT INTO user (name,balance)VALUES(?,?)";
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {

            jdbcTemplate.update( sql, user.getName(), user.getBalance());
            transactionManager.commit(status);
        }
        catch (DataAccessException e) {
            System.out.println("Create transcation failed!!");
            transactionManager.rollback(status);
            throw e;
        }

    }

    public User getData(String name)
    {

        String sql = "SELECT * FROM user WHERE name = ?";

        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {

            User user = jdbcTemplate.queryForObject(sql, new Object[]{name}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User(rs.getString("name"),rs.getDouble("balance"));
                    return user;
                }
            });
            transactionManager.commit(status);
            return user;

        }
        catch (DataAccessException e) {
            System.out.println("Get Transaction failed!!");
            transactionManager.rollback(status);
            throw e;
        }


    }


}
