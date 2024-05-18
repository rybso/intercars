#language:pl
Funkcja: : Intercars

  Założenia:
    Zakładając, że Strona glowna jest otwarta
    I Cookies zostaly zaakceptowane

  Szablon scenariusza: Wybieranie samochodu <marka> <model> <typ> <kod>, dodanie i usuniecie produktow z koszyka
    Gdy Wybranie samochodu: "<marka>" "<model>" "<typ>" "<kod>"
    I Przejdz do akcesoriow
    I Dodaj 4 sztuki wybranego produktu do koszyka
    Wtedy Sprawdz czy poprawny produkt zostal dodany do koszyka
    I Usun pozycje w koszyku
    Wtedy Koszyk jest pusty

    Przykłady:
      | marka | model    | typ     | kod             |
      | AUDI  | A3 (8P1) | 1.6 FSI | BAG, BLF, BLP   |
      | BMW   | 3 (E46)  | 318 d   | M47 D20 (204D1) |
