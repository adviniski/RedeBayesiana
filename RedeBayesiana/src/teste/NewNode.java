package teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;
import redebayesiana.Arvore;
import redebayesiana.GenericTreeNode;
import redebayesiana.No;
import redebayesiana.Objeto;


public class NewNode extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeNo;
	private JTextField textField00;
	private JTextField textField10;
	private JTextField textField01;
	private JTextField textField11;
	private JLabel labelNomeNo = new JLabel("");
	private JLabel lblNomeNoPai = new JLabel("");
	private Arvore tree;
	private JComboBox comboBoxNoPai = new JComboBox();

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { NewNode frame = new NewNode();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	public NewNode(Arvore tree) {
		this.tree = tree;

		setTitle("Add Node");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 493, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome do nó");
		lblNewLabel.setBounds(12, 10, 79, 22);
		contentPane.add(lblNewLabel);

		textFieldNomeNo = new JTextField();
		textFieldNomeNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				labelNomeNo.setText(textFieldNomeNo.getText());
			}
		});
		textFieldNomeNo.setBounds(103, 10, 360, 22);
		contentPane.add(textFieldNomeNo);
		textFieldNomeNo.setColumns(10);

		JLabel lblNPai = new JLabel("Nó pai");
		lblNPai.setBounds(12, 58, 79, 16);
		contentPane.add(lblNPai);
		comboBoxNoPai.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblNomeNoPai.setText(comboBoxNoPai.getSelectedItem().toString());
			}
		});

		comboBoxNoPai.setBounds(103, 55, 360, 22);
		contentPane.add(comboBoxNoPai);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 101, 451, 151);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Probabilidade (pi)", null, panel, null);
		panel.setLayout(null);

		JLabel lblProbabilidadeDeOcorrer = new JLabel("Presente");
		lblProbabilidadeDeOcorrer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProbabilidadeDeOcorrer.setBounds(55, 60, 69, 16);
		panel.add(lblProbabilidadeDeOcorrer);

		JLabel lblProbabilidadeDeNo = new JLabel("Ausente");
		lblProbabilidadeDeNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProbabilidadeDeNo.setBounds(55, 89, 69, 16);
		panel.add(lblProbabilidadeDeNo);

		textField00 = new JTextField();
		textField00.setBounds(136, 57, 116, 22);
		panel.add(textField00);
		textField00.setColumns(10);

		textField10 = new JTextField();
		textField10.setBounds(136, 86, 116, 22);
		panel.add(textField10);
		textField10.setColumns(10);

		textField01 = new JTextField();
		textField01.setColumns(10);
		textField01.setBounds(264, 57, 116, 22);
		panel.add(textField01);
		if (tree.isEmpty())
			textField01.setEnabled(false);

		textField11 = new JTextField();
		textField11.setColumns(10);
		textField11.setBounds(264, 86, 116, 22);
		panel.add(textField11);
		if (tree.isEmpty())
			textField11.setEnabled(false);

		JLabel lblSim = new JLabel("Sim");
		lblSim.setHorizontalAlignment(SwingConstants.CENTER);
		lblSim.setBounds(136, 38, 116, 16);
		panel.add(lblSim);

		JLabel lblNo = new JLabel("Não");
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setBounds(264, 38, 116, 16);
		panel.add(lblNo);

		labelNomeNo.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeNo.setBounds(55, 13, 379, 16);
		panel.add(labelNomeNo);

		lblNomeNoPai.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeNoPai.setBounds(10, 61, 69, 51);
		panel.add(lblNomeNoPai);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addValueToTree();
			}
		});
		btnSave.setBounds(366, 265, 97, 32);
		contentPane.add(btnSave);
		if (tree.getRoot() != null)
			preencheComboBoxParents(comboBoxNoPai);
	}

	private void addValueToTree() {
		No node = new No();
		node.setData(new Objeto());

		Double pi[][] = node.getData().getPi();
		pi[0][0] = Double.parseDouble(textField00.getText()); // primeira
																// linha/coluna
		pi[1][0] = Double.parseDouble(textField10.getText()); // segunda
																// linha/primeira
																// coluna
		if (StringUtils.isNotBlank(textField01.getText()))
			pi[0][1] = Double.parseDouble(textField01.getText()); // primeira
																	// linha/segunda
		if (StringUtils.isNotBlank(textField11.getText())) // coluna
			pi[1][1] = Double.parseDouble(textField11.getText()); // segunda
																	// linha/coluna

		Double[][] lambda = node.getData().getLambda();
		lambda[0][0] = 1.0;
		lambda[1][0] = 1.0;

		Double[][] lambdaOld = node.getData().getLambdaOld();
		lambdaOld[0][0] = 1.0;
		lambdaOld[1][0] = 1.0;

		node.getData().setLabel(textFieldNomeNo.getText());

		if (this.tree.getRoot() == null) {
			// Quando é nó raiz o belief é igual ao pi
			node.getData().setBelief(node.getData().getPi());
			this.tree.setRoot(node);
		} else {
			((GenericTreeNode<Objeto>) comboBoxNoPai.getSelectedItem()).addChild(node);
			biliefPaiFilho(node);
		}
		cleanFields();
		JOptionPane.showMessageDialog(null, "Nó adicionado!");
	}

	private void preencheComboBoxParents(JComboBox cb) {
		DefaultComboBoxModel<GenericTreeNode<Objeto>> modelo = new DefaultComboBoxModel<GenericTreeNode<Objeto>>();
		modelo = tree.getNodes(tree.getRoot(), modelo);
		cb.setModel((ComboBoxModel) modelo);
	}

	private void cleanFields() {
		textFieldNomeNo.setText("");
		textField00.setText("");
		textField01.setText("");
		textField10.setText("");
		textField11.setText("");
		preencheComboBoxParents(comboBoxNoPai);
		labelNomeNo.setText("");
		lblNomeNoPai.setText("");
		textField01.setEnabled(true);
		textField11.setEnabled(true);
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

	public void propagaValores() {

	}

}
