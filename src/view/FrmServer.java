package view;

import com.seaglasslookandfeel.SeaGlassLookAndFeel;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import controller.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

public class FrmServer extends javax.swing.JFrame {

    public FrmServer() {
        initComponents();
        setIcon();
    }

    public void preencher(Funcionario[] f) {
        DefaultTableModel modelo = new DefaultTableModel();

        jtTodos.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Nível de acesso");
        modelo.addColumn("Biometria");

        jtTodos.getColumnModel().getColumn(0);
        jtTodos.getColumnModel().getColumn(1);
        jtTodos.getColumnModel().getColumn(2);
        jtTodos.getColumnModel().getColumn(3);

        for (int i = 0; i < f.length; i++) {

            modelo.addRow(new Object[]{f[i].getCodigo(), f[i].getNome(), f[i].getAcesso(), f[i].getBiometria()});

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guiaServidor = new javax.swing.JTabbedPane();
        pServer = new javax.swing.JPanel();
        lblLog = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTodos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbIncluir = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLog.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblLog.setText("Log");

        start.setText("Iniciar");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        log.setEditable(false);
        log.setColumns(20);
        log.setRows(5);
        jScrollPane2.setViewportView(log);

        javax.swing.GroupLayout pServerLayout = new javax.swing.GroupLayout(pServer);
        pServer.setLayout(pServerLayout);
        pServerLayout.setHorizontalGroup(
            pServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pServerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pServerLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(pServerLayout.createSequentialGroup()
                        .addGroup(pServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLog, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(458, 470, Short.MAX_VALUE))))
        );
        pServerLayout.setVerticalGroup(
            pServerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pServerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblLog)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        guiaServidor.addTab("Servidor", pServer);

        jtTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jtTodos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jbIncluir.setText("Incluir");
        jbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIncluirActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbRemover.setText("Remover");
        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        jbAtualizar.setText("Atualizar");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbAtualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbIncluir)
                .addGap(18, 18, 18)
                .addComponent(jbEditar)
                .addGap(18, 18, 18)
                .addComponent(jbRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAtualizar))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        guiaServidor.addTab("Banco de dados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(guiaServidor)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(guiaServidor)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed

        ex = new Executar(this);
        if (ex.start(porta) == true) {
            log.setText("Porta " + porta + " aberta!");
        } else {
            log.setText("Erro ao abrir porta");
        }
        thread = new Thread(ex.executar);
        thread.start();
    }//GEN-LAST:event_startActionPerformed

    private void jbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIncluirActionPerformed
        FrmFuncionario fr = new FrmFuncionario(user,password);
        fr.desativaCod();
        fr.setVisible(true);
    }//GEN-LAST:event_jbIncluirActionPerformed

    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverActionPerformed
        JOptionPane.showMessageDialog(null, "Selecione um funcionário para remover");
        jtTodos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (jtTodos.getSelectedRow() > -1) {

                    FrmFuncionario ff = new FrmFuncionario(user,password);
                    ff.preencherRemover((int) jtTodos.getValueAt(jtTodos.getSelectedRow(), 0));
                    ff.setVisible(true);
                }
            }
        });
    }//GEN-LAST:event_jbRemoverActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed

        JOptionPane.showMessageDialog(null, "Pressione um registro para alterá-lo");
        jtTodos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (jtTodos.getSelectedRow() > -1) {
                    String opc[] = {"Sim", "Não"};
                    int x = JOptionPane.showOptionDialog(null, "Deseja editar o Código " + jtTodos.getValueAt(jtTodos.getSelectedRow(), 0),
                            "Você tem certeza disso?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
                    if (x == 0) {
                        FrmFuncionario ff = new FrmFuncionario(user,password);
                        ff.preencherAlterar((int) jtTodos.getValueAt(jtTodos.getSelectedRow(), 0));
                        ff.setVisible(true);
                    }
                }
            }
        });
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed

        preencher(ct.getAll());
    }//GEN-LAST:event_jbAtualizarActionPerformed

    public static void main(String args[]) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmServer fr = new FrmServer();
                try {
                    fr.setSQLLogin();
                    fr.ct = new CtrlFuncionario(fr.user, fr.password);
                    fr.preencher(fr.ct.getAll());
                    fr.setVisible(true);
                } catch (NullPointerException npe) {
                    System.exit(0);
                }
            }
        });
    }

    private void setSQLLogin() {
        JLabel lblMessage = new JLabel("Digite o usuário e senha do BD!");
        JTextField txtFieldUser = new JTextField("root");
        JPasswordField txtFieldPassword = new JPasswordField();
        Object[] texts = {lblMessage, txtFieldUser, txtFieldPassword};
        JOptionPane.showMessageDialog(null, texts, "Aviso!", JOptionPane.INFORMATION_MESSAGE);
        user = txtFieldUser.getText();
        password = txtFieldPassword.getText();
    }

    public void setLog(String msg) {
        log.setText(log.getText() + "\n" + msg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane guiaServidor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JButton jbRemover;
    private javax.swing.JTable jtTodos;
    private javax.swing.JLabel lblLog;
    private javax.swing.JTextArea log;
    private javax.swing.JPanel pServer;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
    private final int porta = 34197;
    private Executar ex;
    private Thread thread;
    private CtrlFuncionario ct;
    private String user, password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ServerIcon.png")));
    }
}
