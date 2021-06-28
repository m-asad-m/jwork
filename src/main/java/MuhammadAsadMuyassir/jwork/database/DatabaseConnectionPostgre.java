package MuhammadAsadMuyassir.jwork.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class DatabaseConnectionPostgre adalah class yang membuat koneksi dengan database postgre
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
public class DatabaseConnectionPostgre {

    /**
     * Metode yang digunakan untuk membuat koneksi dengan database postgre
     * @return  objek Connection
     */
    public static Connection connection()
    {
        Connection c = null;
        String db_name = "jwork";
        String db_user = "jwork";
        String db_password = "jwork";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ db_name, db_user, db_password);
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
