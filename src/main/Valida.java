package main;

public class Valida {
	public boolean validarCPF(String cpf) {

    
        char dig10, dig11;
        int soma,num, peso;
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || 
            cpf.equals("33333333333") ||
            cpf.equals("44444444444") || 
            cpf.equals("55555555555") ||
            cpf.equals("66666666666") || 
            cpf.equals("99999999999") ||
            (cpf.length() != 11))
                return(false);
        
        // Calculo do Digito Verificador 1
            soma = 0;
            peso = 10;
            for (int i=0; i < 9; i++) {
            num = (int)(cpf.charAt(i) - 48);
            soma = soma + (num * peso);
            peso = peso - 1;
            }

            int car = 11 - (soma % 11);
            if ((car == 10) || (car == 11))
                dig10 = '0';
            else dig10 = (char)(car + 48); // converte no respectivo caractere numerico

        // Calculo do Digito Verificador 2
            soma = 0;
            peso = 11;
            for(int i=0; i < 10; i++) {
            num = (int)(cpf.charAt(i) - 48); 
            soma = soma + (num * peso);
            peso = peso - 1;
            }

            car = 11 - (soma % 11);
            if ((car == 10) || (car == 11))
                 dig11 = '0';
            else dig11 = (char)(car + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                 return(true);
            else return(false);

	}
	
	public String imprimiCPF(String cpf) {
		 return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
		            cpf.substring(6, 9) + "-" + cpf.substring(9, 11));

	}
	
	public String formatData(String data) {
		return(data.substring(0, 2) + "/" + data.substring(2, 4) + "/" +
	           data.substring(4, 8));
	}
	
	
	
}
