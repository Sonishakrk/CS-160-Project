import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbconnect {

    public int registercustomer(Sales customer) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO fuelpump" +
            "  (deposit, change, pump_number, number_gallons, sales_id) VALUES " +
            " (?, ?, ?, ?, ?);";

        int result = 0;
        try (Connection connection = JDBC.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setLong(1, customer.getdeposit());
            preparedStatement.setLong(2, customer.getchange());
            preparedStatement.setLong(3, customer.getpump_number());
            preparedStatement.setLong(4, customer.getnumber_gallons());
            preparedStatement.setLong(4, customer.getsales_id());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            JDBC.printSQLException(e);
        }
        return result;
    }
}