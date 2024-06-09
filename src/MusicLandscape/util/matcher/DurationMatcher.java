package MusicLandscape.util.matcher;

public class DurationMatcher  extends myMatcher <Track>{
    private int lower;
    private int upper;

    public DurationMatcher() {
        this.lower = Integer.MIN_VALUE;
        this.upper = Integer.MAX_VALUE;
    }

    public DurationMatcher(String pat){
        setPattern(pat);
    }

    @Override
    public boolean matches(Track t) {
        if(t == null) {
            return false;
        }
        int duration = t.getDuration();
        return duration >= lower && duration <= upper;
    }

    @Override
    public String getPatter(){
        return lower + " " + upper;
    }

    @Override
    public void setPattern(String pat) {
        if (pat == null || pat.trim().isEmpty()) {
            // If pattern is empty or null, match any duration
            this.lower = Integer.MIN_VALUE;
            this.upper = Integer.MAX_VALUE;
            return;
        }
        String[] bounds = pat.trim().split("\\s+");
        try {
            int newLower = Integer.parseInt(bounds[0]);
            int newUpper = bounds.length > 1 ? Integer.parseInt(bounds[1]) : newLower;
            // Set bounds only if new bounds are valid (lower <= upper)
            if (newLower <= newUpper) {
                this.lower = newLower;
                this.upper = newUpper;
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // If parsing fails or bounds are invalid, match any duration
            this.lower = Integer.MIN_VALUE;
            this.upper = Integer.MAX_VALUE;
        }
    }

    @Override
    public String toString() {
        return "duration in range (" + getPattern() + ")";
    }
}
