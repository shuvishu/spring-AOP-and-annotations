package transactions;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;




    @Transactional
    public class AccountService {

        private JdbcTemplate jdbcTemplate;

        public JdbcTemplate getJdbcTemplate() {
            return jdbcTemplate;
        }

        public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @Transactional(propagation= Propagation.REQUIRED,rollbackFor = SQLException.class)
        public void updateTable(String senderName,String receiverName,double amount)
        {
            String sql = "INSERT INTO account (sender,receiver,transfer)VALUES(?,?,?)";
            int status =   jdbcTemplate.update(sql, new Object[]{
                    senderName, receiverName,amount
            });
        }
}

