package view;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import dao.DAOUtil;
import dao.FuncionarioDAO;
import entity.Empresa;
import entity.Funcionario;

public class TelaDeFuncionarios {

	protected Shell shell;
	private Table tableEmpresas;
	private TableItem tableItemEmpresa;
	private Text textCodigo;
	private Text textNome;
	private String operacao = "Alterar";
	private Button btnSalvar;
	private Button btnExcluir;
	private Table tableFuncionarios;
	private TableItem tableItemFuncionario;
	private Label labelTitulo;
	private Text textEndereco;
	private Text textSexo;
	private Text textSalario;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaDeFuncionarios window = new TelaDeFuncionarios();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void preencherGridFuncionarios( int codigoEmpresa ){
		
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios = DAOUtil.obterFuncionarios( codigoEmpresa );
		tableFuncionarios.removeAll();

		for (Iterator<Funcionario> iterator = funcionarios.iterator(); iterator.hasNext();) {
			Funcionario funcionario = iterator.next();
			tableItemFuncionario = new TableItem(tableFuncionarios, SWT.NONE);
			tableItemFuncionario.setText( new String[] { String.valueOf(funcionario.getNumRegistro()), funcionario.getNome(),
					funcionario.getEndereco(), String.valueOf(funcionario.getSexo()), String.valueOf(funcionario.getSalarioBase()) } );			
		}

		tableFuncionarios.setSelection(0);
		TableItem[] linha = tableFuncionarios.getSelection();
		if ( tableFuncionarios.getItemCount() != 0 ) {
			textCodigo.setText( linha[0].getText(0));
			textNome.setText(linha[0].getText(1));
			textEndereco.setText(linha[0].getText(2));
			textSexo.setText(linha[0].getText(3));
			textSalario.setText(linha[0].getText(4));
			btnSalvar.setEnabled(true);
			btnExcluir.setEnabled(true);
		} else {			
			textCodigo.setText("");
			textNome.setText("");
			textEndereco.setText("");
			textSexo.setText("");
			textSalario.setText("");
			btnSalvar.setEnabled(false);
			btnExcluir.setEnabled(false);
		}
		
	}
	
