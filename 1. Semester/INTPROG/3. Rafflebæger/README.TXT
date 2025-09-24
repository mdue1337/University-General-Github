DieCup 2 - Martin $ Mathias

Opgave 1:
Vi oprettede klassen TestDriver og den hertil beskrevne metode. Grunden til vi bruger public static void er at metoden så kan kaldes uden der er en instans af klassen, dette gør det nemmere at teste.

Opgave 2:
Denne del af opgaven løste vi allerede i raflebæger 1, vi kalder dermed multipleRolls i vores test klasse.

Opgave 3:
I denne opgave modificerer vi konstruktøren og Die-klassens fields, hvor vi tilføjer "numOfSides". Desuden får vi kravsspecifikationen at terningen minimum skal have 2 sider, dermed laver vi et if-statement i konstruktøren for at se om dette krav er opfyldt, hvis det ikke er opfyldt, smider vi en fejl ved brug af IllegalArgumentException. Der er ingen grund til at modificere getEyes fordi den Accessor-metode henter blot værdien af vores field. 

Opgave 4:
Giver sig selv, man skal bare supplere den med de nødvendige "actual parameters".

Opgave 5:
Ja resultaterne giver mening af f.eks. en 6 og 9 siddet terning burde give (7+10)/2 = 8.5 og vores beregninger gav et på 8.56 ved 100 kast. Desto flere kast, desto tættere burde den korrigerer på den teoretiske værdi.

Opgave 6:
Alt virkede.

Opgave 7:
Det er samme princip som med 1 terning, man sammenligner dem bare og vurderer hvem der vinder.
