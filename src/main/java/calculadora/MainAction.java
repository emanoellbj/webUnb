package calculadora;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;




public class MainAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String expressao1 = request.getParameter("minhaString");
		MainForm main = (MainForm) form;
		
		
		

		if(expressao1 != null && !expressao1.isEmpty()) {
		String semEspacos1 = expressao1.replaceAll("\\s+", "");
	


		Nodo operacao1 = criarOperacao(semEspacos1);
		


		int resultado1 = operacao1.calcula();
		
		
		
		System.out.println(resultado1);
		main.setMessage( resultado1 + "");
		return mapping.findForward("success");}
		return null;
		
	}





	private static Nodo criarOperacao(String expressao) {
	
		try {
			int valor = Integer.parseInt(expressao);
			return new Valor(valor);
		} catch (NumberFormatException e) {

			int nivelParenteses = 0;
			int indexOperador = -1;

			for (int i = 0; i < expressao.length(); i++) {
				char caractere = expressao.charAt(i);
				if (caractere == '(') {
					nivelParenteses++;
				} else if (caractere == ')') {
					nivelParenteses--;
				} else if (nivelParenteses == 1
						&& (caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/' || caractere == '^')) {
					indexOperador = i;
				}
			}

			if (indexOperador != -1) {
			
				String operador = expressao.substring(indexOperador, indexOperador + 1);
				String operando1 = expressao.substring(1, indexOperador);
				String operando2 = expressao.substring(indexOperador + 1, expressao.length() - 1);

			
				Nodo op1 = criarOperacao(operando1);
				Nodo op2 = criarOperacao(operando2);

			
				switch (operador) {
				case "+":
					return new Soma(op1, op2);
				case "-":
					
					throw new UnsupportedOperationException("Operador '-' não suportado.");
				case "*":
					
					return new Multiplicacao(op1, op2);
				case "/":
					return new Divisao(op1, op2);
				case "^":
					return new Expo(op1,op2);
				default:
					throw new IllegalArgumentException("Operador inválido.");
				}
			} else {
				throw new IllegalArgumentException("Expressão inválida.");
			}
		}
	}
}
