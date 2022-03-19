package DTO;

public class PessoasDTO {

    private String nome_pessoas;
    private int codigop;

    public String getNome_pessoas() {
        return nome_pessoas;
    }

    public void setNome_pessoas(String nome_pessoas) {
        this.nome_pessoas = nome_pessoas;
    }

    /**
     * @return the codigop
     */
    public int getCodigop() {
        return codigop;
    }

    /**
     * @param codigop the codigop to set
     */
    public void setCodigop(int codigop) {
        this.codigop = codigop;
    }

}
