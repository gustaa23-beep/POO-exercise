package main;

import java.util.ArrayList;
import javax.swing.JOptionPane;



public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Pessoa> pessoas = new ArrayList<>();  //Criando uma lista de objetos pessoas
		Pessoa p1 = new Pessoa();
		
		/*	String nome = String.valueOf(JOptionPane.showInputDialog("Digite seu nome: "));
		p1.setNome(nome);
		
		String cpf = String.valueOf(JOptionPane.showInputDialog("Digite seu cpf: "));
		p1.setCpf(cpf);
		
		double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite seu salario: "));
		p1.setSalario(salario);
		
		String niver = String.valueOf(JOptionPane.showInputDialog("Digite sua data de nascimento: "));
		p1.setData_nascimento(niver);
		
		
	/*	for (Pessoa p11 : pessoas) {
			System.out.println(p11.getNome());
			System.out.println(p11.getCpf());
			System.out.println(p11.getData_nascimento());
			System.out.println(p11.getSalario());
		}
	*/

			String telefone = String.valueOf(JOptionPane.showInputDialog("(opcional) Digite o telefone: "));
			p1.AddContato(telefone);
		
		
		pessoas.add(p1);
		
		for (Pessoa p11 : pessoas) {
			p11.showTelefone();
		}
	}

}
