package co.com.sofka.ejercicio1;

import co.com.sofka.ejercicio1.entity.Correo;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Ejercicio1 {


    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
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
        correos.add(new Correo("@gmail.com"));
        correos.add(new Correo("juanit0123@outlook.com"));
        correos.add(new Correo("juancho1225gm.com"));
        correos.add(new Correo("juanit0123outk.com"));

        var correosFlux = Flux.fromIterable(correos);

        var correosValidos = correosFlux
                .distinct()
                .map(p -> pattern.matcher(p.getDireccion()).find() ? p : new Correo("xxxx@xxxx.com"))
                .filter(p -> !p.getDireccion().equals("xxxx@xxxx.com"));
        //.doOnNext(p->System.out.println("Correos Validos: "+p.getDireccion()));

        var correosGmail = correosValidos
                .filter(p -> p.getDireccion().contains("@gmail.com"));
        //.doOnNext(p->System.out.println("Direcion gmail: "+p.getDireccion()));

        var correosHotmail = correosValidos
                .filter(p -> p.getDireccion().contains("@hotmail.com"));
        //.doOnNext(p->System.out.println("Direccion hotmail: "+p.getDireccion()));

        var correoOutlook = correosValidos
                .filter(p -> p.getDireccion().contains("@outlook.com"));
        //.doOnNext(p->System.out.println("Direccion Outlook :"+p.getDireccion()));


        System.out.println("Correos totales: " + correosFlux.count().block().longValue());
        System.out.println("Correos validos totales: " + correosValidos.count().block().longValue());
        System.out.println("Correos gmail: " + correosGmail.count().block().longValue());
        System.out.println("Correos hotmail: " + correosHotmail.count().block().longValue());
        System.out.println("Correos outlook: " + correoOutlook.count().block().longValue());


        //correosGmail.subscribe();
        //correosHotmail.subscribe();
        //correoOutlook.subscribe();
    }
}
