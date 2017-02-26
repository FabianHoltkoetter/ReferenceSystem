# ReferenceSystem
Reference System for implementing Test-Methods to then be implemented into Barrakuda

# Getting Started

## Regenerating with Barrakuda

Prerequisites:
https://github.com/xdoo/mdsd <- Pull repository and follow the build instructions so that all artifacts are deployed in your local maven repository

 1. Edit the model .mdsd/referencesystem.barrakuda to your liking
 2. Execute `mvn compile` to start the barrakuda generator
 
## Running the tests

Prerequisites:
https://github.com/xdoo/gaia-common <- Pull repository and follow the build instructions so that all artifacts are deployed in your local maven repository

1. Go to the `src`-directory
2. `mvn package` executes unit-, integration-, component- and consumer driven contract tests and builds executable `jar`s for every service
3. Run `startServices.cmd` (for windows) or run all services manually. Wait for all services to startup fully
3. Extract `src/ETE Test Kongo/apache-jmeter-3.1.zip
4. Run `apache-jmeter-3.1/bin/jmeter.bat` (for windows) and open the configuration `src/ETE Test Kongo/End-To-End Test Kongo.jmx`
5. Execute the tests by clicking on the green "play"-Button. The results can be seen under `View Results Tree`
  1. On systems with low RAM or slow CPUs it can happen that tests fail due to long response times. Running the tests more than once fixes this problem.


## Generating a coverage report

1. Go to the `src`-directory
2. Execute `mvn cobertura:cobertura`. This will run all tests except the end-to-end tests and generate a coverage report for each module under `target/site/cobertura/index.html`
