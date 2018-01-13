package br.unicamp.primeirossocorros.util;

public enum StoryType {
    WHAT("what", 1),
    TRAUMA("trauma", 6),
    CHOKING("choking", 6),
    SEIZURE("seizure",5),
    FAINTING("fainting",3),
    ARREST("arrest",7);

    private String description;
    private int storyLength;

    StoryType(String description, int length){
        this.description = description;
        this.storyLength = length;
    }

    public String getDescription(){
        return this.description;
    }

    public int getStoryLength() {
        return storyLength;
    }
}
