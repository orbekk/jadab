Jadab - A Data Binding framework for Android
============================================

Usage
-----

The framework is located in the Jadab/ subdirectory as a Maven project. See
http://code.google.com/p/maven-android-plugin/wiki/GettingStarted for an
introduction to Android development with Maven. In particular, make sure you
have the `ANDROID_HOME` environment variable set.

Clone the repository and install Jadab into your local Maven repository:

    $ git clone git://github.com/orbekk/jadab.git
    $ cd jadab/Jadab
    $ mvn test                           # Run Robolectric tests
    $ mvn install

Now you should be able to build and run JadabExample.

    $ cd ../JadabExample
    $ mvn help:describe -Dplugin=android # See the available Android goals.
    $ mvn package android:deploy         # Upload to device.


Background
----------

Data Bindings was created in a project with [NTNU][1] and [Capgemini][2].  Our
project group had the task of exploring different ways of unit testing Android
user interfaces, and data bindings was one of the suggestions from our
supervisor, Alex York at Capgemini. Data bindings is not supported on the
Android platform, so we had to create our own.

The project group consisted of:

* Ben Sadeh
* Kjetil Ørbekk
* Lene Oddli Sundli
* Magnus Eide
* Njaal C. A. Gjerde

Some of the Android interaction was inspired by [android-binding][3].


[1]: http://ntnu.no
[2]: http://www.capgemini.com
[3]: http://code.google.com/p/android-binding/
[4]: http://pivotal.github.com/robolectric/
