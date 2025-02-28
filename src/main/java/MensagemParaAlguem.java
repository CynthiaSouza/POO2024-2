public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        return ehAnonima()
                ? "Mensagem para " + emailDestinatario + ". Texto: " + getTexto()
                : "Mensagem de: " + getEmailRemetente() + " para " + emailDestinatario + ". Texto: " + getTexto();
    }
}
