public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        Song next = this.nextSong;
        Song next_next = next == null ? null : next.nextSong;

        while (next_next != null){
            if(next == this || next_next == next){
                return true;
            }
            next = next.nextSong;
            next_next = next_next.nextSong;
            if(next_next != null){
                next_next = next_next.nextSong;
            }
        }
        return false;
//        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}