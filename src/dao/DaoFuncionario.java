package dao;

import conexoes.ConexaoMySql;
import model.Funcionario;

public class DaoFuncionario {
private ConexaoMySql conexao;
private String password,user;
    public DaoFuncionario(String user,String password) {
        this.password=password;
        this.user=user;
        conexao=new ConexaoMySql(this.user,this.password);
    }
    
    public int salvarDAO(Funcionario funcionario) {
        
        try {
            conexao.conectar();
            String sql = "INSERT INTO funcionario (nome,digital,acesso) VALUES ('" + funcionario.getNome() + "','" + funcionario.getBiometria() + "'," + funcionario.getAcesso() + ");";
            return conexao.insertSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            conexao.fecharConexao();
        }
    }

    public boolean excluirDAO(int codigo) {

        try {
            conexao.conectar();
            String sql = "DELETE FROM funcionario WHERE codigo = " + codigo + ";";
            conexao.executarUpdateDeleteSQL(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao();
        }
    }

    public boolean updateDAO(Funcionario funcionario) {

        try {
            conexao.conectar();
            String sql = "UPDATE funcionario SET nome = '" + funcionario.getNome() + "', acesso ='"+funcionario.getAcesso()+"',digital = '"+funcionario.getBiometria()+"' WHERE codigo =" + funcionario.getCodigo() + ";";
            conexao.executarUpdateDeleteSQL(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao();
        }
    }

    public Funcionario getFuncionario(int codigo) {
        Funcionario fon = new Funcionario();

        try {
            conexao.conectar();

            String sql = "SELECT * FROM funcionario WHERE codigo = " + codigo + ";";
            conexao.executarSQL(sql);

            while (conexao.getResultSet().next()) {
                fon.setCodigo(conexao.getResultSet().getInt("codigo"));
                fon.setNome(conexao.getResultSet().getString("nome"));
                fon.setBiometria(conexao.getResultSet().getString("digital"));
                fon.setAcesso(conexao.getResultSet().getInt("acesso"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return fon;
    }

    public Funcionario[] getAll() {
        Funcionario[] fon = {};

        try {
            conexao.conectar();
            String sql = "SELECT COUNT(*) FROM funcionario;";
            conexao.executarSQL(sql);
            while (conexao.getResultSet().next()) {
                fon = new Funcionario[(conexao.getResultSet().getInt("COUNT(*)"))];
            }
            sql = "SELECT * FROM funcionario;";
            conexao.executarSQL(sql);

            for (int i = 0; conexao.getResultSet().next() == true; i++) {
                fon[i] = new Funcionario();
                fon[i].setCodigo(conexao.getResultSet().getInt("codigo"));
                fon[i].setNome(conexao.getResultSet().getString("nome"));
                fon[i].setBiometria(conexao.getResultSet().getString("digital"));
                fon[i].setAcesso(conexao.getResultSet().getInt("acesso"));

            }
        } catch (Exception e) {
        } finally {
            conexao.fecharConexao();
        }
        return fon;
    }
}
