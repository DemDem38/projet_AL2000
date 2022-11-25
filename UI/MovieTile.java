package UI;

import FC.AL2000;
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

    MovieTile(Film f, MainFrame mainFrame, AL2000 model){

        this.film = f;

        try {
            BufferedImage img;
            img = ImageIO.read(getClass().getResource("/res/Images/"+film.getNom().replace('é','e').toLowerCase().replace(" ","").replace(":","")+".jpg"));
            setIcon(new ImageIcon(img.getScaledInstance(175, 250, Image.SCALE_FAST)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO afficher le bon film avec supportID
                model.setCurrentFilm(film);
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
