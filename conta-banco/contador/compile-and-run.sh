#!/bin/bash

javac -d bin src/*
java -cp bin Contador $@
