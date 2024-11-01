package view;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import connection.ConnectionManager;

public class TelaPrincipal {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaPrincipal window = new TelaPrincipal();
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
		try {
			ConnectionManager.getMysqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Projeto para Teste de Banco de Dados");

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mntmCadastros = new MenuItem(menu, SWT.CASCADE);
		mntmCadastros.setText("Cadastros");

		Menu menu_1 = new Menu(mntmCadastros);
		mntmCadastros.setMenu(menu_1);

		MenuItem mntmEmpresas = new MenuItem(menu_1, SWT.NONE);
		mntmEmpresas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TelaDeEmpresas telaDeEmpresas = new TelaDeEmpresas();
				telaDeEmpresas.open();
			}
		});
		mntmEmpresas.setText("Empresas");

		MenuItem mntmFuncionrios = new MenuItem(menu_1, SWT.NONE);
		mntmFuncionrios.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TelaDeFuncionarios telaDeFuncionarios = new TelaDeFuncionarios();
				telaDeFuncionarios.open();
			}
		});
		mntmFuncionrios.setText("Funcionários");

	}
}
