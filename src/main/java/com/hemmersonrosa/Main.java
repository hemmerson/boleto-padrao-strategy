package com.hemmersonrosa;

import java.nio.file.Paths;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            LeituraRetorno leitura = new LeituraRetornoBancoBrasil();
            ProcessarBoletos processarBoletos = new ProcessarBoletos(leitura);

            String caminhoArquivo = Paths.get(Objects.requireNonNull(Main.class.getResource("/banco-brasil-1.csv")).toURI()).toString();
            processarBoletos.processar(caminhoArquivo);
        } catch (Exception e) {
            System.err.println("Erro ao executar o processamento: " + e.getMessage());
        }
    }
}
