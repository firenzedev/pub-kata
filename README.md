# The Pub kata

- [versione iniziale](./initial)
- [versione finale](./final)

## Descrizione

Abbiamo creato un software per gestire il nostro pub virtuale.

La classe `Pub` rappresenta il nostro locale e
riceve nel costruttore la lista delle birre alla spina che sono disponibili.

Le birre sono rappresentate da semplici oggetti di tipo `Beer` e hanno due
caratteristiche:

* un parametro `name` (di tipo stringa), che contiene il nome della birra
* un parametro `quality` (di tipo intero), che è un indicatore della qualità della birra

### Regole sulla qualità

Una volta collegate alla spillatrice, le birre contenute nei fusti tendono a deteriorarsi con il passare del tempo. Seguendo queste regole:

* ogni giorno il valore corrispondente alla qualità delle birre viene decrementato di 2 unità
* la `royal ipa`, però, contiene una quantità maggiore di luppolo e quindi tende a conservarsi più a lungo: la qualità di questa birra, quindi, scende di 1 unità al giorno
* la `belgian trappist tripel` ha una gradazione alcolica più elevata e pertanto la sua qualità
  tende a restare intatta (non si modifica col passare del tempo)
* il `barrel aged barley wine`, al contrario, migliora con l'invecchiamento e pertanto la sua qualità
  cresce di 1 unità ogni giorno
* il valore che indica la qualità di una birra non può essere negativo o superiore a 200

### Funzionamento

Per aggiornare i valori relativi alla qualità delle birre, la classe `Pub` dispone di un metodo
`dayPassed()` che, in base alla qualità corrente delle varie birre, determina quali birre risultano
in offerta nella giornata odierna e quale percentuale di sconto deve essere applicata.

### Regole sugli sconti

Per calcolare le percentuali di sconto, vengono applicate queste regole:

* le birre con qualità inferiore o uguale a `10` vengono vendute a metà prezzo, ovvero hanno uno sconto uguale a `50` (percento)
* dato che conserva meglio la propria qualità, alla `royal ipa` si applicano delle regole diverse:
  lo sconto è pari solamente a `20` (percento) e viene applicato solo quando la qualità è uguale o inferiore a `5`
* le birre `belgian trappist tripel` e `barrel aged barley wine` non vengono mai scontate, indipendentemente dalla loro qualità

## Feature aggiuntiva

Il pub vuole mettere in vendita un nuovo tipo di birra, la `special premium craft beer`.
Trattandosi di una birra artigianale, però, tende a deteriorarsi più velocemente: la sua qualità,
infatti, scende di `4` unità ogni giorno e quando la sua qualità è inferiore o uguale a `20`, viene
scontata del `35` (percento).
