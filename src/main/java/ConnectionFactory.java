import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "kabral2000";
    private String host = "localhost";
    private String porta = "3306";
    private String banco = "db_recomendacoes";

    public Connection conectar(){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + banco, usuario, senha);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
