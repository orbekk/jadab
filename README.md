A data binding framework for use with Android
=============================================

Usage
-----

The framework is organized as several Eclipse projects. We plan to move to a
Maven based project setup, but at the time of writing the source code, we were
using a pure Eclipse/Android setup.

* **DataBinding**: The Data Binding framework. Defines `Property`. Properties can be bound to each other.
* **DataBindingAndroid**: Allows using Data Bindings for Android components. Currently an extremely small subset of Android properties is supported.
* **DataBindingAndroidRobolectricTest**: Test project for `DataBindingAndroid`. Uses [Robolectric][4] to unit test the framework components.
* **DbaCalculator**: A small example project using the data binding framework.

To use the framework, first import all the projects in your Eclipse workspace:

1. File -> New -> Java project.
2. Select "Create project from existing source."
3. Find the project you want to import. Click finish.

Then define the classpath variables used by DataBinding:

1. Window -> Preferences -> Java -> Build path -> Classpath variables
2. Select new.
3. Define the following variable:

    Name: Android8Jar
    File: Browse to $YOUR_ANDROID_SDK/platforms/android-8/android.jar

4. (Optional, if you want to execute the Robolectric tests) Define the following variable:

    Name: RobolectricJar
    File: Browse to the location of the Robolectric jar file.


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
