/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redebayesiana;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import redebayesiana.view.NodePanel;

/**
 *
 * @author david
 */
public class Main extends javax.swing.JFrame {

    private boolean moved = false;
    private int indexNode = -1;
    private ArrayList drawline = new ArrayList();
    private Component comp1 = null;
    private Component comp2 = null;
    private boolean draw = false;
    private Arvore tree;

    /**
     * Creates new form Main
     */
    public Main() {
        tree = new Arvore();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void addValueToTree(NodePanel newNo) {
        No node = new No();
        node.setData(new Objeto());

        Double pi[][] = node.getData().getPi();
        pi[0][0] = Double.parseDouble(pi00.getText()); // primeira
        // linha/coluna
        pi[1][0] = Double.parseDouble(pi10.getText()); // segunda
        // linha/primeira
        // coluna
        if (StringUtils.isNotBlank(pi01.getText())) {
            pi[0][1] = Double.parseDouble(pi01.getText()); // primeira
        }																	// linha/segunda
        if (StringUtils.isNotBlank(pi11.getText())) // coluna
        {
            pi[1][1] = Double.parseDouble(pi11.getText()); // segunda
        }																	// linha/coluna

        Double[][] lambda = node.getData().getLambda();
        lambda[0][0] = 1.0;
        lambda[1][0] = 1.0;

        Double[][] lambdaOld = node.getData().getLambdaOld();
        lambdaOld[0][0] = 1.0;
        lambdaOld[1][0] = 1.0;

        node.getData().setLabel(nameNode.getText());

        if (this.tree.getRoot() == null) {
            node.getData().setBelief(node.getData().getPi());
            this.tree.setRoot(node);
            newNo.setNode(node);

        } else {
            newNo.setNode(node);
            NodePanel no = (NodePanel) jComboBox1.getSelectedItem();
            no.getNode().addChild(node);

            biliefPaiFilho(node);
        }
        cleanFields();
        JOptionPane.showMessageDialog(null, "N� adicionado!");
    }

    private void preencheComboBoxParents(JComboBox cb) {
        DefaultComboBoxModel<GenericTreeNode<Objeto>> modelo = new DefaultComboBoxModel<GenericTreeNode<Objeto>>();
        modelo = tree.getNodes(tree.getRoot(), modelo);
        cb.setModel((ComboBoxModel) modelo);
    }

    private void cleanFields() {
//		//textFieldNomeNo.setText("");
//		pi00.setText("");
//		pi01.setText("");
//		pi10.setText("");
//		pi11.setText("");
//		//preencheComboBoxParents(comboBoxNoPai);
//		nameNode.setText("");
        //lblNomeNoPai.setText("");
        pi01.setEnabled(true);
        pi11.setEnabled(true);
    }

    public void biliefPaiFilho(No no) {
        No parent = (No) no.getParent();
        parent.getData().getBelief()[0][0] = parent.getData().getBelief()[0][0] / parent.getData().getLambdaOld()[0][0];
        parent.getData().getBelief()[1][0] = parent.getData().getBelief()[1][0] / parent.getData().getLambdaOld()[1][0];

        no.getData().getBelief()[0][0] = no.getData().getPi()[0][0] * parent.getData().getBelief()[0][0]
                + no.getData().getPi()[1][0] * parent.getData().getBelief()[1][0];

        no.getData().getBelief()[1][0] = no.getData().getPi()[0][1] * parent.getData().getBelief()[0][0]
                + no.getData().getPi()[1][1] * parent.getData().getBelief()[1][0];
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        AlterarNo = new javax.swing.JPopupMenu();
        jMenuItemAlterarNo = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        ConfigNewNode = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameNode = new javax.swing.JTextField();
        pi00 = new javax.swing.JTextField();
        pi01 = new javax.swing.JTextField();
        pi11 = new javax.swing.JTextField();
        pi10 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lambda10 = new javax.swing.JTextField();
        lambda00 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        EditNode = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nameNode1 = new javax.swing.JTextField();
        pi1 = new javax.swing.JTextField();
        pi2 = new javax.swing.JTextField();
        pi12 = new javax.swing.JTextField();
        pi13 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lambda11 = new javax.swing.JTextField();
        lambda1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new DrawTreeBayes();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItemAlterarNo.setText("Edit Node");
        jMenuItemAlterarNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAlterarNoActionPerformed(evt);
            }
        });
        AlterarNo.add(jMenuItemAlterarNo);

        jMenuItem5.setText("Delete Node");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        AlterarNo.add(jMenuItem5);

        ConfigNewNode.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ConfigNewNode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ConfigNewNode.setMinimumSize(new java.awt.Dimension(418, 350));
        ConfigNewNode.setPreferredSize(new java.awt.Dimension(418, 350));
        ConfigNewNode.setSize(new java.awt.Dimension(418, 350));
        ConfigNewNode.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel((Object[])jPanel1.getComponents()));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 158, -1));

        jLabel1.setText("Selecione o n� pai:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 20));

        jButton3.setText("Adicionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 266, -1, -1));

        jLabel2.setText("Informe o nome do n�:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jLabel3.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 24)); // NOI18N
        jLabel3.setText("Criando novo n�");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));
        jPanel3.add(nameNode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 158, -1));
        jPanel3.add(pi00, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 40, -1));
        jPanel3.add(pi01, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 40, -1));
        jPanel3.add(pi11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 40, -1));
        jPanel3.add(pi10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 40, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sim");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 132, 40, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("N�o");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 134, 40, 10));

        jLabel6.setText("Presente");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel7.setText("Ausente");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel8.setText("Lambda:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));
        jPanel3.add(lambda10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 40, -1));
        jPanel3.add(lambda00, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 40, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 208, 430, 10));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 420, 10));

        ConfigNewNode.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 310));

        ConfigNewNode.getAccessibleContext().setAccessibleParent(this);

        EditNode.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        EditNode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EditNode.setMinimumSize(new java.awt.Dimension(418, 350));
        EditNode.setPreferredSize(new java.awt.Dimension(418, 350));
        EditNode.setSize(new java.awt.Dimension(418, 350));
        EditNode.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        jLabel10.setText("Informe o nome do n�:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, 20));

        jLabel11.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 24)); // NOI18N
        jLabel11.setText("Alterar n�");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 400, -1));
        jPanel4.add(nameNode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 158, -1));
        jPanel4.add(pi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 40, -1));
        jPanel4.add(pi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 40, -1));
        jPanel4.add(pi12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 40, -1));
        jPanel4.add(pi13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 40, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sim");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 40, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("N�o");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 40, 10));

        jLabel14.setText("Presente");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel15.setText("Ausente");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel16.setText("Lambda:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        lambda11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lambda11ActionPerformed(evt);
            }
        });
        jPanel4.add(lambda11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 40, -1));
        jPanel4.add(lambda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 40, -1));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 430, 10));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 420, 10));

        EditNode.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 310));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("New Node");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print Arvore");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setAutoscrolls(true);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("File");

        jMenu3.setText("New Tree");
        jMenu1.add(jMenu3);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setText("New node");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem2.setText("Edit node");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(390, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(156, 156, 156)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //new NovoNo().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConfigNewNode.setVisible(true);
        ConfigNewNode.setLocationRelativeTo(null);
        if (jPanel1.getComponents().length == 0) {
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel((Object[]) new String[]{"N� Raiz"}));
            pi01.setEnabled(false);
            pi11.setEnabled(false);
        } else {
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel((Object[]) jPanel1.getComponents()));
        }
