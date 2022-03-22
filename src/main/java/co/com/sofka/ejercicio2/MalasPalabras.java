package co.com.sofka.ejercicio2;

import reactor.core.publisher.Flux;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class MalasPalabras {


    public static void main(String[] args) {
        System.out.println("Introduzca una cadena por teclado:");
        String entradaTeclado;
        Scanner entradaEscaner = new Scanner(System.in);
        entradaTeclado = entradaEscaner.nextLine();

        var entradaPalabras = Flux.fromStream(Stream.of(entradaTeclado.split(" ")));

        var resultado = entradaPalabras.map(MalasPalabras::esMalaPalabra);

        resultado.subscribe(System.out::println);
    }

    public static String esMalaPalabra(String palabra) {
        String[] malas = {"Abanto", "Abrazafarolas", "Adufe", "Alcornoque",
                "Alfeñique",
                "Andurriasmo",
                "Artabán",
                "Arrastracueros",
                "Atarre",
                "Baboso"};

        return Flux.fromStream(Stream.of(malas))
                .map(p -> p.toLowerCase(Locale.ROOT))
                .map(m -> m.equals(palabra.toLowerCase(Locale.ROOT)) ? "****" : palabra)
                .distinct()
                .filter(p -> p.equals("****"))
                .defaultIfEmpty(palabra)
                .blockFirst();
    }
}
