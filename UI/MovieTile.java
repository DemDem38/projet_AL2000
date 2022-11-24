package UI;

import FC.POJO.Film;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MovieTile extends JLabel {

    private Film film;

    MovieTile(Film film, String ImgPath, MainFrame mainFrame){

        this.film = film;

        try {
            BufferedImage img;
            img = ImageIO.read(getClass().getResource(ImgPath));
            setIcon(new ImageIcon(img.getScaledInstance(175, 250, Image.SCALE_FAST)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO afficher le bon film avec supportID
                mainFrame.changeCard("movieUI");
            }
        });
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
