#!/bin/bash

input="repos.list"

checkDir=$(pwd)

while read name repo
do
  echo "$name"
  cd ../$name
  mvn clean package
  cd $checkDir
done < "$input"

./run-jar.sh
./compare-files.sh