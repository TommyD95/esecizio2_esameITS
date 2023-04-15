import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

class Militare {
    private String nome;
    private String grado;
    private Date dataArruolamento;

    @Override
    public String toString() {
        return "Nome: " + nome + ", Grado: " + grado + ", Data di arruolamento: " + new SimpleDateFormat("dd/MM/yyyy").format(dataArruolamento);
    }

    public Militare(String nome, String grado, String dataArruolamento) throws ParseException {
        this.nome = nome;
        this.grado = grado;
        this.dataArruolamento = new SimpleDateFormat("dd/MM/yyyy").parse(dataArruolamento);
    }

    public String getNome() {
        return nome;
    }

    public String getGrado() {
        return grado;
    }

    public Date getDataArruolamento() {
        return dataArruolamento;
    }

    public int getMesiServizio() {
        long differenza = new Date().getTime() - dataArruolamento.getTime();
        return (int) ((differenza / (1000 * 60 * 60 * 24)) / 30);
    }
}

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Militare> listaMilitari = new ArrayList<>();
        listaMilitari.add(new Militare("Giada", "Sergente", "01/05/2014"));
        listaMilitari.add(new Militare("Vincenzo", "Tenente", "15/10/2016"));
        listaMilitari.add(new Militare("Gianna", "Caporale", "20/03/2015"));
        listaMilitari.add(new Militare("Franco", "Sergente", "10/08/2012"));
        listaMilitari.add(new Militare("Fabrizio", "Tenente", "01/01/2013"));
        listaMilitari.add(new Militare("Carlo", "Maggiore", "01/07/2010"));

        System.out.println("Elenco non ordinato: " + listaMilitari);

        Collections.sort(listaMilitari, new Comparator<Militare>() {
            @Override
            public int compare(Militare m1, Militare m2) {
                return m2.getMesiServizio() - m1.getMesiServizio();
            }
        });

        System.out.println("Elenco ordinato: " + listaMilitari.toString());

        for (Militare militare : listaMilitari) {
            System.out.println(militare.getNome().toUpperCase() + " " + militare.getGrado() + " "
                    + militare.getMesiServizio() + " mesi di servizio");
        }
    }
}