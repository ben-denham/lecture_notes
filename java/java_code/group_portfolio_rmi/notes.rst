RMI
===

http://docs.oracle.com/javase/tutorial/rmi/

* Remote Objects get stored in the rmiregistry.
* A remote object must extend UnicastRemoteObject, implement an interface that
  extends Remote, and must have all its methods throwing RemoteException.
* The interface extending remote must have all its methods throwing
  RemoteException, and only the methods in the interface will be remotely
  callable.
* A server will store a remote object in the rmiregistry using Naming.rebind()
* A client will find an object in the rmiregistry using Naming.lookup()

Running steps
-------------

::

   javac *.java
   rmic myRemoteObject
   start rmiregsitry
   start java myRemoteServer
   java myClient
