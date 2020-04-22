import java.util.ArrayList;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) throws TvCadastradaException{
        System.out.println("Controle remoto iniciado. Bem-vindo(a)!");
        
        //criacao de canais
        Canal Record = new Canal(15, "Record", false);
        Canal Globo = new Canal(10, "Globo", true);
        Canal Disney = new Canal(120, "DisneyChannel", true);
        Canal Novela = new Canal(9, "Canal das Novelas", false); 
        Canal Epoca = new Canal (777, "Epoca", false);
        Canal News = new Canal (001, "News", true);
        
        //criacao de televisoes
        ArrayList<Canal> smart_lg = new ArrayList<>();
        smart_lg.add(Novela); //adicionando canais aleatorios desodernadamente na lista
        smart_lg.add(Globo);
        smart_lg.add(Record);
        SmartTV LG = new SmartTV("LGSmart345", smart_lg, 17); //instanciando uma nova tv
        
        ArrayList<Canal> hd_lg = new ArrayList<>();
        hd_lg.add(Epoca);
        hd_lg.add(Record);
        hd_lg.add(News);
        hd_lg.add(Disney);
        TVHD LG_HD = new TVHD("LGHD567", hd_lg, "Led");
        
        
        TVHD LG_HD2 = new TVHD("LGHD567", hd_lg, "Led");
        
        ArrayList<Canal> hd1 = new ArrayList<>();
        hd1.add(Globo);
        hd1.add(Record);
        hd1.add(Disney);
        hd1.add(Novela);
        TVHD Samsung = new TVHD("SamsungHD91000", hd1, "Samsung HD 7a. Geracao");
        
        //criando um controle
        ControleRemoto universal = new ControleRemoto();
        //adicionando uma tv para testar exception personalizada
        universal.adicionarTVs(LG);
        
        int loop = -1; //entrar na main no inicio do programa
    
        while (loop != 0){
            System.out.println( "\nMenu do controle remoto. Insira o numero correspondente a opcao que deseja:"
                + "\n1: Adicionar televisao."
                + "\n2: Aumentar volume."
                + "\n3: Diminuir volume."
                + "\n4: Sintonizar canal específico."
                + "\n5: Próximo canal."
                + "\n6: Canal anterior."
                + "\n7: Informar dados."
                + "\n8: Mostrar grade."
                + "\n0: Sair do programa");
            Scanner ler_opcao = new Scanner(System.in);
            loop = ler_opcao.nextInt();
            
            //sair do programa
            if (loop == 0){
                System.out.println("Saindo...");
                break;
            }
            
            //cadastrar televisoes ja existentes no controle
            if (loop == 1){
                System.out.println("\nAs televisoes cadastradas podem ser controladas pelo controle. Digite o numero da Tv que deseja cadastrar. \nAs televisoes encontradas sao (1) " + Samsung.getId() + ", (2) " + LG_HD.getId() + ", (3) " + LG.getId());
                Scanner ler = new Scanner(System.in);
                int tv = ler.nextInt();
                
                Televisao tvv; //para metodos do controle
                if (tv == 1)
                    tvv = Samsung;
                
                else if (tv == 2)
                    tvv = LG_HD;
                
                else if (tv == 3)
                    tvv = LG;
                
                else {
                    System.out.println("Opcao invalida. Tente novamente.");
                    continue;
                }
                
                try{
                    universal.adicionarTVs(tvv);
                    System.out.println("Nova televisao cadastrada.");
                }
                catch (TvCadastradaException e){
                    System.out.println(e.getMessage());
                }
            }
            
            //o controle só altera a tv que o usuario selecionar
            //diminuir o volume da televisao escolhida pelo usuario
            else if (loop == 2){
                System.out.println("\nEssas sao as ids das televisoes ja cadastradas: ");
                universal.getTvs();
                System.out.println ("Digite o numero da TV que deseja aumentar o volume. (1) " + Samsung.getId() + ", (2) " + LG_HD.getId() + ", (3) " + LG.getId());
                Scanner ler = new Scanner(System.in);
                int tv = ler.nextInt();
                String id;
                
                if (tv == 1)
                    id = Samsung.getId();
                
                else if (tv == 2)
                    id = LG_HD.getId();
                
                else if (tv == 3)
                    id = LG.getId();
                
                else {
                    System.out.println("Opcao invalida. Tente novamente.");
                    continue;
                }
                universal.aumentarVolume(id);
            }
            
            //aumentar o volume da televisao escolhida pelo usuario
            else if (loop == 3){
                System.out.println("\nEssas sao as ids das televisoes ja cadastradas: ");
                universal.getTvs();
                System.out.println ("Digite o numero da TV que deseja diminuir o volume. (1) " + Samsung.getId() + ", (2) " + LG_HD.getId() + ", (3) " + LG.getId());
                Scanner ler = new Scanner(System.in);
                int tv = ler.nextInt();
                String id;
                
                if (tv == 1)
                    id = Samsung.getId();
                
                else if (tv == 2)
                    id = LG_HD.getId();
                
                else if (tv == 3)
                    id = LG.getId();
                
                else {
                    System.out.println("Opcao invalida. Tente novamente.");
                    continue;
                }
                universal.diminuirVolume(id);
            }
            
            //sintonizar canais - busca pelo numero do canal se esse canal existe na televisao escolhida pelo usuario, se sim, muda para esse canal selecionado
            else if (loop == 4){
                System.out.println("\nEssas sao as ids das televisoes ja cadastradas: ");
                universal.getTvs();
                System.out.println("\nAs televisoes disponiveis sao (1) " + Samsung.getId() + ", (2) " + LG_HD.getId() + ", (3) " + LG.getId());
                universal.listarCanais();
                System.out.println ("Digite o numero da TV que deseja sintonizar canal");
                Scanner ler = new Scanner(System.in);
                int tv = ler.nextInt();
                Televisao tvv;
                
                if (tv == 1)
                    tvv = Samsung;
                
                else if (tv == 2)
                    tvv = LG_HD;
                
                else if (tv == 3)
                    tvv = LG;
                
                else {
                    System.out.println("Opcao invalida. Tente novamente.");
                    continue;
                }
                
                System.out.println("Qual o numero do canal?");
                int canal = ler.nextInt();
                
                universal.sintonizar(tvv, canal);
            }
            
            //ir para o proximo canal 
            else if (loop == 5){
                System.out.println("\nEssas sao as ids das televisoes ja cadastradas: ");
                universal.getTvs();
                System.out.println("\nAs televisoes disponiveis sao (1) " + Samsung.getId() + ", (2) " + LG_HD.getId() + ", (3) " + LG.getId());
                System.out.println ("Deseja ir pro proximo canal de qual Tv? Insira o numero: ");
                Scanner ler = new Scanner(System.in);
                int tv = ler.nextInt();
                String id;
                
                if (tv == 1)
                    id = Samsung.getId();
                
                else if (tv == 2)
                    id = LG_HD.getId();
                
                else if (tv == 3)
                    id = LG.getId();
                
                else {
                    System.out.println("Opcao invalida. Tente novamente.");
                    continue;
                }
                universal.proximoCanal(id);
            }
            
            //o canal atual da tv que ele escolher sera alterado para o proximo na ordem da arraylist desordenada
            else if (loop == 6){
                System.out.println("\nEssas sao as ids das televisoes ja cadastradas: ");
                universal.getTvs();
                System.out.println("\nAs televisoes disponiveis sao (1) " + Samsung.getId() + ", (2) " + LG_HD.getId() + ", (3) " + LG.getId());
                System.out.println ("Deseja ir pro canal anterior de qual Tv? Insira o numero: ");
                Scanner ler = new Scanner(System.in);
                int tv = ler.nextInt();
                String id;
                
                if (tv == 1)
                    id = Samsung.getId();
                
                else if (tv == 2)
                    id = LG_HD.getId();
                
                else if (tv == 3)
                    id = LG.getId();
                
                else {
                    System.out.println("Opcao invalida. Tente novamente.");
                    continue;
                }
                universal.canalAnterior(id);
            }
            
            //informar dados, mostra canal atual e volume da tv selecionada
            else if (loop == 7){
                System.out.println("\nEssas sao as ids das televisoes ja cadastradas: ");
                universal.getTvs();
                System.out.println("\nAs televisoes disponiveis sao (1) " + Samsung.getId() + ", (2) " + LG_HD.getId() + ", (3) " + LG.getId());
                System.out.println ("Digite o numero da TV que deseja ver os dados.");
                Scanner ler = new Scanner(System.in);
                int tv = ler.nextInt();
                Televisao tvv;
                
                if (tv == 1)
                    tvv = Samsung;
                
                else if (tv == 2)
                    tvv = LG_HD;
                
                else if (tv == 3)
                    tvv = LG;
                
                else {
                    System.out.println("Opcao invalida. Tente novamente.");
                    continue;
                }
                
                universal.informarDados(tvv);
            }
            
            //mostra a lista ordenada por numero de canais disponiveis com os dados de cada canal (numero, nome e se e hd)
            else if (loop ==  8){
                System.out.println("\nEssas sao as ids das televisoes ja cadastradas: ");
                universal.getTvs();
                System.out.println("\nAs televisoes disponiveis sao (1) " + Samsung.getId() + ", (2) " + LG_HD.getId() + ", (3) " + LG.getId());
                System.out.println ("Digite o numero da TV que deseja ver os dados.");
                Scanner ler = new Scanner(System.in);
                int tv = ler.nextInt();
                Televisao tvv;
                
                if (tv == 1)
                    tvv = Samsung;
                
                else if (tv == 2)
                    tvv = LG_HD;
                
                else if (tv == 3)
                    tvv = LG;
                
                else {
                    System.out.println("Opcao invalida. Tente novamente.");
                    continue;
                }
           
                universal.mostrarGrade(tvv);
            }
            
            else {
                System.out.println("Opcao invalida. Tente novamente.");
                continue;
            }
            
        }
        
        
    }
}
