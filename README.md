# Random Data Generator

## Table of Contents
- [Introduction]
- [File and Directory Organization]
- [Building the Program]
- [Running the Program]
- [Program Overview]

- **Introduction**
A Java program called the Random Data Generator creates random data entries and publishes them to an output file. The size of the created dataset, disk throughput, and the impact of dataset size and entries on program performance are also covered.

- **File and Directory Organization**
The program consists of the following files and directories:

- `RandomDataGenerator.java`: The Java source code for the Random Data Generator program.
- `README.md`: This manual.
- (Other optional files or directories)

- **Building the Program**
To build the Random Data Generator program-

1. Ensure the Java Development Kit (JDK) installed on the system.
2. Compile the source code using the `javac` command:
   javac RandomDataGenerator.java

- **Running the Program**
To run the Random Data Generator program-
java RandomDataGenerator <number_of_input_entries> <output_file_path>
java RandomDataGenerator 1000 out

- **Program Overview**
It determines whether the application has received the appropriate number of command-line inputs (two arguments: output file location and number of entries). If not, it exits after displaying an error message.
Creating and Writing Data:

It creates random data entries made up of a random text, random integer, and random sequence number.
The output file that has been defined receives these entries.
Performance Measurements

The application computes and shows disk throughput, dataset size (in both MB and MiB), wall time, and CPU time.
Effects of Dataset Size and Number of Entries:

It demonstrates how program performance can be affected by the size of the dataset and the number of entries in terms of memory usage, disk I/O, CPU usage, runtime, and cache utilization.


//////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////

# SortData

## Table of Contents
- [Introduction]
- [File and Directory Organization]
- [Building the Program]
- [Running the Program]
- [Program Overview]

Introduction
File and Directory Organization
Building the Program
Running the Program
1. **Introduction**
The "SortData" Java application is made to accept information from an input file, sort it according to predetermined standards, and then write the sorted information to an output file. Data sets containing elements that are formatted as strings and are separated by underscores can be sorted using this application.

- **File and Directory Organization**
The program consists of :

SortData.java: This is the main Java source code file that contains the program logic.
readme.md: This manual file that provides information about the program.


- **Building the Program**
To build the Random Data Generator program-

1. Ensure the Java Development Kit (JDK) installed on the system.
2. Compile the source code using the `javac` command:
   javac SortData.java

- **Running the Program**
To run the Random Data Generator program-
java SortData <input_file> <temp_directory> <output_file>
java SortData out rotal out_sorted

- **Program Overview**
The program will sort the data based on the numerical values at the beginning of each entry.