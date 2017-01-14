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

### Useful links:
http://henning.kropponline.de/2016/02/14/a-secure-hdfs-client-example/
https://www.cloudera.com/documentation/enterprise/5-2-x/topics/cdh_sg_princ_auth_java.html
