package org.example;

// A prefeitura de uma cidade deseja fazer uma pesquisa entre seus habitantes. Faça um programa para
// coletar dados sobre o salário e o número de filhos de cada habitante e após as leituras, escrever:
// A) média de salário da população;
// B) Média do número de filhos;
// C) Maior salário dos habitantes;
// D) Percentual de pessoas com salário menor que R$150,00

import java.util.Scanner;

public class CalculoPopulacional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantas pessoas desejas entrevistar?");
        int quantidadePessoasEntrevistadas = scanner.nextInt();
        scanner.nextLine();
        boolean runProgram = true;
        float mediaSalarios = 0;
        float mediaFilhos = 0;
        float maiorSalario = 0;
        float salarioMenor150count = 0;
        float salarioPercentualMenor150 = 0;

        float[] salarios = new float[quantidadePessoasEntrevistadas];
        int[] filhos = new int[quantidadePessoasEntrevistadas];

        while (runProgram) {
            for (int i = 0; i < quantidadePessoasEntrevistadas; i++) {
                boolean salarioValidado = false;

                while (!salarioValidado) {
                    System.out.println("Digite o " + (i+1) + "º salario");
                    String entrada = scanner.nextLine();
                        try {
                            float salario = Float.parseFloat(entrada);
                            boolean salarioNegativo = salario < 0;

                            if (salarioNegativo) {
                                System.out.println("Por favor, digite um salário válido.");
                            } else {
                                salarios[i] = salario;
                                salarioValidado = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Por favor, digite um salário válido.");
                        }

                }

                int quantidadeFilhosPorPessoa = 0;
                boolean numeroValidado = false;
                while (!numeroValidado) {
                    System.out.println("Digite a quantidade de filhos do " + (i+1) + "º entrevistado");
                    String entrada = scanner.nextLine();

                    try {
                        quantidadeFilhosPorPessoa = Integer.parseInt(entrada);
                        boolean numeroNegativo = quantidadeFilhosPorPessoa < 0;

                        if (numeroNegativo) {
                            System.out.println("Por favor, digite um número válido.");
                        } else {
                            filhos[i] = quantidadeFilhosPorPessoa;
                            numeroValidado = true;
                        }
                    } catch (Exception e) {
                        System.out.println("Por favor, digite um número válido.");
                    }
                }

            }

            for (float salario : salarios){
                mediaSalarios += salario;
            }
            mediaSalarios = mediaSalarios / quantidadePessoasEntrevistadas;
            System.out.println("A média de salário é: " + mediaSalarios);

            for (float filho: filhos) {
                mediaFilhos += filho;
            }
            mediaFilhos = mediaFilhos / quantidadePessoasEntrevistadas;
            System.out.println("A média de filhos é: " + mediaFilhos);

            maiorSalario = salarios[0];
            for (float salario : salarios) {
                if (maiorSalario < salario) {
                    maiorSalario = salario;
                }
            }
            System.out.println("O maior salário é de: " + maiorSalario);

            for (float salario : salarios) {
                if (salario < 150) {
                    salarioMenor150count++;
                }
            }

            salarioPercentualMenor150 = (salarioMenor150count / quantidadePessoasEntrevistadas) * 100;
            System.out.println("A porcentagem de pessoas que recebem menos de 150 é: " + salarioPercentualMenor150 + "%");

            runProgram = false;
        }

        scanner.close();
    }
}

