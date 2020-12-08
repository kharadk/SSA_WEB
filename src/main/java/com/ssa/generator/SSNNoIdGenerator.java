package com.ssa.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.ssa.constant.AppConstant;

public class SSNNoIdGenerator implements IdentifierGenerator {

	String suffix = null;
	long ssn;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		try {
			Connection con = session.connection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(AppConstant.SQL_GET_SSN_SEQUENCE);

			if (rs.next()) {
				long ssnNo = rs.getLong(1);
				System.out.println(ssnNo);
				suffix = String.valueOf(ssnNo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ssn = Long.parseLong(AppConstant.PREFIX + suffix);

		return ssn;
	}

}
