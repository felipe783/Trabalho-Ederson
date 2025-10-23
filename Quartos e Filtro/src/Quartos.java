import java.util.ArrayList;

public class Quartos {
    //Define o lsita dos quartos
    static ArrayList<Quartos> listaQuarto= new ArrayList<>();
    private int numero;
    private String qualidade,preco;


    //Inicializa o objeto quarto(valores padrão)
    public Quartos(){
        this.numero=0;
        this.qualidade="Desconhecida";
        this.preco="0";
    }
    //Define os valores de quarto
    public Quartos(int numero, String qualidade, String preco){
        this.numero=numero;
        this.qualidade=qualidade;
        this.preco=preco;
    }
    public String getPreco(){
        return preco;
    }
    public int getNumero(){
        return numero;
    }
    public String getQualidade(){
        return qualidade;
    }
    /**Printa Bunitinho**/
    @Override
    public String toString(){
        return numero + qualidade + preco;
    }

    public static void Exibir(ArrayList<Quartos> listaQuarto){
        //Os : percorre a lista sem precisar de indice
        System.out.printf("\n--------------------------------------------------\n");
        System.out.printf("%-10s %-10s %-10s", "Numero", "Qualidade", "Preço");
        System.out.printf("\n--------------------------------------------------");
        for(Quartos quarto : listaQuarto){
            System.out.printf("\n%-10d %-10s %-10s",quarto.numero,quarto.qualidade,quarto.preco);
        }
        System.out.printf("\n--------------------------------------------------\n");
    }
    public static ArrayList<Quartos> sampleList(){
        ArrayList<Quartos> listaQuarto= new ArrayList<>();
        listaQuarto.add(new Quartos(101, "Básica", "119.90"));
        listaQuarto.add(new Quartos(102, "Média", "349.90"));
        listaQuarto.add(new Quartos(103, "Vip", "689.90"));
        listaQuarto.add(new Quartos(104, "Suíte_Vip", "1245.90"));
        listaQuarto.add(new Quartos(105, "Básica", "119.90"));
        listaQuarto.add(new Quartos(201, "Média", "349.90"));
        listaQuarto.add(new Quartos(202, "Vip", "689.90"));
        listaQuarto.add(new Quartos(203, "Suíte_Vip", "1245.90"));
        listaQuarto.add(new Quartos(204, "Básica", "119.90"));
        listaQuarto.add(new Quartos(205, "Média", "349.90"));
        return listaQuarto;
    }
}
