# HDFSKerberosCheck

This code successfully works on Kerberized Cloudera 5.8.0 Environment (VirtualBox).


### Example how to run:

```
java -cp <Dependant Libraries>:hdfskerberoscheck_2.10-1.0.jar com.progrexor.hadoop.HDFSKerberosCheck /etc/hadoop/conf.cloudera.yarn/core-site.xml /etc/hadoop/conf.cloudera.yarn/hdfs-site.xml "cloudera-scm/admin" /home/cloudera/cloudera-scm.keytab hdfs://quickstart.cloudera
```
