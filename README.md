# MediathekHear
Das hier ist ein Projekt analog zu Medeathekview, nur nicht für die Videotheken, sondern für die Audiothek von ARD.

Es zeigt also die Sendungen, die in der ARD Audiothek verfügbar sind, und bietet mehr Sortierfunktionen an als die
Webseite und Smartphone-Apps.

Beim Start werden die aktuellen Sendungen und Episoden abgefragt und in eine lokale Datenbank gespeichert.
Die Aktualisierung passiert nur täglich (also nicht mehr, wenn man das Programm mehrfach am selben Tag startet.)

## ToDos
- Update data.sql function (test last podcast episode for publication date)
- GUI (Swing/FX) Tabelle mit sortierbaren Spalten:
  - ID
  - Sendung
  - Station
  - Titel
  - Datum
  - Genre
  - Download link (Button display)
  - Play Button
  - URL
  - Beschreibung
  - Settings
    - Output directory
    - File Pattern
    - Save image to file
    - Update DB button
