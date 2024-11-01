package view;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import dao.DAOUtil;
import dao.EmpresaDAO;
import entity.Empresa;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;

public class TelaDeEmpresas {

	protected Shell shell;
	private Table table;
	private TableItem tableItem;
	private Text textCodigo;
	private Text textNome;
	private Text textEndereco;
	private Text textTelefone;
	private String operacao = "Alterar";
	private Button btnSalvar;
	private Button btnExcluir;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaDeEmpresas window = new TelaDeEmpresas();
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

	private void preencherGridEmpresas(){

		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		empresas = DAOUtil.obterEmpresas();
		table.removeAll();
		
		for (Iterator<Empresa> iterator = empresas.iterator(); iterator.hasNext();) {
			Empresa empresa = iterator.next();
			tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText( new String[] { String.valueOf(empresa.getCodigo()), empresa.getNome(),
					empresa.getEndereco(), empresa.getTelefone()} );			
		}
		
		table.setSelection(0);
		TableItem[] linha = table.getSelection();
		if ( table.getItemCount() != 0 ) {
			textCodigo.setText( linha[0].getText(0) );
			textNome.setText( linha[0].getText(1) );
			textEndereco.setText( linha[0].getText(2) );
			textTelefone.setText( linha[0].getText(3) );
			btnSalvar.setEnabled(true);
			btnExcluir.setEnabled(true);
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
		shell.setSize(604, 393);
		shell.setText("Tela de Empresas");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] linha = table.getSelection();
				textCodigo.setText( linha[0].getText(0) );
				textNome.setText( linha[0].getText(1) );
				textEndereco.setText( linha[0].getText(2) );
				textTelefone.setText( linha[0].getText(3) );
			}
		});
		table.setHeaderForeground(new Color(Display.getCurrent(),255,255,255));
		table.setHeaderBackground(new Color(Display.getCurrent(),0,0,0));
		table.setBounds(0, 10, 578, 162);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCdigo = new TableColumn(table, SWT.NONE);
		tblclmnCdigo.setWidth(72);
		tblclmnCdigo.setText("C\u00F3digo");
		
		TableColumn tblclmnEmpresa = new TableColumn(table, SWT.NONE);
		tblclmnEmpresa.setWidth(155);
		tblclmnEmpresa.setText("Empresa");
		
		TableColumn tblclmnEndereo = new TableColumn(table, SWT.NONE);
		tblclmnEndereo.setWidth(247);
		tblclmnEndereo.setText("Endere\u00E7o");
		
		TableColumn tblclmnTelefone = new TableColumn(table, SWT.NONE);
		tblclmnTelefone.setWidth(100);
		tblclmnTelefone.setText("Telefone");
		
		Label labelCodigo = new Label(shell, SWT.NONE);
		labelCodigo.setText("C\u00F3digo");
		labelCodigo.setBounds(10, 181, 55, 15);
		
		textCodigo = new Text(shell, SWT.BORDER);
		textCodigo.setEditable(false);
		textCodigo.setBounds(98, 178, 76, 21);
		
		Label labelNome = new Label(shell, SWT.NONE);
		labelNome.setText("Nome empresa:");
		labelNome.setBounds(10, 208, 83, 15);
		
		textNome = new Text(shell, SWT.BORDER);
		textNome.setBounds(98, 205, 205, 21);
		
		Label labelEndereco = new Label(shell, SWT.NONE);
		labelEndereco.setText("Endere\u00E7o:");
		labelEndereco.setBounds(10, 232, 83, 15);
		
		textEndereco = new Text(shell, SWT.BORDER);
		textEndereco.setBounds(98, 229, 205, 21);
		
		Label labelTelefone = new Label(shell, SWT.NONE);
		labelTelefone.setText("Telefone:");
		labelTelefone.setBounds(10, 256, 83, 15);
		
		textTelefone = new Text(shell, SWT.BORDER);
		textTelefone.setBounds(98, 253, 205, 21);
		
		btnSalvar = new Button(shell, SWT.NONE);
		btnSalvar.setEnabled(false);
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Empresa empresa = new Empresa(); 
				empresa.setNome( textNome.getText() );
				empresa.setEndereco( textEndereco.getText() );
				empresa.setTelefone( textTelefone.getText() );					
				EmpresaDAO empresaDAO = new EmpresaDAO();
				if ( operacao.equals("Alterar") ) {					
					empresa.setCodigo( Integer.valueOf(textCodigo.getText()) );
					empresaDAO.alterar(empresa);
				} else if ( operacao.equals("Inserir") ) {
					empresaDAO.inserir(empresa);					
				}
				preencherGridEmpresas();
				operacao = "Alterar";
			}
		});
		btnSalvar.setBounds(140, 280, 75, 25);
		btnSalvar.setText("Salvar");
		
		btnExcluir = new Button(shell, SWT.NONE);
		btnExcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Empresa empresa = new Empresa(); 
				empresa.setCodigo( Integer.valueOf(textCodigo.getText()) );
				EmpresaDAO empresaDAO = new EmpresaDAO();
				empresaDAO.excluir(empresa);
				preencherGridEmpresas();
			}
		});
		btnExcluir.setText("Excluir");
		btnExcluir.setBounds(228, 280, 75, 25);
		
		Button btnIncluir = new Button(shell, SWT.NONE);
		btnIncluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textCodigo.setText( "Automático" );
				textNome.setText( "" );
				textEndereco.setText( "" );
				textTelefone.setText( "" );
				operacao = "Inserir";
				btnSalvar.setEnabled(true);
			}
		});
		btnIncluir.setText("Novo");
		btnIncluir.setBounds(49, 280, 75, 25);
		
		preencherGridEmpresas();
	}
}
