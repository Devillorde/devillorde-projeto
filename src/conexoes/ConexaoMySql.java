package conexoes;//pacote responsavel pela conexão.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ConexaoMySql {

    private boolean status = false; //variavel de controle     
    private String mensagem = ""; //variavel que vai informar o
    private Connection con = null; //varialve de conexão
    private Statement statement; //variavel responsavel por enviar informaçoes para o banco de dados
    private ResultSet resultSet; // variavel responsavel por receber informaçoes de banco de dados

    private String servidor = "localhost"; // localizaçao do servidor
    private String nomeDoBanco = "ministerio";
    private String usuario = "";
    private String senha = "";//senha

    public ConexaoMySql(String usuario,String senha) {
        // contrutor padrao da classe
        setSenha(senha);
        setUsuario(usuario);
    }

    public ConexaoMySql(String servidor, String nomeDoBanco, String usuario, String senha) {
        this.servidor = servidor;
        this.nomeDoBanco = nomeDoBanco;
        this.usuario = usuario;
        this.senha = senha;
        // contrustor sobrecarregado da classe
    }

    public Connection conectar() {
        try {
            //driver do MySql
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //local do banco ,nome do banco , usuario e senha
            String url = "jdbc:mysql://" + servidor + "/" + nomeDoBanco;
            this.setCon((Connection) DriverManager.getConnection(url, usuario, senha));
            this.status = true;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        return this.getCon();

    }

    public boolean fecharConexao() {
        try {
            if ((this.getResultSet() != null) && (this.statement != null)) {
                this.getResultSet().close();
                this.statement.close();
            }
            this.getCon().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    public boolean executarSQL(String pSQL) {
        try {
            //creatStatement de con para criar statement
            this.setStatement(getCon().createStatement());

            //definido o statement , executa a query(consulta) no banco
            this.setResultSet(getStatement().executeQuery(pSQL));

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }//executa att ou exclusao

    public boolean executarUpdateDeleteSQL(String pSQL) {
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());
            //Definido o Statement , executamos a query no BD
            getStatement().executeUpdate(pSQL);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //Executa uma inclusao no BD
    public int insertSQL(String pSQL) {
        int status = 0;

        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());
            //definido o Statement, executamos a query no BD
            this.getStatement().executeUpdate(pSQL);
            //consulta o ultimo id inserido
            this.setResultSet(this.getStatement().executeQuery("SELECT last_insert_id();"));
            //Recupera o ultimo codigo auto incremento inserido na tabela
            while (this.resultSet.next()) {
                status = this.resultSet.getInt(1);
            }

            // retorna o ultimo codigo auto incremento inserido na tabela
            return status;

        } catch (SQLException e) {
            e.printStackTrace();
            return status;
        }

    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Connection getCon() {
        return con;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public String getServidor() {
        return servidor;
    }

    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

}
