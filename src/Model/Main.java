package Model;

import View.PokedexGUI;
import javax.swing.SwingUtilities;
/**
* This program creates a Pokedex based on a map storing data about different Pokemon.
* A visual GUI using the Java Swing API is created simulating a Pokedex for the original 151 Pokemon.
*
@author Eamon Challinor
@version 0.1
 */
public class Main {
    /**
     * A map called pokeMap is created using a hashmap to store all key attributes all original 151 Pokemon.
     * An instance of the Pokedex is initialized for the GUI to be created with data from the pokeMap.
     *
     @param theArgs command line argument.
     */
    public static void main(String[] theArgs) {
        PokeMap pokeMap = new PokeMap();
        pokeMap.put(1, new Pokemon("Bulbasaur", 1, "Grass", "Poison", "src/View/res/bulbasaur.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(2, new Pokemon("Ivysaur", 2, "Grass", "Poison", "src/View/res/ivysaur.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(3, new Pokemon("Venusaur", 3, "Grass", "Poison", "src/View/res/venusaur.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(4, new Pokemon("Charmander", 4, "Fire", "src/View/res/charmander.png", PokemonColor.FIRE.getHexCode(), 1));
        pokeMap.put(5, new Pokemon("Charmeleon", 5, "Fire", "src/View/res/charmeleon.png", PokemonColor.FIRE.getHexCode(), 1));
        pokeMap.put(6, new Pokemon("Charizard", 6, "Fire", "Flying", "src/View/res/charizard.png", PokemonColor.FIRE.getHexCode(), 2));
        pokeMap.put(7, new Pokemon("Squirtle", 7, "Water", "src/View/res/squirtle.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(8, new Pokemon("Wartortle", 8, "Water", "src/View/res/wartortle.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(9, new Pokemon("Blastoise", 9, "Water", "src/View/res/blastoise.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(10, new Pokemon("Caterpie", 10, "Bug", "src/View/res/caterpie.png", PokemonColor.BUG.getHexCode(), 1));

        pokeMap.put(11, new Pokemon("Metapod", 11, "Bug", "src/View/res/metapod.png", PokemonColor.BUG.getHexCode(), 1));
        pokeMap.put(12, new Pokemon("Butterfree", 12, "Bug", "Flying", "src/View/res/butterfree.png", PokemonColor.BUG.getHexCode(), 2));
        pokeMap.put(13, new Pokemon("Weedle", 13, "Bug", "Poison", "src/View/res/weedle.png", PokemonColor.BUG.getHexCode(), 2));
        pokeMap.put(14, new Pokemon("Kakuna", 14, "Bug", "Poison", "src/View/res/kakuna.png", PokemonColor.BUG.getHexCode(), 2));
        pokeMap.put(15, new Pokemon("Beedrill", 15, "Bug", "Poison", "src/View/res/beedrill.png", PokemonColor.BUG.getHexCode(), 2));
        pokeMap.put(16, new Pokemon("Pidgey", 16, "Flying", "Normal", "src/View/res/pidgey.png", PokemonColor.FLYING.getHexCode(), 2));
        pokeMap.put(17, new Pokemon("Pidgeotto", 17, "Flying", "Normal", "src/View/res/pidgeotto.png", PokemonColor.FLYING.getHexCode(), 2));
        pokeMap.put(18, new Pokemon("Pidgeot", 18, "Flying", "Normal", "src/View/res/pidgeot.png", PokemonColor.FLYING.getHexCode(), 2));
        pokeMap.put(19, new Pokemon("Rattata", 19, "Normal", "src/View/res/rattata.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(20, new Pokemon("Raticate", 20, "Normal", "src/View/res/raticate.png", PokemonColor.NORMAL.getHexCode(), 1));

        pokeMap.put(21, new Pokemon("Spearow", 21, "Flying", "Normal", "src/View/res/spearow.png", PokemonColor.FLYING.getHexCode(), 2));
        pokeMap.put(22, new Pokemon("Fearow", 22, "Flying", "Normal", "src/View/res/fearow.png", PokemonColor.FLYING.getHexCode(), 2));
        pokeMap.put(23, new Pokemon("Ekans", 23, "Poison", "src/View/res/ekans.png", PokemonColor.POISON.getHexCode(), 1));
        pokeMap.put(24, new Pokemon("Arbok", 24, "Poison", "src/View/res/arbok.png", PokemonColor.POISON.getHexCode(), 1));
        pokeMap.put(25, new Pokemon("Pikachu", 25, "Electric", "src/View/res/pikachu.png", PokemonColor.ELECTRIC.getHexCode(), 1));
        pokeMap.put(26, new Pokemon("Raichu", 26, "Electric", "src/View/res/raichu.png", PokemonColor.ELECTRIC.getHexCode(), 1));
        pokeMap.put(27, new Pokemon("Sandshrew", 27, "Ground", "src/View/res/sandshrew.png", PokemonColor.GROUND.getHexCode(), 2));
        pokeMap.put(28, new Pokemon("Sandslash", 28, "Ground", "src/View/res/sandslash.png", PokemonColor.GROUND.getHexCode(), 2));
        pokeMap.put(29, new Pokemon("Nidoran (F)", 29, "Poison", "src/View/res/nidoran-f.png", PokemonColor.POISON.getHexCode(), 1));
        pokeMap.put(30, new Pokemon("Nidorina", 30, "Poison", "src/View/res/nidorina.png", PokemonColor.POISON.getHexCode(), 1));

        pokeMap.put(31, new Pokemon("Nidoqueen", 31, "Poison", "Ground", "src/View/res/nidoqueen.png", PokemonColor.POISON.getHexCode(), 2));
        pokeMap.put(32, new Pokemon("Nidoran (M)", 32, "Poison", "src/View/res/nidoran-m.png", PokemonColor.POISON.getHexCode(), 2));
        pokeMap.put(33, new Pokemon("Nidorino", 33, "Poison", "src/View/res/nidorino.png", PokemonColor.POISON.getHexCode(), 2));
        pokeMap.put(34, new Pokemon("Nidoking", 34, "Poison", "Ground", "src/View/res/nidoking.png", PokemonColor.POISON.getHexCode(), 2));
        pokeMap.put(35, new Pokemon("Clefairy", 35, "Normal", "Fairy", "src/View/res/clefairy.png", PokemonColor.NORMAL.getHexCode(), 2));
        pokeMap.put(36, new Pokemon("Clefable", 36, "Normal", "Fairy", "src/View/res/clefable.png", PokemonColor.NORMAL.getHexCode(), 2));
        pokeMap.put(37, new Pokemon("Vulpix", 37, "Fire", "src/View/res/vulpix.png", PokemonColor.FIRE.getHexCode(), 2));
        pokeMap.put(38, new Pokemon("Ninetales", 38, "Fire", "src/View/res/ninetales.png", PokemonColor.FIRE.getHexCode(), 2));
        pokeMap.put(39, new Pokemon("Jigglypuff", 39, "Normal", "Fairy", "src/View/res/jigglypuff.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(40, new Pokemon("Wigglytuff", 40, "Normal", "Fairy", "src/View/res/wigglytuff.png", PokemonColor.NORMAL.getHexCode(), 1));

        pokeMap.put(41, new Pokemon("Zubat", 41, "Poison", "Flying", "src/View/res/zubat.png", PokemonColor.POISON.getHexCode(), 2));
        pokeMap.put(42, new Pokemon("Golbat", 42, "Poison", "Flying", "src/View/res/golbat.png", PokemonColor.POISON.getHexCode(), 2));
        pokeMap.put(43, new Pokemon("Oddish", 43, "Grass", "Poison", "src/View/res/oddish.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(44, new Pokemon("Gloom", 44, "Grass", "Poison", "src/View/res/gloom.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(45, new Pokemon("Vileplume", 45, "Grass", "Poison", "src/View/res/vileplume.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(46, new Pokemon("Paras", 46, "Bug", "Grass", "src/View/res/paras.png", PokemonColor.BUG.getHexCode(), 2));
        pokeMap.put(47, new Pokemon("Parasect", 47, "Bug", "Grass", "src/View/res/parasect.png", PokemonColor.BUG.getHexCode(), 2));
        pokeMap.put(48, new Pokemon("Venonat", 48, "Bug", "Poison", "src/View/res/venonat.png", PokemonColor.BUG.getHexCode(), 2));
        pokeMap.put(49, new Pokemon("Venomoth", 49, "Bug", "Poison", "src/View/res/venomoth.png", PokemonColor.BUG.getHexCode(), 2));
        pokeMap.put(50, new Pokemon("Diglett", 50, "Ground", "src/View/res/diglett.png", PokemonColor.GROUND.getHexCode(), 1));

        pokeMap.put(51, new Pokemon("Dugtrio", 51, "Ground", "src/View/res/dugtrio.png", PokemonColor.GROUND.getHexCode(), 1));
        pokeMap.put(52, new Pokemon("Meowth", 52, "Normal", "src/View/res/meowth.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(53, new Pokemon("Persian", 53, "Normal", "src/View/res/persian.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(54, new Pokemon("Psyduck", 54, "Water", "src/View/res/psyduck.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(55, new Pokemon("Golduck", 55, "Water", "src/View/res/golduck.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(56, new Pokemon("Mankey", 56, "Fighting", "src/View/res/mankey.png", PokemonColor.FIGHTING.getHexCode(), 1));
        pokeMap.put(57, new Pokemon("Primeape", 57, "Fighting", "src/View/res/primeape.png", PokemonColor.FIGHTING.getHexCode(), 1));
        pokeMap.put(58, new Pokemon("Growlithe", 58, "Fire", "src/View/res/growlithe.png", PokemonColor.FIRE.getHexCode(), 1));
        pokeMap.put(59, new Pokemon("Arcanine", 59, "Fire", "src/View/res/arcanine.png", PokemonColor.FIRE.getHexCode(), 1));
        pokeMap.put(60, new Pokemon("Poliwag", 60, "Water", "src/View/res/poliwag.png", PokemonColor.WATER.getHexCode(), 1));

        pokeMap.put(61, new Pokemon("Poliwhirl", 61, "Water", "src/View/res/poliwhirl.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(62, new Pokemon("Poliwrath", 62, "Water", "Fighting", "src/View/res/poliwrath.png", PokemonColor.WATER.getHexCode(), 2));
        pokeMap.put(63, new Pokemon("Abra", 63, "Psychic", "src/View/res/abra.png", PokemonColor.PSYCHIC.getHexCode(), 1));
        pokeMap.put(64, new Pokemon("Kadabra", 64, "Psychic", "src/View/res/kadabra.png", PokemonColor.PSYCHIC.getHexCode(), 1));
        pokeMap.put(65, new Pokemon("Alakazam", 65, "Psychic", "src/View/res/alakazam.png", PokemonColor.PSYCHIC.getHexCode(), 1));
        pokeMap.put(66, new Pokemon("Machop", 66, "Fighting", "src/View/res/machop.png", PokemonColor.FIGHTING.getHexCode(), 1));
        pokeMap.put(67, new Pokemon("Machoke", 67, "Fighting", "src/View/res/machoke.png", PokemonColor.FIGHTING.getHexCode(), 1));
        pokeMap.put(68, new Pokemon("Machamp", 68, "Fighting", "src/View/res/machamp.png", PokemonColor.FIGHTING.getHexCode(), 1));
        pokeMap.put(69, new Pokemon("Bellsprout", 69, "Grass", "Poison", "src/View/res/bellsprout.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(70, new Pokemon("Weepinbell", 70, "Grass", "Poison", "src/View/res/weepinbell.png", PokemonColor.GRASS.getHexCode(), 2));

        pokeMap.put(71, new Pokemon("Victreebel", 71, "Grass", "Poison", "src/View/res/victreebel.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(72, new Pokemon("Tentacool", 72, "Water", "Poison", "src/View/res/tentacool.png", PokemonColor.WATER.getHexCode(), 2));
        pokeMap.put(73, new Pokemon("Tentacruel", 73, "Water", "Poison", "src/View/res/tentacruel.png", PokemonColor.WATER.getHexCode(), 2));
        pokeMap.put(74, new Pokemon("Geodude", 74, "Rock", "Ground", "src/View/res/geodude.png", PokemonColor.ROCK.getHexCode(), 2));
        pokeMap.put(75, new Pokemon("Graveler", 75, "Rock", "Ground", "src/View/res/graveler.png", PokemonColor.ROCK.getHexCode(), 2));
        pokeMap.put(76, new Pokemon("Golem", 76, "Rock", "Ground", "src/View/res/golem.png", PokemonColor.ROCK.getHexCode(), 2));
        pokeMap.put(77, new Pokemon("Ponyta", 77, "Fire", "src/View/res/ponyta.png", PokemonColor.FIRE.getHexCode(), 1));
        pokeMap.put(78, new Pokemon("Rapidash", 78, "Fire", "src/View/res/rapidash.png", PokemonColor.FIRE.getHexCode(), 1));
        pokeMap.put(79, new Pokemon("Slowpoke", 79, "Water", "Psychic", "src/View/res/slowpoke.png", PokemonColor.WATER.getHexCode(), 2));
        pokeMap.put(80, new Pokemon("Slowbro", 80, "Water", "Psychic", "src/View/res/slowbro.png", PokemonColor.WATER.getHexCode(), 2));

        pokeMap.put(81, new Pokemon("Magnemite", 81, "Electric", "src/View/res/magnemite.png", PokemonColor.ELECTRIC.getHexCode(), 1));
        pokeMap.put(82, new Pokemon("Magneton", 82, "Electric", "src/View/res/magneton.png", PokemonColor.ELECTRIC.getHexCode(), 1));
        pokeMap.put(83, new Pokemon("Farfetch'd", 83, "Normal", "Flying", "src/View/res/farfetchd.png", PokemonColor.NORMAL.getHexCode(), 2));
        pokeMap.put(84, new Pokemon("Doduo", 84, "Normal", "Flying", "src/View/res/doduo.png", PokemonColor.NORMAL.getHexCode(), 2));
        pokeMap.put(85, new Pokemon("Dodrio", 85, "Normal", "Flying", "src/View/res/dodrio.png", PokemonColor.NORMAL.getHexCode(), 2));
        pokeMap.put(86, new Pokemon("Seel", 86, "Water", "src/View/res/seel.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(87, new Pokemon("Dewgong", 87, "Water", "Ice", "src/View/res/dewgong.png", PokemonColor.WATER.getHexCode(), 2));
        pokeMap.put(88, new Pokemon("Grimer", 88, "Poison", "src/View/res/grimer.png", PokemonColor.POISON.getHexCode(), 1));
        pokeMap.put(89, new Pokemon("Muk", 89, "Poison", "src/View/res/muk.png", PokemonColor.POISON.getHexCode(), 1));
        pokeMap.put(90, new Pokemon("Shellder", 90, "Water", "src/View/res/shellder.png", PokemonColor.WATER.getHexCode(), 1));

        pokeMap.put(91, new Pokemon("Cloyster", 91, "Water", "Ice", "src/View/res/cloyster.png", PokemonColor.WATER.getHexCode(), 2));
        pokeMap.put(92, new Pokemon("Gastly", 92, "Ghost", "Poison", "src/View/res/gastly.png", PokemonColor.GHOST.getHexCode(), 2));
        pokeMap.put(93, new Pokemon("Haunter", 93, "Ghost", "Poison", "src/View/res/haunter.png", PokemonColor.GHOST.getHexCode(), 2));
        pokeMap.put(94, new Pokemon("Gengar", 94, "Ghost", "Poison", "src/View/res/gengar.png", PokemonColor.GHOST.getHexCode(), 2));
        pokeMap.put(95, new Pokemon("Onix", 95, "Rock", "Ground", "src/View/res/onix.png", PokemonColor.ROCK.getHexCode(), 2));
        pokeMap.put(96, new Pokemon("Drowzee", 96, "Psychic", "src/View/res/drowzee.png", PokemonColor.PSYCHIC.getHexCode(), 1));
        pokeMap.put(97, new Pokemon("Hypno", 97, "Psychic", "src/View/res/hypno.png", PokemonColor.PSYCHIC.getHexCode(), 1));
        pokeMap.put(98, new Pokemon("Krabby", 98, "Water", "src/View/res/krabby.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(99, new Pokemon("Kingler", 99, "Water", "src/View/res/kingler.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(100, new Pokemon("Voltorb", 100, "Electric", "src/View/res/voltorb.png", PokemonColor.ELECTRIC.getHexCode(), 1));

        pokeMap.put(101, new Pokemon("Electrode", 101, "Electric", "src/View/res/electrode.png", PokemonColor.ELECTRIC.getHexCode(), 1));
        pokeMap.put(102, new Pokemon("Exeggcute", 102, "Grass", "Psychic", "src/View/res/exeggcute.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(103, new Pokemon("Exeggutor", 103, "Grass", "Psychic", "src/View/res/exeggutor.png", PokemonColor.GRASS.getHexCode(), 2));
        pokeMap.put(104, new Pokemon("Cubone", 104, "Ground", "src/View/res/cubone.png", PokemonColor.GROUND.getHexCode(), 1));
        pokeMap.put(105, new Pokemon("Marowak", 105, "Ground", "src/View/res/marowak.png", PokemonColor.GROUND.getHexCode(), 1));
        pokeMap.put(106, new Pokemon("Hitmonlee", 106, "Fighting", "src/View/res/hitmonlee.png", PokemonColor.FIGHTING.getHexCode(), 1));
        pokeMap.put(107, new Pokemon("Hitmonchan", 107, "Fighting", "src/View/res/hitmonchan.png", PokemonColor.FIGHTING.getHexCode(), 1));
        pokeMap.put(108, new Pokemon("Lickitung", 108, "Normal", "src/View/res/lickitung.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(109, new Pokemon("Koffing", 109, "Poison", "src/View/res/koffing.png", PokemonColor.POISON.getHexCode(), 1));
        pokeMap.put(110, new Pokemon("Weezing", 110, "Poison", "src/View/res/weezing.png", PokemonColor.POISON.getHexCode(), 1));

        pokeMap.put(111, new Pokemon("Rhyhorn", 111, "Ground", "Rock", "src/View/res/rhyhorn.png", PokemonColor.GROUND.getHexCode(), 2));
        pokeMap.put(112, new Pokemon("Rhydon", 112, "Ground", "Rock", "src/View/res/rhydon.png", PokemonColor.GROUND.getHexCode(), 2));
        pokeMap.put(113, new Pokemon("Chansey", 113, "Normal", "src/View/res/chansey.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(114, new Pokemon("Tangela", 114, "Grass", "src/View/res/tangela.png", PokemonColor.GRASS.getHexCode(), 1));
        pokeMap.put(115, new Pokemon("Kangaskhan", 115, "Normal", "src/View/res/kangaskhan.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(116, new Pokemon("Horsea", 116, "Water", "src/View/res/horsea.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(117, new Pokemon("Seadra", 117, "Water", "src/View/res/seadra.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(118, new Pokemon("Goldeen", 118, "Water", "src/View/res/goldeen.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(119, new Pokemon("Seaking", 119, "Water", "src/View/res/seaking.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(120, new Pokemon("Staryu", 120, "Water", "src/View/res/staryu.png", PokemonColor.WATER.getHexCode(), 1));

        pokeMap.put(121, new Pokemon("Starmie", 121, "Water", "Psychic", "src/View/res/starmie.png", PokemonColor.WATER.getHexCode(), 2));
        pokeMap.put(122, new Pokemon("Mr. Mime", 122, "Psychic", "src/View/res/mr-mime.png", PokemonColor.PSYCHIC.getHexCode(), 1));
        pokeMap.put(123, new Pokemon("Scyther", 123, "Bug", "Flying", "src/View/res/scyther.png", PokemonColor.BUG.getHexCode(), 2));
        pokeMap.put(124, new Pokemon("Jynx", 124, "Ice", "Psychic", "src/View/res/jynx.png", PokemonColor.ICE.getHexCode(), 2));
        pokeMap.put(125, new Pokemon("Electabuzz", 125, "Electric", "src/View/res/electabuzz.png", PokemonColor.ELECTRIC.getHexCode(), 1));
        pokeMap.put(126, new Pokemon("Magmar", 126, "Fire", "src/View/res/magmar.png", PokemonColor.FIRE.getHexCode(), 1));
        pokeMap.put(127, new Pokemon("Pinsir", 127, "Bug", "src/View/res/pinsir.png", PokemonColor.BUG.getHexCode(), 1));
        pokeMap.put(128, new Pokemon("Tauros", 128, "Normal", "src/View/res/tauros.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(129, new Pokemon("Magikarp", 129, "Water", "src/View/res/magikarp.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(130, new Pokemon("Gyarados", 130, "Water", "Flying", "src/View/res/gyarados.png", PokemonColor.WATER.getHexCode(), 2));

        pokeMap.put(131, new Pokemon("Lapras", 131, "Water", "Ice", "src/View/res/lapras.png", PokemonColor.WATER.getHexCode(), 2));
        pokeMap.put(132, new Pokemon("Ditto", 132, "Normal", "src/View/res/ditto.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(133, new Pokemon("Eevee", 133, "Normal", "src/View/res/eevee.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(134, new Pokemon("Vaporeon", 134, "Water", "src/View/res/vaporeon.png", PokemonColor.WATER.getHexCode(), 1));
        pokeMap.put(135, new Pokemon("Jolteon", 135, "Electric", "src/View/res/jolteon.png", PokemonColor.ELECTRIC.getHexCode(), 1));
        pokeMap.put(136, new Pokemon("Flareon", 136, "Fire", "src/View/res/flareon.png", PokemonColor.FIRE.getHexCode(), 1));
        pokeMap.put(137, new Pokemon("Porygon", 137, "Normal", "src/View/res/porygon.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(138, new Pokemon("Omanyte", 138, "Rock", "Water", "src/View/res/omanyte.png", PokemonColor.ROCK.getHexCode(), 2));
        pokeMap.put(139, new Pokemon("Omastar", 139, "Rock", "Water", "src/View/res/omastar.png", PokemonColor.ROCK.getHexCode(), 2));
        pokeMap.put(140, new Pokemon("Kabuto", 140, "Rock", "Water", "src/View/res/kabuto.png", PokemonColor.ROCK.getHexCode(), 2));

        pokeMap.put(141, new Pokemon("Kabutops", 141, "Rock", "Water", "src/View/res/kabutops.png", PokemonColor.ROCK.getHexCode(), 2));
        pokeMap.put(142, new Pokemon("Aerodactyl", 142, "Rock", "Flying", "src/View/res/aerodactyl.png", PokemonColor.ROCK.getHexCode(), 2));
        pokeMap.put(143, new Pokemon("Snorlax", 143, "Normal", "src/View/res/snorlax.png", PokemonColor.NORMAL.getHexCode(), 1));
        pokeMap.put(144, new Pokemon("Articuno", 144, "Ice", "Flying", "src/View/res/articuno.png", PokemonColor.ICE.getHexCode(), 2));
        pokeMap.put(145, new Pokemon("Zapdos", 145, "Electric", "Flying", "src/View/res/zapdos.png", PokemonColor.ELECTRIC.getHexCode(), 2));
        pokeMap.put(146, new Pokemon("Moltres", 146, "Fire", "Flying", "src/View/res/moltres.png", PokemonColor.FIRE.getHexCode(), 2));
        pokeMap.put(147, new Pokemon("Dratini", 147, "Dragon", "src/View/res/dratini.png", PokemonColor.DRAGON.getHexCode(), 1));
        pokeMap.put(148, new Pokemon("Dragonair", 148, "Dragon", "src/View/res/dragonair.png", PokemonColor.DRAGON.getHexCode(), 1));
        pokeMap.put(149, new Pokemon("Dragonite", 149, "Dragon", "Flying", "src/View/res/dragonite.png", PokemonColor.DRAGON.getHexCode(), 2));
        pokeMap.put(150, new Pokemon("Mewtwo", 150, "Psychic", "src/View/res/mewtwo.png", PokemonColor.PSYCHIC.getHexCode(), 1));

        pokeMap.put(151, new Pokemon("Mew", 151, "Psychic", "src/View/res/mew.png", PokemonColor.PSYCHIC.getHexCode(), 1));

        //Create PokedexGUI instance with pokeMap
        SwingUtilities.invokeLater(() -> new PokedexGUI(pokeMap));
    }
}