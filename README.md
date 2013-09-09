Simple Sample
==========

This is a Sample Java Application for OpenShift JBoss cartridges, that is used to demonstrate some of the 
OpenShift basics. 

This uses the OpenShift `jbosseap` cartridge. Documentation on the cartridge can be found at: 
https://github.com/openshift/origin-server/tree/master/cartridges/openshift-origin-cartridge-jbosseap/README.md

To use this set of examles create a Java Application following the 
[online examples](https://www.openshift.com/get-started/) or with:

```
rhc create-app -a jbossexamples -t jbosseap-6
```
Following this you can pull in the code from these examples by using:

```
git remote add examples https://github.com/gssOpenShiftsupportExamples/JavaSample.git
git fetch examples
git checkout master; git merge --strategy=recursive -X theirs examples/master
git push
```
- **Note:** Then change in the merge strategy is so you can avoid conflicts. 

You can then navigate to **http://APP_NAME-NAMESPACE.rhcloud.com/example/** to see this samle in action.

What this example demonstrates
==========

The objectives of this example are fairly simple, and are designed as a starting point for most new developers 
or individuals who are simply new to **OpenShift**. 
- Demonstrate how to create an Application (shown above) 
- Demonstrate how to pull in code from an exsisting repository with `git remotes` (shown above)
- Demonstrate how to push code to your gear and do a `maven` build (explained below; shown above)
- Demonstrate how to change the version of Java that the container used (explained in the war)
- Demonstrate how to deploy a binary artificat (explained in the war)

Of the item that are not already covered (above) this example contains a 
[simple servelet](https://github.com/gssOpenShiftsupportExamples/JavaSample/blob/master/src/main/java/Sample.java) 
that is maped to 
[ExampleServlet](https://github.com/gssOpenShiftsupportExamples/JavaSample/blob/master/src/main/webapp/WEB-INF/web.xml#L18-L26)
when the examle.war is deployed. This servelet is simply used demonstrate the basics to creating 
custom java code and how to place that with in a WAR. This example (if you use the links provided) can also show you 
how to wire up servelet maps so that HTTP request made to the container can be serviced by the servelet. 

The example.war can be build from scratch using 
[maven](https://github.com/gssOpenShiftsupportExamples/JavaSample/blob/master/pom.xml#L65) and the `openshift` profile. 
The reason this is demonstrated in this manner is so that you can see the differenc between an example build from 
source vs an example deployed as a binary (thus demonstrating 2 of the above objectives). 

For more information on this 
see the deployed war at: **http://APP_NAME-NAMESPACE.rhcloud.com/example/** as it explains how to continue this example
and deploy a binary artifact. 

To see what `maven` will do when you push the code to the gear (or to simply test code modifications localy) simply run 
(the following) at the root of your git repository. It will simulate what happens on a `git push` or what happens when a
build is done. 

```
mvn -e clean package -Popenshift -DskipTests
```

The [maven](https://github.com/gssOpenShiftsupportExamples/JavaSample/blob/master/pom.xml#L65) command (as demonstraged 
above) simply builds the java code (the example servelet and bundles up the other resources) to create the 
example.war file. It then places this war file into the deployments direcory of your git repository on the gear, 
completing the build. 

- **Note:** The built war file is not checked-in or commited to the git repository. 
