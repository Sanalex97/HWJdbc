package netology.hwjdbctask1.repository;

import netology.hwjdbctask1.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ReadDB {
    private static String script;

    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReadDB(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        ReadDB.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getProductName(String name) {
        script = read("selectProductName.sql");

        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        return namedParameterJdbcTemplate.query(
                script,
                params,
                (rs, rowNum) -> rs.getString("productname"));
    }
}
