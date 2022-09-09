package PrjPraticaUDP;

import java.util.HashMap;
import java.util.regex.Pattern;
import org.omg.CORBA.DynAnyPackage.InvalidValue;
import exceptions.InsertException;
import exceptions.SearchException;

/**
 * DSD - Desenvolvimento de Sistemas Distribuídos
 * Cap 6
 * Data: 24/11/2013
 * @author João Paulo Aramuni
 *
 */
public class NameTable {

	private HashMap<String, String> _hosts = null;

	public NameTable() {
		super();
		_hosts = new HashMap<String, String>();
	}

	public String List() {
		StringBuffer result = new StringBuffer();
		for (String ipPorta : _hosts.values()) {
			result.append(getNormalizeHostName(ipPorta)).append("\n");
		}
		return result.toString();
	}

	public String SearchName(String logicName) throws SearchException {

		String ipPorta = "";
		if (_hosts.containsKey(logicName)) {
			ipPorta = _hosts.get(logicName).toString();
			return getNormalizeHostName(ipPorta);
		}
		throw new SearchException(logicName);

	}

	public void InsertName(String message) throws Exception {
		String[] words = message.split(" ");
		String logicName = words[1];
		String IpPort = words[2] + ":" + words[3];
		if (_hosts.containsKey(logicName))
			throw new InsertException(logicName);

		Double port = Double.valueOf(words[3]);
		if (port > 65635)
			throw new InvalidValue(String.format("Valor inválido para porta. ",
					port));

		// Insere o nome e porta na hash
		_hosts.put(logicName, IpPort);
		Utils.WriteTrace(String.format(" Nome \"%s\" inserido com sucesso.",
				logicName));

	}

	public TypeMessage Validate(String message) throws Exception {

		String padraoUtilizacao = " \n\tMensagens válidas: \n"
				+ " - insert <nome lógico> <hostname> <port>: insere as informações sobre o <nome lógico> informado nas tabelas \n"
				+ "\t\t do servidor. Retorna \"1\" se for bem sucedido, \"0\" caso contrário.\n"
				+ " - search <nome lógico>: pesquisa as informações sobre o <nome lógico> solicitado nas tabelas do servidor.\n"
				+ "\t\t Devolve as informações no seguinte formato: \"<port> <hostname\" (ou \"-1\" se a busca falhar).";
		StringBuilder errors = new StringBuilder();
		java.util.regex.Pattern patern = Pattern
				.compile("((search [\\w]+)|(insert \\w+ [A-Za-z0-9_\\.//:/-]+ \\d+)|list)");
		CharSequence cs = message.subSequence(0, message.length());
		if (!patern.matcher(cs).matches())
			errors.append(" Mensagem mal formatada. Tente novamente. ").append(
					padraoUtilizacao);

		if (errors.length() > 0)
			throw new Exception(errors.toString());

		if (message.indexOf("insert ") != -1)
			return TypeMessage.Insert;
		else if (message.indexOf("search ") != -1)
			return TypeMessage.Search;
		else
			return TypeMessage.List;
	}

	private String getNormalizeHostName(String ipPorta) {
		String porta = ipPorta.substring(0, ipPorta.indexOf(':'));
		String hostname = ipPorta.substring(ipPorta.indexOf(':') + 1);
		return porta + " " + hostname;
	}
}
