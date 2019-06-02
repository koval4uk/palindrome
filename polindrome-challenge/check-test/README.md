Bunch of shell scripts to check participants results.

To run this scripts on Windows use "Git Bash for Windows"

**Folder structure**

This project should be placed on the same level as participants projects, like this

```
|--hiring-event/
   |
   |--name1_surname1/
   |--name2_surname2/
   |--check/
```
   
   
**List of repositories**

There are file `repos.list` where scripts get information about checked repos

File format is `{user_name_without_spaces} {link_to_gitlab_repo}` 

In case of *local* use `{link_to_gitlab_repo}` not used, but please provide some dummy non-whitespaces string to script works correctly


Also for correct work file should be ended with newline symbol (other words - last line in the file should be empty), so it will look like this

```
1| name_surname git@gitlab.com:javahiringt/name_surname.git
2| 
```

**How to run**

To start checking all projects from gitlab use `./start-gitlab.sh` 

If you want to check your project locally, without cloning repo each time you can use script `./start-local.sh`. 

This script includes action `mvn clean package` thus you can just call it to get a result.

If you use Gradle than please amend for your needs

Don't forget to amend `repos.list` to point to your actual directory

*Use of these scripts for local development is optional*

**Requirements for Jar file naming and location**

Jar file should be named `Palindrom.jar`

Jar file should be placed in **root** of your project (not in `/project/build` or others)

**Output files format**

The output file should contain palindromes of maximum length.

If there are few palindromes they should be placed in the natural order.

Each palindrome should be placed in a new line.

*For automation scripts to work it is desirable, but not mandatory, to file be ended with newline symbol (other words - last line in the file should be empty). Example:*

```
1| level
2| radar
3|
```

**Palindrome for the line can contain spaces only between alphanumerical symbols**

**If there are leading and trailing spaces in palindrome - please trim it!**




