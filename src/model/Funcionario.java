package model;

public class Funcionario {

    private int codigo, acesso;
    private String nome, biometria;

    public Funcionario() {
    }

    public Funcionario(int codigo, int acesso, String nome, String biometria) {
        this.codigo = codigo;
        this.acesso = acesso;
        this.nome = nome;
        this.biometria = biometria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiometria() {
        return biometria;
    }

    public void setBiometria(String biometria) {
        this.biometria = biometria;
    }

}
