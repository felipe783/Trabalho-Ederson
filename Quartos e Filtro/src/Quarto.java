import java.util.ArrayList;
import java.util.Scanner;

public class Quarto{
    int numero;
    String qualidade;
    float preco;

    //Inicializa o objeto quarto(valores padrão)
    public Quarto(){
        this.numero=0;
        this.qualidade="Desconhecida";
        this.preco=0;
    }
    //Define os valores de quarto
    public Quarto(int numero,String qualidade,float preco){
        this.numero=numero;
        this.qualidade=qualidade;
        this.preco=preco;
    }
    /**Printa Bunitinho**/
    @Override
    public String toString(){
        return "Quarto[" +numero + "]"+ "Qualidade:" + qualidade + "Preço:" + preco;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Define os quartos
        ArrayList<Quarto> listaQuarto= new ArrayList<>();
        listaQuarto.add(new Quarto(101, "Básica", 119.90f));
        listaQuarto.add(new Quarto(102, "Média", 349.90f));
        listaQuarto.add(new Quarto(103, "Vip", 689.90f));
        listaQuarto.add(new Quarto(104, "Suíte Vip", 1245.90f));
        listaQuarto.add(new Quarto(105, "Básica", 119.90f));
        listaQuarto.add(new Quarto(201, "Média", 349.90f));
        listaQuarto.add(new Quarto(202, "Vip", 689.90f));
        listaQuarto.add(new Quarto(203, "Suíte Vip", 1245.90f));
        listaQuarto.add(new Quarto(204, "Básica", 119.90f));
        listaQuarto.add(new Quarto(205, "Média", 349.90f));
    }
}


