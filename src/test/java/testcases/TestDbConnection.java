package testcases;

import java.sql.SQLException;

import utilities.DbManager;

public class TestDbConnection {

	public static void main(String[] args) throws SQLException {
		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id=2"));
	}

}
