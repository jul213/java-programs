import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class tareas1 extends JFrame implements ActionListener{

    private JPanel panelPrincipal;
    private JTextField campoTarea;
    private JButton botonAgregar;
    private JButton botonEliminar;
    private JButton botonEditar;
    private JList<String> listaTareas;
    private DefaultListModel<String> modeloListaTareas;

    private List<String> tareas;

    private static final String FILE_NAME = "tareas.txt";

    public tareas1(){
        super("Lista de tareas");

        //componentes
        panelPrincipal = new JPanel(new BorderLayout(10,10));
        panelPrincipal.setBorder(new EmptyBorder(10,10,10,10));
        panelPrincipal.setBackground(new Color(60,63,65) );

        campoTarea = new JTextField();
        campoTarea.setPreferredSize(new Dimension(200, 30) );
        campoTarea.setFont(new Font("Arial", Font.PLAIN, 14));
        campoTarea.setBackground(new Color(69, 73, 74));
        campoTarea.setBackground(Color.WHITE);
        campoTarea.setBorder(BorderFactory.createLineBorder(new Color(46, 48, 50)));
        campoTarea.addActionListener(this); // enter

        botonAgregar = new JButton("Agregar Tarea");
        configurarBoton(botonAgregar);

        botonEliminar = new JButton("Eliminar Tarea");
        configurarBoton(botonEliminar);

        botonEditar = new JButton("Editar Tarea");
        configurarBoton(botonEditar);

        listaTareas = new JList<>();
        modeloListaTareas = new DefaultListModel<>();
        listaTareas.setModel(modeloListaTareas);
        listaTareas.setFont(new Font("Arial", Font.PLAIN, 14));
        listaTareas.setBackground(new Color(69, 73, 74 ));
        listaTareas.setForeground(Color.WHITE);
        listaTareas.setSelectionBackground(new Color(75, 110, 175));
        listaTareas.setSelectionForeground(Color.WHITE);

        // crear un panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.setBackground(new Color(60, 63, 65));
        panelBotones.add(botonAgregar);
        panelBotones.add(botonEditar);
        panelBotones.add(botonEliminar);

        //agregar componentes al panel principal
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout(5, 5));
        panelSuperior.setBackground(new Color(60, 63, 65));
        panelSuperior.add(campoTarea, BorderLayout.CENTER);
        panelSuperior.add(botonAgregar, BorderLayout.EAST);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(new JScrollPane(listaTareas), BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        
        // CONFIGURACION 
        setContentPane(panelPrincipal);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // inicializar lista de tareas
        tareas = new ArrayList<>();

        //cargar tareas hacia el txt
        cargarTareas();


    }

    private void configurarBoton(JButton boton){
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setBackground(new Color(75, 110 , 175 ));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(45, 48, 50)),
            BorderFactory.createEmptyBorder(5 , 15, 5, 15)
        ));
        boton.addActionListener(this);
    }

    private void agregarTarea(String tarea){
        if (tarea.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "La tarea no puede estar vacia", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!tareas.contains(tarea)){
            tareas.add(tarea);
            modeloListaTareas.addElement(tarea);
            campoTarea.setText(""); // limpiar despues de agregar el campo de texto
            guardarTareas(); // guardado de tarea en el archivo
        } else{
            JOptionPane.showMessageDialog(this, "La tarea ya existe", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    private void eliminarTarea(){
      int selectedIndex = listaTareas.getSelectedIndex();
      if (selectedIndex != -1){
        int confirm = JOptionPane.showConfirmDialog(this, "Esta seguro que quiere eliminar esta Tarea?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION){
            tareas.remove(selectedIndex);
            modeloListaTareas.remove(selectedIndex);
            guardarTareas();
        } 
      } else{
            JOptionPane.showMessageDialog(this, "Por favor seleccione una tarea para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        
      }
    }

    private void editarTarea(){
        int selectedIndex = listaTareas.getSelectedIndex();
        if (selectedIndex != -1){
            String nuevaTarea = JOptionPane.showInputDialog(this, "Edita la tarea: ", tareas.get(selectedIndex));
            if (nuevaTarea != null && !nuevaTarea.trim().isEmpty() && !tareas.contains(nuevaTarea)){
                tareas.set(selectedIndex, nuevaTarea);
                modeloListaTareas.set(selectedIndex, nuevaTarea);
                guardarTareas();
            } else if (tareas.contains(nuevaTarea)){
                JOptionPane.showMessageDialog(this, "la tarea ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (nuevaTarea == null || nuevaTarea.trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "La tarea no puede estar vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una tarea para editar", "ERROR", JOptionPane.ERROR_MESSAGE );
        }
    }

    private void guardarTareas(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for (String tarea : tareas){
                writer.write(tarea);
                writer.newLine();
            }
        } catch (IOException e){
            JOptionPane.showMessageDialog(this, "Error al guardar tareas" , "ERROR", JOptionPane.ERROR_MESSAGE); 
        }
    }

    private void cargarTareas(){
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String tarea;
            while ((tarea = reader.readLine()) != null){
                tareas.add(tarea);
                modeloListaTareas.addElement(tarea);
            }
        } catch (FileNotFoundException e){

        } catch (IOException e){
            JOptionPane.showMessageDialog(this, "Error al cargar las tareas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == botonAgregar || e.getSource() == campoTarea){
            String nuevaTarea = campoTarea.getText();
            agregarTarea(nuevaTarea);
        } else if (e.getSource() == botonEliminar){
            eliminarTarea();
        } else if (e.getSource() == botonEditar){
            editarTarea();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(tareas1::new);
    }

}
