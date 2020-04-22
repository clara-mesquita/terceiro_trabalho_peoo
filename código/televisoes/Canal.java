public class Canal{

    private Integer numero;
    private String nome;
    private boolean hd;

    public Canal(Integer numero, String nome, boolean hd){
        this.numero = numero;
        this.nome = nome;
        this.hd = hd;
    }

    public Integer getNumero(){
        return numero;
    } 

    public void setNumero(Integer numero){
        this.numero = numero;
    }

    public String getNome(){
        return nome;
    } 

    public void setNome(String nome){
        this.nome = nome;
    }

    public boolean isHD(){
        return hd;
    } 

    public void setHD(Boolean hd){
        this.hd = hd;
    }
}