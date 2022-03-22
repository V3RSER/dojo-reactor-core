package co.com.sofka.ejercicio1;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Ejercicio1 {


    public static void main(String[] args) {
        List<Correo> correos = new ArrayList<>();

        correos.add(new Correo("jcgo125@gmail.com"));
        correos.add(new Correo("juanita@hotmail.com"));
        correos.add(new Correo("luis@gmail.com"));
        correos.add(new Correo("jcgd56@gmail.com"));
        correos.add(new Correo("juata@hotmail.com"));
        correos.add(new Correo("luisito@gmail.com"));
        correos.add(new Correo("jcgo125@gmail.com"));
        correos.add(new Correo("juanita@hotmail.com"));
        correos.add(new Correo("luis@gmail.com"));
        correos.add(new Correo("jcgho1225@gmail.com"));
        correos.add(new Correo("juanit0123@hotmail.com"));
        correos.add(new Correo("luis123@gmail.com"));
        correos.add(new Correo("juan125@gmail.com"));
        correos.add(new Correo("camilo@hotmail.com"));
        correos.add(new Correo("raul@gmail.com"));
        correos.add(new Correo("raul@outlook.com"));
        correos.add(new Correo("jcgo125@outlook.com"));
        correos.add(new Correo("juanita@yahoo.com"));
        correos.add(new Correo("luis@yahoo.es"));
        correos.add(new Correo("jcgd56@outlook.com"));
        correos.add(new Correo("juata@hotmail.com"));
        correos.add(new Correo("luisito@yahoo.com"));
        correos.add(new Correo("jcgo125@sofka.com.co"));
        correos.add(new Correo("juanita@yahoo.es"));
        correos.add(new Correo("luisesteban@gmail.com"));
        correos.add(new Correo("juancho1225@gmail.com"));
        correos.add(new Correo("juanit0123@Outlook.com"));
        correos.add(new Correo("luis123@sofka.com.co"));
        correos.add(new Correo("juan125@outlook.com"));
        correos.add(new Correo("camilo@hotmail.com"));
        correos.add(new Correo("raul@outlook.com"));
        correos.add(new Correo("jcgo125@outlook.com"));
        correos.add(new Correo("jcgo125@gmail.com"));
        correos.add(new Correo("luisesteban@gmail.com"));
        correos.add(new Correo("juancho1225@gmail.com"));
        correos.add(new Correo("juanit0123@outlook.com"));

        var correosFlux = Flux.fromIterable(correos)
                .distinct()


        var correosGmail= correosFlux
                //cadenaSeparada = cadenaValidada.substring(cadenaValidada.indexOf(']') + 1)
                .distinct()
                .filter(p->p.getDireccion().contains("@gmail.com"));

        var correosHotmail= correosFlux
                //cadenaSeparada = cadenaValidada.substring(cadenaValidada.indexOf(']') + 1)
                .distinct()
                .filter(p->p.getDireccion().contains("@hotmail.com"))
                .doOnNext(p->System.out.println(p.getDireccion()));

        var correoOutlook = correosFlux
                //cadenaSeparada = cadenaValidada.substring(cadenaValidada.indexOf(']') + 1)
                .distinct()
                .filter(p->p.getDireccion().contains("@outlook.com"))
                .doOnNext(p->System.out.println(p.getDireccion()));

        System.out.println("Correos totales: " + correosFlux.count().block().longValue());
        System.out.println("Correos gmail: " + correosGmail.count().block().longValue());
        System.out.println("Correos hotmail: " + correosHotmail.count().block().longValue());
        System.out.println("Correos outlook: " + correoOutlook.count().block().longValue());
    }
}
