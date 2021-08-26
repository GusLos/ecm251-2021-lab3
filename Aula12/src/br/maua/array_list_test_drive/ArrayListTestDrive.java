package br.maua.array_list_test_drive;

import br.maua.model.Conta;
import br.maua.model.Pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTestDrive {
    public static void main(String[] args){
        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Albafica","123"));
        pessoas.add(new Pessoa("Dohko","002"));
        pessoas.add(new Pessoa("Athena","126"));
        pessoas.add(1, new Pessoa("Shion","001"));
        pessoas.addAll(
                Arrays.asList(
                    new Pessoa("Seiya","598"),
                    new Pessoa("Hyoga","785")
                )
        );

        System.out.println("===========================================");
        System.out.println("Passa pelo arrayList Pessoas: ");
        pessoas.forEach(pessoa -> System.out.println(pessoa));

        List<Conta> contas = new ArrayList<>();
        contas.add(new Conta(89));
        contas.add(new Conta());
        System.out.println("===========================================");
        System.out.println("Passa pelo arrayList Pessoas: ");
        contas.forEach(conta -> System.out.println(conta));

    }
}
