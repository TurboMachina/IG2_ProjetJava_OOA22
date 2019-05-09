package dataAccessPackage;

import exceptionPackage.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JTextField;

public class DBDAO implements DAO {

    public DBDAO() {}

    @Override
    public void closeConnexion() throws SQLException {
        SingletonConnexion.closeConnection();
    }

    public void verifierMatricule(String matricule) throws MatriculeException{
        //Faire la requete et prepare statment etc etc
        throw new MatriculeException();
    }

}
