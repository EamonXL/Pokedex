package Model;
/**
 * Creates a Pokemon object that stores all necessary information for all Pokemon
 * added to the PokeMap.
 *
 @author Eamon Challinor
 @version 0.1
 */
public class Pokemon {
    /**
     * Name of Pokemon.
     */
    private String pokemonName;
    /**
     * Pokemon ID number based on official ID.
     */
    private int pokemonID;
    /**
     * Elemental typing of Pokemon.
     */
    private String pokemonType1;
    /**
     * Second elemental typing of Pokemon if it has one.
     */
    private String pokemonType2;
    /**
     * String representation of content root path for Pokemon sprite.
     */
    private String image;
    /**
     * String representation of content root path for Pokemon sprite.
     */
    private int typeNumber;
    /**
     * Color hexcode based on Pokemon primary type.
     */
    private String color;
    /**
     * Constructor for Pokemon class if Pokemon has one type.
     *
     * @param pokemonName name of Pokemon.
     * @param pokemonID ID of Pokemon.
     * @param pokemonType first type of Pokemon.
     * @param image content root path of Pokemon sprite.
     * @param color color based on Pokemon type.
     * @param typeNumber number of Pokemon types.
     */
    public Pokemon(String pokemonName, int pokemonID, String pokemonType, String image, String color, int typeNumber) {
        this.pokemonName = pokemonName;
        this.pokemonID = pokemonID;
        this.pokemonType1 = pokemonType;
        this.image = image;
        this.typeNumber = typeNumber;
        this.color = color;
    }
    /**
     * Constructor for Pokemon class if Pokemon has two types.
     *
     * @param pokemonName name of Pokemon.
     * @param pokemonID ID of Pokemon.
     * @param pokemonType first type of Pokemon.
     * @param pokemonType2 second type of Pokemon.
     * @param image content root path of Pokemon sprite.
     * @param color color based on Pokemon type.
     * @param typeNumber number of Pokemon types.
     */
    public Pokemon(String pokemonName, int pokemonID, String pokemonType, String pokemonType2, String image, String color, int typeNumber) {
        this.pokemonName = pokemonName;
        this.pokemonID = pokemonID;
        this.pokemonType1 = pokemonType;
        this.pokemonType2 = pokemonType2;
        this.image = image;
        this.typeNumber = typeNumber;
        this.color = color;
    }
    /**
     * Getter for Pokemon name.
     */
    public String getPokemonName() {
        return pokemonName;
    }
    /**
     * Getter for Pokemon name.
     */
    public String getPokemonType1() {
        return pokemonType1;
    }
    /**
     * Getter for Pokemon type 1.
     */
    public String getPokemonType2() {
        return pokemonType2;
    }
    /**
     * Getter for Pokemon type 2.
     */
    public String getImage() {
        return image;
    }
    /**
     * Getter for Pokemon type number.
     */
    public int getTypeNumber() {
        return typeNumber;
    }
    /**
     * Getter for Pokemon color.
     */
    public String getColor() { return color; }
    @Override
    public String toString() {
        return "\nName: " + pokemonName + "\nLevel: " + "\nID: " + pokemonID + "\nType: " + pokemonType1;
    }

}