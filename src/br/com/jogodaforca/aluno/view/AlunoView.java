package br.com.jogodaforca.aluno.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.jogodaforca.aluno.controle.AlunoControle;
import br.com.jogodaforca.rodada.view.RodadaView;
import br.com.jogodaforca.util.ValidaEntrada;
import br.com.jogodaforca.vo.AlunoVo;

public class AlunoView extends JPanel {

	/**
	* 
	*/
	private static final long serialVersionUID = -8145041165137451498L;

	private JTextField nomeField;
	private JTextField serieField;
	private JTextField idadeField;
	private JTextField ipField;
	private JTextField portaField;
	private JButton botaoComecar;
	private JButton botaoCriar;

	public AlunoView() {

		criarHead();
		criarCampos();
		criarBotoes();
	}

	private void criarHead() {

		// ------------------------- HEAD -----------------------------
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());

		JLabel titulo = new JLabel("Insira seus dados e clique em enviar");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 30));

		panelTitulo.add(titulo);

		add(panelTitulo, BorderLayout.NORTH);

	}

	// -------------------------CAMPOS -----------------------------
	private void criarCampos() {

		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(new FlowLayout());

		JLabel palavraLabel = new JLabel("Nome:");
		nomeField = new JTextField(15);
		panelCadastro.add(palavraLabel);
		panelCadastro.add(nomeField);

		JLabel dicaLabel = new JLabel("Série:");
		serieField = new JTextField(15);
		panelCadastro.add(dicaLabel);
		panelCadastro.add(serieField);

		JLabel pontosLabel = new JLabel("Idade:");
		idadeField = new JTextField(15);
		panelCadastro.add(pontosLabel);
		panelCadastro.add(idadeField);

		JLabel ipLabel = new JLabel("IP:");
		ipField = new JTextField(15);
		panelCadastro.add(ipLabel);
		panelCadastro.add(ipField);

		JLabel portaLabel = new JLabel("Porta:");
		portaField = new JTextField(15);
		panelCadastro.add(portaLabel);
		panelCadastro.add(portaField);

		add(panelCadastro, BorderLayout.CENTER);
	}

	// ------------------------- BOTOES -----------------------------
	private void criarBotoes() {
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());

		botaoComecar = new JButton("Criar server");
		botaoComecar.addActionListener(listener);
		panelBotoes.add(botaoCriar);

		botaoComecar = new JButton("Entrar em server");
		botaoComecar.addActionListener(listener);
		panelBotoes.add(botaoComecar);

		add(panelBotoes, BorderLayout.SOUTH);

	}

	private ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent evento) {

			if (evento.getSource() == botaoComecar) {
				ValidaEntrada validaEntrada;
				boolean verificaCampo = false;
				boolean validaEntradaCampo = false;
				String nome = " ";
				String serie = " ";
				String idade = " ";
				String ip = " ";
				String porta = " ";

				nome = nomeField.getText().trim();
				serie = serieField.getText().trim();
				idade = idadeField.getText().trim();
				ip = ipField.getText().trim();
				porta = portaField.getText().trim();

				validaEntrada = new ValidaEntrada(nome, serie, idade);
				validaEntradaCampo = validaEntrada.verificaEntradaAluno(validaEntrada);
				verificaCampo = validaEntrada.validarCamposAluno(validaEntrada);

				if (verificaCampo != false && validaEntradaCampo != false) {

					AlunoVo alunoVo = new AlunoVo();
					alunoVo.setNome(nome);
					alunoVo.setSerie(Integer.parseInt(serie));
					alunoVo.setIdade(Integer.parseInt(idade));

					new AlunoControle().cadastrarAluno(alunoVo);

					new RodadaView(alunoVo);

					nomeField.setText(" ");
					serieField.setText(" ");
					idadeField.setText(" ");
					ipField.setText(" ");
					portaField.setText(" ");
				}
			}
		}
	};

}
