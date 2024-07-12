# Welcome to Spectrum's source repository.

Spectrum can monitor the player count on any Minecraft: Java Edition server by
regularly pinging it with the [Server List Ping](https://wiki.vg/Server_List_Ping)
protocol. Results are outputted in CSV format to allow for easy analysis.

## Goals and usage of Spectrum project

The intended use of Spectrum is to allow for server administrators or any
interested players to notice trends in the player counts of their servers and
potentially identify factors that influence server popularity. 

## Get started on your computer

### Prerequisites

You'll need:

- Version 17 of the Java Development Kit for compiling and running the software
- Maven for compiling the software

### Building

Run
```shell
mvn install
```
to compile a JAR file, which will be located in `target/spectrum-version.jar`,
where version is the latest version of the software.

### Configuring

The [spectrum.properties](spectrum.properties) file in the root of this
repository is used by Spectrum as a configuration file. A spectrum.properties
must be present in the working directory of the application during runtime.

Aided by the comments and default values in the file, configure it to your 
liking before running Spectrum.

### Running

Assuming that you have completed the other steps of this section, you can run:
```shell
java -jar target/spectrum-version.jar > out.csv
```
, replacing `version` with the version of the software that you compiled.

This will output Spectrum data in CSV format to the `out.csv` file.

#### Command-line parameters

You can add the `--no-header` flag to the command to prevent Spectrum from
printing a header to your CSV file.

## Technical details

- The application is implemented using Java 17 and built with Maven.
- The [minecraft-server-ping](https://github.com/lucaazalim/minecraft-server-ping)
library is used to poll servers with the SLP protocol.

## License

All contents of this repository, unless explicitly stated otherwise, are
licensed under the MIT license. Please refer to the [LICENSE](LICENSE) file for
further information.