package lab7_1;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class bookDB {
    private static String url = "jdbc:mysql://localhost/library?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static String username = "root";
    private static String password = "rd567567tf678yg8";
    private static String driver = "com.mysql.cj.jdbc.Driver";

    private static Connection myConnection = null;


    public static ArrayList<Book> select() {
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance(); /*forName-загрузка драйвера для базы данных*/
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String author = resultSet.getString(2);
                    int year = resultSet.getInt(3);
                    String title = resultSet.getString(4);
                    String genre = resultSet.getString(5);
                    Book book = new Book(id, author, year, title, genre);
                    books.add(book);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return books;
    }


    public static int insert(Book book) {

        try{
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO book (ID, Author, Year_, Title, Genre) Values (?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, book.getID());
                    preparedStatement.setString(2, book.getAuthor());
                    preparedStatement.setInt(3, book.getYear());
                    preparedStatement.setString(4, book.getTitle());
                    preparedStatement.setString(5, book.getGenre());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Book book) {

        try{
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE book SET Author = ?, Year_ = ?, Title = ?, Genre = ? WHERE ID = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, book.getAuthor());
                    preparedStatement.setInt(2, book.getYear());
                    preparedStatement.setString(3, book.getTitle());
                    preparedStatement.setString(4, book.getGenre());
                    preparedStatement.setInt(5, book.getID());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int ID) {

        try{
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM book WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, ID);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }



    public void close(ResultSet rs)
    {
        if(rs != null)
        {
            try
            {
                rs.close();
            }
            catch(Exception e)
            {
                System.out.println("MyDBConnection || close: " + e);
            }
        }
    }

    public Connection getMyConnection()
    {
        return myConnection;
    }

    public void destroy()
    {
        if(myConnection != null)
        {
            try
            {
                myConnection.close();
            }
            catch(Exception e)
            {
                System.out.println("MyDBConnection || destroy: " + e);
            }
        }
    }

}
