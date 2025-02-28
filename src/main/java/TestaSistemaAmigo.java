public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        sistema.cadastraAmigo("João", "joao@gmail.com");
        sistema.cadastraAmigo("Maria", "maria@gmail.com");

        try {
            sistema.configuraAmigoSecretoDe("joao@gmail.com", "maria@gmail.com");
            sistema.configuraAmigoSecretoDe("maria@gmail.com", "joao@gmail.com");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }

        Mensagem mensagem1 = new MensagemParaAlguem("Olá, João!", "maria@gmail.com", "joao@gmail.com", true);
        Mensagem mensagem2 = new MensagemParaAlguem("Olá a todos!", "maria@gmail.com", "todos", true);

        sistema.pesquisaTodasAsMensagens().add(mensagem1);
        sistema.pesquisaTodasAsMensagens().add(mensagem2);

        for (Mensagem mensagem : sistema.pesquisaMensagensAnonimas()) {
            System.out.println(mensagem.getTextoCompletoAExibir());
        }

        try {
            String amigoSecreto = sistema.pesquisaAmigoSecretoDe("Joao@gmail.com");
            if (amigoSecreto.equals("joao@gmail.com")) {
                System.out.println("OK");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }
    }
}