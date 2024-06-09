package MusicLandscape.util;

import MusicLandscape.entities.Track;

public class CSVTrackFormatter extends Object implements MyFormatter <Track> {

    public CSVTrackFormatter() {}

    @Override
    public String header(){
        return "Title,Writer,Performer,duration,year";
    }

    @Override
    public String topSeparator(){
        return "";
    }

    @Override
    public String format(Track t){
        if(t == null) {
            return "";
        }
        return String.format("%s,%s,%s,%d,%d;",t.getTitle(), t.getPerformer(), t.getWriter(),t.getYear(), t.getDuration());
    }

    @Override
    public String toString(){
        return "CSV format [Title, Writer, Performer, duration, year]";
    }
}
