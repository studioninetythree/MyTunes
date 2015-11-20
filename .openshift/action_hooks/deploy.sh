#!/bin/bash

set -x

if [ ! -d $OPENSHIFT_DATA_DIR/m2/repository ]
        then
                cd $OPENSHIFT_DATA_DIR
                mkdir m2/repository
fi

if [ ! -d $OPENSHIFT_DATA_DIR/logs ]
        then
                cd $OPENSHIFT_DATA_DIR
                mkdir logs
fi

if [ ! -d $OPENSHIFT_DATA_DIR/apache-maven-3.3.3 ]
        then
                cd $OPENSHIFT_DATA_DIR
                wget http://apache.is.co.za/maven/maven-3/3.3.3/binaries/apache-maven-3.3.3-bin.tar.gz
                tar xvf *.tar.gz
                rm -f *.tar.gz
fi


cd $OPENSHIFT_REPO_DIR
export M2=$OPENSHIFT_DATA_DIR/apache-maven-3.3.3/bin
export MAVEN_OPTS="-Xms384m -Xmx412m"

mvn -s settings.xml clean install