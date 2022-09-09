import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class Expressao {

	private static final Character EOE = new Character('#');
	
	public static double calcula(String expr) throws ExpressaoInvalidaException {
		Pilha opd = new Pilha();
		Pilha opn = new Pilha();
		opd.push(EOE);
		
		String[] expressao = expr.split(" ");
		
		for(String s: expressao) {
			if(s == null || s.length() < 1) continue;
			
			try {
				double d = Double.parseDouble(s);
				opn.push(d);
			} catch (NumberFormatException e) {
				if(!("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s) || "(".equals(s) || ")".equals(s)))
					throw new ExpressaoInvalidaException("Operador inválido");
				
				char op = s.charAt(0);
				
				Character c;
				char operador;
				switch (op) {
					case '+':
					case '-':
						if ((c = (Character)opd.peek()) == null)
							throw new ExpressaoInvalidaException("Expressão inválida");
						
						operador = c.charValue();
						if (operador == '*' || operador == '/' || operador == '+' || operador == '-') {
							opd.pop();
							if (!opera(operador,opn))
								throw new ExpressaoInvalidaException("Expressão inválida");
							
						}
						opd.push(op);
						break;
						
					case '*':
					case '/':
						if ((c = (Character)opd.peek()) == null)
							throw new ExpressaoInvalidaException("Expressão inválida");
						
						operador = c.charValue();
						if (operador == '*' || operador == '/') {
							opd.pop();
							if (!opera(operador,opn))
								throw new ExpressaoInvalidaException("Expressão inválida");
							
						}
						opd.push(op);
						break;
						
					case '(':
						opd.push(op);
						break;
						
					case ')':
						do {
							if ((c = (Character)opd.pop()) == null)
								throw new ExpressaoInvalidaException("Expressão inválida");
							
							operador = c.charValue();
							if (operador != '(') {
								if (!opera(operador,opn))
									throw new ExpressaoInvalidaException("Expressão inválida");
								
							}			
						} while (operador != '(');
						break;
						
					default:
						throw new ExpressaoInvalidaException("Expressão inválida");
				}

			}
		}
		
		Character op;
		do {
			if ((op = (Character)opd.pop()) == null)
				throw new ExpressaoInvalidaException("Expressão inválida");
			
			if (!op.equals(EOE)) {
				if (!opera(op.charValue(), opn))
					throw new ExpressaoInvalidaException("Expressão inválida");
				
			}
		} while (!op.equals(EOE));
		
		if (opn.tamanho() != 1)
			throw new ExpressaoInvalidaException("Expressão inválida");
		
		
		double res = ((Double)opn.pop());
		return res;
	}

	private static boolean opera (char operador, Pilha operando) {
		Double op1 = (Double)operando.pop();
		if (op1 == null) return false;
		Double op2 = (Double)operando.pop();
		if (op2 == null) return false;
		
		double i1 = op1;
		double i2 = op2;
		double res = 0;
		
		switch (operador) {
			case '+':
				res = i2 + i1;
				break;
				
			case '-':
				res = i2 - i1;
				break;
				
			case '*':
				res = i2 * i1;
				break;

			case '/':
				if(i1 == 0.0) return false;
				res = i2 / i1;
				break;
		}
		
		operando.push(res);
		return true;
	}
	
	public static char getRandOperator() {
		Random r = new Random();
		switch (r.nextInt(4)) {
		case 0:
			return '+';
		case 1:
			return '-';
		case 2:
			return '*';
		default:
			return '/';
		}
	}
	
	public static int getRandOperand(int level) {
		return new Random().nextInt((int)Math.pow(10, level)); 
	}
	
	private static String getRandExpr(int level) {
		if(level <= 1)
			return "" + getRandOperand(1) + " " + getRandOperator() + " " + getRandOperand(1);
		
		return "( " + getRandExpr(level-1) + " ) " + getRandOperator() + " " + getRandOperand(level) + " " + getRandOperator() + 
			   " ( " + getRandExpr(level-1) + " ) ";
	}

	private static final String invExpression = "INV";
	private String randExpr = null;
	private String puzzleExpr = null;
	private String result = invExpression;
	
	public void generateExpression(int level) {
		randExpr = getRandExpr(level);
	}
	
	public String getExpression() throws ExpressaoInvalidaException {
		if(randExpr == null)
			throw new ExpressaoInvalidaException("Expressão não gerada (use generateExpression())");
		return randExpr;
	}
	
	public void generatePuzzleExpression(int level) {
		generateExpression(level);
		char op = 0;
		do {
			op = getRandOperator();
		} while (randExpr.indexOf(op) == -1);
		result = getResult();
		puzzleExpr =  randExpr.replace(""+op, "?");
	}
	
	public String getPuzzleExpression() {
		if(puzzleExpr == null)
			throw new ExpressaoInvalidaException("Expressão não gerada (use generatePuzzleExpression())");
		return puzzleExpr + " = " + getResult();
	}
	
	public String getResult() {
		if(randExpr == null)
			throw new ExpressaoInvalidaException("Expressão não gerada (use generateExpression())");
		try {
			DecimalFormat df = new DecimalFormat("#.##");
			return df.format(calcula(randExpr)); 
		}
		catch (ExpressaoInvalidaException e) {
			return invExpression;
		}
	}
	
	public boolean isCorrect(String op) {
		if(puzzleExpr == null)
			throw new ExpressaoInvalidaException("Expressão não gerada (use generatePuzzleExpression())");
		String test = puzzleExpr.replace("?", op);
		DecimalFormat df = new DecimalFormat("#.##");
		String newResult;
		try {
			newResult = df.format(calcula(test));
		}
		catch (ExpressaoInvalidaException e) {
			newResult = invExpression;
		}
		return result.equals(newResult);
	}
	
	
	
}

class Pilha {
	
	@SuppressWarnings("rawtypes")
	private Vector v;

	@SuppressWarnings("rawtypes")
	public Pilha() {
		v = new Vector();
	}
	
	public boolean vazia() {
		return v.isEmpty();
	}
	
	public void esvazia() {
		v.clear();
	}
	
	@SuppressWarnings("unchecked")
	public void push (Object o) {
		v.add(o);
	}
	
	public Object pop() {
		if (v.isEmpty()) return null;
		return v.remove(v.size()-1);
	}
	
	public Object peek() {
		if (v.isEmpty()) return null;
		return v.lastElement();
	}
	
	public int tamanho() {
		return v.size();
	}

	@SuppressWarnings("rawtypes")
	public String toString() {
		StringBuffer s = new StringBuffer(v.size()*4);
		s.append("[ ");
		for (Iterator iter = v.iterator(); iter.hasNext();) {
			Object element = iter.next();
			s.append(element + " ");
		}
		s.append("]");
		return s.toString();
	}

}

class ExpressaoInvalidaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExpressaoInvalidaException(String msg) {
		super(msg);
	}
}
