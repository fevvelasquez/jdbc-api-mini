/**
 * fevvelasquez 2021, coding exercises about Java JDBC API Basis.
 * 
 * Connect from Java to MySQL database, then execute free DQL and DML Statement(s).
 * Uses: JDBC API, MySQL, SQL / Javadoc, Logger, ResourceBundle.
 */
package me.fevvelasquez.jdbc.api.app;

import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import me.fevvelasquez.jdbc.api.statement.StatementExecutor;
import me.fevvelasquez.jdbc.api.statement.StatementResult;

/**
 * {@link StatementExecutor}, examples of use.
 * 
 * @version 0.2.0. Exercise, exploring 'execute' method from java.sql.Statement.
 * @author fevvelasquez@gmail.com
 */
public class Example {
	private static final Logger logger = Logger.getLogger(Example.class.getName());

	/**
	 * Main method.
	 * 
	 * @param args No args required.
	 */
	public static void main(String[] args) {

		try {
			// Get Executor connected to the database.
			ResourceBundle db = ResourceBundle.getBundle(Example.class.getPackageName() + ".db");
			StatementExecutor se = StatementExecutor.getInstance(db.getString("url"), db.getString("username"),
					db.getString("password"));
			// ------------------------------------------------------------------------------------

			// Execute UPDATE example:
			StatementResult update = se.executeStatement(
					"UPDATE products SET name = 'updated at " + LocalTime.now() + "' WHERE product_id = 7");
			logger.info(update.toString());
			update.close();
			// ------------------------------------------------------------------------------------

			// Execute SELECT example:
			StatementResult select = se.executeStatement("SELECT * FROM products WHERE product_id <= 7");
			logger.info(select.toString());
			select.close();
			// ------------------------------------------------------------------------------------

			// close connection resources
			se.close();
			// ------------------------------------------------------------------------------------
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
		logger.info("END.");
	}

}
