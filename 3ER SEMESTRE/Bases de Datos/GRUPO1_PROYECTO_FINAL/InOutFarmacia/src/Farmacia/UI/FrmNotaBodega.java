
package Farmacia.UI;

import Farmacia.Datos.Bodega;
import Farmacia.Datos.Empleado;
import Farmacia.Datos.Medicina;
import Farmacia.Datos.NotaBodega;
import Farmacia.Datos.NotaBodega.NotaBodegaItem;
import Farmacia.Utilitario.Utilitarios;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class FrmNotaBodega extends javax.swing.JFrame {

    private String claveServer;
    private ArrayList<Empleado> _empleados;
    private ArrayList<Bodega> _bodegas;
    
    private Medicina medSelec = null;
    private NotaBodega nota;

    public FrmNotaBodega(String claveUsuarioMysql)
    {
        this.claveServer = claveUsuarioMysql;
        CargarBodegas();
        CargarEmpleadas();
        initComponents();
        inicializarVentana();
    }    
    
    private void CargarBodegas()
    {
        _bodegas = Bodega.ConsularTodasBodegas(claveServer);
        if(_bodegas==null)
            _bodegas = new ArrayList<>();
    }
    private void CargarEmpleadas()
    {
        _empleados = Empleado.ConsularTodosEmpleados(claveServer);
        if(_empleados==null)
            _empleados = new ArrayList<>();
    }
    
    private void BuscarArticulo()
    {
        Medicina med = Medicina.ConsularxCodigo(this.claveServer, txtCodArt.getText());
        if(med==null)
        {
            JOptionPane.showMessageDialog(this, "No existe el medicamento con el codigo escrito", "BODEGA", JOptionPane.ERROR_MESSAGE);
            txtNombre.setText("");
            txtCantidad.setText("1");
            txtLote.setText("1");
            txtCaduca.setText(Utilitarios.DateToString(new Date()));
        }
        else
        {
            txtNombre.setText(med.getNombre());
            txtCantidad.setText("1");
            txtLote.setText("");
            txtCaduca.setText(Utilitarios.DateToString(new Date()));
        }
    }
    private boolean validarData()
    {
        boolean resp = true;
        
        if(Utilitarios.StringToDate(txtFecha.getText())==null)
        {
            JOptionPane.showMessageDialog(this, "El formato del texto en el campo fecha no es válido", 
                        "BODEGA", JOptionPane.ERROR_MESSAGE);
            txtFecha.requestFocus();
        }else if(txtNumero.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "No se ha digitado el número del documento", 
                        "BODEGA", JOptionPane.ERROR_MESSAGE);
            txtNumero.requestFocus();
        }else if(txtNumero.getText().trim().equals("0"))
        {
            JOptionPane.showMessageDialog(this, "El número del documento no puede ser cero", 
                        "BODEGA", JOptionPane.ERROR_MESSAGE);
            txtNumero.requestFocus();
        } else if(tblDetalle.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(this, "No han registrado ningún medicamento", 
                        "BODEGA", JOptionPane.ERROR_MESSAGE);
            txtCodArt.requestFocus();
        }
        
        return resp;
    }
    private void FillEntityFromForm()
    {
        if(rdbtnIngreso.isSelected())
            nota.setTipoIE(NotaBodega.INGRESO);
        else
            nota.setTipoIE(NotaBodega.EGRESO);
        
        nota.setFechaMov(Utilitarios.StringToDate(txtFecha.getText()));
        nota.setFechaSolicitud(new Date());
        nota.setIdBodega(((Bodega)cmbBodega.getSelectedItem()).getId());
        nota.setNumero(txtNumero.getText());
        nota.setCodBodeguero(((Empleado)cmbBodeguero.getSelectedItem()).getId());
        nota.setSolicitante(((Empleado)cmbSolicitante.getSelectedItem()).getId());
        nota.setJustificativo(txtObservacion.getText());
        
    }

    private void inicializarVentana()
    {
        if(_bodegas!=null && _bodegas.size()>0)
            cmbBodega.setSelectedIndex(0);
        
        if(_empleados!=null && _empleados.size()>0)
        {
            cmbBodeguero.setSelectedIndex(0);
            cmbSolicitante.setSelectedIndex(0);
        }
        
        this.nota = new NotaBodega();
        this.txtCaduca.setText(Utilitarios.DateToString(new Date()));
        this.txtCantidad.setText("0");
        this.txtCodArt.setText("");
        this.txtFecha.setText(Utilitarios.DateToString(new Date()));
        this.txtLote.setText("");
        this.txtNombre.setText("");
        this.txtNumero.setText("");
        this.txtObservacion.setText("");
    }
    private void agregarDetalle()
    {
        NotaBodegaItem item;
        item = this.nota.new NotaBodegaItem();
        item.setCantidad(Integer.parseInt(txtCantidad.getText()));
        item.setCodigoMed(txtCodArt.getText());
        item.setDescripcionMed(txtNombre.getText());
        item.setNoLote(txtLote.getText());
        item.setFechaCaduca(Utilitarios.StringToDate(txtCaduca.getText()));
        this.nota.getDetalle().add(item);
        
        DefaultTableModel model = (DefaultTableModel)this.tblDetalle.getModel();
        model.addRow(new Object[]{item.getCodigoMed(),item.getDescripcionMed(),String.valueOf(item.getCantidad()),
                            item.getNoLote(),txtCaduca.getText()});
        
        this.txtCaduca.setText(Utilitarios.DateToString(new Date()));
        this.txtCantidad.setText("0");
        this.txtCodArt.setText("");
        this.txtLote.setText("");
        this.txtNombre.setText("");
        this.txtCodArt.requestFocus();
    }
    
    private void guardar()
    {
        if(validarData())
        {
            FillEntityFromForm();
            String mensaje = this.nota.ingresar(claveServer);
            if(mensaje.equals("1"))
            {
                JOptionPane.showMessageDialog(this, "Se guardó correctamente la Nota de " + (rdbtnIngreso.isSelected()?"Ingreso" : "Egreso")  + " de bodega", 
                        "BODEGA", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this, mensaje, "BODEGA", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdbtngTipoNota = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlCabecera = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbBodega = new JComboBox(_bodegas.toArray());
        ;
        txtFecha = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdbtnIngreso = new javax.swing.JRadioButton();
        rdbtnEgreso = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        cmbBodeguero = new JComboBox(this._empleados.toArray());
        pnlDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodArt = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtLote = new javax.swing.JTextField();
        txtCaduca = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cmbSolicitante = new JComboBox(this._empleados.toArray());
        lblSustento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Movimientos de Bodega");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCabecera.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cabecera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel7.setText("Fecha:");

        jLabel9.setText("Bodega:");

        jLabel11.setText("Numero:");

        jLabel10.setText("Tipo:");

        rdbtngTipoNota.add(rdbtnIngreso);
        rdbtnIngreso.setSelected(true);
        rdbtnIngreso.setText("Ingreso");
        rdbtnIngreso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbtnIngresoItemStateChanged(evt);
            }
        });
        rdbtnIngreso.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rdbtnIngresoPropertyChange(evt);
            }
        });

        rdbtngTipoNota.add(rdbtnEgreso);
        rdbtnEgreso.setText("Egreso");

        jLabel12.setText("Bodeguero:");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBodega, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabeceraLayout.createSequentialGroup()
                        .addComponent(rdbtnIngreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbtnEgreso))
                    .addComponent(cmbBodeguero, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(rdbtnIngreso)
                    .addComponent(rdbtnEgreso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cmbBodeguero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "Lote", "Caducidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalle.setRowSelectionAllowed(false);
        tblDetalle.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDetalle);

        jLabel2.setText("Cod.Art.");

        jLabel3.setText("Nombre");

        jLabel4.setText("Cantidad");

        jLabel5.setText("Lote");

        jLabel6.setText("Caducidad");

        txtCodArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodArtKeyPressed(evt);
            }
        });

        txtCaduca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCaducaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(txtCodArt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCaduca, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCaduca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Reesponsable"));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel13.setText("Solicitante:");

        lblSustento.setText("Sustento:");

        txtObservacion.setColumns(20);
        txtObservacion.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtObservacion.setRows(1);
        jScrollPane2.setViewportView(txtObservacion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(254, 254, 254)
                        .addComponent(lblSustento)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblSustento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCabecera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCaducaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaducaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            agregarDetalle();
        }
    }//GEN-LAST:event_txtCaducaKeyPressed

    private void txtCodArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodArtKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            BuscarArticulo();
        }
    }//GEN-LAST:event_txtCodArtKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void rdbtnIngresoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rdbtnIngresoPropertyChange
        
    }//GEN-LAST:event_rdbtnIngresoPropertyChange

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rdbtnIngresoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbtnIngresoItemStateChanged
        if(rdbtnIngreso.isSelected())
            lblSustento.setText("Justificativo:");
        else
            lblSustento.setText("Destino:");
    }//GEN-LAST:event_rdbtnIngresoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbBodega;
    private javax.swing.JComboBox<String> cmbBodeguero;
    private javax.swing.JComboBox<String> cmbSolicitante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSustento;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JRadioButton rdbtnEgreso;
    private javax.swing.JRadioButton rdbtnIngreso;
    private javax.swing.ButtonGroup rdbtngTipoNota;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTextField txtCaduca;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodArt;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables
}
