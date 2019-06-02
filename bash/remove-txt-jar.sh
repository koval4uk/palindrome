#!/usr/bin/env bash

cd ..
rm $(ls -I "input.txt" -I ".editorconfig" -I ".gitignore"  -I "pom.xml")
rm *.jar
