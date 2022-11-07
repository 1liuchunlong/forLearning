import java.sql.*;

public class jdbcConfig {


    public static void main(String[] args) {
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String URL = "jdbc:sqlserver://localhost:1433;databaseName=StudentSystemDao";
        String USERNAME = "sa";
        String PASSWORD = "sa";
        Statement statement=null;
        ResultSet rs=null;
        try {
            Class.forName(DRIVER);
            System.out.println("------加载驱动成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con=null;
        try {
            con= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("--------连接数据库成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        进行查询
        try {

            statement=con.createStatement();
//            返回的是一个ResultSet
            rs=statement.executeQuery("select * from tb_User");
            while(rs.next()){
                System.out.println(rs.getString(1)+"-- "+rs.getString(2));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
