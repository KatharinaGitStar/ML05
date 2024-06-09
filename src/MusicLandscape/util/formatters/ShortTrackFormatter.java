package MusicLandscape.util.formatters;
import MusicLandscape.entities.Track;

public class ShortTrackFormatter extends Object implements MyFormatter<Track>{

    public ShortTrackFormatter() {}

    @Override
    public String header(){
        return "Title    (min:sec)";
    }
    @Override
    public String format(Track t) {
        String title = String.format("%-10s", t.getTitle()); // Ensure title is exactly ten characters wide
        String duration = formatDuration(t.getDuration()); // Format duration as "min:sec"
        return title + " (" + duration + ")";
    }

    @Override
    public String toString() {
        return "short format [Title (min:sec)]";
    }

    //top separator consists of dashes (-) only. It is exactly as wide as the header.
    @Override
    public String topSeparator(){
        return "---------- (------)";
    }
}
