package transactions;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;


@Transactional
public class Account {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    void add(User user){

        String sql ="insert into user values(?,?)";
        int status = jdbcTemplate.update(sql, new Object[]{
            user.getName(),user.getBalance()
        });
        if(status>0)
        {
            System.out.println("Successfully inserted!");
        }
        else
        {
            System.out.println("Failure inserting!");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly=true)
    public User getData(String name)
    {

        String sql = "SELECT * FROM user WHERE name = ?";
        return (User)jdbcTemplate.queryForObject(sql, new Object[]{name}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("name"),rs.getDouble("balance"));
                return user;
            }
        });

    }


    public void delete(String name)
    {
        String sql = "delete from user where name = ?";
        int status =  jdbcTemplate.update(sql,new Object[]{name});
        if(status>0)
        {
            System.out.println("Successfully deleted!");
        }
        else
        {
            System.out.println("Failure deleting!");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(String name , double updatedBalance)
    {
        String sql = "UPDATE user SET balance = ? WHERE name = ?";
        int status = jdbcTemplate.update(sql,new Object[]{updatedBalance,name});
        if(status>0)
        {
            System.out.println("Successfully updated!");
        }
        else
        {
            System.out.println("Failure updating!");
        }
    }
}


