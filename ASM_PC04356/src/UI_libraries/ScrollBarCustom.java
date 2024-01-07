package UI_libraries;

import java.awt.Color;
import java.awt.Dimension;
import javaswingdev.drawer.scroll.ModernScrollBarUI;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(Color.WHITE);
    }
}
