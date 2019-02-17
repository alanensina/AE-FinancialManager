package controller;

import javax.swing.JOptionPane;

public class RegisterUserController {

	public RegisterUserController() {
	}

	public void register() {
		/*
		- Criar uma camada service que faz toda a manipulação dos dados
		- Os controllers serão responsáveis apenas para fazer a comunicação entre as camadas
		- A view pode ter implementação dentro dos ActionListeners, porém apenas para pegar os dados da tela, 
			passar para o controller e ele enviar pro service manipular esses dados.
		
		Caminho dos dados:
		View -> Controller -> Service -> Controller -> DAO
		*/
	}

	public boolean validateName(String name) {
		if (name.length() < 12) {
			return name.matches("[A-Z][a-z]{1,}");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid name length, maximum 12 character");
			return false;
		}
	}
}
