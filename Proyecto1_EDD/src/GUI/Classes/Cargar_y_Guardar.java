/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Classes;

import App.App;
import App.FileFunctions;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author andre
 */
public class Cargar_y_Guardar extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Cargar_y_Guardar() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
        this.jFileChooser1.setFileFilter(filter);
//        JOptionPane.showMessageDialog(null, "Antes de cargar un nuevo archivo .txt, guarde los datos los datos" + 
//                "\n" + "actualmente cargados en memoria. Presione el boton de Guardar.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_Inicio1 = new javax.swing.JPanel();
        icono1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_nueva_ruta = new javax.swing.JPanel();
        icono3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_nuevo_almacen = new javax.swing.JPanel();
        icono4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_reporte = new javax.swing.JPanel();
        icono5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_gest_inventario1 = new javax.swing.JPanel();
        icono6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_mapa_almacenes = new javax.swing.JPanel();
        icono = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_cargar_guardar1 = new javax.swing.JPanel();
        icono7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_Inicio2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        mensaje = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        BG.setBackground(new java.awt.Color(155, 170, 193));
        BG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SidePanel.setBackground(new java.awt.Color(34, 46, 60));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/AmazonLogo.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        SidePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 280, 80));

        btn_Inicio1.setBackground(new java.awt.Color(55, 71, 90));
        btn_Inicio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Inicio1MouseClicked(evt);
            }
        });

        icono1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/amazon_logo_blanco.png"))); // NOI18N
        icono1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inicio");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_Inicio1Layout = new javax.swing.GroupLayout(btn_Inicio1);
        btn_Inicio1.setLayout(btn_Inicio1Layout);
        btn_Inicio1Layout.setHorizontalGroup(
            btn_Inicio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_Inicio1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(icono1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        btn_Inicio1Layout.setVerticalGroup(
            btn_Inicio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_Inicio1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_Inicio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(icono1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        SidePanel.add(btn_Inicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 330, 60));

        btn_nueva_ruta.setBackground(new java.awt.Color(55, 71, 90));
        btn_nueva_ruta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nueva_rutaMouseClicked(evt);
            }
        });

        icono3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/nueva ruta blanco.png"))); // NOI18N
        icono3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono3MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nuevas Rutas");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_nueva_rutaLayout = new javax.swing.GroupLayout(btn_nueva_ruta);
        btn_nueva_ruta.setLayout(btn_nueva_rutaLayout);
        btn_nueva_rutaLayout.setHorizontalGroup(
            btn_nueva_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nueva_rutaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(icono3)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        btn_nueva_rutaLayout.setVerticalGroup(
            btn_nueva_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nueva_rutaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_nueva_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(icono3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        SidePanel.add(btn_nueva_ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 330, 60));

        btn_nuevo_almacen.setBackground(new java.awt.Color(55, 71, 90));
        btn_nuevo_almacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nuevo_almacenMouseClicked(evt);
            }
        });

        icono4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/nuevo almacen blanco.png"))); // NOI18N
        icono4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono4MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nuevo Almacen");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_nuevo_almacenLayout = new javax.swing.GroupLayout(btn_nuevo_almacen);
        btn_nuevo_almacen.setLayout(btn_nuevo_almacenLayout);
        btn_nuevo_almacenLayout.setHorizontalGroup(
            btn_nuevo_almacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nuevo_almacenLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(icono4)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        btn_nuevo_almacenLayout.setVerticalGroup(
            btn_nuevo_almacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nuevo_almacenLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_nuevo_almacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(icono4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        SidePanel.add(btn_nuevo_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 330, 60));

        btn_reporte.setBackground(new java.awt.Color(55, 71, 90));
        btn_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reporteMouseClicked(evt);
            }
        });

        icono5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/reporte blanco.png"))); // NOI18N
        icono5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono5MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reporte");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_reporteLayout = new javax.swing.GroupLayout(btn_reporte);
        btn_reporte.setLayout(btn_reporteLayout);
        btn_reporteLayout.setHorizontalGroup(
            btn_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_reporteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(icono5)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        btn_reporteLayout.setVerticalGroup(
            btn_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_reporteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(icono5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        SidePanel.add(btn_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 330, 60));

        btn_gest_inventario1.setBackground(new java.awt.Color(55, 71, 90));
        btn_gest_inventario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_gest_inventario1MouseClicked(evt);
            }
        });

        icono6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/gestion_inventario_blanco.png"))); // NOI18N
        icono6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icono6MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gestión de Inventario");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_gest_inventario1Layout = new javax.swing.GroupLayout(btn_gest_inventario1);
        btn_gest_inventario1.setLayout(btn_gest_inventario1Layout);
        btn_gest_inventario1Layout.setHorizontalGroup(
            btn_gest_inventario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_gest_inventario1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(icono6)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_gest_inventario1Layout.setVerticalGroup(
            btn_gest_inventario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_gest_inventario1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_gest_inventario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(icono6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        SidePanel.add(btn_gest_inventario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 330, 60));

        btn_mapa_almacenes.setBackground(new java.awt.Color(55, 71, 90));

        icono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/mapa blanco.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mapa de Almacenes");

        javax.swing.GroupLayout btn_mapa_almacenesLayout = new javax.swing.GroupLayout(btn_mapa_almacenes);
        btn_mapa_almacenes.setLayout(btn_mapa_almacenesLayout);
        btn_mapa_almacenesLayout.setHorizontalGroup(
            btn_mapa_almacenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_mapa_almacenesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(icono)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        btn_mapa_almacenesLayout.setVerticalGroup(
            btn_mapa_almacenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_mapa_almacenesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_mapa_almacenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        SidePanel.add(btn_mapa_almacenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 330, 60));

        btn_cargar_guardar1.setBackground(new java.awt.Color(243, 168, 71));

        icono7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        icono7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Cargar y guardar.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Cargar y Guardar");

        javax.swing.GroupLayout btn_cargar_guardar1Layout = new javax.swing.GroupLayout(btn_cargar_guardar1);
        btn_cargar_guardar1.setLayout(btn_cargar_guardar1Layout);
        btn_cargar_guardar1Layout.setHorizontalGroup(
            btn_cargar_guardar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_cargar_guardar1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(icono7)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_cargar_guardar1Layout.setVerticalGroup(
            btn_cargar_guardar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_cargar_guardar1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_cargar_guardar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(icono7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        SidePanel.add(btn_cargar_guardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 330, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Unimet 2023 ®");
        SidePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, -1, -1));

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SidePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 260, 26));

        btn_Inicio2.setBackground(new java.awt.Color(55, 71, 90));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nuevo Pedido");

        javax.swing.GroupLayout btn_Inicio2Layout = new javax.swing.GroupLayout(btn_Inicio2);
        btn_Inicio2.setLayout(btn_Inicio2Layout);
        btn_Inicio2Layout.setHorizontalGroup(
            btn_Inicio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_Inicio2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel5)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        btn_Inicio2Layout.setVerticalGroup(
            btn_Inicio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_Inicio2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        SidePanel.add(btn_Inicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 330, 60));

        BG.add(SidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 710));

        jPanel1.setBackground(new java.awt.Color(34, 46, 60));

        jPanel4.setBackground(new java.awt.Color(246, 183, 102));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/exit.png"))); // NOI18N
        exit.setText("Exit");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(584, Short.MAX_VALUE)
                .addComponent(exit)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Seccion Cargar y Guardar Datos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        BG.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 650, 190));

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });
        BG.add(jFileChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 530, 360));

        jButton1.setBackground(new java.awt.Color(34, 46, 60));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/save_btn.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        BG.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, -1, 70));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/¡ATENCIÓN!Antes de cargar un archivo nuevo asegúrese de guardar si así lo desea..png"))); // NOI18N

        javax.swing.GroupLayout mensajeLayout = new javax.swing.GroupLayout(mensaje);
        mensaje.setLayout(mensajeLayout);
        mensajeLayout.setHorizontalGroup(
            mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mensajeLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mensajeLayout.setVerticalGroup(
            mensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mensajeLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        BG.add(mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 330, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_exitMousePressed
    private Point initialClick;

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        initialClick = evt.getPoint();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        // TODO add your handling code here:
            int x = getLocation().x - initialClick.x + evt.getX();
            int y = getLocation().y - initialClick.y + evt.getY();
            setLocation(x, y);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FileFunctions.saveTxt(App.g);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
        try{
            App.selectedFile = this.jFileChooser1.getSelectedFile();
            App.selectedPath = App.selectedFile.getAbsolutePath();
            System.out.println(App.selectedPath);
            String newData = FileFunctions.readTxt();
            FileFunctions.loadData(newData);
            JOptionPane.showMessageDialog(null, "Carga Exitosa!");
            System.out.println(App.g.toString());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar los datos. Revise el formato del archivo.");
        }
        
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void btn_Inicio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Inicio1MouseClicked
        // TODO add your handling code here:
        Inicio v1 = new Inicio();
        this.dispose();
        v1.setVisible(true);
    }//GEN-LAST:event_btn_Inicio1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Inicio v1 = new Inicio();
        this.dispose();
        v1.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void icono1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono1MouseClicked
        // TODO add your handling code here:
        Inicio v1 = new Inicio();
        this.dispose();
        v1.setVisible(true);
    }//GEN-LAST:event_icono1MouseClicked

    private void btn_nueva_rutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nueva_rutaMouseClicked
        // TODO add your handling code here:
        Nuevas_Rutas v3 = new Nuevas_Rutas();
        this.dispose();
        v3.setVisible(true);
    }//GEN-LAST:event_btn_nueva_rutaMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        Nuevas_Rutas v3 = new Nuevas_Rutas();
        this.dispose();
        v3.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void icono3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono3MouseClicked
        // TODO add your handling code here:
        Nuevas_Rutas v3 = new Nuevas_Rutas();
        this.dispose();
        v3.setVisible(true);
    }//GEN-LAST:event_icono3MouseClicked

    private void btn_nuevo_almacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevo_almacenMouseClicked
        // TODO add your handling code here:
        Nuevo_Almacen v4 = new Nuevo_Almacen();
        this.dispose();
        v4.setVisible(true);
    }//GEN-LAST:event_btn_nuevo_almacenMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        Nuevo_Almacen v4 = new Nuevo_Almacen();
        this.dispose();
        v4.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void icono4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono4MouseClicked
        // TODO add your handling code here:
        Nuevo_Almacen v4 = new Nuevo_Almacen();
        this.dispose();
        v4.setVisible(true);
    }//GEN-LAST:event_icono4MouseClicked

    private void btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reporteMouseClicked
        // TODO add your handling code here:
        Reporte v5 = new Reporte();
        this.dispose();
        v5.setVisible(true);
    }//GEN-LAST:event_btn_reporteMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        Reporte v5 = new Reporte();
        this.dispose();
        v5.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void icono5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono5MouseClicked
        // TODO add your handling code here:
        Reporte v5 = new Reporte();
        this.dispose();
        v5.setVisible(true);
    }//GEN-LAST:event_icono5MouseClicked

    private void btn_gest_inventario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gest_inventario1MouseClicked
        // TODO add your handling code here:
        Gestion_Inventario v6 = new Gestion_Inventario();
        this.dispose();
        v6.setVisible(true);
    }//GEN-LAST:event_btn_gest_inventario1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        Gestion_Inventario v6 = new Gestion_Inventario();
        this.dispose();
        v6.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void icono6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icono6MouseClicked
        // TODO add your handling code here:
        Gestion_Inventario v6 = new Gestion_Inventario();
        this.dispose();
        v6.setVisible(true);
    }//GEN-LAST:event_icono6MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        Inicio v1 = new Inicio();
        this.dispose();
        v1.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked


    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(Cargar_y_Guardar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Cargar_y_Guardar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Cargar_y_Guardar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Cargar_y_Guardar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Cargar_y_Guardar().setVisible(true);
        }
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel btn_Inicio1;
    private javax.swing.JPanel btn_Inicio2;
    private javax.swing.JPanel btn_cargar_guardar1;
    private javax.swing.JPanel btn_gest_inventario1;
    private javax.swing.JPanel btn_mapa_almacenes;
    private javax.swing.JPanel btn_nueva_ruta;
    private javax.swing.JPanel btn_nuevo_almacen;
    private javax.swing.JPanel btn_reporte;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel icono1;
    private javax.swing.JLabel icono3;
    private javax.swing.JLabel icono4;
    private javax.swing.JLabel icono5;
    private javax.swing.JLabel icono6;
    private javax.swing.JLabel icono7;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mensaje;
    // End of variables declaration//GEN-END:variables
}
