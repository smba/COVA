# Setup COVA for Java applications
* Clone git repository `git clone https://github.com/smba/COVA.git`
* Link z3 to `LD_LIBRARY_PATH` (Linux) by adding `export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:/path/to/repository/COVA/cova/localLibs/z3-4.5.0-x64-ubuntu/bin/"`
* Link local libraries `sh /path/to/repository/COVA/cova/localLibs/install_local_libs.sh`
* Build COVA with Maven `mvn install` (includes test cases) 
* Configure `COVA/cova/config/Configuraion_APIs.txt` - specify which field or method is the starting point for the taint analysis
* Example for this test suite:

```
<bench.Configuration: boolean getX()>() -> C: X ID: 1001
<bench.Configuration: boolean getY()>() -> C: Y ID: 1002
```

* Delete all lines in the files `/path/to/repository/COVA/cova/config/`:
```
AndroidCallbacks.txt
IO_APIs.txt
SourcesAndSinks.txt
UICallback_APIs.txt
```
* Run COVA  with
```
COVA/cova/$ java -jar target/cova-0.0.1-SNAPSHOT.jar -java -all -config config/ -app "MyClass" -cp ../myTestBench -output_html ../myTestBench
```

* Find path condition results as HTML at  `/path/to/repository/COVA/cova/covaOutput/htmlOutput`
