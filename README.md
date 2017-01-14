# HDFSKerberosCheck

This code successfully works on Kerberized Cloudera 5.8.0 Environment (VirtualBox).


### Example how to run:

```
java -cp <Dependant Libraries>:hdfskerberoscheck_2.10-1.0.jar com.progrexor.hadoop.HDFSKerberosCheck \
    /etc/hadoop/conf.cloudera.yarn/core-site.xml \     #
    /etc/hadoop/conf.cloudera.yarn/hdfs-site.xml \     #
    "cloudera-scm/admin" \                             # Principal
    /home/cloudera/cloudera-scm.keytab \               # Keytab
    hdfs://quickstart.cloudera                         # Namenode
```

### To create Keytab

```
ktutil
ktutil:  addent -password -p cloudera-scm/admin@CLOUDERA -k 1 -e rc4-hmac
Password for cloudera-scm/admin@CLOUDERA: [enter your password]
ktutil:  wkt cloudera-scm.keytab
ktutil:  quit
```

### Useful links:
http://henning.kropponline.de/2016/02/14/a-secure-hdfs-client-example/
https://www.cloudera.com/documentation/enterprise/5-2-x/topics/cdh_sg_princ_auth_java.html
