package View;

import Model.PokeMap;
import Model.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
/**
 * The PokedexGUI creates a GUI representation of a Pokedex.
 * The Pokedex can be navigated to choose any of the 151 original Pokemon
 * and learn about each Pokemon.
 *
 @author Eamon Challinor
 @version 0.1
 */
public class PokedexGUI extends JFrame {
    /**
     * The pokeMap with all the data for each Pokemon.
     */
    private final PokeMap pokeMap;
    /**
     * Central panel for main screen with list of Pokemon to select.
     */
    private JPanel centerPanel;
    /**
     * Top bar panel for title.
     */
    private final JPanel topBarPanel;
    /**
     * Custom pokemon font based on Gen V pokedex font.
     */
    private final Font customFont;
    /**
     * Index for page number start to avoid scrolling to a negative page number.
     */
    private int pageStartIndex;
    /**
     *  Current page number for selection menu.
     */
    private int pageNumber;
    /**
     * Constructs Pokedex GUI.
     *
     * @param pokemonMap an instance of the pokeMap.
     */
    public PokedexGUI(PokeMap pokemonMap) {
        super("Pokedex");
        this.pokeMap = pokemonMap;
        pageStartIndex = 0;
        pageNumber = 1;

        Font f = new Font("SansSerif", Font.PLAIN, 14);
        try (InputStream fontStream = PokedexGUI.class.getResourceAsStream(
                "/View/fonts/pokemon-black-white-black-2-and-white-2-tex.otf")) {
            if (fontStream != null) {
                f = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(20f);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(f);
            }
        } catch (Exception ignored) {}
        customFont = f;

        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.RED);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        topBarPanel = buildTopBar();
        add(topBarPanel, BorderLayout.NORTH);

        centerPanel = buildMainMenu();
        add(centerPanel, BorderLayout.CENTER);

        setSize(800, 900);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    /**
     * Creates the top bar portion of the Pokedex main menu.
     *
     */
    private JPanel buildTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
        topBar.setBackground(Color.decode("#CC0000"));
        topBar.setPreferredSize(new Dimension(800, 60));

        JLabel centerLabel = new JLabel("", SwingConstants.CENTER);
        ImageIcon header = loadIcon("src/View/res/Pokedex Simulator.png", 300, 50);
        if (header != null) centerLabel.setIcon(header);