//        NodePanel newNo = new NodePanel();
//        jPanel1.add(newNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        DrawTreeBayes dw = (DrawTreeBayes) jPanel1;
        ArrayList dl = dw.drawline;
        try {
            for (Object dl1 : dl) {
                DrawLineComponents dlc = (DrawLineComponents) dl1;
                if (dlc.comp1.equals(jPanel1.getComponent(indexNode)) || dlc.comp2.equals(jPanel1.getComponent(indexNode))) {
                    dl.remove(dl1);
                    if (indexNode != -1) {
                        jPanel1.remove(jPanel1.getComponent(indexNode));
                        indexNode = -1;
                    }
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItemAlterarNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAlterarNoActionPerformed
        NodePanel alterarNo = (NodePanel) jPanel1.getComponent(indexNode);
        EditNode.setVisible(true);

        pi1.setText(alterarNo.getPi00().getText());
        pi2.setText(alterarNo.getPi01().getText());
        pi12.setText(alterarNo.getPi10().getText());
        pi13.setText(alterarNo.getPi11().getText());
        lambda1.setText(alterarNo.getLambda00().getText());
        lambda11.setText(alterarNo.getLambda10().getText());
        nameNode1.setText(alterarNo.getNameNode().getText());

    }//GEN-LAST:event_jMenuItemAlterarNoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        NodePanel newNo = new NodePanel();
        newNo.setPi00(pi00.getText());
        newNo.setPi01(pi01.getText());
        newNo.setPi10(pi10.getText());
        newNo.setPi11(pi11.getText());
        newNo.setLambda00(lambda00.getText());
        newNo.setLambda10(lambda10.getText());
        newNo.setNameNode(nameNode.getText());
        addValueToTree(newNo);
        boolean temfilho = false;
        int x = 0;
        int y = 0;
        if (jPanel1.getComponentCount() > 0) {
            DrawTreeBayes dr = (DrawTreeBayes) jPanel1;
            for (Object drawline1 : dr.drawline) {
                DrawLineComponents dl = (DrawLineComponents) drawline1;
                if (dl.getComp1().equals(jComboBox1.getSelectedItem())) {
                    temfilho = true;
                }
            }
            if (temfilho) {
                Component cp = (Component) jComboBox1.getSelectedItem();
                jPanel1.add(newNo, new org.netbeans.lib.awtextra.AbsoluteConstraints((int) (cp.getX() + (cp.getWidth() * 1.5)), cp.getY() + cp.getHeight(), -1, -1));
            } else {
                Component cp = (Component) jComboBox1.getSelectedItem();
                jPanel1.add(newNo, new org.netbeans.lib.awtextra.AbsoluteConstraints((int) (cp.getX() - cp.getWidth() * 1.5), cp.getY() + cp.getHeight(), -1, -1));
            }
        } else {
            jPanel1.add(newNo, new org.netbeans.lib.awtextra.AbsoluteConstraints((jPanel1.getWidth() / 2), 0, -1, -1));
        }

        if (jPanel1.getComponentCount() > 1) {
            DrawTreeBayes dr = (DrawTreeBayes) jPanel1;
            dr.addComponentToDrawLine(new DrawLineComponents((Component) jComboBox1.getSelectedItem(), jPanel1.getComponent(jPanel1.getComponentCount() - 1)));
        }

        ConfigNewNode.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if (evt.getButton() == 3) {
            Point noPoint = new Point(evt.getX(), evt.getY());
            if (jPanel1.getComponentAt(noPoint) != null) {
                AlterarNo.show(jPanel1, evt.getX(), evt.getY());
                indexNode = jPanel1.getComponentZOrder(jPanel1.getComponentAt(noPoint));
            }
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tree.getNodes(tree.getRoot());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        No node = new No();
        node.setData(new Objeto());

        Double pi[][] = node.getData().getPi();
        pi[0][0] = Double.parseDouble(pi1.getText()); // primeira
        // linha/coluna
        pi[1][0] = Double.parseDouble(pi12.getText()); // segunda
        // linha/primeira
        // coluna
        if (StringUtils.isNotBlank(pi2.getText())) {
            pi[0][1] = Double.parseDouble(pi2.getText()); // primeira
        }																	// linha/segunda
        if (StringUtils.isNotBlank(pi13.getText())) // coluna
        {
            pi[1][1] = Double.parseDouble(pi13.getText()); // segunda
        }																	// linha/coluna

        Double[][] lambda = node.getData().getLambda();
        lambda[0][0] = Double.parseDouble(lambda1.getText());
        lambda[1][0] = Double.parseDouble(lambda11.getText());;

//        Double[][] lambdaOld = node.getData().getLambdaOld();
//        lambdaOld[0][0] = 1.0;
//        lambdaOld[1][0] = 1.0;

        node.getData().setLabel(nameNode1.getText());
        
        NodePanel np = (NodePanel)jPanel1.getComponent(indexNode);
        np.setPi00(pi1.getText());
        np.setPi01(pi2.getText());
        np.setPi10(pi12.getText());
        np.setPi11(pi13.getText());
        np.setNameNode(nameNode1.getText());
        np.setLambda00(lambda1.getText());
        np.setLambda10(lambda11.getText());
        
        EditNode.dispose();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void lambda11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lambda11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lambda11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu AlterarNo;
    private javax.swing.JDialog ConfigNewNode;
    private javax.swing.JDialog EditNode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemAlterarNo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField lambda00;
    private javax.swing.JTextField lambda1;
    private javax.swing.JTextField lambda10;
    private javax.swing.JTextField lambda11;
    private javax.swing.JTextField nameNode;
    private javax.swing.JTextField nameNode1;
    private javax.swing.JTextField pi00;
    private javax.swing.JTextField pi01;
    private javax.swing.JTextField pi1;
    private javax.swing.JTextField pi10;
    private javax.swing.JTextField pi11;
    private javax.swing.JTextField pi12;
    private javax.swing.JTextField pi13;
    private javax.swing.JTextField pi2;
    // End of variables declaration//GEN-END:variables
}
