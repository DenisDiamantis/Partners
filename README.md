## Εισαγωγή



Ο σκοπός αυτού του έγγραφου είναι να περιγράψει το πεδίο ορισμού, τις απαιτήσεις λογισμικού και την ανάλυση του συστήματος της εφαρμογής Project Partners.

### Εμβέλεια

#### Δυνατότητες Λογισμικού
Αρχικά, το λογισμικό επιτρέπει στους διαχειριστές να προσθέσουν μαθήματα που έχουν ομαδικές εργασίες. Επίσης, θα δημιουργεί τον λογαριασμό του φοιτητή, με βάση τον αριθμό μητρώου του και θα αποθηκεύει τα στοιχεία του. Το σύστημα θα επιτρέπει στον φοιτητή να ενημερώσει τα στοιχεία αυτά όποτε επιθυμεί, με την προϋπόθεση να υποβάλλει τον κωδικό του. Έπειτα το σύστημα του παρουσιάζει τα μαθήματα της σχολής, που απαιτούν την εκπόνηση μίας ομαδικής εργασίας φιλτραρισμένα ανά εξάμηνο. Ο φοιτητής επιλέγει τα μαθήματα στα οποία αναζητεί ομάδα, το σύστημα αποθηκεύει τις επιλογές του και ύστερα του εμφανίζει τις διαθέσιμες ομάδες ανά μάθημα. Στη συνέχεια εάν διαλέξει μία από τις διαθέσιμες ομάδες, το σύστημα ειδοποιεί τον υπεύθυνο εκείνης της ομάδας και περιμένει έγκριση από αυτόν, για να πραγματοποιηθεί η εγγραφή του φοιτητή σε αυτή την ομάδα. Ωστόσο, εάν δεν επιλέξει καμία από τις διαθέσιμες ομάδες, το σύστημα του δίνει τη δυνατότητα να δημιουργήσει μία δική του, θέτοντας ένα όριο στον δυνατό αριθμό μελών, στην οποία θα ορίσει αυτός τις δικές του απαιτήσεις. Μετά την ολοκλήρωση του εξαμήνου, το σύστημα θα δέχεται ανώνυμες αξιολογήσεις μεταξύ των φοιτητών που συνεργάστηκαν και αποσυνθέτει τις ομάδες.

#### Λειτουργίες εκτός των δυνατοτήτων του λογισμικού
Το λογισμικό δεν επιτρέπει να συνδεθεί ο χρήστης χωρίς να έχει αριθμό μητρώου, δεν δίνει πρόσβαση στον χρήστη χωρίς σωστή υποβολή του κωδικού του, δεν επιτρέπει να φτιάξει ο χρήστης πάνω από μια ομάδες στο ίδιο μάθημα, δεν αφήνει το χρήστη να αξιολογήσει κάποιο συμφοιτητή του αν δεν έχει συνεργαστεί μαζί του τουλάχιστον μία φορά, δεν δίνει τη δυνατότητα στον φοιτητή να δει τα στοιχεία επικοινωνίας των ατόμων που δεν είναι στην ομάδα του, δεν αφήνει τον χρήστη να ενημερώσει τα στοιχεία του εάν δεν υποβάλλει τον κωδικό του για λόγους εξακρίβωσης, δεν επιτρέπει μία ομάδα να υπερβεί το μέγιστο αριθμό μελών.

## Data Flow Diagram
![](pic1.png)

### Ακρώνυμα και Συντομογραφίες

|  Έννοια  |   Επεξήγηση     |
|----------------------|----------------------------------|
| Αριθμός Μητρώου                | Ο μοναδικός αριθμός που δίνεται σε κάθε φοιτητή κατά την εγγραφή της σχολής |
| Φοιτητής| Ο μαθητής που σπουδάζει και φοιτά στο πανεπιστήμιο|
| Ημερολόγιο| Σύστημα που αναγράφει όλες τις ημέρες του έτους|
| Διαχειριστική Ομάδα| Η ομάδα που είναι υπεύθυνη για τη διαχείρηση ενός συστήματος|

### Επισκόπηση

Στη συνέχεια θα παρουσιαστεί μία γενική εικόνα του συστήματος με τη χρήση ενός μοντέλου περιπτώσεων χρήσης. Έπειτα θα ακολουθήσουν οι απαιτήσεις του λογισμικού αλλά και η ανάλυση του συστήματος.


### Μοντέλο Περιπτώσεων Χρήσης

## Use Case
![](pic2.png)

|  Περιπτώσεις χρήσης  |   Ανάλυση Περιπτώσεων Χρήσης     |
| -------------------- |----------------------------------|
| **ΠΧ Δημιουργία Ομάδας** | Ο φοιτητής δημιουργεί μία δική του ομάδα αντί να εγγραφεί σε μία υπάρχουσα|
| **ΠΧ Επιλογή Ομάδας**| Ο φοιτητής επιλέγει μία υπάρχουσα ομάδα |
| **ΠΧ Επιλογή Μαθημάτων**| Ο φοιτητής επιλέγει τα μαθήματα που θα χρειαστεί ομαδική εργασία το τρέχον εξάμηνο|
| **ΠΧ Ενημέρωση Στοιχείων**| Ο φοιτητής ενημερώνει τα στοιχεία του λογαριασμού του|
| **ΠΧ Αίτηση Αποχώρησης Από Ομάδα**| Ο φοιτητής αιτείται να αποχωρήσει από μία ομάδα που είναι εγγεγραμμένος|
| **ΠΧ Δημιουργία Λογαριασμού**| Ο φοιτητής δημιουργεί τον λογαριασμό του|
|**ΠΧ Αξιολόγηση**| Ο φοιτητής αξιολογεί κάποιο συμφοιτητή του με τον οποίο συνεργάστηκε|
|**ΠΧ Διαχείρηση Διαθέσιμων Μαθημάτων**| Η διαχειριστική ομάδα οργανώνει τα διαθέσιμα μαθήματα του τρέχοντος εξαμήνου|
|**ΠΧ Αποσύνθεση Ομάδων**| Το ημερολόγιο στην ημερομηνία που υποδείχτηκε ότι τελειώνει το εξάμηνο αποσυνθέτει τις ομάδες|