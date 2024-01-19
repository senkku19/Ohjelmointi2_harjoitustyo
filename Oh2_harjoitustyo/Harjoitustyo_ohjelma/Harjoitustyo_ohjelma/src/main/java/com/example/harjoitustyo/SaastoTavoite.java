package com.example.harjoitustyo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**Luokka toteuttaa SäästöTavoite-tilin, jolla on
 * käyttäjä nimi, tavoite, kuinka paljon tavoitetta on jäljellä, kuinka monesti tilille lisätään,
 * päivämäärä jolloin tavoite pitää olla säästetty, aloituspäivä ja ainakun tiliä käytetään päiväys.
 * @author Senja Moilanen
 * @version 1.0
 * 23.3.2023
 */
public class SaastoTavoite implements Serializable {
    /**
     * Käyttäjänimi merkkijonona
     */
    private String kayttaja;
    /**
     * Kuinka monesti tilille lisätään (Päivittain, viikoittain tai kuukausittain) merkkijonona
     */
    private String valinta;
    /**
     * Käyttäjän antama säästötavoite desimaalilukuna
     */
    private double tavoite;
    /**
     * Kuinka paljon tavoitetta on jäljellä sillä hetkellä desimaalilukuna
     */
    private double tavoitettaJaljella;
    /**
     * Päivämäärä johon asti on aikaa säästä LocalDate:na
     */
    private LocalDate  saastoAika;
    /**
     * Päivä jolloin säästäminen alkoi Localdate:na
     */
    private LocalDate saastopaivays;
    /**
     * Joka kerta, kun käyttäjä kirjautuu sisään LocalDate:na
     */
    private LocalDate eranPaivays;

    /**
     * Alustaja, joka luo Säästötilin annetulla käyttäjänimellä.
     * @param kayttaja String kayttajanimi
     */
    public SaastoTavoite(String kayttaja){
        this.kayttaja = kayttaja;
    }

    /**
     * Asettaa säästö tavoitteen
     * @param tavoite double tilin tavoite
     */

    public void setTavoite(double tavoite) {
        this.tavoite = tavoite;
    }

    /**
     * Asettaa, kuinka paljon säästettävää on jäljellä
     * @param tavoitettaJaljella double jäljellä oleva tavoite
     */
    public void setTavoitettaJaljella(double tavoitettaJaljella) {
        this.tavoitettaJaljella =tavoitettaJaljella;
    }

    /**
     * Palauttaa, kuinka paljon säästettävää on jäljellä
     * @return double tavoitettaJaljella
     */
    public double getTavoitettaJaljella() {
        return tavoitettaJaljella;
    }

    /**
     * Asettaa päivän, jolloin tavoite pitää olla säästetty
     * @param aika LocalDate
     */

    public void setSaastoAika(LocalDate aika) {
        this.saastoAika = aika;
    }

    /**
     * Asettaa päivän, milloin säästötavoite on luotu
     * @param saastopaivays LocalDate
     */
    public void setSaastopaivays(LocalDate saastopaivays) {
        this.saastopaivays = saastopaivays;
    }

    /**
     * Asettaa, milloin käyttäjä kirjautuu ohjelmaan
     * @param eranPaivays LocalDate
     */
    public void setEranPaivays(LocalDate eranPaivays) {
        this.eranPaivays = eranPaivays;
    }

    /**
     * Palauttaa säästö tavoitteen
     * @return double tavoite
     */

    public double getTavoite() {
        return tavoite;
    }

    /**
     * Palauttaa päivän jolloin säästötavoite pitää olla säästetty
     * @return LocalDate saastoAika
     */
    public LocalDate getSaastoAika() {
        return saastoAika;
    }

    /**
     * Palauttaa käyttäjän nimen
     * @return String kayttaja
     */

    public String getKayttaja() {
        return kayttaja;
    }

    /**
     * Palauttaa päivän jolloin käyttäjä käyttää ohjelmaa
     * @return LocalDate eranPaivays
     */
    public LocalDate getEranPaivays() {
        return eranPaivays;
    }

    /**
     * Palauttaa päivän jolloin säästötavoite aloitettiin
     * @return LocalDate saastopaivays
     */
    public LocalDate getSaastopaivays() {
        return saastopaivays;
    }

    /**
     * Asettaa, kuinka usein säästöihin lisätään (viikottain, päivittäin tai kuukausittain)
     * @param valinta String
     */
    public void setValinta(String valinta) {
        this.valinta = valinta;
    }

    /**
     * Palauttaa, kuinka usein käyttäjä lisää säästöihin
     * @return String valinta
     */

    public String getValinta() {
        return valinta;
    }


    /**
     * Jos käyttäjä valitsi, että lisää päivittäin tilille, palauttaa tämä päivien määrän
     * @return int paivienMaara
     */
    public int palautaPaivienMaara(){
        int paivienMaara = Math.toIntExact(ChronoUnit.DAYS.between(eranPaivays, saastoAika));
        return paivienMaara;
    }
    /**
     * Jos käyttäjä valitsi, että lisää kuukausittain tilille, palauttaa tämä kuukausien määrän
     * @return int kuukausienMaara
     */
    public int palautaKuukausienMaara(){
        int KuukausienMaara = Math.toIntExact(ChronoUnit.MONTHS.between(eranPaivays, saastoAika));
        return KuukausienMaara;
    }
    /**
     * Jos käyttäjä valitsi, että lisää viikottain tilille, palauttaa tämä viikkojen määrän
     * @return int viikkojenMaara
     */
    public int palautaViikojenMaara(){
        int viikkojenMaara = Math.toIntExact(ChronoUnit.WEEKS.between(eranPaivays, saastoAika));
        return viikkojenMaara;
    }

    /**
     * Laskee kuinka paljon käyttäjän pitää lisätä tilille, että tavoite täyttyisi ajoissa
     * @param aikaMaara int aikaMaara
     * @return double kuinkaPaljon
     */
    public double laskeKeskiverto(int aikaMaara){
        double kuinkaPaljon = tavoitettaJaljella/aikaMaara;
        return kuinkaPaljon;
    }

    /**
     * Laskee kuinka paljon tavoitetta on jäljellä.
     * @param lisaa double
     */
    public void laskeTavoitettaJaljella(double lisaa){
        tavoitettaJaljella -= lisaa;
        setTavoitettaJaljella(tavoitettaJaljella);
    }
}
