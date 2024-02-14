# Most Active Cookie

Find most active cookie grouping date from log files


## Project Details

-Get log file path from command line with jar path and date
-Parse log file data
-Group log file data with date
-Find most active data from map

## Technologies

Java, Maven

## Log File Style

cookie,timestamp
AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00
SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00
5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00
AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00
SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00
4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00
fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00
4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00

## Installation

Run 'mvn clean install'  before running below

java -jar target\most-active-cookie-0.0.1-SNAPSHOT.jar -f src\logs\cookie.csv -d 2018-12-09
