package QuartosFiltro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;


public class Filtro {
    public static void Comparar(List<String> Escolha/*, List<String> Preco*/) {
        ArrayList<Quartos> quartos = Quartos.sampleList();
        for (Quartos q : quartos) {
            for(int i=0;i<Escolha.size();i++){
                if(Escolha.get(i).equals(q.getQualidade())){
                    System.out.printf("%-10s",q.getQualidade());
                }
                if(Escolha.get(i).equals(q.getPreco())){
                    System.out.printf("%-10s",q.getPreco());
                }
            }
        }
    }
}


