/**
 * 
 */
package com.curso.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.curso.ecommerce.model.api.User;

/**
 * @author raidentrance
 *
 */
@Component
public class UserDao {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;

	public List<User> findAll() {
		return jdbcTemplate.query("select * from user", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				return new User(rs.getInt("USER_ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"));
			}
		});
	}
	
	public  Map<String, Object> getTESTRepository( String entrada) throws Exception  {
		Map<String, Object> respuesta = new HashMap<>();
		
		String sql = "SELECT  "
				+ "'sebastian' AS nombre "
				+ "FROM DUAL ";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);				

		if(rows != null) {
			for (Map<String, Object> row : rows) {
				System.out.println("RESPUESTA DB::"+(String) row.get("nombre"));
				respuesta.put("nombre", (String) row.get("nombre"));
				
			}
		}
		
		return  respuesta;
	}
}
