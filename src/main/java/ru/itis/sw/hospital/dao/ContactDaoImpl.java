package ru.itis.sw.hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.sw.hospital.dao.models.Contact;
import ru.itis.sw.hospital.dao.utils.ParamsMapper;
import ru.itis.sw.hospital.dao.utils.SqlQueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SqlQueryExecutor mSqlQueryExecutor;
    @Autowired
    private ParamsMapper mParamsMapper;

    static final RowMapper<Contact> CONTACT_ROW_MAPPER = new RowMapper<Contact>() {
        @Override
        public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new Contact(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("number"),
                        resultSet.getString("email"), resultSet.getString("address"));
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };
}
