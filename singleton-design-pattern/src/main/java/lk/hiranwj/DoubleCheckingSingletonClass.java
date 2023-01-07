package lk.hiranwj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoubleCheckingSingletonClass {

//    private static volatile DoubleCheckingSingletonClass doubleCheckingSingletonClass = new DoubleCheckingSingletonClass();
    private static volatile DoubleCheckingSingletonClass doubleCheckingSingletonClass;
    private static volatile Connection connection;

    public DoubleCheckingSingletonClass() {
        if (doubleCheckingSingletonClass != null) {
            throw new RuntimeException("Please use getSingletonClass");
        }
    }

    public static DoubleCheckingSingletonClass getDoubleCheckingSingletonClass() {
        if (doubleCheckingSingletonClass == null)

            synchronized (DoubleCheckingSingletonClass.class) {
                if (doubleCheckingSingletonClass == null) {

                    doubleCheckingSingletonClass = new DoubleCheckingSingletonClass();
                }
            }

        return doubleCheckingSingletonClass;
    }

    public Connection getConnection() {
        if (connection == null) {
            synchronized (DoubleCheckingSingletonClass.class) {
                if (connection == null) {

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/mydb",
                                "root", "mysql");
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

//                    String url = "jdbc:derby:memory:myDB;create=true";
//                    String url = "jdbc:mysql://localhost:3306/mydb", "root", "mysql";

//                    try {
//                        connection = DriverManager.getConnection(url);
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }

                }
            }
        }

        return connection;
    }

}
