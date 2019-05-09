package dataAccessPackage;

import java.sql.SQLException;

public interface DAO {
    public void closeConnexion() throws SQLException;
}
