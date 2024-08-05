package DataAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* AR-001
*  Author: Andrés Alvarado Matamoros
 * Base class for managing database connections and resources.
 * This class provides methods for closing SQL resources such as ResultSet,
 * PreparedStatement, CallableStatement, and Connection objects.
 */
public class BaseConnectionDA {
    protected PreparedStatement preparedStatements;
    protected ResultSet resultSets;
    protected CallableStatement callableStatements;
    protected ConnectionDA conectionDA = new ConnectionDA();
    protected Connection connections;
    /**
     * AR-001
     * Author: Andrés Alvarado Matamoros
     * Closes all SQL resources associated with this instance.
     * This method attempts to close ResultSet, PreparedStatement,
     * CallableStatement, and Connection objects. It suppresses SQLExceptions
     * that may occur during the closing process.
     */
    public void closeResources() {
        try {
            if (resultSets != null) resultSets.close();
            if (preparedStatements != null) preparedStatements.close();
            if (callableStatements != null) callableStatements.close();
            if (connections != null) connections.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
