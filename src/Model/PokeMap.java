package Model;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Creates a linkedHashMap representation of a pokeMap with all 151 original Pokemon.
 * The ID number of the Pokemon is used as the key and the value is a Pokemon object reference.
 *
 @author Eamon Challinor
 @version 0.1
 */
public class PokeMap {

    private final Map<Integer, Pokemon> pokemonMap = new LinkedHashMap<>();
    /**
     * Constructor for PokeMap.
     */
    public PokeMap() {
    }
    /**
     * Adds a new Pokemon to the PokeMap.
     *
     * @param id ID number of Pokemon.
     * @param p Pokemon object reference.
     */
    public void put(int id, Pokemon p) { pokemonMap.put(id, p); }
    /**
     * Uses ID to get Pokemon reference.
     *
     * @param id ID number of Pokemon.
     */
    public Pokemon getPokemon(int id) {
        return pokemonMap.get(id); }
}