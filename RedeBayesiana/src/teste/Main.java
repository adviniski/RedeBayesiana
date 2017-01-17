package teste;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import redebayesiana.Arvore;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Font fontePadrao = new Font("Arial", Font.PLAIN, 18);
	private Arvore tree = new Arvore();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		init();
		
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 517);
		setResizable(false);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(fontePadrao);
		menuBar.add(mnFile);

		JMenuItem mntmNewTree = new JMenuItem("New tree");
		mntmNewTree.setFont(fontePadrao);
		mnFile.add(mntmNewTree);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(fontePadrao);
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(HIDE_ON_CLOSE);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(fontePadrao);
		menuBar.add(mnEdit);

		JMenuItem mntmNewNode = new JMenuItem("New node");
		mntmNewNode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewNode nn = new NewNode(tree);
				nn.setVisible(true);
			}
		});
		mntmNewNode.setFont(fontePadrao);
		mnEdit.add(mntmNewNode);

		JMenuItem mntmEditNode = new JMenuItem("Edit node");
		mntmEditNode.setFont(fontePadrao);
		
		mnEdit.add(mntmEditNode);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
