package LojaRoupas;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas {
    @Override
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa) {
        return ;
    }

    @Override
    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixoDescricao) {
        return null;
    }

    @Override
    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        return null;
    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException {

    }

    @Override
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException {

    }

    @Override
    public int pesquisaQuantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException {
        return 0;
    }

    @Override
    public Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        return null;
    }
}
