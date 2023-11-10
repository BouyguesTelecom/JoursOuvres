# Java - Jours Ouvrés français

[![Build Status](https://travis-ci.org/BouyguesTelecom/JoursOuvres.svg?branch=master)](https://travis-ci.org/BouyguesTelecom/JoursOuvres)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=fr.bouyguestelecom%3Ajoursouvres&metric=alert_status)](https://sonarcloud.io/dashboard?id=fr.bouyguestelecom%3Ajoursouvres)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=fr.bouyguestelecom%3Ajoursouvres&metric=coverage)](https://sonarcloud.io/dashboard?id=fr.bouyguestelecom%3Ajoursouvres)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=fr.bouyguestelecom%3Ajoursouvres&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=fr.bouyguestelecom%3Ajoursouvres)

Cette librairie permet de calculer les jours ouvrés et d'obtenir les jours fériés français.


## Exigences
Nécessite au moins Java 8 à cause de l'utilisation de `java.time.LocalDate`.

## Fonctionnalités

La classe `JoursOuvresFrance` met à disposition plusieurs méthodes pour obtenir les dates de jours fériés et faire certains calcul de dates.

### Obtenir les jours fériés
On peut obtenir les dates de jours fériés d'une année avec la méthode suivante : 
    `List<LocalDate> joursFeries(int annee)`

On peut aussi obtenir un jour férié spécifique avec une autre méthode comme celle-ci : 
    `LocalDate lundiDePentecote(int annee)`

### Calculer des nombres de jours
Il est possible de calculer des nombres de jours entre 2 dates (`LocalDate`) : une date de début (incluse) et une date de fin (exclue).

Il est possible de calculer le nombres de jours en semaine, c'est à dire sans les jours de week-end : 
    `long calculJoursSemaine(final LocalDate debut, final LocalDate fin)`
    
Il est possible de calculer le nombre de jours fériés en semaine :
    `long calculNombreJoursFeriesSemaine(final LocalDate debut, final LocalDate fin)`
    
Il esr aussi possible de calculer le nombre de jours ouvrés entre 2 dates :
    `long calculJoursOuvres(final LocalDate debut, final LocalDate fin)`
    
L'ensemble de ces méthodes peuvent être appelé avec 2 paramètres booléens supplémentaire si l'on veut plus de précision sur l'intervalle
de calcul. Ainsi avec les paramètres `(final LocalDate debut, final LocalDate fin, final boolean debutInclus, final boolean finIncluse)`
il est possible de préciser si l'on inclu ou non la date de début dans l'intervalle et si l'on inclu la date de fin ou non.

## Utilisation

```java
import fr.bouyguestelecom.joursouvres.JoursOuvresFrance;

import java.time.LocalDate;


public class MaClasse {
 
    public void maMethode() {
        
        long joursOuvresPremierSemestre = JoursOuvresFrance.calculJoursOuvres(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 7, 1));
    }
}
```
## Exemples

Calculer le nombre de jours en semaine pour le mois de Janvier 2019
```
JoursOuvresFrance.calculJoursSemaine(LocalDate.of(2019, Month.JANUARY, 1), LocalDate.of(2019, Month.FEBRUARY, 1))
```

Calculer le nombres de jours fériés en semaine entre 2 dates
```
JoursOuvresFrance.calculNombreJoursFeriesSemaine(LocalDate.of(2019, Month.APRIL, 15), LocalDate.of(2019, Month.JULY, 20))
```

Calculer le nombre de jours ouvrés en 2019 :
```
JoursOuvresFrance.calculNombreJoursFeriesSemaine(LocalDate.of(2019, Month.JANUARY, 1), LocalDate.of(2020, Month.JANUARY, 1))
```

## Contribuer au projet

[Contribuer](CONTRIBUTING.md) ♥
## License

[Apache License 2.0](LICENSE.md)


