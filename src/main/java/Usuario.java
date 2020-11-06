import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String senha;

    ConnectionFactory conn = new ConnectionFactory();

    public Usuario( String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, int idade, String cpf, String email, String senha){
        this(email, senha);
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void cadastrarUsuario() throws SQLException {
        String sql = "INSERT into Usuario(nome, idade, cpf, email, senha) values (?, ?, ?, ?, ?)";
        Connection c = null;
        try{
            c = conn.conectar();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setString(3, cpf);
            ps.setString(4, email);
            ps. setString(5, senha);

            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                c.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void Logar(){
        String sql = "select * from Usuario where email = ? and senha = ?";
        try(Connection c = new ConnectionFactory().conectar()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, this.email);
            ps.setString(2, this.senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String nome = rs.getString("nome");
                System.out.println("Deu certo");
                System.out.println("Nome do usuário: " + nome);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