	private void preencherGridEmpresas(){

		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		empresas = DAOUtil.obterEmpresas();
		tableEmpresas.removeAll();
		
		for (Iterator<Empresa> iterator = empresas.iterator(); iterator.hasNext();) {
			Empresa empresa = iterator.next();
			tableItemEmpresa = new TableItem(tableEmpresas, SWT.NONE);
			tableItemEmpresa.setText( new String[] { String.valueOf(empresa.getCodigo()), empresa.getNome(),
					empresa.getEndereco(), empresa.getTelefone()} );			
		}
		
		tableEmpresas.setSelection(0);
		if ( tableEmpresas.getItemCount() != 0 ) {
			TableItem[] linhaEmpresa = tableEmpresas.getSelection();
			preencherGridFuncionarios( Integer.valueOf(linhaEmpresa[0].getText(0)) );
		} else {			
			btnSalvar.setEnabled(false);
			btnExcluir.setEnabled(false);
		}
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(718, 578);
		shell.setText("Tela de Funcionários");
		
		tableEmpresas = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableEmpresas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] linhaEmpresa = tableEmpresas.getSelection();
				labelTitulo.setText( "Funcionários da empresa " + linhaEmpresa[0].getText(0) + " - " + linhaEmpresa[0].getText(1) );
				preencherGridFuncionarios( Integer.valueOf(linhaEmpresa[0].getText(0)) );
			}
		});
		tableEmpresas.setHeaderForeground(new Color(Display.getCurrent(),255,255,255));
		tableEmpresas.setHeaderBackground(new Color(Display.getCurrent(),0,0,0));
		tableEmpresas.setBounds(0, 10, 578, 162);
		tableEmpresas.setHeaderVisible(true);
		tableEmpresas.setLinesVisible(true);
		
		TableColumn tblclmnCdigo = new TableColumn(tableEmpresas, SWT.NONE);
		tblclmnCdigo.setWidth(72);
		tblclmnCdigo.setText("Código");
		
		TableColumn tblclmnEmpresa = new TableColumn(tableEmpresas, SWT.NONE);
		tblclmnEmpresa.setWidth(155);
		tblclmnEmpresa.setText("Empresa");
		
		TableColumn tblclmnEndereco = new TableColumn(tableEmpresas, SWT.NONE);
		tblclmnEndereco.setWidth(247);
		tblclmnEndereco.setText("Endereço");
		
		TableColumn tblclmnTelefone = new TableColumn(tableEmpresas, SWT.NONE);
		tblclmnTelefone.setWidth(100);
		tblclmnTelefone.setText("Telefone");
		
		Label labelNumRegistro = new Label(shell, SWT.NONE);
		labelNumRegistro.setText("Número de registro:");
		labelNumRegistro.setBounds(16, 382, 115, 15);
		
		textCodigo = new Text(shell, SWT.BORDER);
		textCodigo.setEditable(false);
		textCodigo.setBounds(147, 379, 76, 21);
		
		Label labelNome = new Label(shell, SWT.NONE);
		labelNome.setText("Nome do Funcionário:");
		labelNome.setBounds(16, 406, 125, 15);
		
		textNome = new Text(shell, SWT.BORDER);
		textNome.setBounds(147, 403, 205, 21);
		
		btnSalvar = new Button(shell, SWT.NONE);
		btnSalvar.setEnabled(false);
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Funcionario funcionario = new Funcionario(); 
				funcionario.setNome( textNome.getText() );
				funcionario.setEndereco( textEndereco.getText() );
				funcionario.setSexo( textSexo.getText().charAt(0) );					
				funcionario.setSalarioBase( Double.valueOf(textSalario.getText()) );
				
				Empresa empresa = new Empresa(); 
				TableItem[] linhaEmpresa = tableEmpresas.getSelection();
				empresa.setCodigo( Integer.valueOf(linhaEmpresa[0].getText(0)) );				
				funcionario.setEmpresa(empresa);					
				
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				if ( operacao.equals("Alterar") ) {					
					funcionario.setNumRegistro( Integer.valueOf(textCodigo.getText()) );
					funcionarioDAO.alterar(funcionario);
				} else if ( operacao.equals("Inserir") ) {
					funcionarioDAO.inserir(funcionario);					
				}
				preencherGridFuncionarios(empresa.getCodigo());
				operacao = "Alterar";
			}
		});
		btnSalvar.setBounds(104, 504, 75, 25);
		btnSalvar.setText("Salvar");
		
		btnExcluir = new Button(shell, SWT.NONE);
		btnExcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] linhaEmpresa = tableEmpresas.getSelection();

				Funcionario funcionario = new Funcionario(); 
				funcionario.setNumRegistro( Integer.valueOf(textCodigo.getText()) );
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				funcionarioDAO.excluir(funcionario);
				
				preencherGridFuncionarios( Integer.valueOf(linhaEmpresa[0].getText(0)) );
			}
		});
		btnExcluir.setText("Excluir");
		btnExcluir.setBounds(192, 504, 75, 25);
		
		Button btnIncluir = new Button(shell, SWT.NONE);
		btnIncluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textCodigo.setText( "Automático" );
				textNome.setText( "" );
				textEndereco.setText( "" );
				textSexo.setText( "" );
				textSalario.setText( "" );
				operacao = "Inserir";
				btnSalvar.setEnabled(true);
			}
		});
		btnIncluir.setText("Novo");
		btnIncluir.setBounds(16, 504, 75, 25);
		
		tableFuncionarios = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableFuncionarios.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] linha = tableFuncionarios.getSelection();
				if ( tableFuncionarios.getItemCount() != 0 ) {
					textCodigo.setText( linha[0].getText(0));
					textNome.setText(linha[0].getText(1));
					textEndereco.setText(linha[0].getText(2));
					textSexo.setText(linha[0].getText(3));
					textSalario.setText(linha[0].getText(4));
				}
			}
		});
		tableFuncionarios.setSelection(0);
		tableFuncionarios.setLinesVisible(true);
		tableFuncionarios.setHeaderVisible(true);
		tableFuncionarios.setHeaderForeground(new Color(Display.getCurrent(),255,255,255));
		tableFuncionarios.setHeaderBackground(new Color(Display.getCurrent(),0,0,0));
		tableFuncionarios.setBounds(0, 200, 683, 162);
		
		TableColumn tblclmnNmeroDeRegistro = new TableColumn(tableFuncionarios, SWT.NONE);
		tblclmnNmeroDeRegistro.setWidth(117);
		tblclmnNmeroDeRegistro.setText("Número de Registro");
		
		TableColumn tblclmnNome = new TableColumn(tableFuncionarios, SWT.NONE);
		tblclmnNome.setWidth(173);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnEnderecoFuncionario = new TableColumn(tableFuncionarios, SWT.NONE);
		tblclmnEnderecoFuncionario.setWidth(208);
		tblclmnEnderecoFuncionario.setText("Endereço");
		
		TableColumn tblclmnSexo = new TableColumn(tableFuncionarios, SWT.NONE);
		tblclmnSexo.setWidth(80);
		tblclmnSexo.setText("Sexo");
		
		TableColumn tblclmnSalrio = new TableColumn(tableFuncionarios, SWT.NONE);
		tblclmnSalrio.setWidth(100);
		tblclmnSalrio.setText("Salário");
		
		labelTitulo = new Label(shell, SWT.NONE);
		labelTitulo.setForeground(new Color(Display.getCurrent(),0,0,255));
		labelTitulo.setFont(new Font(Display.getDefault(), "Segoe UI", 9, SWT.BOLD));
		labelTitulo.setText("Funcionários");
		labelTitulo.setBounds(10, 179, 282, 15);
		
		Label lblEndereo = new Label(shell, SWT.NONE);
		lblEndereo.setText("Endereço:");
		lblEndereo.setBounds(16, 430, 125, 15);
		
		textEndereco = new Text(shell, SWT.BORDER);
		textEndereco.setBounds(147, 427, 205, 21);
		
		Label lblSexo = new Label(shell, SWT.NONE);
		lblSexo.setText("Sexo:");
		lblSexo.setBounds(16, 454, 125, 15);
		
		textSexo = new Text(shell, SWT.BORDER);
		textSexo.setBounds(147, 451, 205, 21);
		
		Label lblSalrio = new Label(shell, SWT.NONE);
		lblSalrio.setText("Salário:");
		lblSalrio.setBounds(16, 478, 125, 15);
		
		textSalario = new Text(shell, SWT.BORDER);
		textSalario.setBounds(147, 475, 205, 21);
		
		preencherGridEmpresas();
	}
}
