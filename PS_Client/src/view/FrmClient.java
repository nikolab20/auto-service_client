package view;

import controller.Controller;
import domain.Radnik;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import listeners.FormListener;
import lombok.Getter;
import threads.AnimationMenuCloseThread;
import threads.AnimationMenuThread;
import view.tablemodels.TableModelBillItem;

/**
 *
 * @author nikol
 */
public class FrmClient extends javax.swing.JFrame implements FormListener {

    private ResourceBundle resourceBundle;

    @Getter
    private JPanel activePanel;

    public FrmClient() {
        initComponents();
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        prepareView();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        btnCustomer = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnMarket = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        panelSubMenu = new javax.swing.JPanel();
        lpSubMenu = new javax.swing.JLayeredPane();
        panelInventory = new view.panels.submenu.PanelInventory();
        panelEmployee = new view.panels.submenu.PanelEmployee();
        panelCustomer = new view.panels.submenu.PanelCustomer();
        panelMarket = new view.panels.submenu.PanelMarket();
        panelHeader = new javax.swing.JPanel();
        lblIconUser = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        lpContentPane = new javax.swing.JLayeredPane();
        panelAddCustomer = new view.panels.PanelAddCustomer();
        panelAddEmployee = new view.panels.PanelAddEmployee();
        panelDeleteEmployee = new view.panels.PanelDeleteEmployee();
        panelSearchCustomer = new view.panels.PanelSearchCustomer();
        panelUpdateCustomer = new view.panels.PanelUpdateCustomer();
        panelUpdateEmployee = new view.panels.PanelUpdateEmployee();
        panelAddCarPart = new view.panels.PanelAddCarPart();
        panelAddService = new view.panels.PanelAddService();
        panelUpdateCarPart = new view.panels.PanelUpdateCarPart();
        panelSearchCarPart = new view.panels.PanelSearchCarPart();
        panelUpdateService = new view.panels.PanelUpdateService();
        panelDeleteService = new view.panels.PanelDeleteService();
        panelAddBill = new view.panels.PanelAddBill();
        panelInvalidateBill = new view.panels.PanelInvalidateBill();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 450));
        setPreferredSize(new java.awt.Dimension(548, 550));

        panelMenu.setBackground(new java.awt.Color(51, 52, 57));

        btnCustomer.setBackground(new java.awt.Color(51, 52, 57));
        btnCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/support.png"))); // NOI18N
        btnCustomer.setText("Customer");
        btnCustomer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnCustomer.setFocusPainted(false);
        btnCustomer.setIconTextGap(10);
        btnCustomer.setMinimumSize(new java.awt.Dimension(180, 34));
        btnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseExited(evt);
            }
        });
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        btnEmployee.setBackground(new java.awt.Color(51, 52, 57));
        btnEmployee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/work.png"))); // NOI18N
        btnEmployee.setText("Employee");
        btnEmployee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnEmployee.setFocusPainted(false);
        btnEmployee.setIconTextGap(10);
        btnEmployee.setMinimumSize(new java.awt.Dimension(180, 34));
        btnEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseExited(evt);
            }
        });
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnMarket.setBackground(new java.awt.Color(51, 52, 57));
        btnMarket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMarket.setForeground(new java.awt.Color(255, 255, 255));
        btnMarket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/supermarket.png"))); // NOI18N
        btnMarket.setText("Market");
        btnMarket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnMarket.setFocusPainted(false);
        btnMarket.setIconTextGap(10);
        btnMarket.setMinimumSize(new java.awt.Dimension(180, 34));
        btnMarket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseExited(evt);
            }
        });
        btnMarket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarketActionPerformed(evt);
            }
        });

        btnExcel.setBackground(new java.awt.Color(51, 52, 57));
        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnExcel.setFocusPainted(false);
        btnExcel.setIconTextGap(10);
        btnExcel.setMinimumSize(new java.awt.Dimension(180, 34));
        btnExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseExited(evt);
            }
        });

        btnInventory.setBackground(new java.awt.Color(51, 52, 57));
        btnInventory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventory.setForeground(new java.awt.Color(255, 255, 255));
        btnInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inventory.png"))); // NOI18N
        btnInventory.setText("Inventory");
        btnInventory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnInventory.setFocusPainted(false);
        btnInventory.setIconTextGap(10);
        btnInventory.setMinimumSize(new java.awt.Dimension(180, 34));
        btnInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseExited(evt);
            }
        });
        btnInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryActionPerformed(evt);
            }
        });

        btnSettings.setBackground(new java.awt.Color(51, 52, 57));
        btnSettings.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSettings.setForeground(new java.awt.Color(255, 255, 255));
        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settings.png"))); // NOI18N
        btnSettings.setText("Settings");
        btnSettings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSettings.setFocusPainted(false);
        btnSettings.setIconTextGap(10);
        btnSettings.setMinimumSize(new java.awt.Dimension(180, 34));
        btnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseExited(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(51, 52, 57));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnExit.setFocusPainted(false);
        btnExit.setIconTextGap(10);
        btnExit.setMinimumSize(new java.awt.Dimension(180, 34));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FrmClient.this.mouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMarket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMarket, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lpSubMenu.setLayer(panelInventory, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSubMenu.setLayer(panelEmployee, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSubMenu.setLayer(panelCustomer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpSubMenu.setLayer(panelMarket, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpSubMenuLayout = new javax.swing.GroupLayout(lpSubMenu);
        lpSubMenu.setLayout(lpSubMenuLayout);
        lpSubMenuLayout.setHorizontalGroup(
            lpSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(lpSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpSubMenuLayout.createSequentialGroup()
                    .addComponent(panelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(lpSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpSubMenuLayout.createSequentialGroup()
                    .addComponent(panelInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(lpSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpSubMenuLayout.createSequentialGroup()
                    .addComponent(panelMarket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        lpSubMenuLayout.setVerticalGroup(
            lpSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addGroup(lpSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
            .addGroup(lpSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
            .addGroup(lpSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelMarket, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelSubMenuLayout = new javax.swing.GroupLayout(panelSubMenu);
        panelSubMenu.setLayout(panelSubMenuLayout);
        panelSubMenuLayout.setHorizontalGroup(
            panelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lpSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelSubMenuLayout.setVerticalGroup(
            panelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lpSubMenu)
        );

        panelHeader.setBackground(new java.awt.Color(119, 118, 116));

        lblIconUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIconUser.setForeground(new java.awt.Color(255, 255, 255));
        lblIconUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        lblIconUser.setText("user");
        lblIconUser.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblIconUser.setIconTextGap(25);

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/open-menu.png"))); // NOI18N
        btnMenu.setBorder(null);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setFocusPainted(false);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIconUser)
                .addGap(20, 20, 20))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIconUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenu))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelContent.setBackground(new java.awt.Color(255, 255, 255));

        lpContentPane.setLayer(panelAddCustomer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelAddEmployee, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelDeleteEmployee, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelSearchCustomer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelUpdateCustomer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelUpdateEmployee, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelAddCarPart, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelAddService, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelUpdateCarPart, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelSearchCarPart, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelUpdateService, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelDeleteService, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelAddBill, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lpContentPane.setLayer(panelInvalidateBill, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout lpContentPaneLayout = new javax.swing.GroupLayout(lpContentPane);
        lpContentPane.setLayout(lpContentPaneLayout);
        lpContentPaneLayout.setHorizontalGroup(
            lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDeleteEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAddCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAddEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelSearchCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelUpdateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelUpdateEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAddCarPart, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAddService, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelUpdateCarPart, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelSearchCarPart, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelUpdateService, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelDeleteService, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAddBill, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelInvalidateBill, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
        );
        lpContentPaneLayout.setVerticalGroup(
            lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lpContentPaneLayout.createSequentialGroup()
                .addComponent(panelDeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 708, Short.MAX_VALUE))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 470, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 315, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 513, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 227, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelUpdateEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelAddCarPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 127, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelAddService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 211, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelUpdateCarPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 135, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelSearchCarPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 513, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelUpdateService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 211, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelDeleteService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 484, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelAddBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 399, Short.MAX_VALUE)))
            .addGroup(lpContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lpContentPaneLayout.createSequentialGroup()
                    .addComponent(panelInvalidateBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 708, Short.MAX_VALUE)))
        );

        scrollPane.setViewportView(lpContentPane);

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelSubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(panelContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        openSubmenu(lpSubMenu, panelEmployee, panelSubMenu, panelMenu);
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        openSubmenu(lpSubMenu, panelCustomer, panelSubMenu, panelMenu);
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryActionPerformed
        openSubmenu(lpSubMenu, panelInventory, panelSubMenu, panelMenu);
    }//GEN-LAST:event_btnInventoryActionPerformed

    private void mouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEntered
        if (evt.getSource() == btnCustomer) {
            btnCustomer.setBackground(new Color(119, 118, 116));
        }

        if (evt.getSource() == btnEmployee) {
            btnEmployee.setBackground(new Color(119, 118, 116));
        }

        if (evt.getSource() == btnExcel) {
            btnExcel.setBackground(new Color(119, 118, 116));
        }

        if (evt.getSource() == btnExit) {
            btnExit.setBackground(new Color(119, 118, 116));
        }

        if (evt.getSource() == btnInventory) {
            btnInventory.setBackground(new Color(119, 118, 116));
        }

        if (evt.getSource() == btnMarket) {
            btnMarket.setBackground(new Color(119, 118, 116));
        }

        if (evt.getSource() == btnSettings) {
            btnSettings.setBackground(new Color(119, 118, 116));
        }
    }//GEN-LAST:event_mouseEntered

    private void mouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseExited
        if (evt.getSource() == btnCustomer) {
            btnCustomer.setBackground(new Color(51, 52, 57));
        }

        if (evt.getSource() == btnEmployee) {
            btnEmployee.setBackground(new Color(51, 52, 57));
        }

        if (evt.getSource() == btnExcel) {
            btnExcel.setBackground(new Color(51, 52, 57));
        }

        if (evt.getSource() == btnExit) {
            btnExit.setBackground(new Color(51, 52, 57));
        }

        if (evt.getSource() == btnInventory) {
            btnInventory.setBackground(new Color(51, 52, 57));
        }

        if (evt.getSource() == btnMarket) {
            btnMarket.setBackground(new Color(51, 52, 57));
        }

        if (evt.getSource() == btnSettings) {
            btnSettings.setBackground(new Color(51, 52, 57));
        }
    }//GEN-LAST:event_mouseExited

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        new AnimationMenuThread(panelMenu, panelSubMenu).start();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnMarketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarketActionPerformed
        openSubmenu(lpSubMenu, panelMarket, panelSubMenu, panelMenu);
    }//GEN-LAST:event_btnMarketActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnMarket;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSettings;
    private javax.swing.JLabel lblIconUser;
    private javax.swing.JLayeredPane lpContentPane;
    private javax.swing.JLayeredPane lpSubMenu;
    private view.panels.PanelAddBill panelAddBill;
    private view.panels.PanelAddCarPart panelAddCarPart;
    private view.panels.PanelAddCustomer panelAddCustomer;
    private view.panels.PanelAddEmployee panelAddEmployee;
    private view.panels.PanelAddService panelAddService;
    private javax.swing.JPanel panelContent;
    private view.panels.submenu.PanelCustomer panelCustomer;
    private view.panels.PanelDeleteEmployee panelDeleteEmployee;
    private view.panels.PanelDeleteService panelDeleteService;
    private view.panels.submenu.PanelEmployee panelEmployee;
    private javax.swing.JPanel panelHeader;
    private view.panels.PanelInvalidateBill panelInvalidateBill;
    private view.panels.submenu.PanelInventory panelInventory;
    private view.panels.submenu.PanelMarket panelMarket;
    private javax.swing.JPanel panelMenu;
    private view.panels.PanelSearchCarPart panelSearchCarPart;
    private view.panels.PanelSearchCustomer panelSearchCustomer;
    private javax.swing.JPanel panelSubMenu;
    private view.panels.PanelUpdateCarPart panelUpdateCarPart;
    private view.panels.PanelUpdateCustomer panelUpdateCustomer;
    private view.panels.PanelUpdateEmployee panelUpdateEmployee;
    private view.panels.PanelUpdateService panelUpdateService;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        setTitle(resourceBundle.getString("client_title"));
        Controller.getInstance().defaultPrepareForm(this);
        Radnik radnik = Controller.getInstance().getRadnik();

        if (radnik.isAdministrator()) {
            lblIconUser.setText(radnik.getImeRadnika() + " " + radnik.getPrezimeRadnika() + " (admin)");
        } else {
            lblIconUser.setText(radnik.getImeRadnika() + " " + radnik.getPrezimeRadnika());
            btnEmployee.setEnabled(false);
            btnSettings.setEnabled(false);
        }

        btnCustomer.setText(resourceBundle.getString("client_btn_customer"));
        btnEmployee.setText(resourceBundle.getString("client_btn_employee"));
        btnMarket.setText(resourceBundle.getString("client_btn_market"));
        btnExcel.setText(resourceBundle.getString("client_btn_excel"));
        btnInventory.setText(resourceBundle.getString("client_btn_inventory"));
        btnSettings.setText(resourceBundle.getString("client_btn_setting"));
        btnExit.setText(resourceBundle.getString("client_btn_exit"));

        setAllLayerInvisible(lpContentPane);
        setAllLayerInvisible(lpSubMenu);
        setListenersToPanels();
        preparePanels();
    }

    private void setListenersToPanels() {
        panelCustomer.addListener(this);
        panelEmployee.addListener(this);
        panelInventory.addListener(this);
        panelMarket.addListener(this);
    }

    private void setAllLayerInvisible(JLayeredPane jp) {
        for (Component component : jp.getComponents()) {
            ((JPanel) component).setVisible(false);
        }
    }

    private void openPanel(JScrollPane scrollPane, JLayeredPane layeredPane, JPanel menu, JPanel toOpen) {
        scrollPane.getVerticalScrollBar().setValue(0);
        setAllLayerInvisible(layeredPane);
        new AnimationMenuCloseThread(menu).start();
        activePanel = toOpen;
        toOpen.setVisible(true);
    }

    private void openSubmenu(JLayeredPane submenuLayeredPane, JPanel toOpen, JPanel panelSubMenu, JPanel panelMenu) {
        setAllLayerInvisible(submenuLayeredPane);
        toOpen.setVisible(true);
        new AnimationMenuThread(panelSubMenu, panelMenu).start();
    }

    private void preparePanels() {
        panelCustomer.preparePanel();
        panelAddCustomer.preparePanel();
        panelUpdateCustomer.preparePanel();
        panelAddEmployee.preparePanel();
        panelUpdateEmployee.preparePanel();
        panelDeleteEmployee.preparePanel();
        panelSearchCustomer.preparePanel();
        panelEmployee.preparePanel();
        panelInventory.preparePanel();
        panelAddCarPart.preparePanel();
        panelAddService.preparePanel();
        panelUpdateCarPart.preparePanel();
        panelSearchCarPart.preparePanel();
        panelUpdateService.preparePanel();
        panelDeleteService.preparePanel();
        panelMarket.preparePanel();
        panelAddBill.preparePanel();
        panelInvalidateBill.preparePanel();
    }

    @Override
    public void openAddCustomer() {
        panelAddCustomer.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelAddCustomer);
    }

    @Override
    public void openUpdateCustomer() {
        panelUpdateCustomer.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelUpdateCustomer);
    }

    @Override
    public void openSearchCustomer() {
        panelSearchCustomer.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelSearchCustomer);
    }

    @Override
    public void openAddEmployee() {
        panelAddEmployee.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelAddEmployee);
    }

    @Override
    public void openUpdateEmployee() {
        panelUpdateEmployee.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelUpdateEmployee);
    }

    @Override
    public void openDeleteEmployee() {
        panelDeleteEmployee.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelDeleteEmployee);
    }

    @Override
    public void openAddCarPart() {
        panelAddCarPart.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelAddCarPart);
    }

    @Override
    public void openSearchCarPart() {
        panelSearchCarPart.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelSearchCarPart);
    }

    @Override
    public void openAddService() {
        panelAddService.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelAddService);
    }

    @Override
    public void openUpdateService() {
        panelUpdateService.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelUpdateService);
    }

    @Override
    public void openDeleteService() {
        panelDeleteService.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelDeleteService);
    }

    @Override
    public void openUpdateCarPart() {
        panelUpdateCarPart.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelUpdateCarPart);
    }

    @Override
    public void openAddBill() {
        panelAddBill.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelAddBill);
    }

    @Override
    public void openInvalidateBill() {
        panelInvalidateBill.clearPanel();
        openPanel(scrollPane, lpContentPane, panelSubMenu, panelInvalidateBill);
    }
}
