# Running COVA for JAVA applications

* Install COVA following the instructions provided in the top-level README.md.
* Configure `COVA/cova/config/Configuraion_APIs.txt` - specify which field or method is the starting point for the taint analysis
* Example for his test suite:

```
<bench.Configuration: boolean getX()>() -> C: X ID: 1001
<bench.Configuration: boolean getY()>() -> C: Y ID: 1002
```

* run with
```
COVA/cova/$ java -jar target/cova-0.0.1-SNAPSHOT.jar -java -all -config config/ -app "MyClass" -cp ../myTestBench -output_html ../myTestBench
```
