#!/bin/bash
echo "Launch jars"

input="repos.list"

fileinput="file-input"

echo "Create solution directories"
rm -r solutions
mkdir solutions

while read name repo
do
  echo "$name = $repo"
  solutionsDir=solutions/$name
  mkdir $solutionsDir
  mkdir $solutionsDir/base
  mkdir $solutionsDir/parallel
  mkdir $solutionsDir/line
  mkdir $solutionsDir/parallel-line
done < "$input"

echo "Running jars"
while read name repo
do
  echo "$name = $repo"
  solutionsDir=solutions/$name
  for entry in `ls $fileinput`
  do
	  echo "$name $entry base"
	  java -jar ../$name/Palindrom.jar $fileinput/$entry $solutionsDir/base/$entry &>> $solutionsDir/base/output
	  echo "$name $entry parallel"
	  java -jar ../$name/Palindrom.jar $fileinput/$entry $solutionsDir/parallel/$entry parallel &>> $solutionsDir/parallel/output
	  echo "$name $entry line"
	  java -jar ../$name/Palindrom.jar $fileinput/$entry $solutionsDir/line/$entry line &>> $solutionsDir/line/output
	  echo "$name $entry parallel line"
	  java -jar ../$name/Palindrom.jar $fileinput/$entry $solutionsDir/parallel-line/$entry parallel line &>> $solutionsDir/parallel-line/output
  done

done < "$input"

echo "Launched"
echo " "