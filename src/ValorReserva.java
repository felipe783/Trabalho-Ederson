public class ValorReserva {
        public double valorTotal;
        public double calculo(int entrada, int saida, int quarto) {
            int dias = saida - entrada;
            switch(quarto){
                case 1:
                    valorTotal = dias * 119.90;
                    return valorTotal;
                case 2:
                    valorTotal =  dias * 349.90;
                    return valorTotal;
                case 3:
                    valorTotal =  dias * 689.90;
                    return valorTotal;
                case 4:
                    valorTotal =  dias * 1245.90;
                    return valorTotal;
                default:
                    return 0;
            }
        }



}
