# Negociation_SMA

## Equipe

* Anthony CHAPUT
* Bastien JACOUD
* Mark KPAMY

## Informations

Chaque fournisseur à un agent associé.
Les négociateurs représente les personnes qui veulent un service en fonction des préférences (choix de la compagnie).

### Contraintes

#### Fournisseur

* Date butoir
* ...

#### Négociateur

* Budget
* ...

### Billet

* Date départ
* Date arrivée
* Heure départ
* heure arrivée
* ...
  
### Cas à prévoir

* **Cas 1 :** 1N -> 1F
* **Cas 2 :** 2N -> 1F
* **Cas 3 :** 1N -> nF
* **Cas 4 :** nN -> nF

### Protocole

Attention : les prix ne sont pas les minimums (ils ne révèlent pas leur budget)

1. Négociant -> Fournisseur : appel d'offre (*request*)
2. Fournisseur -> Négociant (Offre (ex : Paris - New York : 1.000 €))
3. Négociant -> Fournisseur (300 €)
4. F -> N (800 €)
5. N -> F (400 €)

A définir : Durée de la négociation (ex : 3 min)

Negociateur : vérification d'une offre disponible, accepte, refuse, contre proposition

Fournisseur : vérification demande, accepte, refuse, contre-proposition