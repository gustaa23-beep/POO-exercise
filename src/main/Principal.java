package main;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Principal {
	
	public static String formatSeq(int casa, int seq){
        String sequencia = "";
        switch (casa){
        case 3:
            sequencia  = String.format("%03d", seq);
            break;
        case 4:
            sequencia  = String.format("%04d", seq);
            break;
        case 5:
            sequencia  = String.format("%05d", seq);
            break;
        case 6:
            sequencia  = String.format("%06d", seq);
            break;
        }
        return sequencia; 
	}

	public static int menu() {
		Scanner sc = new Scanner(System.in);
		String option = JOptionPane.showInputDialog("Digite uma opção: \n"
			+ "1- Inserir \n"
			+ "2- mostrar valores\n"
			+ "0- Sair \n");
		int op = Integer.parseInt(option);
		return op;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			NumberFormat dindin = NumberFormat.getCurrencyInstance();
			Locale localeBR = new Locale( "pt", "BR" ); 
			Scanner sc = new Scanner(System.in);
			String nome,cpf,niver,telefone;
			double salario;
			int op=menu(),seq,casa;
			ArrayList<Pessoa> pessoas = new ArrayList<>();  //Criando uma lista de objetos pessoas
			
			
			//--------------- SEQUENCIA ---------------------------------------------//
					String sequencia = JOptionPane.showInputDialog("O número inicial da sequência (1 a 105):");
					seq = Integer.parseInt(sequencia);
					
					if(seq < 1 || seq > 105) {
						sequencia = JOptionPane.showInputDialog("Digite novamente o número da sequência (1 a 105):");
						seq = Integer.parseInt(sequencia);
					}
				 	
					String ca = JOptionPane.showInputDialog("Digite o nº de casas (3 a 6):");
					casa = Integer.parseInt(ca);
					if(casa < 3 || casa > 6) {
						ca = JOptionPane.showInputDialog("Digite novamente o nº de casas (3 a 6):");
						casa = Integer.parseInt(ca);
					}
			
			while(op!=0) {
				switch(op) {
					case 1:	
						Pessoa p = new Pessoa();
						int i=0;
						
					
						//--------------- CADASTRO ----------------------------------------------//
						nome = JOptionPane.showInputDialog("Digite o nome:");
						p.setNome(nome);
					
						cpf = JOptionPane.showInputDialog("Digite o cpf:");
						p.setCpf(cpf);
					
						niver = JOptionPane.showInputDialog("Digite a data de nascimento:");
						p.setData_nascimento(niver);
					
						String s;
						s  = JOptionPane.showInputDialog("Digite o salário: ");
						salario = Double.parseDouble(s);
						p.setSalario(salario);
					
						String j0;
						j0 = JOptionPane.showInputDialog("Quantidade de telefones que possui:");
						int j = Integer.parseInt(j0);
					
						if(j < 1) {
							telefone = "null";
							p.AddContato(telefone);
						}
						
						while(i != j) {
						
							if(j > 1) {
							telefone = JOptionPane.showInputDialog("Digite o "+ (i+1) +"º telefone:");
							p.AddContato(telefone);
							i++;
							} 
							if(j == 1){
							telefone = JOptionPane.showInputDialog("Digite o telefone:");
							p.AddContato(telefone);
							i++;
							}
						
						}
					
						pessoas.add(p);
						System.out.println("\n");
						break;
						
				case 2:		
					//-------------------------- IMPRIMINDO DADOS ----------------------------------------------------------//
						System.out.println("SEQ\t"+ "NOME\t\t\t" + "CPF\t\t\t\t" + "DT.NASC.\t\t" + "SALÁRIO\t");
						System.out.println("________________________________________________________________________________________________________________________________________________\n");
					
						int tSeq = 0;
						for(int k=0; k < pessoas.size();k++) {
							tSeq = seq + k;
							System.out.print(formatSeq(casa, tSeq));
							System.out.print("\t" + pessoas.get(k).getNome().toUpperCase() + "\t\t");
							if(pessoas.get(k).v.validarCPF(pessoas.get(k).getCpf()) == true) {
								System.out.print(pessoas.get(k).v.imprimiCPF(pessoas.get(k).getCpf()) + "\t\t\t\t");
							}
							else {
								System.out.print(pessoas.get(k).v.imprimiCPF(pessoas.get(k).getCpf()) + "*" + "\t\t\t\t");
							}
						
							System.out.print(pessoas.get(k).v.formatData(pessoas.get(k).getData_nascimento()) + "\t\t");
							System.out.println(dindin.format(pessoas.get(k).getSalario()) + "\t");
						
							System.out.print("Telefones: ");
							pessoas.get(k).showTelefone();
							System.out.println("\n");
						}
						
						break;
						
					default:
						JOptionPane.showMessageDialog(null,"Opção inválida!!!","Atenção", JOptionPane.WARNING_MESSAGE);
						break;
				}
				op = menu();
			}	
	}

}
