public class Amigo {
    private String email;
    private String amigoSecreto;

    public Amigo(String email, String emailAmigo) {
        this.email = email;
        this.amigoSecreto = null;
    }

    public String getEmail() {
        return email;
    }

    public void setAmigoSecreto(String AmigoSecreto) {
        this.amigoSecreto = amigoSecreto;
    }

    public String getAmigoSecreto() {
        return amigoSecreto;
    }
}
