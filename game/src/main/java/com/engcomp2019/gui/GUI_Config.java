package com.engcomp2019.gui;

import com.engcomp2019.core.*;
import static com.engcomp2019.gui.GUI_MainMenu.a;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author erick / rckmath
 */
public class GUI_Config extends JFrame {

    private final ImageIcon imgFrame = new ImageIcon(this.getClass().getResource("/imgs/frames/frameBackground.png"));
    private final ImageIcon imgMenu = new ImageIcon(this.getClass().getResource("/imgs/elements/configDropdown.png"));
    private final ImageIcon imgRecord = new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnRecord.png"));
    private final ImageIcon imgLeoHead = new ImageIcon(this.getClass().getResource("/imgs/easteregg/leoHeadDance.gif"));
    private final ArrayList<ImageIcon> imgBtnReset = new ArrayList<>();
    private final ArrayList<ImageIcon> imgBtnTheme = new ArrayList<>();
    private final ArrayList<ImageIcon> imgVolume = new ArrayList<>();
    private final DragWindow drag = new DragWindow();
    private final Close close = new Close();
    private final ArrayList<JLabel> menuItems;
    private Boolean menuActive = true;
    private final Session s;
    private final JFrame previousFrame;

    /**
     * Inicializa e instancia a tela de configurações
     *
     * @param pPreviousFrame Recebe o frame de onde foi chamado
     * @param s Mantém a sessão inicializada
     */
    public GUI_Config(JFrame pPreviousFrame, Session s) {
        this.s = s;
        this.previousFrame = pPreviousFrame;
        // Propriedades da janela e inicialização dos componentes
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        loadImages();

        menuItems = new ArrayList<JLabel>() {
            {
                add(goBack);
                add(exitGame);
            }
        };

        // Para inicializar as opções de menu desativadas
        menuActive = close.menu(0, menuActive, menuDropdown, menuItems);

        if (!s.getAudioOn()) {
            a.stop();
            btnAudio.setIcon(imgVolume.get(1));
        } else {
            btnAudio.setIcon(imgVolume.get(0));
        }

        this.add(btnAudio, new AbsoluteConstraints(32, 525, -1, -1));

        altTheme.setIcon(imgLeoHead);
        this.add(altTheme, new AbsoluteConstraints(740, 50, -1, -1));
        altTheme.setVisible(false);

        menuDropdown.setIcon(imgMenu);
        this.add(menuDropdown, new AbsoluteConstraints(39, 20, -1, -1));
        menuDropdown.setVisible(false);

        btnReset.setIcon(imgBtnReset.get(0));
        this.add(btnReset, new AbsoluteConstraints(315, 165, -1, -1));

        btnRecord.setIcon(imgRecord);
        this.add(btnRecord, new AbsoluteConstraints(215, 165, -1, -1));

        lblRecord.setText(String.format("%06d%n", s.getRecordScore()));

        // Define imagem de botao de tema de acordo com o status do mesmo
        if (!s.getAltTheme()) {
            btnTheme.setIcon(imgBtnTheme.get(0));
        } else {
            btnTheme.setIcon(imgBtnTheme.get(3));
            altTheme.setVisible(true);
        }

        frameBackground.setIcon(imgFrame);
        this.add(frameBackground, new AbsoluteConstraints(0, 0, -1, -1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitGame = new javax.swing.JLabel();
        goBack = new javax.swing.JLabel();
        menuDropdown = new javax.swing.JLabel();
        logoImg = new javax.swing.JLabel();
        btnAbout = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        btnFile = new javax.swing.JLabel();
        lblRecord = new javax.swing.JLabel();
        btnRecord = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        btnTheme = new javax.swing.JLabel();
        btnAudio = new javax.swing.JLabel();
        altTheme = new javax.swing.JLabel();
        frameDrag = new javax.swing.JLabel();
        frameBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("frameConfig"); // NOI18N
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitGameMouseReleased(evt);
            }
        });
        getContentPane().add(exitGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 130, 18));

        goBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                goBackMouseReleased(evt);
            }
        });
        getContentPane().add(goBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, 18));
        getContentPane().add(menuDropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 20, 130, 38));
        getContentPane().add(logoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-31, 31, -1, -1));

        btnAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAboutMouseReleased(evt);
            }
        });
        getContentPane().add(btnAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 0, 50, 18));

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCloseMouseReleased(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 7, 24, 24));

        btnMinimize.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimize.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseReleased(evt);
            }
        });
        getContentPane().add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 7, 24, 24));

        btnFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFileMouseReleased(evt);
            }
        });
        getContentPane().add(btnFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 0, 70, 18));

        lblRecord.setBackground(new java.awt.Color(255, 255, 255));
        lblRecord.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 205, -1, -1));
        getContentPane().add(btnRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 190, -1, -1));

        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnResetMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnResetMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnResetMouseReleased(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 190, -1, -1));

        btnTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThemeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnThemeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnThemeMouseReleased(evt);
            }
        });
        getContentPane().add(btnTheme, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        btnAudio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAudioMouseReleased(evt);
            }
        });
        getContentPane().add(btnAudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 515, 32, 32));
        getContentPane().add(altTheme, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 30, 30));

        frameDrag.setPreferredSize(new java.awt.Dimension(41, 18));
        frameDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                frameDragMouseDragged(evt);
            }
        });
        frameDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                frameDragMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                frameDragMouseReleased(evt);
            }
        });
        getContentPane().add(frameDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 18));

        frameBackground.setBackground(new java.awt.Color(0, 0, 0));
        frameBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frameBackground.setPreferredSize(new java.awt.Dimension(800, 576));
        getContentPane().add(frameBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void frameDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameDragMouseDragged
        menuActive = close.menu(0, menuActive, menuDropdown, menuItems);
        drag.setInitialCoordenates(evt);
        drag.setFrame(this);
        drag.setCoord();
    }//GEN-LAST:event_frameDragMouseDragged

    private void frameDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameDragMousePressed
        frameDrag.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        drag.setFinalCoordenates(evt);
    }//GEN-LAST:event_frameDragMousePressed

    private void frameDragMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameDragMouseReleased
        frameDrag.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_frameDragMouseReleased

    private void btnAboutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMouseReleased
        GUI_AboutUs frameAbout = new GUI_AboutUs(this);
        frameAbout.setVisible(true);
        menuActive = close.menu(0, menuActive, menuDropdown, menuItems);
    }//GEN-LAST:event_btnAboutMouseReleased

    private void btnCloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseReleased
        s.saveSession(s);
        new Close(this, true).frame();
    }//GEN-LAST:event_btnCloseMouseReleased

    private void btnMinimizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseReleased
        setState(Frame.ICONIFIED);  // Minimize our frame
        menuActive = close.menu(0, menuActive, menuDropdown, menuItems);
    }//GEN-LAST:event_btnMinimizeMouseReleased

    private void btnFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFileMouseReleased
        menuActive = close.menu(1, menuActive, menuDropdown, menuItems);
    }//GEN-LAST:event_btnFileMouseReleased

    private void goBackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackMouseReleased
        this.dispose();
        previousFrame.setVisible(true);
        previousFrame.setEnabled(true);
    }//GEN-LAST:event_goBackMouseReleased

    private void exitGameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitGameMouseReleased
        menuActive = close.menu(0, menuActive, menuDropdown, menuItems);
        GUI_Exit frameExit = new GUI_Exit(s, this);
        frameExit.setVisible(true);
    }//GEN-LAST:event_exitGameMouseReleased

    private void btnThemeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemeMouseEntered
        if (!s.getAltTheme()) {
            btnTheme.setIcon(imgBtnTheme.get(1));
        } else {
            btnTheme.setIcon(imgBtnTheme.get(4));
        }
    }//GEN-LAST:event_btnThemeMouseEntered

    private void btnThemeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemeMouseExited
        if (!s.getAltTheme()) {
            btnTheme.setIcon(imgBtnTheme.get(0));
        } else {
            btnTheme.setIcon(imgBtnTheme.get(3));
        }
    }//GEN-LAST:event_btnThemeMouseExited

    private void btnThemeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemeMousePressed
        if (!s.getAltTheme()) {
            s.setAltTheme(true);
            btnTheme.setIcon(imgBtnTheme.get(2));
        } else {
            s.setAltTheme(false);
            btnTheme.setIcon(imgBtnTheme.get(5));
        }
    }//GEN-LAST:event_btnThemeMousePressed

    private void btnThemeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemeMouseReleased
        if (!s.getAltTheme()) {
            altTheme.setVisible(false);
            btnTheme.setIcon(imgBtnTheme.get(1));
        } else {
            altTheme.setVisible(true);
            btnTheme.setIcon(imgBtnTheme.get(4));
        }
    }//GEN-LAST:event_btnThemeMouseReleased

    private void btnResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseEntered
        btnReset.setIcon(imgBtnReset.get(1));
    }//GEN-LAST:event_btnResetMouseEntered

    private void btnResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseExited
        btnReset.setIcon(imgBtnReset.get(0));
    }//GEN-LAST:event_btnResetMouseExited

    private void btnResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMousePressed
        btnReset.setIcon(imgBtnReset.get(2));
    }//GEN-LAST:event_btnResetMousePressed

    private void btnResetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseReleased
        btnReset.setIcon(imgBtnReset.get(1));
        menuActive = close.menu(0, menuActive, menuDropdown, menuItems);
        // Chamar frame para confirmar ação
        GUI_RestartConfirm frameConfirm;
        frameConfirm = new GUI_RestartConfirm(this, s);
        frameConfirm.setVisible(true);
    }//GEN-LAST:event_btnResetMouseReleased

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        menuActive = close.menu(0, menuActive, menuDropdown, menuItems);
    }//GEN-LAST:event_formMouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        lblRecord.setText(String.format("%06d%n", s.getRecordScore()));
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnAudioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAudioMouseReleased
        if (s.getAudioOn()) {
            btnAudio.setIcon(imgVolume.get(1));
            a.stop();
            s.setAudioOn(false);
        } else {
            btnAudio.setIcon(imgVolume.get(0));
            a.play(true);
            s.setAudioOn(true);
        }
    }//GEN-LAST:event_btnAudioMouseReleased

    // <editor-fold defaultstate="collapsed" desc="Carregar imagens">
    private void loadImages() {
        /* Instancia e define nossos elementos na tela */
        imgBtnTheme.add(new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnTemaFDef.png")));
        imgBtnTheme.add(new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnTemaFHover.png")));
        imgBtnTheme.add(new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnTemaFPressed.png")));
        imgBtnTheme.add(new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnTemaTDef.png")));
        imgBtnTheme.add(new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnTemaTHover.png")));
        imgBtnTheme.add(new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnTemaTPressed.png")));
        imgBtnReset.add(new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnResetRDef.png")));
        imgBtnReset.add(new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnResetRHov.png")));
        imgBtnReset.add(new ImageIcon(this.getClass().getResource("/imgs/buttons/other/btnResetRPre.png")));

        imgVolume.add(new ImageIcon(this.getClass().getResource("/imgs/elements/volumeOn.png")));
        imgVolume.add(new ImageIcon(this.getClass().getResource("/imgs/elements/volumeOff.png")));

        s.setFrameIcon(this);
    }
    // </editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altTheme;
    private javax.swing.JLabel btnAbout;
    private javax.swing.JLabel btnAudio;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnFile;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnRecord;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnTheme;
    private javax.swing.JLabel exitGame;
    private javax.swing.JLabel frameBackground;
    private javax.swing.JLabel frameDrag;
    private javax.swing.JLabel goBack;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JLabel logoImg;
    private javax.swing.JLabel menuDropdown;
    // End of variables declaration//GEN-END:variables
}