        JPanel leftIcons = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 3));
        leftIcons.setOpaque(false);
        leftIcons.add(new DrawPanel(18, Color.decode("#ADD8A0")));
        leftIcons.add(new DrawPanel(8, Color.GREEN));
        leftIcons.add(new DrawPanel(8, Color.YELLOW));
        leftIcons.add(new DrawPanel(8, Color.RED));

        topBar.add(leftIcons, BorderLayout.WEST);
        topBar.add(centerLabel, BorderLayout.CENTER);

        return topBar;
    }
    /**
     * Creates the main menu of Pokedex to choose a Pokemon to learn more about.
     *
     */
    private JPanel buildMainMenu() {
        JPanel panelRowOne = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelRowOne.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
        panelRowOne.setBackground(Color.decode("#CC0000"));

        JButton[] buttons = new JButton[10];

        JLabel welcomeLabel = new JLabel("Welcome To Your Pokedex", SwingConstants.CENTER);
        welcomeLabel.setFont(customFont.deriveFont(Font.BOLD, 32f));
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(Color.decode("#ADD8E6"));
        welcomeLabel.setPreferredSize(new Dimension(750, 50));
        panelRowOne.add(welcomeLabel);

        for (int i = 0; i < 10; i++) {
            Pokemon poke = (pokeMap == null) ? null : pokeMap.getPokemon(i + pageStartIndex + 1);
            String label = (poke == null) ? "Empty" : poke.getPokemonName();
            buttons[i] = new JButton(label);

            BufferedImage orig = null;
            if (poke != null && poke.getImage() != null && !poke.getImage().isEmpty()) {
                orig = loadBufferedImage(poke.getImage());
            }
            if (orig != null) {
                Image smallImg = orig.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                buttons[i].setIcon(new ImageIcon(smallImg));
            }

            buttons[i].setHorizontalTextPosition(SwingConstants.CENTER);
            buttons[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            buttons[i].setIconTextGap(5);
            buttons[i].setBorder(BorderFactory.createEmptyBorder());
            buttons[i].setPreferredSize(new Dimension(150, 120));
            buttons[i].setFocusPainted(false);
            buttons[i].setContentAreaFilled(true);
            buttons[i].setBackground(Color.decode("#ADD8E6"));
            buttons[i].setFont(customFont.deriveFont(Font.BOLD, 20f));
            buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            final int idx = i;
            final Pokemon finalPoke = poke;
            final BufferedImage baseImage = orig;

            buttons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (baseImage != null) {
                        Image big = baseImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                        buttons[idx].setIcon(new ImageIcon(big));
                    }
                    buttons[idx].setBackground(Color.decode("#87CEFA"));
                    buttons[idx].setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (baseImage != null) {
                        Image small = baseImage.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                        buttons[idx].setIcon(new ImageIcon(small));
                    }
                    buttons[idx].setBackground(Color.decode("#ADD8E6"));
                    buttons[idx].setBorder(BorderFactory.createEmptyBorder());
                }
            });

            buttons[i].addActionListener(ae -> {
                if (finalPoke == null) return;
                JPanel detail = buildDetailPanel(finalPoke);
                getContentPane().remove(centerPanel);
                centerPanel = detail;
                getContentPane().add(centerPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            });

            panelRowOne.add(buttons[i]);
        }
        JButton previousPageButton = new JButton("Previous");
        previousPageButton.setFont(customFont.deriveFont(Font.BOLD, 24f));
        previousPageButton.setBackground(Color.decode("#ADD8E6"));
        previousPageButton.setOpaque(true);
        previousPageButton.setPreferredSize(new Dimension(125, 50));

        JLabel pageNumberLabel = new JLabel("Page " + pageNumber, SwingConstants.CENTER);
        pageNumberLabel.setBackground(Color.decode("#ADD8E6"));
        pageNumberLabel.setOpaque(true);
        pageNumberLabel.setPreferredSize(new Dimension(500, 50));
        pageNumberLabel.setFont(customFont.deriveFont(Font.BOLD, 24f));

        JButton nextPageButton = new JButton("Next");
        nextPageButton.setFont(customFont.deriveFont(Font.BOLD, 24f));
        nextPageButton.setBackground(Color.decode("#ADD8E6"));
        nextPageButton.setPreferredSize(new Dimension(125, 50));
        nextPageButton.setOpaque(true);

        JLabel spaceLabel = new JLabel(" ");
        spaceLabel.setBackground(Color.decode("#CC0000"));
        spaceLabel.setOpaque(true);
        spaceLabel.setPreferredSize(new Dimension(750, 70));


        panelRowOne.add(previousPageButton);
        panelRowOne.add(pageNumberLabel);
        panelRowOne.add(nextPageButton);


        nextPageButton.addActionListener(e -> {
            getContentPane().remove(centerPanel);
            pageStartIndex += 10;
            pageNumber += 1;
            centerPanel = buildMainMenu();
            getContentPane().add(centerPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        previousPageButton.addActionListener(e -> {
            if(pageNumber > 1) {
                getContentPane().remove(centerPanel);
                pageStartIndex -= 10;
                pageNumber -= 1;
                centerPanel = buildMainMenu();
                getContentPane().add(centerPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        return panelRowOne;
    }
    /**
     * Creates a new detail page for selected Pokemon from the main menu.
     *
     * @param p the current Pokemon selected to display details.
     *
     */
    private JPanel buildDetailPanel(Pokemon p) {
        JPanel detailPanel = new JPanel(new BorderLayout());
        JPanel pokePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pokeImagePanel = new JPanel(new GridLayout(1,2,10,0));
        JPanel descriptionPanel = new JPanel(new GridLayout(3,1,10,0));
        pokeImagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        pokeImagePanel.setBackground(Color.decode(p.getColor()));
        detailPanel.setBackground(Color.decode(p.getColor()));
        pokePanel.setBackground(Color.decode("#CC0000"));
        detailPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));

        JLabel nameLabel = new JLabel(p.getPokemonName(), SwingConstants.CENTER);
        nameLabel.setFont(customFont.deriveFont(Font.BOLD, 22f));
        nameLabel.setForeground(Color.BLACK);

        JLabel typeLabel = new JLabel("Type 1: " + p.getPokemonType1(), SwingConstants.LEFT);
        JLabel type2Label;
        if (p.getTypeNumber() == 1){
            type2Label = new JLabel("Type 2: None", SwingConstants.LEFT);
        } else {
            type2Label = new JLabel("Type 2: " + p.getPokemonType2(), SwingConstants.LEFT);
        }
        typeLabel.setFont(customFont.deriveFont(Font.BOLD, 40f));
        type2Label.setFont(customFont.deriveFont(Font.BOLD, 40f));
        typeLabel.setHorizontalAlignment(2);
        type2Label.setHorizontalAlignment(2);

        nameLabel.setPreferredSize(new Dimension(700, 40));
        nameLabel.setFont(customFont.deriveFont(Font.BOLD, 38f));
        nameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        nameLabel.setForeground(Color.WHITE);

        BufferedImage img = loadBufferedImage(p.getImage());
        JLabel imageLabel = new JLabel();
        if (img != null) {
            Image scaled = img.getScaledInstance(325, 325, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
            imageLabel.setPreferredSize(new Dimension(325, 325));
            imageLabel.setBackground(Color.decode("#FFFFFF"));
            imageLabel.setVerticalAlignment(SwingConstants.TOP);
        }

        descriptionPanel.add(typeLabel);
        descriptionPanel.add(type2Label);
        descriptionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        descriptionPanel.setPreferredSize(new Dimension(425, 333));

        pokeImagePanel.add(imageLabel, new GridLayout());

        pokePanel.add(pokeImagePanel);
        pokePanel.add(descriptionPanel);

        detailPanel.add(nameLabel, BorderLayout.NORTH);
        detailPanel.add(pokePanel, BorderLayout.CENTER);

        JButton back = new JButton("Back to Pokedex");
        back.setFont(customFont.deriveFont(Font.BOLD, 20f));
        back.setBackground(Color.decode("#ADD8E6"));
        back.addActionListener(e -> {
            getContentPane().remove(centerPanel);
            centerPanel = buildMainMenu();
            getContentPane().add(centerPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });
        detailPanel.add(back, BorderLayout.PAGE_END);

        return detailPanel;
    }
    /**
     * Loads Pokemon sprite image.
     *
     * @param resourcePath a string representation of content root path.
     * @param w width of image.
     * @param h height of image.
     */
    private ImageIcon loadIcon(String resourcePath, int w, int h) {
        BufferedImage img = loadBufferedImage(resourcePath);
        if (img == null) return null;
        return new ImageIcon(img.getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }
    /**
     * Reads file path from res folder for image to display Pokemon sprite.
     *
     * @param resourcePath a string representation of content root path.
     */
    private BufferedImage loadBufferedImage(String resourcePath) {
        if (resourcePath == null) return null;
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            if (is != null) return ImageIO.read(is);
        } catch (Exception ignored) {}
        try {
            File f = new File(resourcePath);
            if (f.exists()) return ImageIO.read(f);
        } catch (Exception ignored) {}
        return null;
    }
}