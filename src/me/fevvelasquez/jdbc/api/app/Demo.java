/**
 * ----------------------------
 * Java JDBC API basis, coding exercises.
 * Exploring java.sql.DriverManager , java.sql.Connection , java.sql.Statement , java.sql.ResultSet features.
 * ----------------------------
 * 
 * fevvelasquez writes the StatementExecutor own class as a factory of 
 * database connected, ready to use, automated Statement instances. 
 * 
 * So, you can execute any valid SQL statement directly and see the results into a StatementResult instance.
 * 
 * 
 * 
 * Even if MySql is used for the demo, a distinct RDBMS or distinct database can be used.
 */
package me.fevvelasquez.jdbc.api.app;

import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import me.fevvelasquez.jdbc.api.statement.StatementExecutor;
import me.fevvelasquez.jdbc.api.statement.StatementResult;

/**
 * {@link StatementExecutor} Demo, examples of use.
 * 
 * @version 0.2.0. Demo version.
 * @author fevvelasquez@gmail.com
 */
public class Demo {
	private static final Logger logger = Logger.getLogger(Demo.class.getName());

	/**
	 * Main method.
	 * 
	 * @param args No args required.
	 */
	public static void main(String[] args) {

		try {
			// Get Executor connected to the database.
			ResourceBundle db = ResourceBundle.getBundle(Demo.class.getPackageName() + ".db");
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
