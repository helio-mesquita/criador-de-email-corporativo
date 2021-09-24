package emailApp;

import java.text.Normalizer;
import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String primeiroNome;
    private String segundoNome;
    private String senha;
    private String departamento;
    private String email;
    private int capacidadeCaixaDeEntrada = 500;
    private int defaultsenhaLength = 10;
    private String emailAlternativo;
    private String nomeDaCompanhia;

    public void instrucoesEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao criador de e-mails corporativos. Para prosseguir, digite o nome da empresa: ");
        String aux = sc.next();
        this.nomeDaCompanhia = aux;
        System.out.println("Digite seu primeiro nome: ");
        aux = sc.next();
        this.primeiroNome = aux;
        System.out.println("Digite seu segundo nome: ");
        aux = sc.next();
        this.segundoNome = aux;
        this.departamento = setDepartament();
        System.out.println("Departamento: " + this.departamento);
        if (!this.departamento.isEmpty()) {
            email = removerAcentos(primeiroNome.toLowerCase()) + "." + removerAcentos(segundoNome.toLowerCase()) + "@" + departamento + "." + removerAcentos(nomeDaCompanhia.toLowerCase()) + ".com";
        } else {
            email = removerAcentos(primeiroNome.toLowerCase()) + "." + removerAcentos(segundoNome.toLowerCase()) + "@" + removerAcentos(nomeDaCompanhia.toLowerCase()) + ".com";
        }
        System.out.println("Seu email é: " + email);
        this.senha = randomsenha(defaultsenhaLength);
        System.out.println("Sua senha é: " + this.senha);
        System.out.println("Deseja alterar a senha?\n1 Sim \n2 Não");
        int confirmar = sc.nextInt();
        if (confirmar == 1) {
            System.out.println("Insira sua nova senha:");
            String novaSenha = sc.next();
            mudarSenha(novaSenha);
            System.out.println("Sua nova senha é: " + this.senha + "\n");
        }
        System.out.println("Deseja adicionar um email alternativo?\n1 Sim \n2 Não");
        confirmar = sc.nextInt();
        if (confirmar == 1) {
            System.out.println("Insira seu email alternativo");
            String emailAlternativo = sc.next();
            setEmailAlternativo(emailAlternativo);
            System.out.println("Seu email alternativo é: " + emailAlternativo + "\n");
        }


    }

    private String setDepartament() {
        System.out.println("Escolha o seu departamento:\n1 Para Vendas\n2 Para Desenvolvimento\n3 Para Contabilidade \n0 Para nenhum\nInsira o código do seu departamento: ");
        Scanner sc = new Scanner(System.in);
        int DepChoice = sc.nextInt();
        switch (DepChoice) {
            case 1:
                return "vendas";

            case 2:
                return "desenvolvimento";

            case 3:
                return "contabilidade";

            default:
                return "";
        }

    }

    private String randomsenha(int length) {
        String senhaSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] senha = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * senhaSet.length());
            senha[i] = senhaSet.charAt(rand);

        }
        return new String(senha);
    }

    public void setCapacidadeCaixaDeEntrada (int capacity) {
        this.capacidadeCaixaDeEntrada = capacity;
    }

    public void setEmailAlternativo (String altEmail) {
        this.emailAlternativo = altEmail;
    }

    public void mudarSenha(String senha) {
        this.senha = senha;
    }

    public int getcapacidadeCaixaDeEntrada() {
        return capacidadeCaixaDeEntrada;
    }

    public String getemailAlternativo () {
        return emailAlternativo;
    }

    public String getsenha() {
        return this.senha;
    }

    public String showInfo() {
        return "==================================================================================\n" +
                "NOME: " + primeiroNome + " " + segundoNome +
                "\nEMAIL CORPORATIVO: " + email +
                "\nCAPACIDADE DE CAIXA DE ENTRADA: " + capacidadeCaixaDeEntrada + "mb";
    }
    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
