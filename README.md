# DeLuxe PDF Reader v2.0 — Android

Tamna početna biblioteka prema referentnoj slici: pretraga, Active Tabs (zadnja otvorena knjiga), Continue Reading, naslovnice PDF-ova, napredak, filteri All/Reading/Finished/Unread, plutajući + za dodavanje PDF-a. Čitač: fiksna ili pomična vodoravna crta, izbor boje i debljine, zumiranje i pomicanje stranice, listanje stranicu po stranicu.

## Instalacija bez računala — GitHub Actions

1. Na mobitelu otvori github.com, prijavi se i napravi **privatni** repozitorij `DeLuxePDFReader` (main grana).
2. Raspakiraj preuzeti izvorni ZIP. Prenesi njegov SADRŽAJ u korijen repozitorija: `.github/workflows/build-apk.yml`, `app/`, `build.gradle.kts`, `settings.gradle.kts` (i README). Na GitHub mobilnom webu uključi Desktop site ako je potrebno. GitHubov Upload files može preskočiti skrivenu `.github` mapu pri izboru datoteka; po potrebi je kreiraj u GitHub web uređivaču ručno.
3. Otvori karticu **Actions** → **Build Android APK** → **Run workflow** → **Run workflow**. Ako se workflow pokrene automatski nakon uploada, samo pričekaj.
4. Kad završi zeleno, otvori run i preuzmi **DeLuxePDFReader-APK** pod Artifacts. Preuzeti ZIP raspakiraj u Files aplikaciji.
5. Dodirni `app-debug.apk`, dopusti instaliranje aplikacija iz tog izvora kad Android zatraži i instaliraj.

**Napomena:** APK se izrađuje na GitHubovom serveru, ne na telefonu. Ovo je izvorni projekt, ne gotov APK. Projekt nije kompajliran ni testiran u ovom okruženju. Debug APK namijenjen je osobnoj upotrebi. PDF-ovi su lokalni; nema internetske dozvole.

**Ograničenja:** Active Tabs u v2.0 prikazuje posljednju otvorenu knjigu; PDF se lista po stranicama, a ne kontinuirano. Neki zaključani PDF-ovi nisu podržani. Naslovnice se generiraju iz prve stranice, ne preuzimaju se s interneta.
