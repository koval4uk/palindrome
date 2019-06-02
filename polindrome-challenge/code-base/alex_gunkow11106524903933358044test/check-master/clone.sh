#!/bin/bash
echo "Cloning git repositories"

input="repos.list"
while read name repo
do
  echo "$name = $repo"
  rm -r ../$name
  mkdir ../$name
  git clone $repo ../$name
done < "$input"

echo "Cloned"
echo " "