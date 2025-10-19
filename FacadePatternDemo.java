// Complex subsystem classes
class TV {
    public void on() {
        System.out.println("TV: Turning on");
    }
    
    public void off() {
        System.out.println("TV: Turning off");
    }
    
    public void setInput(String input) {
        System.out.println("TV: Setting input to " + input);
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound System: Powering on");
    }
    
    public void off() {
        System.out.println("Sound System: Powering off");
    }
    
    public void setVolume(int level) {
        System.out.println("Sound System: Volume set to " + level);
    }
}

class StreamingDevice {
    public void on() {
        System.out.println("Streaming Device: Starting up");
    }
    
    public void off() {
        System.out.println("Streaming Device: Shutting down");
    }
    
    public void play(String movie) {
        System.out.println("Streaming Device: Playing " + movie);
    }
}

// FACADE - Simplifies the complex subsystem
class HomeTheaterFacade {
    private TV tv;
    private SoundSystem sound;
    private StreamingDevice streaming;
    
    public HomeTheaterFacade() {
        this.tv = new TV();
        this.sound = new SoundSystem();
        this.streaming = new StreamingDevice();
    }
    
    // Simple interface to watch a movie (hides complexity)
    public void watchMovie(String movie) {
        System.out.println("Getting ready to watch " + movie + "...\n");
        tv.on();
        tv.setInput("HDMI 1");
        sound.on();
        sound.setVolume(20);
        streaming.on();
        streaming.play(movie);
        System.out.println("\nEnjoy your movie!");
    }
    
    public void endMovie() {
        System.out.println("\nShutting down movie theater...\n");
        streaming.off();
        sound.off();
        tv.off();
        System.out.println("All systems off!");
    }
}

// Client code
public class FacadePatternDemo {
    public static void main(String[] args) {
        // Without facade: would need 6+ method calls to watch a movie
        // With facade: just one simple method call
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        
        homeTheater.watchMovie("The Matrix");
        
        // Later...
        homeTheater.endMovie();
    }
}