import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class GameEngine {
    private boolean running;
    
    public void start() {
        init();
        gameLoop();
        cleanUp();
    }
    
    private void init() {
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (Exception e) {
            System.err.println("Error initializing display: " + e.getMessage());
            System.exit(1);
        }
        
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 0, 600, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        
        running = true;
    }
    
    private void gameLoop() {
        while (running && !Display.isCloseRequested()) {
            update();
            render();
            Display.update();
        }
    }
    
    private void update() {
        // Update game objects and handle user input
    }
    
    private void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glLoadIdentity();
        
        // Render game objects
    }
    
    private void cleanUp() {
        Display.destroy();
    }
    
    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        engine.start();
    }
}
