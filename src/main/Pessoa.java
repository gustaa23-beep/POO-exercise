package main;

import java.util.ArrayList;

public class Pessoa extends Telefone{
	String nome;
	String cpf;
	double salario;
	String data_nascimento;
	ArrayList<Telefone> contato = new ArrayList<>();

	public Pessoa() {};
	
	public Pessoa(String nome, String cpf, double salario, String data_nascimento, ArrayList<Telefone> contato) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.data_nascimento = data_nascimento;
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getData_nascimento() {
		return data_nascimento;
	}
	
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public void AddContato(String telefone) {  			// METODO PARA ADICIONAR CONTATOS TRANSFORMANDO UMA STRING EM TELEFONE
		Telefone tel = new Telefone(telefone);
		contato.add(tel);
	}
	
	public void showTelefone() {		
		for(Telefone t : contato) {
			String tel = String.valueOf(t.getTelefone());
			System.out.println(tel);
		}
	}
	
}
