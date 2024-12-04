package com.hemmersonrosa;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos (LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String nomeArquivo) {
        System.out.println("Boletos\n" +
                "-----------------------------------------------------");
        final var boletos = leituraRetorno.lerArquivo(nomeArquivo);
        boletos.forEach(System.out::println);
    }
}
