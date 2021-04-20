package it.objectmethod.esempio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.objectmethod.esempio.dao.IDaoNazioni;

@Component
public class DaoNazioniImpl implements IDaoNazioni {

	@Autowired
	DataSource dataSource;

	@Override
	public List<String> getAllContinenti() {
		List<String> conts = new ArrayList<String>();

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT Continent FROM country");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String cont = rs.getString("Continent");
				conts.add(cont);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conts;
	}

}
