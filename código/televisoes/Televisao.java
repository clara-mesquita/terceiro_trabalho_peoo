import java.util.ArrayList;
import java.util.Collections;

public abstract class Televisao  {
    
    private String id;
    protected int volume_atual;
    protected ArrayList<Canal> canais_disp = new ArrayList<>(); //lista de canais cadastrados e disponiveis naquela tv
    protected ArrayList<Canal> todos_canais = new ArrayList<>(); //lista de canais disponiveis para cadastrar
    protected Canal canal_atual;
    public static final int VOLUME_MINIMO = 0;
    public static final int VOLUME_MAXIMO = 10;
    
    public void getCanais(){
        System.out.println("\nA lista de canais de " + this.getId() + " é: ");
        for(Canal c : this.canais_disp){
            if (c.isHD())
            System.out.println(c.getNumero() + " - " + c.getNome() + " - Canal digital (HD)\n");
            else
            System.out.println(c.getNumero() + " - " + c.getNome() + " - Canal analogico\n");    
        }
    }
    
    public Televisao(String id, ArrayList<Canal> listaTV){
        this.id = id;
        this.volume_atual = 5;
        for (int i = 0; i < listaTV.size()-1; i++){
            this.todos_canais.add(i, listaTV.get(i));
        }
    }
    public String getId(){
        return this.id;
    }
    public int getVolume(){
        return volume_atual;
    } 

    public void setVolume(int volume_atual){
        this.volume_atual = volume_atual;
    }

    public Canal getCanal(){
        return canal_atual;
    }
    
    public void setCanalAtual(Canal canal){
        this.canal_atual = canal;        
    }
   
    public void alterarVolume(String altera_volume){
        if(altera_volume == "aumenta"){
            if(volume_atual+1 > VOLUME_MAXIMO)
                System.out.println("Ja esta no volume maximo!");
            else
                volume_atual++;
        }
        else if(altera_volume == "diminui"){
            if(volume_atual-1 < VOLUME_MINIMO)
                System.out.println("Ja esta no volume minimo!");
            else
                volume_atual--;
        }
        else
            System.out.println("Comando Invalido!");
    }
    
    //metodo abstrato para cadastrar canais na televisao
    public abstract void cadastrarCanais(ArrayList<Canal> canais);

    public boolean verificarCanal(Canal canal){
        for(Canal c : this.canais_disp)
            if(c.getNumero() == canal.getNumero())
                return true;
                
        return false;
    }
    
    public void sintonizarCanal(int numero_do_canal) throws CanalInexistenteException {
        boolean existe = false;
        for(Canal c : this.canais_disp)
            if(c.getNumero() == numero_do_canal){
                canal_atual = c;
                existe = true;
            }
        
        if (!existe)
            throw new CanalInexistenteException ("Nao foi possivel encontrar esse canal.");
            
    }

    public void alterarCanal(String mudar_canal){
        int numero_canal_atual=-1, numero_de_canais=0;
        for(Canal c : this.canais_disp)
            numero_de_canais++;
        
        for(Canal c : this.canais_disp)
        {
            numero_canal_atual++;
            if(c.getNumero() == canal_atual.getNumero())
                break;
        }
    
        if(mudar_canal == "proximo"){
            if(numero_canal_atual+1 == numero_de_canais)
                canal_atual = canais_disp.get(0);
            else
                canal_atual = canais_disp.get(numero_canal_atual+1);
        }
        else if(mudar_canal == "anterior"){
            if(numero_canal_atual-1 == -1)
                canal_atual = canais_disp.get(numero_de_canais-1);
            else
                canal_atual = canais_disp.get(numero_canal_atual-1);
        }
        else
            System.out.println("Comando Invalido!");
    } 

    public void informarDados(){
        System.out.println("O canal atual eh: " + canal_atual.getNome() + " - " + canal_atual.getNumero() + " - " + canal_atual.isHD());
        System.out.println("O volume atual eh: " + volume_atual);	
    }
    
    public void mostrarGrade(){
        Collections.sort(canais_disp, new SortByNumber());
    
            for(Canal c: this.canais_disp)
            {
            System.out.println(c.getNumero() + " - " + c.getNome() + " - " + c.isHD());
            }  	
    }
}