## Shop-System 
Dieses Projekt implementiert ein einfaches Shop-System mit Produkt- und Bestellverwaltung. Die Kernfunktionen sind modular aufgebaut und können durch optionale Bonus-Features erweitert werden.

## Inhalt
1. ProductRepo
2. OrderListRepo
3. ShopService
4. OrderRepoInterface
5. OrderMapRepo
6. Bonus (optional, zunächst deaktiviert)

## Beschreibung

Dieses Programm bietet eine grundlegende Verwaltung für Produkte und Bestellungen in einem Shop. Es ermöglicht das Anlegen, Abrufen und Entfernen von Produkten und Bestellungen. Die Architektur ist so gestaltet, dass verschiedene Implementierungen für die Speicherung von Bestellungen genutzt werden können (z.B. Listen oder Maps).

Mit dem ShopService können Bestellungen aufgegeben werden, wobei geprüft wird, ob die gewünschten Produkte existieren. Die Programmlogik ist modular und kann flexibel erweitert werden.

Alle Kernfunktionen sind darauf ausgelegt, die wichtigsten Abläufe eines Shops abzubilden: Produktverwaltung, Bestellverwaltung und die Schnittstelle zur Aufgabe neuer Bestellungen.

Im Bonus-Bereich sind zusätzliche Features vorgesehen, wie Preis- und Mengenverwaltung, Tests, eine interaktive Befehlszeilenschnittstelle, farbige Ausgaben, Integration einer EAN-Datenbank, Lagerverwaltung und ein Lagerprotokoll. Diese Erweiterungen sind optional und können nach Bedarf ergänzt werden.

## Bonus (optional)

- Produkte können einen Preis und die Menge pro Bestellung enthalten.
- Die Gesamtsumme einer Bestellung wird berechnet.
- Der Benutzer kann die Menge von Produkten in Bestellungen angeben und ändern.
- Es gibt aussagekräftige Tests für die Kernklassen mit assertj-Matchern.
- Ein interaktives Produktverwaltungssystem über die Kommandozeile mit Scanner.
- Farbliche und formatierte Befehlszeilenausgaben.
- Integration einer EAN-Datenbank im CSV-Format als Datenquelle.
- Verwaltung des Lagerbestands, automatische Anpassung bei Bestellungen.
- Zusätzliche Workflows für Wareneingang und -ausgang.
- Protokollierung aller Lagerbestandsänderungen mit Verknüpfungen zu Bestellungen und Lagerbewegungen.
