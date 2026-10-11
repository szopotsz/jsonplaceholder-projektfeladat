JSONPlaceholder API tesztprojekt
A projekt Java,MavenJunit5 és REST Assured hasznalataval valositja meg a kovetkezo JSONPlaceholder REST API teszteket:
-GET /posts:bejegyzesek listajnak ellenorzese
-GET/posts/1 :letezo bejegyzes azonositasa es ellenorzese
-GET/posts/9999:nem letezo bejegyzes es HTTP 404 ellenorzese
-POST /posts:uj bejegyzes letrehozasanak es http 201 valasznak ellenorzese

Tesztek futtatasa
A teszteket Eclipsben JUnit5tel,vagy Mavennel futtathatok.Parancssorbol a projekt konyvtaraban:mvn clean test.
A tesztfuttatas a target/surefire-reports konyvtarban talalhatok.

Alap URL: https://jsonplaceholder.typicode.com 