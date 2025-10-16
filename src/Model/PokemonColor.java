package Model;
/**
 * Enumerators for colors based on Pokemon type.
 *
 @author Eamon Challinor
 @version 0.1
 */
public enum PokemonColor {
    FIRE("#EE8130"),       // warm orange-red
    WATER("#6390F0"),      // bright water blue
    GRASS("#7AC74C"),      // vibrant green
    ELECTRIC("#F7D02C"),   // bright yellow
    GROUND("#E2BF65"),     // earthy brownish yellow
    ROCK("#B6A136"),       // golden brown
    PSYCHIC("#F95587"),    // pink-magenta
    STEEL("#B7B7CE"),      // light gray-blue
    FIGHTING("#C22E28"),   // deep red
    BUG("#A6B91A"),        // olive green
    FLYING("#A98FF3"),     // sky purple-blue
    GHOST("#735797"),      // deep purple
    POISON("#A33EA1"),     // violet-purple
    DRAGON("#6F35FC"),     // royal purple
    ICE("#96D9D6"),        // icy aqua
    FAIRY("#D685AD"),   // pastel pink
    NORMAL("#FFFFFF");

    /**
     * Hex code representing color.
     */
    private final String hexCode;
    /**
     * Constructor for PokemonColor.
     *
     * @param hexCode hex code for color.
     */
    PokemonColor(String hexCode) {
        this.hexCode = hexCode;
    }
    /**
     * Getter for hex code.
     */
    public String getHexCode() {
        return hexCode;
    }
}