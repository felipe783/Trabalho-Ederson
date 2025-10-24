import java.util.ArrayList;
import java.util.Scanner;
import java.text.Normalizer;

public class Filtro {
    public static Scanner input = new Scanner(System.in);

    public static String[] Selecao_Filtro(String[] aux){
        String[] filtro_tipo = null;
        for (String tipo : aux) {
            if (tipo.equals("0")) { // Preço
                System.out.println("O preco do quarto que voce deseja filtrar:");
                filtro_tipo = input.nextLine().toLowerCase().split(" ");
            }
            else{
                if (tipo.equals("1")) { // Qualidade
                    System.out.println("Fale a qualidade do quarto que voce deseja filtrar:");
                    filtro_tipo = input.nextLine().toLowerCase().split(" ");
                }
                else { // Dois (qualidade/preço)
                    System.out.println("Fale a qualidade/preco do quarto que voce deseja filtrar:");
                    filtro_tipo = input.nextLine().toLowerCase().split(" ");
                }
            }
        }
        return filtro_tipo;
    }

    /**
     *
     String[] tipos=oq ele escolheu como filtro(basico,vip,119.90....)
     String[] escolha= oq ele selecionou(0,1,2)
     *
     */
    public static void Comparar(String[] tipos,String[] escolha){
        ArrayList<Quartos> quartos = Quartos.sampleList();
        for(int i=0;i<tipos.length;i++){
            for(Quartos q : quartos){
                if(escolha[0].equals("0")){ //Preço
                    if(q.getPreco().equals(tipos[i])){
                        System.out.printf("\n%-10d %-10s %-10s",q.getNumero(),q.getQualidade(),q.getPreco());
                    }
                }
                else{
                    if(escolha[0].equals("1")){//Qualidade
                        if(q.getQualidade().equalsIgnoreCase(tipos[i])){
                            System.out.printf("\n%-10d %-10s %-10s",q.getNumero(),q.getQualidade(),q.getPreco());
                        }
                    }
                    else{ //os Dois
                        if(q.getQualidade().equalsIgnoreCase(tipos[i]) || q.getPreco().equalsIgnoreCase(tipos[i])){
                            System.out.printf("\n%-10d %-10s %-10s",q.getNumero(),q.getQualidade(),q.getPreco());
                        }
                    }
                }
            }
        }
    }

}
