package controller;

import dao.DaoFuncionario;
import model.Funcionario;

public class CtrlFuncionario {

    private String password,user;
    public CtrlFuncionario(String user,String password) {
        this.password=password;
        this.user=user;
    }
    
    public int salvarCtrl(Funcionario funcionario) {
        return new DaoFuncionario(user,password).salvarDAO(funcionario);
    }

    public Funcionario getFuncionario(int codigo) {
        return new DaoFuncionario(user,password).getFuncionario(codigo);
    }

    public Funcionario[] getAll() {
        return new DaoFuncionario(user,password).getAll();
    }

    public boolean updateCtrl(Funcionario funcionario) {
        return new DaoFuncionario(user,password).updateDAO(funcionario);
    }

    public boolean deleteCtrl(int codigo) {
        return new DaoFuncionario(user,password).excluirDAO(codigo);
    }
}
