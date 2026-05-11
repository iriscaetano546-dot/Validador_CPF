import static java.lang.IO.*;
void main() {
    IO.println("Digite o CPF: ");
    String cpf = IO.readln();

    if (validarCpf(cpf)) {
        IO.println("CPF válido!");
    } else {
        IO.println("CPF inválido!");
    }

    char resposta = IO.readln("Deseja realizar outra consulta? (s/n)").charAt(0);
    if (resposta == 's' || resposta == 'S') {
        main(); // Chama o método main novamente para reiniciar a calculadora
    } else {
        IO.println("Encerrando o consultor de cpf. Até mais!");
    }
}

boolean validarCpf(String cpf) {
    String removido = cpf.replaceAll("\\D", "");

    if (removido.length() != 11) return false;

    if (removido.matches("(\\d)\\1{10}")) return false;

    try {
        int soma = 0;

        for (int i = 0; i < 9; i++) {
            int num = removido.charAt(i) - '0';
            soma += num * (10 - i);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            int num = removido.charAt(i) - '0';
            soma += num * (11 - i);
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        return digito1 == (removido.charAt(9) - '0') &&
                digito2 == (removido.charAt(10) - '0');

    } catch (Exception e) {
        return false;
    }

}