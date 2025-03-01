import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap() {
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        amigos.put(emailAmigo, new Amigo(nomeAmigo, emailAmigo));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem mensagem : mensagens) {
            if (mensagem.ehAnonima()) {
                anonimas.add(mensagem);
            }
        }
        return anonimas;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = amigos.get(emailDaPessoa);
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo com e-mail " + emailDaPessoa + "não encontrado");
        }
        amigo.setAmigoSecreto(emailAmigoSorteado);
    }
    
    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(mensagens);
    }
    
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = amigos.get(emailDaPessoa);
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo com e-mail " + emailDaPessoa + " não encontrado.");
        }
        if (amigo.getAmigoSecreto() == null) {
            throw new AmigoNaoSorteadoException("Amigo secreto ainda não foi sorteado para " + emailDaPessoa);
        }
        return amigo.getAmigoSecreto();
    }
}
