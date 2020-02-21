package com.douzone.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douzone.emaillist.vo.EmaillistVO;

@Repository
public class EmaillistRepository {

	// SELECT (all)
	public List<EmaillistVO> findAll() {
		List<EmaillistVO> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			conn = getConnection();

			String command = "select * from emaillist order by no asc";
			statement = conn.prepareStatement(command);

			set = statement.executeQuery();
			while (set.next()) {
				Long no = set.getLong(1);
				String firstName = set.getString(2);
				String lastName = set.getString(3);
				String email = set.getString(4);

				EmaillistVO newVo = new EmaillistVO();
				newVo.setNo(no);
				newVo.setFirstName(firstName);
				newVo.setLastName(lastName);
				newVo.setEmail(email);

				result.add(newVo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원정리
			try {
				if (set != null) {
					set.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// INSERT
	public Boolean insert(EmaillistVO vo) {
		Boolean result = false;

		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = getConnection();

			String command = "insert into emaillist values(null, ?, ?, ?)";
			statement = conn.prepareStatement(command);

			statement.setString(1, vo.getFirstName());
			statement.setString(2, vo.getLastName());
			statement.setString(3, vo.getEmail());

			result = (statement.executeUpdate() == 1);

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원정리
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// Connection
	private Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://192.168.1.118:3307/webdb";

			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("SQL 연결 실패:" + e);
		}

		return conn;
	}
}
