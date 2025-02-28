import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();

        System.out.println("Informe a quantidade de amigos: ");
        int quantAmigos = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < quantAmigos; i++) {
            System.out.println("Informe o nome do amigo: ");
            String nomeAmigo = sc.nextLine();
            System.out.println("Informe o e-mail do amigo: ");
            String emailAmigo = sc.nextLine();
            sistema.cadastraAmigo(nomeAmigo, emailAmigo);
        }

        System.out.println("Informe o sorteios dos amigos secretos:");
        for (int i = 0; i < quantAmigos; i++) {
            System.out.println("Informe o e-mail do participante: ");
            String emailParticipante = sc.nextLine();
            System.out.println("Informe o e-mail do amigo secreto: ");
            String emailAmigo = sc.nextLine();

            try {
                sistema.configuraAmigoSecretoDe(emailParticipante, emailAmigo);
            } catch (AmigoInexistenteException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Informe o remetente da mensagem: ");
        String remetente = sc.nextLine();
        System.out.println("Texto da mensagem: ");
        String texto = sc.nextLine();
        System.out.println("A mensagem é anônima? (true/false): ");
        boolean anonima = sc.nextBoolean();
        sc.nextLine();

        Mensagem mensagem = new MensagemParaAlguem("Olá!", "maria@gmail.com", "Todos", false);
        sistema.pesquisaTodasAsMensagens().add(mensagem);

        System.out.println("Mensagens anônimas:");
        for (Mensagem msg : sistema.pesquisaMensagensAnonimas()) {
            System.out.println(mensagem.getTextoCompletoAExibir());
        }

        sc.close();
    }
}
