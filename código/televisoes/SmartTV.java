import java.util.ArrayList;

public class SmartTV extends Televisao {
    int polegadas;
    
    public void setPolegadas(int polegadas){
        this.polegadas = polegadas;
    }
    
    public int getPolegadas(){
        return this.polegadas;
    }
    
    public void attLista(ArrayList<Canal> listaTV){
        for (int i = 0; i < listaTV.size()-1; i++)
            this.canais_disp.add(i, listaTV.get(i));
    }
    
    public SmartTV(String id, ArrayList<Canal> listaTV, int polegadas){
        super(id, listaTV);
        this.polegadas = polegadas;
        if (!listaTV.isEmpty())
            this.canal_atual = listaTV.get(0); 
        for (int i = 0; i < listaTV.size()-1; i++){
            this.canais_disp.add(i, listaTV.get(i));
        }
    }

    public void cadastrarCanais(ArrayList<Canal> canais){
        boolean existe = false;
    
        for(Canal canal_analizado : canais){
            for(Canal c : this.canais_disp){
                if(canal_analizado.getNumero() == c.getNumero())
                    existe = true;
            }
            if(existe == false)
                canais_disp.add(canal_analizado);
            
            this.setCanalAtual(canais_disp.get(0));

        }
    }

    
}