package controller;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import arquivo.*;
import java.io.File;
import newString.TreatStrings;
import view.FrmServer;
import model.Funcionario;

public class Executar {

    private byte[] file;
    private FrmServer frmserver;
    private java.net.Socket cliente;
    private java.net.ServerSocket servidor;
    private List<PrintStream> clientes;

    public Executar(FrmServer frmserver) {
        this.frmserver = frmserver;
    }

    public Runnable executar = new Runnable() {
        public void run() {
            clientes = new ArrayList<PrintStream>();
            while (true) {
                PrintStream ps = null;
                try {
                    cliente = servidor.accept();
                    frmserver.setLog("Cliente: " + cliente.getInetAddress().getHostAddress() + " conectou!");
                    ps = new PrintStream(cliente.getOutputStream());
                    clientes.add(ps);
                } catch (IOException ex) {
                    javax.swing.JOptionPane.showMessageDialog(frmserver, "Erro ao conectar cliente!", "ERRO!!!", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
                new Thread(Listening).start();
            }
        }
    };

    private Runnable Listening = new Runnable() {
        public void run() {
            try {

                PrintStream ps = new PrintStream(cliente.getOutputStream());
                java.util.Scanner s = new java.util.Scanner(cliente.getInputStream());
                String nome = s.nextLine();
                System.out.println("Tá ouvindo");
                ps.println("Nome arquivo enviado");
                int fileSize = Integer.parseInt(s.nextLine());
                ps.println("tamanho arquivo enviado");
                file = IOFile.receiveFile(cliente, fileSize);
                Arquivo.emArquivo(file, "client", newString.TreatStrings.getExtension(nome));
                
                CtrlFuncionario ctrl = new CtrlFuncionario(frmserver.getUser(), frmserver.getPassword());
                Funcionario[] fon = ctrl.getAll();
                int resultado;
                File comparar = new File(System.getProperty("user.dir").replace('\\', '/') + "/src/" + "client" + TreatStrings.getExtension(nome));
                ps.println("Ate aqui deu certo");
                for (int i = 0; i < fon.length; i++) {
                    File original = new File(fon[i].getBiometria());
                    resultado = Arquivo.compareImage(original, comparar);
                    if(resultado>=80){
                        ps.println("true");
                        ps.println(fon[i].getNome());
                        ps.println(fon[i].getAcesso());
                    }else{
                        ps.println("true");
                    }
                }
                
                File trash = new File(System.getProperty("user.dir").replace('\\', '/') + "/src/" + "client" + TreatStrings.getExtension(nome));
                if(trash.exists()){
                    trash.delete();
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Executar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    };

    public boolean start(int porta) {
        try {
            servidor = new ServerSocket(porta);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
