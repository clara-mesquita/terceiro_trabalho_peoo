import java.util.ArrayList;

public class ControleRemoto {
    ArrayList<Televisao> tvs = new ArrayList<>();
    
   public void listarCanais(){
       for (Televisao t : this.tvs){
           t.getCanais();
       }
   }
    
    public void getTvs(){
        for(Televisao tv : this.tvs)
            System.out.println("- " + tv.getId());        
    }
    public void adicionarTVs(Televisao tv)throws TvCadastradaException{
        boolean existe = false;
    
            for(Televisao t : this.tvs){
                if(tv.getId() == t.getId())
                    existe = true;
            }
            if(existe == false)
                this.tvs.add(tv);
            else 
                throw new TvCadastradaException("Essa Tv ja esta cadastrada.");
    }

    public void aumentarVolume(String id){
        boolean existe = false;
        
        for(Televisao t : this.tvs){
            if(id.equals(t.getId())){
                Televisao selecionada = t;
                selecionada.alterarVolume("aumenta");
                existe = true;
                System.out.println("O volume da tv agora e :" + selecionada.getVolume());
                break;
            }
        }
        
        if (!existe)
            System.out.println("\nEssa televisao nao esta cadastrada.");      
    }
    
    public void diminuirVolume(String id){
        boolean existe = false;
        
        for(Televisao t : this.tvs){
            if(id.equals(t.getId())){
                Televisao selecionada = t;
                selecionada.alterarVolume("diminui");
                existe = true;
                System.out.println("O volume da tv agora e :" + selecionada.getVolume());
                break;
            }
        }
        
        if (!existe)
            System.out.println("\nEssa televisao nao esta cadastrada.");   
    }
    
    public void sintonizar(Televisao t, int numero_do_canal){
        try {
           t.sintonizarCanal(numero_do_canal);
        }
        catch (CanalInexistenteException e) {
            System.out.println(e.getMessage());
            }
        
        System.out.println("Sintonizado.");
    }

    public void proximoCanal(String id){
        boolean existe = false;
        for(Televisao t : this.tvs){
            if(id.equals(t.getId())){
                Televisao selecionada = t;
                selecionada.alterarCanal("proximo");
                existe = true;
                Canal atual = selecionada.getCanal();

                System.out.println("O canal atual eh: " + atual.getNome() + " - " + atual.getNumero() + " - " + atual.isHD());
                break;
            }
        }
        
        if (!existe)
            System.out.println("\nEssa televisao nao esta cadastrada."); 
    }
    
    public void canalAnterior(String id){
       boolean existe = false;
        for(Televisao t : this.tvs){
            if(id.equals(t.getId())){
                Televisao selecionada = t;
                selecionada.alterarCanal("anterior");
                existe = true;
                Canal atual = selecionada.getCanal();

                System.out.println("O canal atual eh: " + atual.getNome() + " - " + atual.getNumero() + " - " + atual.isHD());
                break;
            }
        }
        
        if (!existe)
            System.out.println("\nEssa televisao nao esta cadastrada."); 
    }
    
    public void informarDados(Televisao tv){
            if (tvs.contains(tv)){
            System.out.println("\nDados da tv de id: " + tv.getId());
            tv.informarDados();   
            }
            else
                System.out.println("Tv nao cadastrada");
    }
    
    public void mostrarGrade(Televisao tv){
            if (tvs.contains(tv)){
            System.out.println("\nDados da tv de id: " + tv.getId());
            tv.mostrarGrade();   
            }
            else
                System.out.println("Tv nao cadastrada");
        
    }
}