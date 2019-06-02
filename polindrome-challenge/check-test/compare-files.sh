#!/bin/bash
echo "Check results correctness"

input="repos.list"

fileinput="file-input"
fileoutput="file-output"
fileoutputline="file-output-line"

while read name repo
do
  echo "-------------------------------------------"
  echo "-- $(tput setaf 6)$name$(tput sgr0)" 
  echo "----"
  solutionsDir=solutions/$name
  
  echo "-- BASE"
  for entry in `ls $fileinput`
  do	  
	  diff $fileoutput/$entry $solutionsDir/base/$entry  -qs --strip-trailing-cr | sed "s/differ/$(tput setaf 1)&/; s/are/$(tput setaf 2)&/; s/$/$(tput sgr0)/"
	  diff $fileoutput/$entry $solutionsDir/base/$entry  -ys --strip-trailing-cr &>> $solutionsDir/base/comparision
  done	  
  echo
	  
  echo "-- PARALLEL"
  for entry in `ls $fileinput`
  do
	  diff $fileoutput/$entry $solutionsDir/parallel/$entry -qs | sed "s/differ/$(tput setaf 1)&/; s/are/$(tput setaf 2)&/; s/$/$(tput sgr0)/"
	  diff $fileoutput/$entry $solutionsDir/parallel/$entry  -ys &>> $solutionsDir/parallel/comparision
  done	  
  echo
	 
  echo "-- LINE"
  for entry in `ls $fileinput`
  do 
	  diff $fileoutputline/$entry $solutionsDir/line/$entry -qs | sed "s/differ/$(tput setaf 1)&/; s/are/$(tput setaf 2)&/; s/$/$(tput sgr0)/"
	  diff $fileoutput/$entry $solutionsDir/line/$entry  -ys &>> $solutionsDir/line/comparision
  done	  
  echo
	  
  echo "-- PARALLEL LINE"
  for entry in `ls $fileinput`
  do
	  diff $fileoutputline/$entry $solutionsDir/parallel-line/$entry -qs | sed "s/differ/$(tput setaf 1)&/; s/are/$(tput setaf 2)&/; s/$/$(tput sgr0)/"
	  diff $fileoutput/$entry $solutionsDir/parallel-line/$entry  -ys &>> $solutionsDir/parallel-line/comparision
  done	  
  echo "-------------------------------------------"
  echo
  

done < "$input"


echo "========"
echo "All done"