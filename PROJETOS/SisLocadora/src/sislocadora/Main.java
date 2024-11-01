/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sislocadora;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.internal.fonts.DefaultGnomeFontPolicy;
import usuario.JFrameLocadora;
import usuario.SplashLocadora;
import utilitarios.LtpUtil;

/**
 *
 * @author JP
 */
public class Main {

    private static SplashLocadora dialog = new SplashLocadora(null, true);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LtpUtil.traduzirSwing();
        try {
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel");
            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel");
            UIManager.put("ClassLoader", SubstanceLookAndFeel.class.getClassLoader());
            SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
            SubstanceLookAndFeel.setFontPolicy(new DefaultGnomeFontPolicy());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Locadora Ltda",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }

        Thread splash = new Thread(new Runnable() {

            public void run() {
                dialog.setVisible(true);
            }
        });
        splash.start();

        Thread conexao = new Thread(new Runnable() {

            public void run() {
                try {
                    bdlocadora.BDLocadora.abrirConexao();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    System.exit(1);
                }
            }
        });
        conexao.start();

        LtpUtil.delayMilli(6000, LtpUtil.SLEEP_METHOD_THREAD);

        do {
        } while (conexao.isAlive());

        dialog.dispose();
        
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDialog.setDefaultLookAndFeelDecorated(true);
                JFrame.setDefaultLookAndFeelDecorated(true);

                new JFrameLocadora();
            }
        });
    }
}