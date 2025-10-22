import java.util.ArrayList;
import java.util.Scanner;

public class Quarto_Exibição{
    //Define o lsita dos quartos
    static ArrayList<Quarto_Exibição> listaQuarto= new ArrayList<>();
    int numero;
    String qualidade;
    float preco;

    //Inicializa o objeto quarto(valores padrão)
    public Quarto_Exibição(){
        this.numero=0;
        this.qualidade="Desconhecida";
        this.preco=0;
    }
    //Define os valores de quarto
    public Quarto_Exibição(int numero, String qualidade, float preco){
        this.numero=numero;
        this.qualidade=qualidade;
        this.preco=preco;
    }
    /**Printa Bunitinho**/
    @Override
    public String toString(){
        return numero + qualidade + preco;
    }

    public static void Exibir(){
        //Os : percorre a lista sem precisar DE indice
        System.out.printf("\n--------------------------------------------------\n");
        System.out.printf("%-10s %-10s %-10s", "Numero", "Qualidade", "Preço");
        System.out.printf("\n--------------------------------------------------");
        for(Quarto_Exibição quarto : listaQuarto){
            System.out.printf("\n%-10d %-10s %-10.2f",quarto.numero,quarto.qualidade,quarto.preco);
        }
        System.out.printf("\n--------------------------------------------------\n");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        listaQuarto.add(new Quarto_Exibição(101, "Básica", 119.90f));
        listaQuarto.add(new Quarto_Exibição(102, "Média", 349.90f));
        listaQuarto.add(new Quarto_Exibição(103, "Vip", 689.90f));
        listaQuarto.add(new Quarto_Exibição(104, "Suíte Vip", 1245.90f));
        listaQuarto.add(new Quarto_Exibição(105, "Básica", 119.90f));
        listaQuarto.add(new Quarto_Exibição(201, "Média", 349.90f));
        listaQuarto.add(new Quarto_Exibição(202, "Vip", 689.90f));
        listaQuarto.add(new Quarto_Exibição(203, "Suíte Vip", 1245.90f));
        listaQuarto.add(new Quarto_Exibição(204, "Básica", 119.90f));
        listaQuarto.add(new Quarto_Exibição(205, "Média", 349.90f));
        Exibir();
    }
}


