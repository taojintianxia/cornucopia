#!/bin/bash

# download and install
ANT_VERSION=1.10.11
wget http://archive.apache.org/dist/ant/binaries/apache-ant-${ANT_VERSION}-bin.tar.gz
sudo tar xvfvz apache-ant-${ANT_VERSION}-bin.tar.gz -C /opt
sudo ln -sfn /opt/apache-ant-${ANT_VERSION} /opt/ant
sudo sh -c 'echo ANT_HOME=/opt/ant >> /etc/environment'
sudo ln -sfn /opt/ant/bin/ant /usr/bin/ant

# check installation
ant -version

#cleanup
rm apache-ant-${ANT_VERSION}-bin.tar.gz
