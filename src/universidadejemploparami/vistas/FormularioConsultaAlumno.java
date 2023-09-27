/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package universidadejemploparami.vistas;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadejemploparami.accesoadatos.AlumnoData;
import universidadejemploparami.accesoadatos.InscripcionData;
import universidadejemploparami.accesoadatos.MateriaData;
import universidadejemploparami.entidades.Alumno;
import universidadejemploparami.entidades.Materia;
import static universidadejemploparami.vistas.View.listaAlumnos;




public class FormularioConsultaAlumno extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData;
    private MateriaData materiaData;
    private InscripcionData inscData;
    
    
    public FormularioConsultaAlumno() {
         initComponents();
        alumnoData = new AlumnoData();
        materiaData = new MateriaData();
        inscData= new InscripcionData();
        
        cargarListaMateriasEnComboBox();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcboxAlumnos = new javax.swing.JComboBox<>();
        jbSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaAlumnos = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Roboto Serif 20pt", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 102, 255));
        jLabel1.setText("Listado de Alumnos por Materia");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, null, null));

        jLabel2.setFont(new java.awt.Font("Roboto Serif 20pt", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Seleccione una Materia");

        jcboxAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboxAlumnosActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(153, 0, 51));
        jbSalir.setFont(new java.awt.Font("Roboto Serif 20pt", 3, 14)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(0, 0, 0));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcboxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jbSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcboxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        jtTablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtTablaAlumnos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcboxAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboxAlumnosActionPerformed
    // Obtén la materia seleccionada del JComboBox
    Materia materiaSeleccionada = (Materia) jcboxAlumnos.getSelectedItem();

    // Llama al método que obtenga los alumnos inscritos en la materia seleccionada
    int idMateria = materiaSeleccionada.getIdMateria();
    List<Alumno> alumnosInscritos = inscData.obtenerAlumnosPorMateria(idMateria);

    // Crea un modelo de tabla
    DefaultTableModel model = new DefaultTableModel();
    //hola
    // Agrega las columnas necesarias al modelo de tabla
    model.addColumn("ID");
    model.addColumn("Nombre");
    model.addColumn("Apellido");
    model.addColumn("Fecha de Nacimiento");

    // Llena el modelo con los datos de los alumnos obtenidos
    for (Alumno alumno : alumnosInscritos) {
        model.addRow(new Object[] {
            alumno.getIdAlumno(),
            alumno.getNombre(),
            alumno.getApellido(),
            alumno.getFechaNac()
        });
    }

    // Establece el modelo en la tabla
    jtTablaAlumnos.setModel(model);
    jtTablaAlumnos.revalidate(); 
        
    }//GEN-LAST:event_jcboxAlumnosActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    
    private void cargarListaMateriasEnComboBox() {
        // Obtén la lista de materias desde MateriaData
        List<Materia> listaMaterias = materiaData.listarMaterias();

        // Limpia el JComboBox antes de agregar las nuevas materias
        jcboxAlumnos.removeAllItems();

        // Agrega las materias al JComboBox
        for (Materia materia : listaMaterias) {
            jcboxAlumnos.addItem(materia);
        }
    }
    
    private void actualizarTablaAlumnos(List<Alumno> alumnos) {
        // Crea el modelo de la tabla de alumnos con las columnas adecuadas
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Fecha de Nacimiento");
        // Agrega las filas con los datos de los alumnos
        for (Alumno alumno : alumnos) {
            modelo.addRow(new Object[]{
                alumno.getIdAlumno(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getFechaNac()
            });
        }
        // Establece el modelo en la tabla de alumnos
        jtTablaAlumnos.setModel(modelo);
    }

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Materia> jcboxAlumnos;
    private javax.swing.JTable jtTablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
