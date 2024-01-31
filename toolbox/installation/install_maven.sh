#!/bin/bash

# download and install
MAVEN_VERSION=3.9.6
wget https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.zip
sudo unzip apache-maven-${MAVEN_VERSION}-bin.zip -d /opt
sudo ln -sfn /opt/apache-maven-${MAVEN_VERSION} /opt/maven
sudo sh -c 'echo MAVEN_HOME=/opt/maven >> /etc/environment'
sudo ln -sfn /opt/maven/bin/mvn /usr/bin/mvn

# check installation
mvn -version

#cleanup
rm apache-maven-${MAVEN_VERSION}-bin.zip
