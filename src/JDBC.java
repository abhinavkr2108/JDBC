import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Load the driver
        Class.forName("org.postgresql.Driver");

        int sid=5;
        String name="Sahil";
        int marks=70;


        String url="jdbc:postgresql://localhost:5432/student";
        String user="postgres";
        String password="postgres";
        String insertQuery = "insert into student values (?,?,?)";
        String updateQuery = "update student set name='Rahul' where sid=3";
        String query = "select * from student";

        //2. Create Connection and statement
        Connection connection = DriverManager.getConnection(url, user,password);
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setInt(1,sid);
        preparedStatement.setString(2,name);
        preparedStatement.setInt(3,marks);
        preparedStatement.execute();

        // 3. Execute Statement (insert/update data)
//        statement.execute(updateQuery);

        // 3. Execute Statement (fetch data)
        ResultSet rs = statement.executeQuery(query);

        System.out.println("StudentID : StudentName : StudentMarks");

        while (rs.next()){
            System.out.print(rs.getInt(1)+ " : ");
            System.out.print(rs.getString(2 )+ " : ");
            System.out.print(rs.getInt(3));
            System.out.println();
        }

        connection.close();



    }
}
