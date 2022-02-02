package projekt;

import static org.junit.jupiter.api.Assertions.*;

class MagazynTest {
    @org.junit.jupiter.api.Test
    void dodajNowySektor() {
        Magazyn m=new Magazyn();
        m.usunProdukt("Nowy Sektor");//na wypadek gdyby w poczatkowym stanie magazynu istnial sektor o takiej nazwie
        Sektor s=new Sektor("Nowy Sektor");
        assertTrue(m.DodajSektor(s));
    }

    @org.junit.jupiter.api.Test
    void zdublujSektor(){
        Magazyn m=new Magazyn();
        Sektor s=new Sektor("Nowy Sektor");
        m.DodajSektor(s);
        assertFalse(m.DodajSektor(s));
    }

    @org.junit.jupiter.api.Test
    void usunSektor(){
        Magazyn m= new Magazyn();
        Sektor s=new Sektor("Sektor Usuwany");
        m.DodajSektor(s);
        assertTrue(m.usunProdukt("Sektor Usuwany"));
    }

    @org.junit.jupiter.api.Test
    void dodajProdukt(){
        Magazyn m= new Magazyn();
        Sektor s=new Sektor("NaszSektor");
        m.DodajSektor(s);

        ProduktIloscBuilder builder=new ProduktIloscBuilder();
        builder.setCena(123);
        builder.setNazwa("Nowy Produkt");
        builder.setKrajID("999");
        builder.setProducentID("9999");
        builder.setProduktID("99999");
        builder.setKontrolnyID("9");
        ProduktIlosc p= builder.getProdukt();

        assertTrue(m.DodajProdukt("NaszSektor",p));
    }

    @org.junit.jupiter.api.Test
    void zdublujProdukt(){
        Magazyn m= new Magazyn();
        Sektor s=new Sektor("NaszSektor");
        m.DodajSektor(s);

        ProduktIloscBuilder builder=new ProduktIloscBuilder();
        builder.setCena(123);
        builder.setNazwa("Nowy Produkt");
        builder.setKrajID("999");
        builder.setProducentID("9999");
        builder.setProduktID("99999");
        builder.setKontrolnyID("9");
        ProduktIlosc p= builder.getProdukt();
        m.DodajProdukt("NaszSektor",p);
        assertFalse(m.DodajProdukt("NaszSektor",p));
    }

    @org.junit.jupiter.api.Test
    void zdublujProdukt2(){
        Magazyn m= new Magazyn();
        Sektor s=new Sektor("NaszSektor");
        m.DodajSektor(s);
        Sektor s2=new Sektor("NaszSektor2");
        m.DodajSektor(s2);
        ProduktIloscBuilder builder=new ProduktIloscBuilder();
        builder.setCena(123);
        builder.setNazwa("Nowy Produkt");
        builder.setKrajID("999");
        builder.setProducentID("9999");
        builder.setProduktID("99999");
        builder.setKontrolnyID("9");
        ProduktIlosc p= builder.getProdukt();
        m.DodajProdukt("NaszSektor",p);
        assertFalse(m.DodajProdukt("NaszSektor2",p));
    }

    @org.junit.jupiter.api.Test
    void usunProdukt(){
        Magazyn m= new Magazyn();
        Sektor s=new Sektor("NaszSektor");
        m.DodajSektor(s);
        ProduktIloscBuilder builder=new ProduktIloscBuilder();
        builder.setCena(123);
        builder.setNazwa("Nowy Produkt");
        builder.setKrajID("999");
        builder.setProducentID("9999");
        builder.setProduktID("99999");
        builder.setKontrolnyID("9");
        ProduktIlosc p= builder.getProdukt();
        m.DodajProdukt("NaszSektor",p);

        assertTrue(m.usunProdukt("9999999999999"));
    }


}