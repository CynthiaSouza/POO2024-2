public class SistemaAmigoMapTest {
    public static void main(String[] args) {
        SistemaAmigoMap sistema = new SistemaAmigoMap();

        sistema.cadastraAmigo("João", "joao@gmail.com");
        sistema.cadastraAmigo("Maria", "maria@gmail.com");

        try {
            sistema.configuraAmigoSecretoDe("joao@gmail.com", "maria@gmail.com");
            sistema.configuraAmigoSecretoDe("maria@gmail.com", "joao@gmail.com");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }

        Mensagem mensagem1 = new MensagemParaAlguem("Olá, João!", "maria@gmail.com", "joao@gmail.com", true);
        Mensagem mensagem2 = new MensagemParaAlguem("Olá a todos!", "maria@gmail.com", "todos", false);

        sistema.pesquisaTodasAsMensagens().add(mensagem1);
        sistema.pesquisaTodasAsMensagens().add(mensagem2);

        for (Mensagem msg : sistema.pesquisaMensagensAnonimas()) {
            System.out.println(msg.getTextoCompletoAExibir());
        }

        try {
            String amigoSecreto = sistema.pesquisaAmigoSecretoDe("joao@gmail.com");
            if (amigoSecreto.equals("maria@gmail.com")) {
                System.out.println("OK");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }
    }
}
