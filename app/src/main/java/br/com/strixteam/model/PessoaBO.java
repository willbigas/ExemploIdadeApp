package br.com.strixteam.model;

public class PessoaBO {

    public static boolean validarNome(String nome) {
        return !(nome == null || nome.equals(""));
    }

    public static boolean validarIdade(Integer idade) {
        return !(idade == null || idade < 0);
    }

    public static boolean verificarMaioridadeIdade(Integer idade) {
        return idade >= 18;
    }
}
