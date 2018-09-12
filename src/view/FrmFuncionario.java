package view;

import controller.CtrlFuncionario;
import java.awt.Image;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Funcionario;
import arquivo.Arquivo;
import java.io.File;
import java.io.IOException;
import newString.TreatStrings;
public class FrmFuncionario extends javax.swing.JFrame {
    //renato eva e adao

    public FrmFuncionario(String user,String password) {
        initComponents();
        ct = new CtrlFuncionario(user, password);
    }
    private CtrlFuncionario ct;
    public void ajustar() {
        jtfFoto.setText(null);
        jtfNome.setText(null);
        jtfNome.requestFocus();

    }

    public void preencher(int codigo) {
        //ct = new CtrlFuncionario();
        Funcionario fon = ct.getFuncionario(codigo);

        jtfCodigo.setText(String.valueOf(fon.getCodigo()));
        jtfNome.setText(fon.getNome());
        jtfFoto.setText(fon.getBiometria());

        Image imagem = java.awt.Toolkit.getDefaultToolkit().getImage(fon.getBiometria());

        jlFoto.setIcon(new javax.swing.ImageIcon(imagem));

    }

    public void preencherAlterar(int codigo) {
        preencher(codigo);

        jbRemover.setVisible(false);
        jbSalvar.setVisible(false);

    }

    public void preencherRemover(int codigo) {
        preencher(codigo);
        jtfNome.setEditable(false);
        jtfFoto.setEditable(false);
        jbSelecionar.setVisible(false);
        jbAlterar.setVisible(false);
        jbSalvar.setVisible(false);

    }

    public void desativaCod() {
        jtfCodigo.setVisible(false);
        jlCodigo.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jlCodigo = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfFoto = new javax.swing.JTextField();
        jbSelecionar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jcbNivel = new javax.swing.JComboBox<>();
        jlFoto = new javax.swing.JLabel();
        jbAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(769, 303));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Funcionário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel2.setText("Nome:");

        jLabel3.setText("Nível de acesso:");

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbRemover.setText("Remover");
        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jlCodigo.setText("Código:");

        jtfCodigo.setEditable(false);

        jtfFoto.setEditable(false);
        jtfFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFotoActionPerformed(evt);
            }
        });

        jbSelecionar.setText("Selecionar");
        jbSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelecionarActionPerformed(evt);
            }
        });

        jLabel6.setText("Digital:");

        jcbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlCodigo)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbSelecionar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCodigo)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jcbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbSelecionar)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbRemover)
                    .addComponent(jbFechar)
                    .addComponent(jbAlterar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelecionarActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter ff = new FileNameExtensionFilter("JPEG, GIF, PNG, PDF", "jpg", "jpeg", "gif", "png", "pdf");
        fc.setFileFilter(ff);
        fc.setDialogTitle("Selecione a digital");
        java.io.File file = null;
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();

            jtfFoto.setText(file.getPath());
        }

        Image imagem = java.awt.Toolkit.getDefaultToolkit().getImage(file.getPath());

        jlFoto.setIcon(new javax.swing.ImageIcon(imagem));
    }//GEN-LAST:event_jbSelecionarActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed

        Funcionario fon = new Funcionario();
        try {
            String extention = TreatStrings.getExtension(jtfFoto.getText());
            fon.setNome(jtfNome.getText());
            fon.setBiometria(System.getProperty("user.dir").replace('\\', '/') + "/src/fingerprints/" + jtfNome.getText() + extention);
            fon.setAcesso(Integer.parseInt((String) jcbNivel.getSelectedItem()));
            ct.salvarCtrl(fon);
            File input = new File(jtfFoto.getText());
            File output = new File(System.getProperty("user.dir").replace('\\', '/') + "/src/fingerprints/" + jtfNome.getText() + extention);
            try {
                Arquivo.copyFile(input, output);
            } catch (IOException ex) {
            }
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            ajustar();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverActionPerformed

        String opc[] = {"Sim", "Não"};
        int x = JOptionPane.showOptionDialog(null, "Deseja remover o Código " + jtfCodigo.getText(),
                "Você tem certeza disso?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
        if (x == 0) {
            ct.deleteCtrl(Integer.parseInt(jtfCodigo.getText()));
            File f = new File(jtfFoto.getText());
            f.delete();
            JOptionPane.showMessageDialog(null, "Removido com sucesso");
        }
        dispose();
    }//GEN-LAST:event_jbRemoverActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        Funcionario fon = new Funcionario();
        //Itálo eva & adão
        try {
            fon.setCodigo(Integer.parseInt(jtfCodigo.getText()));
            fon.setNome(jtfNome.getText());
            fon.setBiometria(jtfFoto.getText());
            fon.setAcesso(Integer.parseInt((String) jcbNivel.getSelectedItem()));
            ct.updateCtrl(fon);
            JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jtfFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFotoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbRemover;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JButton jbSelecionar;
    private javax.swing.JComboBox<String> jcbNivel;
    private javax.swing.JLabel jlCodigo;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfFoto;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}
