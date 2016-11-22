# Chocoholics Anonymous

## Requirements

The Chocoholics Anonymous data system requires that the following software be installed on the user's system:

* Java 8
## To build the Chocoholics Anonymous project:

* ANT
* Java JDK (for building only)

## Building the Project

To build, you must first make sure that you have Java 8 and Apache Ant installed. Instructions for installing Ant are available on the Apache Ant website. In order to build, you must also have Java JDK 8, which is available on Oracle's website.

Once you have installed Ant you can run the following commands in the root project directory to build the Chocoholics Anonymous project:

* Generate documentation for the project.

$ ant doc

* Build a runnable jar file

$ ant jar

* Buid documentation and build the runnable jar

$ ant all

## Running the Simulation

To run the Chocohlics Anonymous data simulation, simply run the command

$ java -jar release/ChocAn.jar

in the root project directory.

Instructions for Use