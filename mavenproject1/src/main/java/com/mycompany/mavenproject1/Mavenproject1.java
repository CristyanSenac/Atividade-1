/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.model.Produto;
import com.mycompany.mavenproject1.views.cadastroVIEW;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristyan
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
        
       // lista.add(new Produto("Carro de luxo", 250000.00));
        //lista.add(new Produto("Troféu copa do mundo", 380000.89));
                
        new cadastroVIEW(lista).setVisible(true);
    }
}
