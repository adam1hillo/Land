package be.vdab.land;

import be.vdab.util.LandException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Land {
    private String landCode, landNaam, hoofdstad;
    private BigInteger aantalInwoners;
    private BigDecimal oppervlakte;

    public Land(String landCode, String landNaam, String hoofdstad, BigInteger aantalInwoners, BigDecimal oppervlakte) {
        setLandCode(landCode);
        setLandNaam(landNaam);
        setHoofdstad(hoofdstad);
        setAantalInwoners(aantalInwoners);
        setOppervlakte(oppervlakte);
    }

    public String getLandCode() {
        return landCode;
    }

    public final void setLandCode(String landCode) {
        if (landCode == null || landCode.isBlank()) {
            throw new LandException("Land code verplicht in te vullen");
        } else {
            this.landCode = landCode;
        }
    }

    public String getLandNaam() {
        return landNaam;
    }

    public void setLandNaam(String landNaam) {
        if (landNaam == null || landNaam.isBlank()) {
            throw new LandException("Land naam verplicht in te vullen");
        } else {
            this.landNaam = landNaam;
        }
    }

    public String getHoofdstad() {
        return hoofdstad;
    }

    public void setHoofdstad(String hoofdstad) {
        if (hoofdstad == null || hoofdstad.isBlank()) {
            throw new LandException("Hoofdstad verplicht in te vullen");
        } else {
            this.hoofdstad = hoofdstad;
        }
    }

    public BigInteger getAantalInwoners() {
        return aantalInwoners;
    }

    public void setAantalInwoners(BigInteger aantalInwoners) {
        if (aantalInwoners.compareTo(BigInteger.ZERO) > 0) {
            this.aantalInwoners = aantalInwoners;
        } else {
            throw new LandException("Aantal inwoners moet groter zijn dan 0");
        }
    }

    public BigDecimal getOppervlakte() {
        return oppervlakte;
    }

    public void setOppervlakte(BigDecimal oppervlakte) {
        if (oppervlakte.compareTo(BigDecimal.ZERO) > 0) {
            this.oppervlakte = oppervlakte;
        } else {
            throw new LandException("Oppervlakte moet groter zijn dan 0");
        }
    }
    public BigDecimal berekenBevolkingsdichtheid() {
        return  new BigDecimal(aantalInwoners).divide(oppervlakte, 2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return landCode + "; " + landNaam + "; " + hoofdstad + "; " + aantalInwoners + "; " + oppervlakte;
    }

    public void printGegevens() {
        System.out.println("\nLand: " + landNaam +
                "\nLandcode: " + landCode +
                "\nHoofdstad: " + hoofdstad +
                "\nAantal inwoners: " + aantalInwoners +
                "\nOppervlakte: " + oppervlakte +
                "\nBevolkingsdichtheid: " + berekenBevolkingsdichtheid() + " pers/km2\n");
    }
}
