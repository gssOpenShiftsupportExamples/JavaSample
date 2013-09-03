=======
JavaSample
==========

This is a Sample Java Application for OpenShift JBoss cartridges, that is used to demonstrate some of the OpenShift basics. 

This uses the OpenShift `jbosseap` cartridge. Documentation on the cartridge can be found at: https://github.com/openshift/origin-server/tree/master/cartridges/openshift-origin-cartridge-jbosseap/README.md

To use this set of examles create a Java Application following the [online examples](https://www.openshift.com/get-started/) or with:

```
rhc create-app -a jbossexamples -t jbosseap-6
```
Following this you can pull in the code from these examples by using:

```
git remote add examples https://github.com/gssOpenShiftsupportExamples/JavaSample.git
git fetch examples
git checkout master; git merge examples/master
git push
```

You can then navigate to http://APP_NAME-NAMESPACE.rhcloud.com/examle/ to see this samle in action. 

=======
What these example demonstrates
==========

This is a [simple servelet example](https://github.com/gssOpenShiftsupportExamples/JavaSample/blob/master/src/main/java/Sample.java) 
that is maped to [ExampleServlet](https://github.com/gssOpenShiftsupportExamples/JavaSample/blob/master/src/main/webapp/WEB-INF/web.xml#L18-L26)
when the examle.war is build using [maven](https://github.com/gssOpenShiftsupportExamples/JavaSample/blob/master/pom.xml#L65). 

To see this build work in action simply run at the root of your git repository: 

```
mvn clean package -P openshift
```
