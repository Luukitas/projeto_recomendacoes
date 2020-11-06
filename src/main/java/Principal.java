import javax.swing.*;

public class Principal {

    public static void main(String[] args) {
        // Pergunta o nome
        //String nome = JOptionPane.showInputDialog("Digite o nome");
        // Idade
        //int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
        // CPF
        //String cpf = JOptionPane.showInputDialog("Digite o cpf");
        // E-mail
        String email = JOptionPane.showInputDialog("Digite o email");
        // Senha
        String senha = JOptionPane.showInputDialog("Digite o senha");
        // Instanciando a Classe
        Usuario lucas = new Usuario(email, senha);
        //Fazendo a conexão
        try {
            lucas.Logar();
        }catch (Exception e){
            System.out.println("Deu ruim");
        }
    }

}
