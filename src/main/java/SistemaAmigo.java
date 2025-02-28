import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigo() {
        this.amigos = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        this.amigos.add(new Amigo(nomeAmigo, emailAmigo));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem mensagem : this.mensagens) {
            if (mensagem.ehAnonima()) {
                anonimas.add(mensagem);
            }
        }
        return anonimas;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailDaPessoa)) {
                amigo.setAmigoSecreto(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("Amigo com e-mail " + emailDaPessoa + " não encontrado.");
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(this.mensagens);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailDaPessoa)) {
                if (amigo.getAmigoSecreto() == null) {
                    throw new AmigoNaoSorteadoException("Amigo secreto ainda não foi sorteado para " + emailDaPessoa);
                }
                return amigo.getAmigoSecreto();
            }
        }
        throw new AmigoInexistenteException("Amigo com e-mail " + emailDaPessoa + " não encontrado.");
    }
}

