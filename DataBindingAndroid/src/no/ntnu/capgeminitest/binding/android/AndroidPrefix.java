package no.ntnu.capgeminitest.binding.android;

public class AndroidPrefix {
    public static String getComponentPrefix(String name) {
        if (name == "View" || name == "ViewGroup") {
            return "android.view.";
        } else if (name.contains(".")) {
            return null;
        } else {
            return "android.widget.";
        }
    }
}
