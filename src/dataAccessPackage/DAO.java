package dataAccessPackage;

import java.sql.SQLException;

public interface DAO {
    void closeConnexion() throws SQLException;
}
