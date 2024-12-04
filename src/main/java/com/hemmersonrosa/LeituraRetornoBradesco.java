package com.hemmersonrosa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBradesco implements LeituraRetorno {

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        try {
            List<Boleto> boletos = new ArrayList<>();
            var lines = Files.readAllLines(Path.of(nomeArquivo));
            for (String line : lines) {
                Boleto b = new Boleto();
                String[] array = line.split(";");
                b.setId(Integer.parseInt(array[0]));
                b.setCodBanco(array[1]);
                b.setAgencia(array[2]);
                b.setContaBancaria(array[3]);
                b.setDataVencimento(LocalDate.parse(array[4], FORMATO_DATA));
                b.setDataPagamento(LocalDateTime.parse(array[5], FORMATO_DATA_HORA));
                b.setCpfCliente(array[6]);
                b.setValor(Double.parseDouble(array[7]));
                b.setMulta(Double.parseDouble(array[8]));
                b.setJuros(Double.parseDouble(array[9]));
                boletos.add(b);
            }
            return boletos;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
