package de.etgramli.mediathekhear;

import de.etgramli.mediathekhear.ui.MainWindow;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class Main {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Main.class)
                .headless(false)
                .run(args);
        EventQueue.invokeLater(() -> ctx.getBean(MainWindow.class).setVisible(true));
    }
}
