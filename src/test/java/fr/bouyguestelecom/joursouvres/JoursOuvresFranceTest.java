package fr.bouyguestelecom.joursouvres;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

public class JoursOuvresFranceTest {

    @Test
    public void estFerie() {

        // Jour de l'an
        assertTrue(JoursOuvresFrance.estFerie(LocalDate.of(2019, Month.JANUARY, 1)));
        // Lundi de Paques
        assertTrue(JoursOuvresFrance.estFerie(LocalDate.of(2019, Month.APRIL, 22)));
        // 1er Mai
        assertTrue(JoursOuvresFrance.estFerie(LocalDate.of(2019, Month.MAY, 1)));
        // Ascension
        assertTrue(JoursOuvresFrance.estFerie(LocalDate.of(2019, Month.MAY, 30)));

    }

    @Test
    public void calculJoursSemaine() {
        // 23 jours en semaine en Mai 2019
        assertEquals(23,
            JoursOuvresFrance.calculJoursSemaine(LocalDate.of(2019, Month.MAY, 1), LocalDate.of(2019, Month.JUNE, 1)));

        // 261 jours en semaine en 2019
        assertEquals(261,
            JoursOuvresFrance.calculJoursSemaine(LocalDate.of(2019, Month.JANUARY, 1), LocalDate.of(2020, Month.JANUARY, 1)));
    }

    @Test
    public void calculNombreJoursFeriesSemaine() {
        // 3 jours fériés en Mai 2019
        // - Fete du travail le Mercredi 1 Mai
        // - Victoire des alliés le Mercredi 8 Mai
        // - L'Ascension le Jeudi 30 Mai
        assertEquals(3, JoursOuvresFrance.calculNombreJoursFeriesSemaine(LocalDate.of(2019, Month.MAY, 1),
            LocalDate.of(2019, Month.JUNE, 1)));

        // Le 14 Juillet 2019 tombe un dimanche
        assertEquals(0, JoursOuvresFrance.calculNombreJoursFeriesSemaine(LocalDate.of(2019, Month.JULY, 1),
            LocalDate.of(2019, Month.AUGUST, 1)));

        // 10 jours feries en semaine en 2019
        assertEquals(10, JoursOuvresFrance.calculNombreJoursFeriesSemaine(LocalDate.of(2019, Month.JANUARY, 1),
            LocalDate.of(2020, Month.JANUARY, 1)));

    }

    @Test
    public void calculJoursOuvres() {
        // 23 jours de semaine moins 3 jours fériés en semaine
        assertEquals(20,
            JoursOuvresFrance.calculJoursOuvres(LocalDate.of(2019, Month.MAY, 1), LocalDate.of(2019, Month.JUNE, 1)));

        assertEquals(251,
            JoursOuvresFrance.calculJoursOuvres(LocalDate.of(2019, Month.JANUARY, 1), LocalDate.of(2020, Month.JANUARY, 1)));

        JoursOuvresFrance.calculNombreJoursFeriesSemaine(LocalDate.of(1500, Month.APRIL, 1), LocalDate.of(1500, Month.JUNE, 1));
    }

    @Test
    public void paques() {

        assertEquals(LocalDate.of(2019, Month.APRIL, 21), JoursOuvresFrance.paques(2019));
        assertEquals(LocalDate.of(2020, Month.APRIL, 12), JoursOuvresFrance.paques(2020));
        assertEquals(LocalDate.of(2021, Month.APRIL, 4), JoursOuvresFrance.paques(2021));
        assertEquals(LocalDate.of(2022, Month.APRIL, 17), JoursOuvresFrance.paques(2022));
        assertEquals(LocalDate.of(2023, Month.APRIL, 9), JoursOuvresFrance.paques(2023));
        assertEquals(LocalDate.of(2024, Month.MARCH, 31), JoursOuvresFrance.paques(2024));
        assertEquals(LocalDate.of(2025, Month.APRIL, 20), JoursOuvresFrance.paques(2025));
        assertEquals(LocalDate.of(2026, Month.APRIL, 5), JoursOuvresFrance.paques(2026));
        assertEquals(LocalDate.of(2027, Month.MARCH, 28), JoursOuvresFrance.paques(2027));
        assertEquals(LocalDate.of(2028, Month.APRIL, 16), JoursOuvresFrance.paques(2028));
        assertEquals(LocalDate.of(2029, Month.APRIL, 1), JoursOuvresFrance.paques(2029));
        assertEquals(LocalDate.of(2030, Month.APRIL, 21), JoursOuvresFrance.paques(2030));

    }
}