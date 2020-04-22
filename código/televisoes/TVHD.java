import java.util.ArrayList;

public class TVHD extends Televisao {
    String modelo;
    
    public TVHD(String id, ArrayList<Canal> listaTV, String modelo){
        super(id, listaTV);
        this.modelo = modelo;
        canais_disp.clear();
        for (Canal c : listaTV){
            if (c.isHD())
                canais_disp.add(c); 
        }
        this.setCanalAtual(canais_disp.get(canais_disp.size()-1));
    }
    
    public void cadastrarCanais(ArrayList<Canal> canais){
        boolean existe = false;
    
        for(Canal canal_analizado : canais){
            for(Canal c : this.canais_disp){
                if(canal_analizado.getNumero() == c.getNumero())
                    existe = true;
            }
            if(existe == false && canal_analizado.isHD() == true)
                canais_disp.add(canal_analizado);
            
            int ultimo = canais_disp.size();
            this.setCanalAtual(canais_disp.get(ultimo));
        }
    }
}