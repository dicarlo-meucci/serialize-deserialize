package com.itismeucci;

import java.io.File;
import java.util.*;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App {

    public static void main(String[] args) {
        XmlMapper mapper = new XmlMapper();
        Alunno a1 = new Alunno();
        a1.setNome("Niccolò");
        a1.setCognome("BATTISTINI");
        a1.setDataNascita(new Date(1088546400));
        Alunno a2 = new Alunno();
        a2.setNome("Leonardo");
        a2.setCognome("Di Carlo");
        a2.setDataNascita(new Date(1094767200));
        ArrayList<Alunno> alunni = new ArrayList<>();
        alunni.add(a1);
        alunni.add(a2);
        Classe classe = new Classe();
        classe.setNumero(5);
        classe.setSezione("CIA");
        classe.setAula("06-TE");
        classe.setAlunni(alunni);

        // serializza

        try {
            mapper.writeValue(new File("balls.xml"), classe);
        } catch (Exception e) {

        }

        // -------

        File file = new File("balls.xml");

        // deserializza

        try {
            Classe deserialized = mapper.readValue(file, Classe.class);
            System.out.println(deserialized.getNumero() + deserialized.getSezione());
        } catch (Exception e) {

        }

        // -------
    }
}
